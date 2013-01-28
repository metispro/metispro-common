/**
 * 
 */
package com.metispro.service.proxy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.metispro.service.ServiceProxy;
import com.metispro.service.ServiceResponse;

/**
 * @author Tim
 * 
 */
public abstract class HttpServiceProxy implements ServiceProxy
{
    protected final String requestMethod;

    protected Map<String, String> requestProperties = new HashMap<String, String>();

    /**
     * @throws IOException
     * 
     */
    public HttpServiceProxy()
    {
        this("GET", "text/html");
    }

    public HttpServiceProxy(String requestMethod, String contentType)
    {
        this.requestMethod = requestMethod;
        requestProperties.put("Content-Type", contentType);
    }

    public void setContentType(String contentType)
    {
        requestProperties.put("Content-Type", contentType);
    }

    public void addRequestProperty(String key, String value)
    {
        requestProperties.put(key, value);
    }

    protected ServiceResponse executeServiceRequestResponse(
            HttpServiceRequest request) throws Exception
    {
        URL url = new URL(getURL(request.getMethod()));
        HttpURLConnection conn = null;
        HttpServiceResponse response = null;

        try
        {
            conn = openConnection(url);

            if (request.getPayload() != null)
            {
                OutputStream os = conn.getOutputStream();
                os.write(request.getPayload());
                os.flush();

                response = new HttpServiceResponse();

                int status = conn.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK)
                    response.setErrorCode("Failed : HTTP error code : "
                            + status);

                try
                {
                    byte[] body = readStream(conn.getInputStream());

                    if (body.length > 0)
                        response.setPayload(body);
                } catch (Exception e)
                {
                    response.setErrorCode(e.getMessage());
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    e.printStackTrace(new PrintStream(out, true));
                    response.setPayload(out.toByteArray());
                }
            }

            if (response == null)
            {
                response = new HttpServiceResponse();

                try
                {
                    byte[] body = readStream(conn.getInputStream());

                    int status = conn.getResponseCode();
                    if (status != HttpURLConnection.HTTP_OK)
                    {
                        response.setErrorCode("Failed : HTTP error code : "
                                + status);
                        response.setPayload(conn.getResponseMessage()
                                .getBytes());
                    } else if (body.length > 0)
                        response.setPayload(body);
                } catch (Exception e)
                {
                    response.setErrorCode(e.getMessage());
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    e.printStackTrace(new PrintStream(out, true));
                    response.setPayload(out.toByteArray());
                }
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally
        {
            if (conn != null)
                conn.disconnect();

        }

        return response;
    }

    private HttpURLConnection openConnection(URL url) throws Exception
    {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod(this.requestMethod);

        for (Entry<String, String> entry : requestProperties.entrySet())
        {
            conn.setRequestProperty(entry.getKey(), entry.getValue());
        }

        return conn;
    }

    private static byte[] readStream(InputStream in) throws IOException
    {
        byte[] buf = new byte[1024];
        int count = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        while ((count = in.read(buf)) != -1)
            out.write(buf, 0, count);
        return out.toByteArray();
    }

    protected abstract String getURL(String method);
}

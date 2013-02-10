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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.metispro.service.ServiceProxy;
import com.metispro.service.ServiceResponse;

/**
 * @author Tim
 * 
 */
public abstract class HttpServiceProxy implements ServiceProxy
{
    final Logger logger = LoggerFactory.getLogger(this.getClass());

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
        logger.trace(
                "Initializing poxy with requestMethod = {} and contentType = {}",
                requestMethod, contentType);
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

    /**
     * Gets HttpServiceResponse for specified HttpServiceRequest
     * 
     * @param request
     * @return
     * @throws Exception
     */
    public ServiceResponse getServiceResponse(HttpServiceRequest request)
            throws Exception
    {
        if (request == null)
        {
            logger.warn("HttpServiceRequest cannot be null");
            return null;
        }

        logger.info("Executing HttpServiceProxy for URL = "
                + this.getEndpoint(request.getMethod()));

        HttpServiceResponse response = (HttpServiceResponse) this
                .executeServiceRequestResponse(request);

        return response;
    }

    protected ServiceResponse executeServiceRequestResponse(
            HttpServiceRequest request) throws Exception
    {
        if (request == null)
            logger.warn("HttpServiceRequest cannot be null");

        URL url = new URL(getEndpoint(request.getMethod()));
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
                response.setResponseCode(status);
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
                    int status = conn.getResponseCode();
                    response.setResponseCode(status);
                    if (status != HttpURLConnection.HTTP_OK)
                    {
                        response.setErrorCode("Failed : HTTP error code : "
                                + status);
                        response.setPayload(conn.getResponseMessage()
                                .getBytes());
                    } else
                    {
                        byte[] body = readStream(conn.getInputStream());

                        response.setPayload(body);
                    }
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
            logger.error("Failed to execute service proxy Request/Response.", e);
            throw e;
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

    protected abstract String getEndpoint(String method);
}

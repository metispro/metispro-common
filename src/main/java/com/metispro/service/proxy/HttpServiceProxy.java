/**
 * 
 */
package com.metispro.service.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public HttpServiceProxy() throws IOException
    {
        this("GET", "text/html");
    }

    public HttpServiceProxy(String requestMethod, String contentType)
            throws IOException
    {
        this.requestMethod = requestMethod;
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
        HttpURLConnection conn = openConnection(url);

        HttpServiceResponse response = new HttpServiceResponse();

        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED)
        {
            response.setErrorCode("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        StringBuffer sb = new StringBuffer();
        String output;
        while ((output = br.readLine()) != null)
        {
            sb.append(output);
        }

        conn.disconnect();

        if (sb.length() > 0)
            response.setPayload(sb.toString().getBytes());

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

    protected abstract String getURL(String method);
}

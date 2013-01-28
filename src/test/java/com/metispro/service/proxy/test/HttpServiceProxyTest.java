/**
 * 
 */
package com.metispro.service.proxy.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metispro.service.proxy.HttpServiceProxy;
import com.metispro.service.proxy.HttpServiceRequest;
import com.metispro.service.proxy.HttpServiceResponse;

/**
 * @author Tim
 * 
 */
public class HttpServiceProxyTest
{

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testHttpServiceProxy()
    {
        GoogleServiceProxy proxy = new GoogleServiceProxy();
        try
        {
            HttpServiceResponse response = proxy.getGoogleHomePage();

            assertNotNull(response);
            assertFalse(response.hasError());

            String output = new String(response.getPayload());

            System.out.println(output);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        ErrorServiceProxy errorProxy = new ErrorServiceProxy();
        try
        {
            HttpServiceResponse response = errorProxy.getErrorResponse();
            assertNotNull(response);
            assertTrue(response.hasError());

            System.out.println(response.getErrorCode());
            String output = new String(response.getPayload());

            System.out.println(output);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    class GoogleServiceProxy extends HttpServiceProxy
    {
        private final String url = "http://www.google.com";

        @Override
        protected String getURL(String method)
        {
            return url;
        }

        public HttpServiceResponse getGoogleHomePage() throws Exception
        {
            HttpServiceResponse response = (HttpServiceResponse) this
                    .executeServiceRequestResponse(new HttpServiceRequest("/"));

            return response;
        }

    }

    class ErrorServiceProxy extends HttpServiceProxy
    {
        private final String url = "http://localhost";

        @Override
        protected String getURL(String method)
        {
            return url;
        }

        public HttpServiceResponse getErrorResponse() throws Exception
        {
            HttpServiceResponse response = (HttpServiceResponse) this
                    .executeServiceRequestResponse(new HttpServiceRequest("/"));

            return response;
        }
    }
}

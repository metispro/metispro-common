/**
 * 
 */
package com.metispro.service.proxy.test;

import static org.junit.Assert.assertEquals;
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
    public void testHttpOKResponse()
    {
        TestHttpServiceProxy proxy = new TestHttpServiceProxy(
                "http://www.google.com");

        try
        {
            HttpServiceResponse response = proxy.getServiceResponse();

            assertNotNull(response);
            assertFalse(response.hasError());

            String output = new String(response.getPayload());

            System.out.println(output);
            assertTrue(true);
        } catch (Exception e)
        {
            e.printStackTrace();
            assertFalse(true);
        }

    }

    @Test
    public void testUnknownHost() throws Exception
    {
        TestHttpServiceProxy proxy = new TestHttpServiceProxy();

        // Test Unknown host
        try
        {
            proxy.setEndpoint("http://bogus.bogus.bogus");
            HttpServiceResponse response = proxy.getServiceResponse();
            assertNotNull(response);
            assertTrue(response.hasError());

            System.out.println(response.getErrorCode());
            String output = new String(response.getPayload());

            System.out.println(output);
            assertTrue(true);
        } catch (Exception e)
        {
            e.printStackTrace();
            assertFalse(true);
        }
    }

    @Test
    public void testHttp404() throws Exception
    {

        TestHttpServiceProxy proxy = new TestHttpServiceProxy();

        try
        {
            proxy.setEndpoint("http://localhost");
            HttpServiceResponse response = proxy.getServiceResponse("bogus");
            assertNotNull(response);
            assertTrue(response.hasError());
            assertEquals(404, response.getResponseCode());

            System.out.println(response.getErrorCode());
        } catch (Exception e)
        {
            e.printStackTrace();
            assertFalse(true);
        }
    }

    class TestHttpServiceProxy extends HttpServiceProxy
    {
        private String endpoint = "http://localhost";

        public TestHttpServiceProxy()
        {
        }

        public TestHttpServiceProxy(String endpoint)
        {
            this.endpoint = endpoint;
        }

        @Override
        protected String getEndpoint(String method)
        {
            return endpoint + "/" + method;
        }

        public void setEndpoint(String url)
        {
            this.endpoint = url;
        }

        public HttpServiceResponse getServiceResponse() throws Exception
        {
            return this.getServiceResponse(null);
        }

        public HttpServiceResponse getServiceResponse(String method)
                throws Exception
        {
            if (method == null)
                method = "";

            System.out.println("Executing HttpServiceProxy for URL = "
                    + this.getEndpoint(method));

            HttpServiceResponse response = (HttpServiceResponse) this
                    .executeServiceRequestResponse(new HttpServiceRequest(
                            method));

            return response;
        }
    }
}

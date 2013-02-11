/**
 * 
 */
package com.metispro.service.proxy;

import com.metispro.service.ServiceRequest;
import com.metispro.service.ServiceResponse;

/**
 * @author Tim
 * 
 */
public abstract class JsonServiceProxy extends HttpServiceProxy
{

    /**
     * 
     */
    public JsonServiceProxy()
    {
        super();
    }

    /**
     * @param requestMethod
     * @param contentType
     */
    public JsonServiceProxy(String requestMethod, String contentType)
    {
        super(requestMethod, contentType);
    }

    /**
     * Gets HttpServiceResponse for specified HttpServiceRequest
     * 
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public ServiceResponse getServiceResponse(ServiceRequest request)
            throws Exception
    {
        if (request == null)
        {
            logger.warn("ServiceRequest cannot be null");
            return null;
        }

        JsonServiceResponse response = new JsonServiceResponse(
                (HttpServiceResponse) this
                        .executeServiceRequestResponse(request));

        return response;
    }
}

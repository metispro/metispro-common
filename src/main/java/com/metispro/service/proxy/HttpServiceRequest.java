package com.metispro.service.proxy;

import com.metispro.service.ServiceRequest;

public abstract class HttpServiceRequest implements ServiceRequest
{
    protected String method;

    public HttpServiceRequest()
    {
        // TODO Auto-generated constructor stub
    }

    public String getMethod()
    {
        return method;
    }

}

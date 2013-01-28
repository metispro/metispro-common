package com.metispro.service.proxy;

import com.metispro.service.ServiceRequest;

public class HttpServiceRequest implements ServiceRequest
{
    protected String method;

    public HttpServiceRequest(String method)
    {
        this.method = method;
    }

    public String getMethod()
    {
        return method;
    }

    public void setPayload(byte[] bytes)
    {
        // TODO Auto-generated method stub

    }

    public byte[] getPayload()
    {
        // TODO Auto-generated method stub
        return null;
    }

}

package com.metispro.service.proxy;

import com.metispro.service.ServiceRequest;

public class HttpServiceRequest implements ServiceRequest
{
    protected String method;

    protected byte[] payload;

    public HttpServiceRequest(String method)
    {
        if (method != null)
            this.method = method;
        else
            this.method = "";
    }

    public String getMethod()
    {
        return method;
    }

    public ServiceRequest setPayload(byte[] bytes)
    {
        this.payload = bytes;
        return this;
    }

    public byte[] getPayload()
    {
        return payload;
    }

}

/**
 * 
 */
package com.metispro.service.proxy;

import com.metispro.service.ServiceResponse;

/**
 * @author Tim
 * 
 */
public class HttpServiceResponse implements ServiceResponse
{
    protected byte[] payload;

    protected boolean hasError = false;

    protected String errorCode;

    protected int responseCode = -1;

    /**
     * 
     */
    public HttpServiceResponse()
    {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.metispro.service.ServiceResponse#setPayload(byte[])
     */
    public ServiceResponse setPayload(byte[] bytes)
    {
        this.payload = bytes;
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.metispro.service.ServiceResponse#getPayload()
     */
    public byte[] getPayload()
    {
        return payload;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.metispro.service.ServiceResponse#hasError()
     */
    public boolean hasError()
    {
        return hasError;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.metispro.service.ServiceResponse#getErrorCode()
     */
    public String getErrorCode()
    {
        return errorCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     * @return
     */
    public ServiceResponse setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
        hasError = true;
        return this;
    }

    /**
     * @return the responseCode
     */
    public int getResponseCode()
    {
        return responseCode;
    }

    /**
     * @param responseCode
     *            the responseCode to set
     * @return
     */
    public ServiceResponse setResponseCode(int responseCode)
    {
        this.responseCode = responseCode;
        return this;
    }

}

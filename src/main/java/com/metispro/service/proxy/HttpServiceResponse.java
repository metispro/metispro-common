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
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.metispro.service.ServiceResponse#setPayload(byte[])
     */
    public void setPayload(byte[] bytes)
    {
        this.payload = bytes;
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
     */
    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
        hasError = true;
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
     */
    public void setResponseCode(int responseCode)
    {
        this.responseCode = responseCode;
    }

}

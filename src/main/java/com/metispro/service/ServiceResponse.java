/**
 * 
 */
package com.metispro.service;

/**
 * @author Tim
 * 
 */
public interface ServiceResponse
{
    public ServiceResponse setPayload(byte[] bytes);

    public byte[] getPayload();

    public boolean hasError();

    public ServiceResponse setErrorCode(String errorCode);

    public String getErrorCode();

    public ServiceResponse setResponseCode(int responseCode);

    public int getResponseCode();
}

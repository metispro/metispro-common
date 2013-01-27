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
    public void setPayload(byte[] bytes);

    public byte[] getPayload();

    public boolean hasError();

    public String getErrorCode();
}

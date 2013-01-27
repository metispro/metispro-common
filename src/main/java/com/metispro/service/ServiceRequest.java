/**
 * 
 */
package com.metispro.service;

/**
 * @author Tim
 * 
 */
public interface ServiceRequest
{
    public void setPayload(byte[] bytes);

    public byte[] getPayload();

}

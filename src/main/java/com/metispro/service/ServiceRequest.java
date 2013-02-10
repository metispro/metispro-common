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
    public ServiceRequest setPayload(byte[] bytes);

    public byte[] getPayload();

}

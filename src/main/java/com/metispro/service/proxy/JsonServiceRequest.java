/**
 * 
 */
package com.metispro.service.proxy;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.metispro.service.ServiceRequest;
import com.metispro.util.CamelCaseNamingStrategy;

/**
 * @author Tim
 * 
 */
public class JsonServiceRequest extends HttpServiceRequest
{
    protected Object jsonObject;

    /**
     * @param method
     */
    public JsonServiceRequest(String method)
    {
        super(method);
    }

    public ServiceRequest setJsonPayload(Object jsonObject)
            throws JsonGenerationException, JsonMappingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());

        String json = mapper.writeValueAsString(jsonObject);

        this.jsonObject = jsonObject;

        this.setPayload(json.getBytes());

        return this;
    }
}

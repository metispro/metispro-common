/**
 * 
 */
package com.metispro.service.proxy;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.metispro.service.ServiceResponse;
import com.metispro.util.CamelCaseNamingStrategy;

/**
 * @author Tim
 * 
 */
public class JsonServiceResponse extends HttpServiceResponse
{
    protected Object jsonObject;

    /**
     * Default Constructor.
     */
    public JsonServiceResponse()
    {
        super();
    }

    /**
     * Constructs from ServiceResponse instance.
     * 
     * @param response
     */
    public JsonServiceResponse(ServiceResponse response)
    {
        super();
        this.errorCode = response.getErrorCode();
        this.hasError = response.hasError();
        this.payload = response.getPayload();
        this.responseCode = response.getResponseCode();
    }

    public Object getJsonPayload(Class<?> clazz) throws JsonParseException,
            JsonMappingException, IOException
    {
        if (jsonObject != null)
            return jsonObject;

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());

        mapper.readValue(this.getPayload(), clazz);

        return jsonObject;
    }
}

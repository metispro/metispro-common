package com.metispro.util;

import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;

/**
 * Converts standard CamelCase field and method names to typical JSON field
 * names having all lower case characters with an underscore separating
 * different words. For example, all of the following are converted to JSON
 * field name "some_name":
 * 
 * Java field name "someName"<br>
 * Java method name "getSomeName" <br>
 * Java method name "setSomeName" <br>
 * 
 * Typical Use:
 * 
 * String jsonString = "{\"foo_name\":\"fubar\"}";<br>
 * ObjectMapper mapper = new ObjectMapper(); <br>
 * mapper.setPropertyNamingStrategy( <br>
 * new CamelCaseNamingStrategy()); <br>
 * Foo foo = mapper.readValue(jsonString, Foo.class); <br>
 * System.out.println(mapper.writeValueAsString(foo)); <br>
 * // prints {"foo_name":"fubar"} <br>
 * 
 * class Foo <br>
 * { <br>
 * private String fooName; <br>
 * public String getFooName() {return fooName;} <br>
 * public void setFooName(String fooName) <br>
 * {this.fooName = fooName;} <br>
 * } <br>
 */
public class CamelCaseNamingStrategy extends PropertyNamingStrategy
{
    @Override
    public String nameForGetterMethod(MapperConfig<?> config,
            AnnotatedMethod method, String defaultName)
    {
        return translate(defaultName);
    }

    @Override
    public String nameForSetterMethod(MapperConfig<?> config,
            AnnotatedMethod method, String defaultName)
    {
        return translate(defaultName);
    }

    @Override
    public String nameForField(MapperConfig<?> config, AnnotatedField field,
            String defaultName)
    {
        return translate(defaultName);
    }

    private String translate(String defaultName)
    {
        char[] nameChars = defaultName.toCharArray();
        StringBuilder nameTranslated = new StringBuilder(nameChars.length * 2);
        for (char c : nameChars)
        {
            if (Character.isUpperCase(c))
            {
                nameTranslated.append("_");
                c = Character.toLowerCase(c);
            }
            nameTranslated.append(c);
        }
        return nameTranslated.toString();
    }
}

/**
 * 
 */
package com.metispro.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Tim
 * 
 */
public class BeanUtil
{

    /**
     * Copies all properties from one bean to another.
     * 
     * @param fromBean
     * @param toBean
     */
    public static void copyBeanProperties(final Object fromBean,
            final Object toBean)
    {
        try
        {
            @SuppressWarnings("unchecked")
            // this should be safe
            final Map<String, Object> beanAProps = PropertyUtils
                    .describe(fromBean);
            @SuppressWarnings("unchecked")
            // this should be safe
            final Map<String, Object> beanBProps = PropertyUtils
                    .describe(toBean);

            if (!beanAProps.keySet().containsAll(beanBProps.keySet()))
            {
                throw new IllegalArgumentException("Incompatible types: "
                        + fromBean + ", " + toBean);
            }
            for (final Entry<String, Object> entryA : beanAProps.entrySet())
            {
                if (beanBProps.get(entryA.getKey()) == null)
                {
                    PropertyUtils.setMappedProperty(toBean, entryA.getKey(),
                            entryA.getValue());
                }
            }
        } catch (final IllegalAccessException e)
        {
            throw new IllegalStateException(e);
        } catch (final InvocationTargetException e)
        {
            throw new IllegalStateException(e);
        } catch (final NoSuchMethodException e)
        {
            throw new IllegalStateException(e);
        }
    }
}

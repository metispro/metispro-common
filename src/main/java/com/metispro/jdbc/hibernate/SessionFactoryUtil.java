/**
 * 
 */
package com.metispro.jdbc.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Tim
 * 
 */
public class SessionFactoryUtil
{
    private static SessionFactory sessionFactory = null;

    static
    {
        try
        {
            if (sessionFactory == null)
            {
                ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
                ServiceRegistry serviceRegistry = builder
                        .buildServiceRegistry();
                sessionFactory = new Configuration().configure()
                        .buildSessionFactory(serviceRegistry);
            }

        } catch (Throwable ex)
        {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

}

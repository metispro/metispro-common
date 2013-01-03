/**
 * 
 */
package com.metispro.jdbc.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.metispro.model.registration.Activity;
import com.metispro.model.registration.Participant;
import com.metispro.model.registration.Program;
import com.metispro.model.registration.Registration;
import com.metispro.model.registration.Session;

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
                Configuration configuration = new Configuration()
                        .addPackage("com.metispro.model.membership")
                        .addPackage("com.metispro.model.registration")
                        .addPackage("com.metispro.model.reservation")
                        .addPackage("com.metispro.model.scheduling")
                        .addAnnotatedClass(Activity.class)
                        .addAnnotatedClass(Participant.class)
                        .addAnnotatedClass(Program.class)
                        .addAnnotatedClass(Registration.class)
                        .addAnnotatedClass(Session.class).configure();
                ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
                ServiceRegistry serviceRegistry = builder.applySettings(
                        configuration.getProperties()).buildServiceRegistry();
                sessionFactory = configuration
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

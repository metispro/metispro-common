/**
 * 
 */
package com.metispro.jdbc.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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
    protected static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    static
    {
        try
        {
            if (sessionFactory == null)
            {
                buildSessionFactory();
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

    /**
     * Returns the ThreadLocal ProgramSession instance. Lazy initialize the
     * <code>SessionFactory</code> if needed.
     * 
     * @return ProgramSession
     * @throws HibernateException
     */
    public synchronized static Session getSession() throws HibernateException
    {
        Session session = threadLocal.get();

        if (session == null || !session.isOpen())
        {
            if (sessionFactory == null)
            {
                buildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            threadLocal.set(session);
        }

        return session;
    }

    /**
     * Close the single hibernate session instance.
     * 
     * @throws HibernateException
     */
    public synchronized static void closeSession() throws HibernateException
    {
        Session session = threadLocal.get();
        threadLocal.set(null);

        if (session != null && session.isOpen())
        {
            session.close();
        }

        session = null;
    }

    private static void buildSessionFactory()
    {
        Configuration configuration = new Configuration()
                .addPackage("com.metispro.model.membership")
                .addPackage("com.metispro.model.registration")
                .addAnnotatedClass(
                        com.metispro.model.registration.Activity.class)
                .addAnnotatedClass(
                        com.metispro.model.registration.Participant.class)
                .addAnnotatedClass(
                        com.metispro.model.registration.Program.class)
                .addAnnotatedClass(
                        com.metispro.model.registration.Registration.class)
                .addAnnotatedClass(com.metispro.model.registration.School.class)
                .addAnnotatedClass(
                        com.metispro.model.registration.ProgramSession.class)
                .addPackage("com.metispro.model.reservation")
                .addAnnotatedClass(
                        com.metispro.model.reservation.Equipment.class)
                .addAnnotatedClass(
                        com.metispro.model.reservation.Facility.class)
                .addPackage("com.metispro.model.scheduling").configure();
        ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
        ServiceRegistry serviceRegistry = builder.applySettings(
                configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}

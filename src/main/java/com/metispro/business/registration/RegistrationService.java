/**
 * 
 */
package com.metispro.business.registration;

import org.hibernate.Session;

import com.metispro.jdbc.hibernate.SessionFactoryUtil;
import com.metispro.model.registration.Registration;

/**
 * @author Tim
 * 
 */
public class RegistrationService
{

    public Registration getRegistration(long id) throws Exception
    {

        Session session = SessionFactoryUtil.getSessionFactory()
                .getCurrentSession();

        Registration registration = (Registration) session.load(
                Registration.class, id);

        return registration;
    }

}

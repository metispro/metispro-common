/**
 * 
 */
package com.metispro.business.registration;

import org.hibernate.Session;

import com.metispro.jdbc.hibernate.SessionFactoryUtil;
import com.metispro.model.registration.Registration;
import com.metispro.model.registration.School;

/**
 * @author Tim
 * 
 */
public class RegistrationService
{

    public Registration getRegistration(long id) throws Exception
    {

        Session session = SessionFactoryUtil.getSession();

        Registration registration = (Registration) session.load(
                Registration.class, id);

        return registration;
    }

    public School addSchool(School school) throws Exception
    {
        Session session = SessionFactoryUtil.getSession();

        session.save(school);

        return school;
    }

    public School getSchool(long id) throws Exception
    {
        Session session = SessionFactoryUtil.getSession();

        return (School) session.load(School.class, id);
    }
}

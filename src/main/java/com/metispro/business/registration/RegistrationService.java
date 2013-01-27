/**
 * 
 */
package com.metispro.business.registration;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.metispro.business.StaleDataException;
import com.metispro.jdbc.hibernate.SessionFactoryUtil;
import com.metispro.model.registration.ProgramSession;
import com.metispro.model.registration.Registration;
import com.metispro.model.registration.School;

/**
 * Metispro Registration Functional component. Provides all service interfaces
 * for the Registration functional component.
 * 
 * @author Tim
 * 
 */
public class RegistrationService
{

    /**
     * Add a new ProgramSession instance.
     * 
     * @param programSession
     * @throws Exception
     */
    public void addProgramSession(ProgramSession programSession)
            throws Exception
    {
        if (programSession == null)
            return;

        Session session = SessionFactoryUtil.getSession();

        session.save(programSession);
    }

    /**
     * Get a ProgramSession instance for specific identifier.
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public ProgramSession getProgramSession(long id) throws Exception
    {
        Session session = SessionFactoryUtil.getSession();

        ProgramSession programSession = (ProgramSession) session.load(
                ProgramSession.class, id);

        return programSession;
    }

    /**
     * Update existing persistent ProgramSession instance.
     * 
     * @param programSession
     * @return
     * @throws Exception
     */
    public ProgramSession updateProgramSession(ProgramSession programSession)
            throws Exception
    {
        Session session = SessionFactoryUtil.getSession();

        ProgramSession tmpSession = (ProgramSession) session.load(
                ProgramSession.class, programSession.getId());

        if (programSession.getUpdateDate().getTime() != tmpSession
                .getUpdateDate().getTime())
            throw new StaleDataException("ProgramSession instance is stale!");

        BeanUtils.copyProperties(tmpSession, programSession);

        session.update(tmpSession);

        return programSession;
    }

    /**
     * Gets a Registration instance for specific identifier.
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public Registration getRegistration(long id) throws Exception
    {

        Session session = SessionFactoryUtil.getSession();

        Registration registration = (Registration) session.load(
                Registration.class, id);

        return registration;
    }

    /**
     * Add new Registration instance.
     * 
     * @param registration
     * @throws Exception
     */
    public void addRegistration(Registration registration) throws Exception
    {
        if (registration == null)
            return;

        Session session = SessionFactoryUtil.getSession();

        session.save(registration);
    }

    public Registration updateRegistration(Registration registration)
            throws Exception
    {
        if (registration == null)
            return registration;

        Session session = SessionFactoryUtil.getSession();

        Registration preg = (Registration) session.load(Registration.class,
                registration.getId());

        if (registration.getUpdateDate().getTime() != preg.getUpdateDate()
                .getTime())
            throw new StaleDataException("Registration instance is stale!");

        BeanUtils.copyProperties(preg, registration);

        session.update(preg);

        return registration;
    }

    public void addSchool(School school) throws Exception
    {
        if (school == null)
            return;

        Session session = SessionFactoryUtil.getSession();

        session.save(school);
    }

    public School getSchool(long id) throws Exception
    {
        Session session = SessionFactoryUtil.getSession();

        return (School) session.load(School.class, id);
    }
}

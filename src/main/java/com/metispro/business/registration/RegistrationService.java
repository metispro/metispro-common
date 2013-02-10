/**
 * 
 */
package com.metispro.business.registration;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.metispro.business.StaleDataException;
import com.metispro.jdbc.hibernate.SessionFactoryUtil;
import com.metispro.model.registration.Program;
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
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Add new Program instance.
     * 
     * @param program
     * @throws Exception
     */
    public void addProgram(Program program) throws Exception
    {
        if (program == null)
        {
            logger.warn("Missing required Program parameter.");
            return;
        }

        Session session = SessionFactoryUtil.getSession();

        session.save(program);
    }

    /**
     * Get Program instance for identifier.
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public Program getProgram(long id) throws Exception
    {
        Session session = SessionFactoryUtil.getSession();

        logger.debug("Retreiving Program with id = {}", id);

        return (Program) session.load(Program.class, id);
    }

    /**
     * Update Program instance.
     * 
     * @param program
     * @return
     * @throws Exception
     */
    public Program updateProgram(Program program) throws Exception
    {
        if (program == null)
        {
            logger.warn("Missing required Program parameter.");
            return program;
        }

        Session session = SessionFactoryUtil.getSession();

        Program tmp = this.getProgram(program.getId());

        if (program.getUpdateDate().getTime() != tmp.getUpdateDate().getTime())
            throw new StaleDataException("Program instance is stale!");

        BeanUtils.copyProperties(tmp, program);

        session.update(tmp);

        return program;
    }

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
        {
            logger.warn("Missing required ProgramSession parameter.");
            return;
        }

        Session session = SessionFactoryUtil.getSession();

        if (programSession.getProgram() != null
                && programSession.getProgram().getId() == 0)
            this.addProgram(programSession.getProgram());

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

        logger.debug("Retreiving ProgramSession with id = {}", id);

        return (ProgramSession) session.load(ProgramSession.class, id);

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
        if (programSession == null)
        {
            logger.warn("Missing required ProgramSession parameter.");
            return programSession;
        }

        Session session = SessionFactoryUtil.getSession();

        ProgramSession tmpSession = this.getProgramSession(programSession
                .getId());

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

        logger.debug("Retreiving Registration with id = {}", id);

        return (Registration) session.load(Registration.class, id);
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
        {
            logger.warn("Missing required Registration parameter.");
            return;
        }

        Session session = SessionFactoryUtil.getSession();

        session.save(registration);
    }

    public Registration updateRegistration(Registration registration)
            throws Exception
    {
        if (registration == null)
        {
            logger.warn("Missing required Registration parameter.");
            return registration;
        }

        Session session = SessionFactoryUtil.getSession();

        Registration preg = this.getRegistration(registration.getId());

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
        {
            logger.warn("Missing required School parameter.");
            return;
        }

        Session session = SessionFactoryUtil.getSession();

        session.save(school);
    }

    public School getSchool(long id) throws Exception
    {
        Session session = SessionFactoryUtil.getSession();

        logger.debug("Retreiving School with id = {}", id);

        return (School) session.load(School.class, id);
    }
}

/**
 * 
 */
package com.metispro.business.registration.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metispro.business.registration.RegistrationService;
import com.metispro.jdbc.hibernate.SessionFactoryUtil;
import com.metispro.model.registration.ProgramSession;
import com.metispro.model.registration.Registration;
import com.metispro.model.registration.School;

/**
 * @author Tim
 * 
 */
public class RegistrationServiceTest
{
    Session session = null;
    RegistrationService service = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        session = SessionFactoryUtil.getSession();
        service = new RegistrationService();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
        SessionFactoryUtil.closeSession();
    }

    @Test
    public void testProgramSession() throws Exception
    {
        System.out.println(this.getClass().getSimpleName()
                + ".testProgramSession");

        final ProgramSession programSession = new ProgramSession();
        programSession.setName("Fall Session");
        programSession.setBeginDate(new Date());

        Transaction trx = null;

        // Test adding a new ProgramSession
        try
        {
            trx = session.beginTransaction();

            service.addProgramSession(programSession);

            ProgramSession tmp = service.getProgramSession(programSession
                    .getId());

            assertEquals(programSession, tmp);

            trx.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            trx.rollback();
        }

        // Test updating a ProgramSession
        try
        {
            trx = session.beginTransaction();

            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(programSession.getBeginDate());
            cal.add(Calendar.YEAR, 1);

            programSession.setEndDate(cal.getTime());

            System.out.println("ProgramSession version: "
                    + programSession.getUpdateDate());
            Thread.sleep(2000);
            service.updateProgramSession(programSession);

            ProgramSession tmp = service.getProgramSession(programSession
                    .getId());
            System.out
                    .println("ProgramSession version: " + tmp.getUpdateDate());

            assertEquals(programSession, tmp);

            trx.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            trx.rollback();
        }

        // Test ProgramSession StaleDataException
        // try
        // {
        // trx = session.beginTransaction();
        //
        // programSession.setName("Spring Session");
        //
        // Thread thread = new Thread(new Runnable()
        // {
        //
        // public void run()
        // {
        // Session s = SessionFactoryUtil.getSession();
        //
        // RegistrationService svc = new RegistrationService();
        //
        // Transaction t;
        //
        // try
        // {
        // ProgramSession p2 = new ProgramSession();
        // BeanUtils.copyProperties(p2, programSession);
        // p2.setName("Summer Session");
        //
        // t = s.beginTransaction();
        //
        // svc.updateProgramSession(p2);
        //
        // t.commit();
        // } catch (Exception e)
        // {
        // e.printStackTrace();
        // }
        // }
        //
        // });
        //
        // thread.start();
        //
        // // Last update original transient object, should throw exception
        // service.updateProgramSession(programSession);
        //
        // trx.commit();
        // assertFalse(true);
        // } catch (Exception e)
        // {
        // assertTrue(true);
        // e.printStackTrace();
        // trx.rollback();
        // }

    }

    @Test
    public void testSchool() throws Exception
    {
        System.out.println(this.getClass().getSimpleName() + ".testSchool");

        School school = new School();
        school.setName("Pittsburg High School");
        school.setAddressLine1("100 4th Street");
        school.setAddressLine2("Box 100");
        school.setCity("Pittsburg");
        school.setState("KS");
        school.setZipcode(66762);

        Transaction trx = null;
        try
        {
            trx = session.beginTransaction();

            service.addSchool(school);

            School tmp = service.getSchool(school.getId());

            assertEquals(school, tmp);

            trx.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            trx.rollback();
        }
    }

    @Test
    public void testRegistration() throws Exception
    {
        System.out.println(this.getClass().getSimpleName()
                + ".testRegistration");

        Transaction trx = null;

        Registration registration = new Registration();
        registration.setAge(43);
        registration.setRegistrantAddr("101 Test Street, Pittsburg, KS  66762");
        registration.setRegistrantName("Joe Schmoe");
        registration.setRegistrantPhone("1112223333");

        // Test addRegistration
        try
        {
            trx = session.beginTransaction();

            service.addRegistration(registration);

            Registration tmpReg = service.getRegistration(registration.getId());

            assertEquals(registration, tmpReg);

            trx.commit();

        } catch (Exception e)
        {
            e.printStackTrace();
            trx.rollback();
        }

        // Test updateRegistration
        try
        {
            trx = session.beginTransaction();

            registration.setAmountPaid(9.99);
            registration.setSize("Large");

            service.updateRegistration(registration);

            Registration tmpReg = service.getRegistration(registration.getId());

            assertEquals(registration, tmpReg);

            trx.commit();

        } catch (Exception e)
        {
            e.printStackTrace();
            trx.rollback();
        }
    }

}

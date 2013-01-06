/**
 * 
 */
package com.metispro.business.registration.test;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metispro.business.registration.RegistrationService;
import com.metispro.jdbc.hibernate.SessionFactoryUtil;
import com.metispro.model.registration.School;

/**
 * @author Tim
 * 
 */
public class RegistrationServiceTest
{
    Session session = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        session = SessionFactoryUtil.getSession();
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
    public void testSchool()
    {
        RegistrationService service = new RegistrationService();

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

            assertEquals(school.getId(), tmp.getId());
            assertEquals(school.getName(), tmp.getName());
            assertEquals(school.getAddressLine1(), tmp.getAddressLine1());
            assertEquals(school.getAddressLine2(), tmp.getAddressLine2());
            assertEquals(school.getCity(), tmp.getCity());
            assertEquals(school.getState(), tmp.getState());
            assertEquals(school.getZipcode(), tmp.getZipcode());

            trx.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            trx.rollback();
        }
    }

}

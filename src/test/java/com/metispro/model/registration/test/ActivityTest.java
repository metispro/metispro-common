/**
 * 
 */
package com.metispro.model.registration.test;

import java.util.Date;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metispro.jdbc.hibernate.SessionFactoryUtil;
import com.metispro.model.registration.Activity;

/**
 * @author Tim
 * 
 */
public class ActivityTest
{

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testActivity()
    {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        session.save(new Activity().setAccount("account")
                .setActivityDate(new Date()).setFee(1.50).setName("TEST"));
        session.getTransaction().commit();

    }

}

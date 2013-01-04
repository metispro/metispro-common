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
    private Session session = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        session = SessionFactoryUtil.getSessionFactory().openSession();
        // session.getTransaction().begin();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
        // session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testActivity() throws Exception
    {
        Activity activity = new Activity().setAccount("account")
                .setActivityDate(new Date()).setFee(1.50).setName("TEST");
        session.save(activity);

        System.out.println("id = " + activity.getId());

        this.nestedTransaction();
    }

    private void nestedTransaction() throws Exception
    {
        Activity activity = new Activity().setAccount("account2")
                .setActivityDate(new Date()).setFee(1.50).setName("TEST2");

        session.save(activity);
        System.out.println("id = " + activity.getId());

    }
}

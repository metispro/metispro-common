package com.metispro.model.registration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Tim
 * 
 */
@Entity
public class Activity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 255)
    private String name;

    @Column(name = "ACTIVITY_DATE")
    private Date activityDate;

    private Double fee;

    @Column(length = 255)
    private String account;

    @Column(name = "SIGNUP_DEADLINE")
    private Date signupDeadline;

    public long getId()
    {
        return id;
    }

    public Activity setId(long id)
    {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * 
     * @param name
     */
    public Activity setName(String name)
    {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     */
    public Date getActivityDate()
    {
        return activityDate;
    }

    /**
     * 
     * @param activityDate
     */
    public Activity setActivityDate(Date activityDate)
    {
        this.activityDate = activityDate;
        return this;
    }

    /**
     * 
     * @return
     */
    public Double getFee()
    {
        return fee;
    }

    /**
     * 
     * @param fee
     */
    public Activity setFee(Double fee)
    {
        this.fee = fee;
        return this;
    }

    /**
     * 
     * @return
     */
    public String getAccount()
    {
        return account;
    }

    /**
     * 
     * @param account
     */
    public Activity setAccount(String account)
    {
        this.account = account;
        return this;
    }

    /**
     * 
     * @return
     */
    public Date getSignupDeadline()
    {
        return signupDeadline;
    }

    /**
     * 
     * @param signupDeadline
     */
    public Activity setSignupDeadline(Date signupDeadline)
    {
        this.signupDeadline = signupDeadline;
        return this;
    }

}

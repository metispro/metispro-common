package com.metispro.model.registration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

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

    @Version
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

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
     * @return the updateDate
     */
    public Date getUpdateDate()
    {
        return updateDate;
    }

    /**
     * @param updateDate
     *            the updateDate to set
     */
    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        result = prime * result
                + ((activityDate == null) ? 0 : activityDate.hashCode());
        result = prime * result + ((fee == null) ? 0 : fee.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((signupDeadline == null) ? 0 : signupDeadline.hashCode());
        result = prime * result
                + ((updateDate == null) ? 0 : updateDate.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Activity other = (Activity) obj;
        if (account == null)
        {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        if (activityDate == null)
        {
            if (other.activityDate != null)
                return false;
        } else if (!activityDate.equals(other.activityDate))
            return false;
        if (fee == null)
        {
            if (other.fee != null)
                return false;
        } else if (!fee.equals(other.fee))
            return false;
        if (id != other.id)
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (signupDeadline == null)
        {
            if (other.signupDeadline != null)
                return false;
        } else if (!signupDeadline.equals(other.signupDeadline))
            return false;
        if (updateDate == null)
        {
            if (other.updateDate != null)
                return false;
        } else if (!updateDate.equals(other.updateDate))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Activity [id=").append(id).append(", updateDate=")
                .append(updateDate).append(", name=").append(name)
                .append(", activityDate=").append(activityDate)
                .append(", fee=").append(fee).append(", account=")
                .append(account).append(", signupDeadline=")
                .append(signupDeadline).append("]");
        return builder.toString();
    }

}

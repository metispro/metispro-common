/**
 * 
 */
package com.metispro.model.registration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author Tim
 * 
 */
@Entity
public class Program
{

    public enum Type
    {
        CLASS, LEAGUE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "PROGRAM_TYPE", length = 30)
    private Type programType;

    private String name;

    private String description;

    private Double fee;

    private String account;

    /**
     * @return the id
     */
    public long getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id)
    {
        this.id = id;
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
     * @return the programType
     */
    public Type getProgramType()
    {
        return programType;
    }

    /**
     * @param programType
     *            the programType to set
     */
    public void setProgramType(Type programType)
    {
        this.programType = programType;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the fee
     */
    public Double getFee()
    {
        return fee;
    }

    /**
     * @param fee
     *            the fee to set
     */
    public void setFee(Double fee)
    {
        this.fee = fee;
    }

    /**
     * @return the account
     */
    public String getAccount()
    {
        return account;
    }

    /**
     * @param account
     *            the account to set
     */
    public void setAccount(String account)
    {
        this.account = account;
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
                + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((fee == null) ? 0 : fee.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((programType == null) ? 0 : programType.hashCode());
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
        Program other = (Program) obj;
        if (account == null)
        {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        if (description == null)
        {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
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
        if (programType != other.programType)
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
        builder.append("Program [id=").append(id).append(", updateDate=")
                .append(updateDate).append(", programType=")
                .append(programType).append(", name=").append(name)
                .append(", description=").append(description).append(", fee=")
                .append(fee).append(", account=").append(account).append("]");
        return builder.toString();
    }

}

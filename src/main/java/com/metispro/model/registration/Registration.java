package com.metispro.model.registration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 * 
 * @author Tim
 * 
 */
@Entity
public class Registration
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "PROGRAM_ID")
    private Program program;

    @Column(name = "REGISTRANT_NAME")
    private String registrantName;

    @Column(name = "REGISTRANT_PHONE")
    private String registrantPhone;

    @Column(name = "REGISTRANT_ADDR")
    private String registrantAddr;

    private String size;

    private int age;

    private long memberId;

    @Column(name = "AMOUNT_PAID")
    private Double amountPaid;

    @Column(name = "TRANSFER_NUM")
    private int transferNum;

    /**
     * 
     * @return
     */
    public long getId()
    {
        return id;
    }

    /**
     * 
     * @param id
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
     * 
     * @return
     */
    public Program getProgram()
    {
        return program;
    }

    /**
     * 
     * @param program
     */
    public void setProgram(Program program)
    {
        this.program = program;
    }

    /**
     * 
     * @return
     */
    public String getRegistrantName()
    {
        return registrantName;
    }

    /**
     * 
     * @param registrantName
     */
    public void setRegistrantName(String registrantName)
    {
        this.registrantName = registrantName;
    }

    /**
     * 
     * @return
     */
    public String getRegistrantPhone()
    {
        return registrantPhone;
    }

    /**
     * 
     * @param registrantPhone
     */
    public void setRegistrantPhone(String registrantPhone)
    {
        this.registrantPhone = registrantPhone;
    }

    /**
     * 
     * @return
     */
    public String getRegistrantAddr()
    {
        return registrantAddr;
    }

    /**
     * 
     * @param registrantAddr
     */
    public void setRegistrantAddr(String registrantAddr)
    {
        this.registrantAddr = registrantAddr;
    }

    /**
     * 
     * @return
     */
    public String getSize()
    {
        return size;
    }

    /**
     * 
     * @param size
     */
    public void setSize(String size)
    {
        this.size = size;
    }

    /**
     * 
     * @return
     */
    public int getAge()
    {
        return age;
    }

    /**
     * 
     * @param age
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * 
     * @return
     */
    public long getMemberId()
    {
        return memberId;
    }

    /**
     * 
     * @param memberId
     */
    public void setMemberId(long memberId)
    {
        this.memberId = memberId;
    }

    /**
     * 
     * @return
     */
    public Double getAmountPaid()
    {
        return amountPaid;
    }

    /**
     * 
     * @param amountPaid
     */
    public void setAmountPaid(Double amountPaid)
    {
        this.amountPaid = amountPaid;
    }

    /**
     * 
     * @return
     */
    public int getTransferNum()
    {
        return transferNum;
    }

    /**
     * 
     * @param transferNum
     */
    public void setTransferNum(int transferNum)
    {
        this.transferNum = transferNum;
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
        result = prime * result + age;
        result = prime * result
                + ((amountPaid == null) ? 0 : amountPaid.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (int) (memberId ^ (memberId >>> 32));
        result = prime * result + ((program == null) ? 0 : program.hashCode());
        result = prime * result
                + ((registrantAddr == null) ? 0 : registrantAddr.hashCode());
        result = prime * result
                + ((registrantName == null) ? 0 : registrantName.hashCode());
        result = prime * result
                + ((registrantPhone == null) ? 0 : registrantPhone.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + transferNum;
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
        Registration other = (Registration) obj;
        if (age != other.age)
            return false;
        if (amountPaid == null)
        {
            if (other.amountPaid != null)
                return false;
        } else if (!amountPaid.equals(other.amountPaid))
            return false;
        if (id != other.id)
            return false;
        if (memberId != other.memberId)
            return false;
        if (program == null)
        {
            if (other.program != null)
                return false;
        } else if (!program.equals(other.program))
            return false;
        if (registrantAddr == null)
        {
            if (other.registrantAddr != null)
                return false;
        } else if (!registrantAddr.equals(other.registrantAddr))
            return false;
        if (registrantName == null)
        {
            if (other.registrantName != null)
                return false;
        } else if (!registrantName.equals(other.registrantName))
            return false;
        if (registrantPhone == null)
        {
            if (other.registrantPhone != null)
                return false;
        } else if (!registrantPhone.equals(other.registrantPhone))
            return false;
        if (size == null)
        {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
            return false;
        if (transferNum != other.transferNum)
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
        builder.append("Registration [id=").append(id).append(", updateDate=")
                .append(updateDate).append(", program=").append(program)
                .append(", registrantName=").append(registrantName)
                .append(", registrantPhone=").append(registrantPhone)
                .append(", registrantAddr=").append(registrantAddr)
                .append(", size=").append(size).append(", age=").append(age)
                .append(", memberId=").append(memberId).append(", amountPaid=")
                .append(amountPaid).append(", transferNum=")
                .append(transferNum).append("]");
        return builder.toString();
    }

}

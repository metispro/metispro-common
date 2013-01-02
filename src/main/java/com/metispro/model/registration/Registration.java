package com.metispro.model.registration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

}

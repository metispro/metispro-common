package com.metispro.model.registration;

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
public class Participant
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 60)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 60)
    private String lastName;

    @Column(name = "MIDDLE_NAME", length = 60)
    private String middleName;

    @Column(name = "ADDRESS_LINE1")
    private String addressLine1;

    @Column(name = "ADDRESS_LINE2")
    private String addressLine2;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String state;

    private int zipcode;

    private int phone;

    @Column(length = 10)
    private String size;

    private int age;

    @Column(length = 20)
    private String grade;

    private Double balance;

    @Column(length = 1)
    private String scholarship;

    private long membershipId;

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
     * 
     * @return
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * 
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     */
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName()
    {
        return middleName;
    }

    /**
     * @param middleName
     *            the middleName to set
     */
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    /**
     * 
     * @return
     */
    public String getAddressLine1()
    {
        return addressLine1;
    }

    /**
     * 
     * @param addressLine1
     */
    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    /**
     * 
     * @return
     */
    public String getAddressLine2()
    {
        return addressLine2;
    }

    /**
     * 
     * @param addressLine2
     */
    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    /**
     * 
     * @return
     */
    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * 
     * @return
     */
    public String getState()
    {
        return state;
    }

    /**
     * 
     * @param state
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * 
     * @return
     */
    public int getZipcode()
    {
        return zipcode;
    }

    /**
     * 
     * @param zipcode
     */
    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }

    /**
     * 
     * @return
     */
    public int getPhone()
    {
        return phone;
    }

    /**
     * 
     * @param phone
     */
    public void setPhone(int phone)
    {
        this.phone = phone;
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
    public String getGrade()
    {
        return grade;
    }

    /**
     * 
     * @param grade
     */
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    /**
     * 
     * @return
     */
    public Double getBalance()
    {
        return balance;
    }

    /**
     * 
     * @param balance
     */
    public void setBalance(Double balance)
    {
        this.balance = balance;
    }

    /**
     * 
     * @return
     */
    public String getScholarship()
    {
        return scholarship;
    }

    /**
     * 
     * @param scholarship
     */
    public void setScholarship(String scholarship)
    {
        this.scholarship = scholarship;
    }

    /**
     * 
     * @return
     */
    public long getMembershipId()
    {
        return membershipId;
    }

    /**
     * 
     * @param membershipId
     */
    public void setMembershipId(long membershipId)
    {
        this.membershipId = membershipId;
    }

}

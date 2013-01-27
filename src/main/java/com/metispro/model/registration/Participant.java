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
public class Participant
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

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
        result = prime * result
                + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
        result = prime * result
                + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
        result = prime * result + age;
        result = prime * result + ((balance == null) ? 0 : balance.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result
                + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((grade == null) ? 0 : grade.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result
                + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + (int) (membershipId ^ (membershipId >>> 32));
        result = prime * result
                + ((middleName == null) ? 0 : middleName.hashCode());
        result = prime * result + phone;
        result = prime * result
                + ((scholarship == null) ? 0 : scholarship.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result
                + ((updateDate == null) ? 0 : updateDate.hashCode());
        result = prime * result + zipcode;
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
        Participant other = (Participant) obj;
        if (addressLine1 == null)
        {
            if (other.addressLine1 != null)
                return false;
        } else if (!addressLine1.equals(other.addressLine1))
            return false;
        if (addressLine2 == null)
        {
            if (other.addressLine2 != null)
                return false;
        } else if (!addressLine2.equals(other.addressLine2))
            return false;
        if (age != other.age)
            return false;
        if (balance == null)
        {
            if (other.balance != null)
                return false;
        } else if (!balance.equals(other.balance))
            return false;
        if (city == null)
        {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (firstName == null)
        {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (grade == null)
        {
            if (other.grade != null)
                return false;
        } else if (!grade.equals(other.grade))
            return false;
        if (id != other.id)
            return false;
        if (lastName == null)
        {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (membershipId != other.membershipId)
            return false;
        if (middleName == null)
        {
            if (other.middleName != null)
                return false;
        } else if (!middleName.equals(other.middleName))
            return false;
        if (phone != other.phone)
            return false;
        if (scholarship == null)
        {
            if (other.scholarship != null)
                return false;
        } else if (!scholarship.equals(other.scholarship))
            return false;
        if (size == null)
        {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
            return false;
        if (state == null)
        {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (updateDate == null)
        {
            if (other.updateDate != null)
                return false;
        } else if (!updateDate.equals(other.updateDate))
            return false;
        if (zipcode != other.zipcode)
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
        builder.append("Participant [id=").append(id).append(", updateDate=")
                .append(updateDate).append(", firstName=").append(firstName)
                .append(", lastName=").append(lastName).append(", middleName=")
                .append(middleName).append(", addressLine1=")
                .append(addressLine1).append(", addressLine2=")
                .append(addressLine2).append(", city=").append(city)
                .append(", state=").append(state).append(", zipcode=")
                .append(zipcode).append(", phone=").append(phone)
                .append(", size=").append(size).append(", age=").append(age)
                .append(", grade=").append(grade).append(", balance=")
                .append(balance).append(", scholarship=").append(scholarship)
                .append(", membershipId=").append(membershipId).append("]");
        return builder.toString();
    }

}

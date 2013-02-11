package com.metispro.model.registration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class ProgramSession
{

    @Id
    @GeneratedValue
    private long id;

    @Version
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    private String name;

    @Column(name = "BEGIN_DATE")
    private Date beginDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "SIGNUP_DEADLINE")
    private Date signUpDeadline;

    @ManyToOne
    @JoinColumn(name = "PROGRAM_ID")
    private Program program;

    @Column(name = "SESSION_NOTE")
    private String sessionNote;

    public long getId()
    {
        return id;
    }

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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getBeginDate()
    {
        return beginDate;
    }

    public void setBeginDate(Date beginDate)
    {
        this.beginDate = beginDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    /**
     * @return the signUpDeadline
     */
    public Date getSignUpDeadline()
    {
        return signUpDeadline;
    }

    /**
     * @param signUpDeadline
     *            the signUpDeadline to set
     */
    public void setSignUpDeadline(Date signUpDeadline)
    {
        this.signUpDeadline = signUpDeadline;
    }

    /**
     * @return the program
     */
    public Program getProgram()
    {
        return program;
    }

    /**
     * @param program
     *            the program to set
     */
    public void setProgram(Program program)
    {
        this.program = program;
    }

    /**
     * @return the sessionNote
     */
    public String getSessionNote()
    {
        return sessionNote;
    }

    /**
     * @param sessionNote
     *            the sessionNote to set
     */
    public void setSessionNote(String sessionNote)
    {
        this.sessionNote = sessionNote;
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
                + ((beginDate == null) ? 0 : beginDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((program == null) ? 0 : program.hashCode());
        result = prime * result
                + ((sessionNote == null) ? 0 : sessionNote.hashCode());
        result = prime * result
                + ((signUpDeadline == null) ? 0 : signUpDeadline.hashCode());
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
        ProgramSession other = (ProgramSession) obj;
        if (beginDate == null)
        {
            if (other.beginDate != null)
                return false;
        } else if (!beginDate.equals(other.beginDate))
            return false;
        if (endDate == null)
        {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (id != other.id)
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (program == null)
        {
            if (other.program != null)
                return false;
        } else if (!program.equals(other.program))
            return false;
        if (sessionNote == null)
        {
            if (other.sessionNote != null)
                return false;
        } else if (!sessionNote.equals(other.sessionNote))
            return false;
        if (signUpDeadline == null)
        {
            if (other.signUpDeadline != null)
                return false;
        } else if (!signUpDeadline.equals(other.signUpDeadline))
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
        builder.append("ProgramSession [id=").append(id)
                .append(", updateDate=").append(updateDate).append(", name=")
                .append(name).append(", beginDate=").append(beginDate)
                .append(", endDate=").append(endDate)
                .append(", signUpDeadline=").append(signUpDeadline)
                .append(", program=").append(program).append(", sessionNote=")
                .append(sessionNote).append("]");
        return builder.toString();
    }

}

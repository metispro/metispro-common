/**
 * 
 */
package com.metispro.model.registration;

import java.util.Date;

/**
 * @author Tim
 *
 */
public class Program {
	
	private enum Type {
		CLASS, LEAGUE
	}
	
	private long id;
	
	private Type programType;
	
	private String name;
	
	private String description;
	
	private Double fee;
	
	private String account;
	
	private Date signUpDeadline;
	
	private Session session;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the programType
	 */
	public Type getProgramType() {
		return programType;
	}

	/**
	 * @param programType the programType to set
	 */
	public void setProgramType(Type programType) {
		this.programType = programType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the fee
	 */
	public Double getFee() {
		return fee;
	}

	/**
	 * @param fee the fee to set
	 */
	public void setFee(Double fee) {
		this.fee = fee;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the signUpDeadline
	 */
	public Date getSignUpDeadline() {
		return signUpDeadline;
	}

	/**
	 * @param signUpDeadline the signUpDeadline to set
	 */
	public void setSignUpDeadline(Date signUpDeadline) {
		this.signUpDeadline = signUpDeadline;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	

}

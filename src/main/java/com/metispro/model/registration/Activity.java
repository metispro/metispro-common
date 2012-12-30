package com.metispro.model.registration;

import java.util.Date;

public class Activity {
	
	private long id;
	
	private String name;
	
	private Date activityDate;
	
	private Double fee;
	
	private String account;
	
	private Date signupDeadline;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getSignupDeadline() {
		return signupDeadline;
	}

	public void setSignupDeadline(Date signupDeadline) {
		this.signupDeadline = signupDeadline;
	}
	
	

}

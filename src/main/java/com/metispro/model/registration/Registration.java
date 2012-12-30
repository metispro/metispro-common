package com.metispro.model.registration;

public class Registration {
	
	private long id;
	
	private Program program;
	
	private String registrantName;
	
	private String registrantPhone;
	
	private String registrantAddr;
	
	private String size;
	
	private int age;
	
	private long memberId;
	
	private Double amountPaid;
	
	private int transferNum;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public String getRegistrantName() {
		return registrantName;
	}

	public void setRegistrantName(String registrantName) {
		this.registrantName = registrantName;
	}

	public String getRegistrantPhone() {
		return registrantPhone;
	}

	public void setRegistrantPhone(String registrantPhone) {
		this.registrantPhone = registrantPhone;
	}

	public String getRegistrantAddr() {
		return registrantAddr;
	}

	public void setRegistrantAddr(String registrantAddr) {
		this.registrantAddr = registrantAddr;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getTransferNum() {
		return transferNum;
	}

	public void setTransferNum(int transferNum) {
		this.transferNum = transferNum;
	}
	
	

}

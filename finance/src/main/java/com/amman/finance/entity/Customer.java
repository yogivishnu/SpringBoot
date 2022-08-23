package com.amman.finance.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String firstName;
	
	//private String gender;
	private String mobileNumber;
	@Column(nullable = false)
	private String aadharNumer;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String loanDate;
	
	private int loanAmount;
	
	private int loanInstallment;
	
	@Column(name = "modifiedDate")
	private java.sql.Date modifiedDate;
	
	
	
	@OneToMany(targetEntity = DaySheet.class,cascade = CascadeType.ALL)
	
	@JoinColumn(name = "cl_fk",referencedColumnName ="customerId" )
	private List<DaySheet> daySheets;
	
	
	
	public List<DaySheet> getDaySheets() {
		return daySheets;
	}

	public void setDaySheets(List<DaySheet> daySheets) {
		this.daySheets = daySheets;
	}

	public Customer(Long customerId, String firstName, String mobileNumber, String aadharNumer, String loanDate,
			int loanAmount, int loanInstallment, Date modifiedDate, List<DaySheet> daySheets) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.mobileNumber = mobileNumber;
		this.aadharNumer = aadharNumer;
		this.loanDate = loanDate;
		this.loanAmount = loanAmount;
		this.loanInstallment = loanInstallment;
		this.modifiedDate = modifiedDate;
		this.daySheets = daySheets;
	}

	public int getloanInstallment() {
		return loanInstallment;
	}

	public void setloanInstallment(int loanInstallment) {
		this.loanInstallment = loanInstallment;
	}

	public java.sql.Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(java.sql.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}


	//@DateTimeFormat(pattern="dd-MM-yyyy")
	

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAadharNumer() {
		return aadharNumer;
		
	}

	public void setAadharNumer(String aadharNumer) {
		this.aadharNumer = aadharNumer;
	}


	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public Date getCreatedDate() {
		return modifiedDate;
	}

	public Date setCreatedDate(Date date) {
		return this.modifiedDate = date;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", mobileNumber=" + mobileNumber
				+ ", aadharNumer=" + aadharNumer + ", loanDate=" + loanDate + ", loanAmount=" + loanAmount
				+ ", loanInstallment=" + loanInstallment + ", modifiedDate=" + modifiedDate + ", daySheets=" + daySheets
				+ "]";
	}

	

	public Customer() {
		super();
	}

	

	
	
	
	
	
	

}

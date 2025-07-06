package com.auto.mailer.bean;

public class GoogleSheetBean {
	
	private String serialNumber;
	private String emailId;
	private String isMailSent;
	private String date;
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getIsMailSent() {
		return isMailSent;
	}
	public void setIsMailSent(String isMailSent) {
		this.isMailSent = isMailSent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "GoogleSheetBean [serialNumber=" + serialNumber + ", emailId=" + emailId + ", isMailSent=" + isMailSent
				+ ", date=" + date + "]";
	}
	
	

}

package com.society.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "inTime", "outTime" }, allowGetters = true)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Code")
	private Long userCode;

	@NotBlank
	@Column(name = "User_Name")
	public String userName;

	@NotBlank
	@Column(name = "First_Name")
	public String firstName;

	@NotBlank
	@Column(name = "Last_Name")
	public String lastName;

	@NotBlank
	@Email
	@Column(name = "Email_Id")
	public String emailId;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date inTime;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date outTime;

	public String getEmailId() {
		return emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getUserCode() {
		return userCode;
	}

	public Date getInTime() {
		return inTime;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getOutTime() {
		return outTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

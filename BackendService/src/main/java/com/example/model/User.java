package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voda_user")
public class User {

	 @Id
	 @Column(name="userid")
	 private Integer userid;
	 
	 @Column(name="username") 
	 private String msisdn;
	
	 @Column(name="password")
	 private String password;
	 
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", msisdn=" + msisdn + ", password="
				+ password + "]";
	}

}

package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_mi")
public class MobileInternet {
	@OneToOne
	private User user;
	@Id
	private Integer id;
	private Long balance;
	private Long sallefny;
	private String ratePlan;
	private String usbMsisdn;
	private Long consumedData;
	private Long totalQouta;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Long getSallefny() {
		return sallefny;
	}
	public void setSallefny(Long sallefny) {
		this.sallefny = sallefny;
	}
	public String getRatePlan() {
		return ratePlan;
	}
	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}
	public String getUsbMsisdn() {
		return usbMsisdn;
	}
	public void setUsbMsisdn(String usbMsisdn) {
		this.usbMsisdn = usbMsisdn;
	}
	public Long getConsumedData() {
		return consumedData;
	}
	public void setConsumedData(Long consumedData) {
		this.consumedData = consumedData;
	}
	public Long getTotalQouta() {
		return totalQouta;
	}
	public void setTotalQouta(Long totalQouta) {
		this.totalQouta = totalQouta;
	}
}

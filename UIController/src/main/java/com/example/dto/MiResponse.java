package com.example.dto;

public class MiResponse {
	private Long balance;
	private Long sallefny; 
	private String ratePlan;
	private Long consumedQouta;
	private Long totalQouta;
	private String usbMsisdn;

	public MiResponse() {
	}

	public MiResponse(Long balance, Long sallefny) {
		super();
		this.balance = balance;
		this.sallefny = sallefny;
	}
	
	public MiResponse(Long balance, Long sallefny, String ratePlan, Long consumedQouta, Long totalQouta) {
		super();
		this.balance = balance;
		this.sallefny = sallefny;
		this.ratePlan = ratePlan;
		this.consumedQouta = consumedQouta;
		this.totalQouta = totalQouta;
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

	public Long getConsumedQouta() {
		return consumedQouta;
	}

	public void setConsumedQouta(Long consumedQouta) {
		this.consumedQouta = consumedQouta;
	}

	public Long getTotalQouta() {
		return totalQouta;
	}

	public void setTotalQouta(Long totalQouta) {
		this.totalQouta = totalQouta;
	}

	public String getUsbMsisdn() {
		return usbMsisdn;
	}

	public void setUsbMsisdn(String usbMsisdn) {
		this.usbMsisdn = usbMsisdn;
	}

	@Override
	public String toString() {
		return "MiResponse {\"balance\":" + balance + ", \"sallefny\":" + sallefny + ", \"ratePlan\":" + ratePlan
				+ ", \"consumedQouta\":" + consumedQouta + ", \"totalQouta\":" + totalQouta + ", \"usbMsisdn\":"
				+ usbMsisdn + "}";
	}
}

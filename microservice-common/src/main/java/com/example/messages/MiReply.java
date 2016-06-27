package com.example.messages;

public class MiReply extends BasicMessage {
	private Long balance;
	private Long sallefny;
	private String ratePlan;
	private Long consumedQouta;
	private Long totalQouta;
	private String usbMsisdn;
	

	public MiReply() {
	}

	public MiReply(String correlationId, String sessionId) {
		super(correlationId, sessionId);
	}
	
	public MiReply(String correlationId, String sessionId, Long balance, Long sallefny, String ratePlan,
			Long consumedQouta, Long totalQouta) {
		super(correlationId, sessionId);
		this.balance = balance;
		this.sallefny = sallefny;
		this.ratePlan = ratePlan;
		this.consumedQouta = consumedQouta;
		this.totalQouta = totalQouta;
	}

	public MiReply(String correlationId, String sessionId, Long balance, Long sallefny) {
		super(correlationId, sessionId);
		this.balance = balance;
		this.sallefny = sallefny;
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
		return "MiReply {\"balance\":" + balance + ", \"sallefny\":" + sallefny + ", \"ratePlan\":" + ratePlan
				+ ", \"consumedQouta\":" + consumedQouta + ", \"totalQouta\":" + totalQouta + ", \"usbMsisdn\":"
				+ usbMsisdn + "}";
	}

}

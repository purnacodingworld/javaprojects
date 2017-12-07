package com.banking.loans.util;

public class ResponseContent {

	private String transactionNo;
	private String responseCode;
	private String responseDesc;
		
	public ResponseContent(String transactionNo, String responseCode, String responseDesc) {
		super();
		this.transactionNo = transactionNo;
		this.responseCode = responseCode;
		this.responseDesc = responseDesc;
	}
	
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDesc() {
		return responseDesc;
	}
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}
	@Override
	public String toString(){
		return "{transactionNo:"+transactionNo+",responseCode:"+responseCode+",responseDesc:"+responseDesc+"}";
	}
}

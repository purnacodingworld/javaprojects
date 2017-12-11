package com.banking.loans.util;

public class ResponseContent {

	private String transactionNo;
	private String responseCode;
	private String responseDesc;	
	
	public ResponseContent(String transactionNo) {		
		this.transactionNo = transactionNo;		
	}
	
	public ResponseContent(String transactionNo,Exception ex) {		
		this.transactionNo = transactionNo;	
		this.responseCode = "FAILD";
		this.responseDesc = ex.getMessage();
	}
	
	public String getTransactionNo() {
		return transactionNo;
	}

	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
		System.out.println("responseCode desciption:"+BankingUsersConstants.getCodeMessage(responseCode));		
		this.responseDesc = BankingUsersConstants.getCodeMessage(responseCode);
	}
	public String getResponseDesc() {
		return responseDesc;
	}
		
	@Override
	public String toString(){
		return "{transactionNo:"+transactionNo+",responseCode:"+responseCode+",responseDesc:"+responseDesc+"}";
	}
}

package com.banking.loans.util;

public class TxnRefGenerator {

	private static TxnRefGenerator TxnRefGeneratot;
	private String TxnRefPrefix = "TXNREF";
	private long TxnRefPostfix = 123456;	
	private String TxnReference;
	private static Object monitor = new Object();
	private TxnRefGenerator(){		
	}
	
	public static TxnRefGenerator getInstance(){
		if(TxnRefGeneratot==null){
			synchronized (monitor) {
				TxnRefGeneratot = new TxnRefGenerator();
			}			
		}
		return TxnRefGeneratot;
	}
	
	public String generateTxnRef(){
		TxnReference = TxnRefPrefix+(TxnRefPostfix+1);
		return TxnReference;
	}
}

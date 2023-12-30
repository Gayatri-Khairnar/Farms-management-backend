package com.agro.entity;

import com.agro.entity.User;

public class PaymentHistory {
	private int id;
	private String transactionId;
	private User user;
	private double amount;
	private PaymentStatus status;
	private TransactionType transactionType;
	
	public static enum PaymentStatus{
		PENDING , FAILED , SUCCESSFULL ;
	}
	
	public static enum TransactionType{
		CREDIT , DEBIT;
	}
}

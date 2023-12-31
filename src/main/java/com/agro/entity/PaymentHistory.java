package com.agro.entity;

import com.agro.entity.User;

import jakarta.persistence.*;

@Entity
@Table(name="paymenthistory")
public class PaymentHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="paymenthistory_id")
	private int id;
	private String transactionId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	public static enum PaymentStatus{
		PENDING , FAILED , SUCCESSFULL ;
	}
	
	public static enum TransactionType{
		CREDIT , DEBIT;
	}
}

package com.agro.entity;

import com.agro.entity.User;
import jakarta.persistence.*;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
	public static enum PaymentStatus{
		PENDING , FAILED , SUCCESSFULL ;
	}
	
	public static enum TransactionType{
		CREDIT , DEBIT;
	}
}

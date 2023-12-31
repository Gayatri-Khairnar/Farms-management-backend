package com.agro.entity;

import com.agro.entity.User;

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
@Table(name="payment_history")
public class PaymentHistory {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
	private int id;
	private String transactionId;

	private double amount;
	private PaymentStatus status;
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

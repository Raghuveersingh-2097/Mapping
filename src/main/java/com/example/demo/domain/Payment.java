package com.example.demo.domain;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
@Data
@Entity
public class Payment {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@Column(unique=true)
private String transactionId;
private Double actualAmount;
private String paymentIdentifier;
@NotBlank(message="Payment Gateway Reqiured")
private String paymentGateway;
private Double discount;
	
/**---------------------------ManytoOne Mapping with customer--------------------------------**/
@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
@JoinColumn(name = "customer_id", updatable = false, nullable = false)
@JsonIgnore
private Customer customer;

}

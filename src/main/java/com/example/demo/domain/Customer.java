package com.example.demo.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@Entity
public class Customer {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotBlank(message="Contact Required")
@Size(max=10,min=10,message="Phone number must be 10 digits")
@Column(unique=true)
private String contact;
@NotBlank(message="Name Required")
private String name;
@NotBlank(message="Gender Required")
private String gender;
//@NotBlank(message="Nutrition-Plan Name Required")
//private String nutritionName;
@NotBlank(message="Customer Identifier Reqiured")
@Column(unique=true,updatable=false)
private String customerIdentifier;
@NotBlank(message="Payment Identifier Required")
@Column(unique=true,updatable=false)
private String paymentIdentifier;
private Integer PTSequence = 0;

/**----------------------------------OneToOne mapping with NutritionPLan-------------------------**/
@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="customer")
private DietPlan dietPlan;

/**----------------------------------OneToMany mapping with Payment-----------------------**/
@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL , mappedBy = "customer")
private List<Payment> payment=new ArrayList<>();

@Column(updatable=false)
private Date createdDate;
private Date updatedDate;

@PrePersist
public void onCreate() {
	this.createdDate=new Date();
}
@PreUpdate
public void onUpdate() {
	this.updatedDate=new Date();
}
}

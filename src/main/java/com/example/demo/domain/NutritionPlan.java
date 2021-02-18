package com.example.demo.domain;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@Entity
public class NutritionPlan {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String customerName;
@NotBlank(message="Plan Name Necessary")
private String PlanName;
private String description;
@Column(unique=true,updatable=false,nullable=false)
private String customerIdentifier;


/**----------------------------------OneToOne mapping with Customer-------------------------**/
@OneToOne(fetch=FetchType.EAGER)
@JoinColumn(name="Customer_id",nullable=false)
@JsonIgnore
private Customer customer;

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
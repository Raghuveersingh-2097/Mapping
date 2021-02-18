package com.example.demo.exception;

public class NutritionPlanExceptionResponse {

private String dietPlan;

public String getDietPlan() {
	return dietPlan;
}

public NutritionPlanExceptionResponse(String dietPlan) {
	super();
	this.dietPlan = dietPlan;
}

public void setDietPlan(String dietPlan) {
	this.dietPlan = dietPlan;
}	
}

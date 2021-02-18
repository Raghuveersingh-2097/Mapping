package com.example.demo.presentation;

public class DietInsertion {
public String ret() {
	return "Veg";
}
public Double carbs() {
	Double d=0.0;
	if(ret()=="Veg") {
		d=3.3;
	}else {
		d=3.8;
	}
	return d;
}
}

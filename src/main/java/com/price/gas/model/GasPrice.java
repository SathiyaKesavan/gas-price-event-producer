package com.price.gas.model;


public class GasPrice {
    private String currency;
    private String name;
    private String gasoline;
    private String midGrade;
    private String premium;
    private String diesel;
    
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGasoline() {
		return gasoline;
	}
	public void setGasoline(String gasoline) {
		this.gasoline = gasoline;
	}
	public String getMidGrade() {
		return midGrade;
	}
	public void setMidGrade(String midGrade) {
		this.midGrade = midGrade;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getDiesel() {
		return diesel;
	}
	public void setDiesel(String diesel) {
		this.diesel = diesel;
	}
}
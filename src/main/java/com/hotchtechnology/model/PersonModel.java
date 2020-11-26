package com.hotchtechnology.model;

public class PersonModel {

	private int id;
	private String name;
	private String mobile;
	private String country;
	private String state;
	private String city;
	public PersonModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonModel(int id, String name, String mobile, String city, String state, String country) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.country = country;
		this.state = state;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "PersonModel [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + ", state="
				+ state + ", city=" + city + "]";
	}
	
	
	
	
	
	
}

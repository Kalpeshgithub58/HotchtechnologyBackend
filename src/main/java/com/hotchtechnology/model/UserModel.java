package com.hotchtechnology.model;

public class UserModel {

 private int id;
 private String userName;
 private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserModel() {
	super();
	// TODO Auto-generated constructor stub
}
public UserModel(int id, String userName, String password) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
}
@Override
public String toString() {
	return "UserModel [id=" + id + ", userName=" + userName + ", password=" + password + "]";
}
 
 

 
 
 

}

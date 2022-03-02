package com.studentApp.models;

public class Administrator {
	
	int Admin_id;
	String Admin_name;
	String password;
	
	
	
	public Administrator(int admin_id, String admin_name, String password) {
		super();
		Admin_id = admin_id;
		Admin_name = admin_name;
		this.password = password;
	}
	
	
	public Administrator() {
		super();
		
	}



	public int getAdmin_id() {
		return Admin_id;
	}
	public void setAdmin_id(int admin_id) {
		Admin_id = admin_id;
	}
	public String getAdmin_name() {
		return Admin_name;
	}
	public void setAdmin_name(String admin_name) {
		Admin_name = admin_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}

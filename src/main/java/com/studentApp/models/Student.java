package com.studentApp.models;

public class Student 
{
	
	int sid;
	String studentName;
	int age;
	long phone;
	String emailId;
	String address;
	String password;
	
	
	public Student()
	{
		super();
		
	}


	public Student(int sid, String studentName, int age, long phone, String emailId, String address, String password)
	{
		super();
		this.sid = sid;
		this.studentName = studentName;
		this.age = age;
		this.phone = phone;
		this.emailId = emailId;
		this.address = address;
		this.password = password;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() 
	{
		return "Student [sid=" + sid + ", studentName=" + studentName + ", age=" + age + ", phone=" + phone
				+ ", emailId=" + emailId + ", address=" + address + ", password=" + password + "]";
	}
	

	

}



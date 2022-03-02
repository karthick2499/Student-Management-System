package com.studentApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminOperations {
	
	DatabaseConnectivity ob=new DatabaseConnectivity();
	Connection conn =ob.dbConnection();
	
	
	public boolean login(int adminid,String password) throws SQLException 
	{
		
		PreparedStatement ps=conn.prepareStatement("select * from admin where admin_id=? && password=?");
		ps.setInt(1, adminid);
		ps.setString(2, password);
		ResultSet result=ps.executeQuery();
		
		    if(result.next()) {
				return true; 
			}
			else {
				return false;
			}
	}
	
	
	
	public boolean admission(long sid,String sname,int age,long phone,String emailid,String address) throws SQLException {
		PreparedStatement ps =conn.prepareStatement("insert into student values(?,?,?,?,?,?)");
		ps.setLong(1, sid);
		ps.setString(2, sname);
		ps.setInt(3, age);
		ps.setLong(4, phone);
		ps.setString(5, emailid);
		ps.setString(6, address);
		
		int affectedRows =ps.executeUpdate();
		
		if(affectedRows>0) {
			return true;
		}else {
			return false;
		}	
	}
	
	
	
	public ResultSet subject(long sid) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from subject where sid=?");
		ps.setLong(1, sid);
		ResultSet result = ps.executeQuery();
		return result;
	}
	
	
	
	public boolean marks(long sid,double phy,double chem,double math) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("insert into subject values(?,?,?,?)");
		ps.setLong(1, sid);
		ps.setDouble(2, phy);
		ps.setDouble(3, chem);
		ps.setDouble(4, math);
		
		
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0) {
			return true;
		}else {
			return false;
		}	
	}
	
	public boolean enterFees(long sid,int first,int mid,int balance) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("insert into fees values(?,?,?,?)");
		ps.setLong(1, sid);
		ps.setDouble(2, first);
		ps.setDouble(3, mid);
		ps.setDouble(4, balance);
		
		
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0) {
			return true;
		}else {
			return false;
		}	
	}
	
	
	
	public ResultSet fees(long sid) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from fees where sid=?");
		ps.setLong(1, sid);
		ResultSet result=ps.executeQuery();
		return result;
	}



	public ResultSet studentInfo(long sid) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from student where sid=?");
		ps.setLong(1, sid);
		ResultSet result=ps.executeQuery();
		return result;
	}
	
	
	public boolean logout() throws SQLException {
		conn.close();
		return true;	
	}

}

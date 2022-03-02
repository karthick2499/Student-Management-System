package com.studentApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentOperations {
	
	DatabaseConnectivity ob=new DatabaseConnectivity();
	Connection conn =ob.dbConnection();
	
	
	public boolean login(long sid,String password) throws SQLException 
	{
		
		PreparedStatement ps=conn.prepareStatement("select * from student where sid=? && password=?");
		ps.setLong(1, sid);
		ps.setString(2, password);
		ResultSet result=ps.executeQuery();
		
		    if(result.next()) 
		    {
				return true; 
			}
			else 
			{
				return false;
			}
	}
	
	public ResultSet fees(long sid) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from fees where sid=?");
		ps.setLong(1, sid);
		ResultSet result=ps.executeQuery();
		return result;
	}
	
	public ResultSet subject(long sid) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from subject where sid=?");
		ps.setLong(1, sid);
		ResultSet result = ps.executeQuery();
		return result;
	}
	
	public ResultSet student(long sid1) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from student where sid=?");
		ps.setLong(1, sid1);
		ResultSet result=ps.executeQuery();
		return result;
	}
	
	public boolean logout() throws SQLException {
		conn.close();
		return true;	
	}
	
	

}


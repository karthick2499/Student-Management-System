package com.studentApp;

import java.sql.ResultSet;
import java.util.Scanner;

import com.studentApp.dao.AdminOperations;
import com.studentApp.dao.StudentOperations;

public class App 
{
    public static void main( String[] args )
    {
    	boolean status=true;
    	try
    	{
    		do
    		{
   	         Scanner scan = new Scanner(System.in);
   			 
      			 System.out.println("=======================================================================");
      			 System.out.println("                            Student Management System                  ");
      			 System.out.println("=======================================================================");
      			 System.out.println("1 -> Admin");
      		     System.out.println("2 -> Student");
      		     System.out.println("Enter your User Type:");
      		     int userType=scan.nextInt();
      		     
      		     if(userType==1)
      		     {
      		    	 System.out.println("Enter your Admin id:");
      				 	int adminid=scan.nextInt();
      				 	System.out.println("Enter Password:");
      				 	String password=scan.next();
      				 	
      				 	AdminOperations ob=new AdminOperations();
      				 	
      				 	
      				 	if(ob.login(adminid, password))
      				 	{
      				 		System.out.println("=======================================================================");
     				 		    System.out.println("Login successfull!!");
     				         System.out.println("=======================================================================");
     				         
      				 		System.out.println("=======================================================================");
     			        	    System.out.println("Options");
     			        	    System.out.println("1.New Admission\r\n"
     				        		 +"2.Existing student Information\r\n"
     				        		 +"3.Report\r\n"
     				        		 +"4.Enter mark\r\n"
     				        		 +"5.Enter fees amount\r\n"
     				        		 +"6.Fees Amount\r\n"
     				        		 +"7.Logout\r\n");
     			        	 System.out.println("=======================================================================");
     				         int input=scan.nextInt();
     				         
     				         if(input==1) 
     				         {
   			        	    System.out.println("Enter student Id:");
   			        		long sid=scan.nextLong();
   			        		
   			        		System.out.println("Enter student  name:");
   			        		String sname=scan.next();
   			        		
   			        		System.out.println("Enter student address:");
   			        		String address=scan.next();
   			        		
   			        		System.out.println("Enter student age:");
   			        		int age = scan.nextInt();
   			        		
   			        		System.out.println("Enter phone number:");
   			        		long phone=scan.nextLong();
   			        		
   			        		System.out.println("Enter valid email id:");
   			        		String emailid=scan.next();
   			        		
   			        		
   			        		if(ob.admission(sid,sname,age,phone,emailid,address))
   			        		{
   			                    System.out.println("=======================================================================");
   			        			System.out.println(" Student Account created successfully!!");
   			                    System.out.println("=======================================================================");

   			        		}
   			        		else
   			        		{   System.out.println("=======================================================================");
   			        			System.out.println("Problem in account creation!!");
   			                    System.out.println("=======================================================================");

   			        		}
   			        	 
   			         }
     				      else if(input==2) {
   				        	 System.out.println("Enter Student Id to check the Information:");
   				        		long sid=scan.nextLong();
   				        		ResultSet result=ob.studentInfo(sid);
   				        		while(result.next())
   				        		{
   				        			System.out.println("=======================================================================");
   				        			System.out.println("---Student Details ----");
   				                    System.out.println("=======================================================================");
   				                  
   				                    System.out.println("Student Name :"+result.getString(2));
   				        			System.out.println("Student age :"+result.getInt(3));
   				        			System.out.println("Phone number :"+result.getLong(4));
   				        			System.out.println("Email :"+result.getString(5));
   				        			System.out.println("Address:"+result.getString(6));
   				        			
   				        			
   				        		}
   				         }
     				         
     				   else if(input==3) {
   			        	 System.out.println("Enter Student Id:");
   			        	 long sid= scan.nextLong();
   			        	 ResultSet result=ob.subject(sid);
   			        	 while(result.next()) {
   			        		 System.out.println("=======================================================================");
   			        			System.out.println("---Marks Details ----");
   			                    System.out.println("=======================================================================");
   			                    
   			                    System.out.println("Physics :"+result.getDouble(2));
   			        			System.out.println("Chemistry :"+result.getDouble(3));
   			        			System.out.println("Maths :"+result.getDouble(4));
   			        		 
   			        	 }
   			         }
     				         
     				         
     				else if(input==4) {
   		        	 
   		        	 System.out.println("Enter student Id:");
   		        		long sid=scan.nextLong();
   		        		
   		        		System.out.println("Enter Physics :");
   		        		double phy = scan.nextDouble();
   		        		
   		        		System.out.println("Enter Chemistry :");
   		        		double chem = scan.nextDouble();
   		        		
   		        		System.out.println("Enter Maths :");
   		        		double math = scan.nextDouble();
   		        		
   		        		
   		        		
   		        		if(ob.marks(sid, phy, chem, math)) {
   		        			System.out.println("=======================================================================");
   		        			System.out.println("Marks updated!!");
   		                    System.out.println("=======================================================================");

   		        		}
   		        		
   		        	 
   		         }
     				else if(input==5) {
   		        	 
   	        	    System.out.println("Enter student Id:");
   	        		long sid=scan.nextLong();
   	        		
   	        		System.out.println("Enter First Term :");
   	        		int first= scan.nextInt();
   	        		
   	        		System.out.println("Enter Last Term :");
   	        		int mid= scan.nextInt();
   	        		
   	        		System.out.println("Enter Balance Amount :");
   	        		int balance= scan.nextInt();
   	        		
   	        		
   	        		
   	        		if(ob.enterFees(sid, first, mid, balance)) {
   	        			System.out.println("=======================================================================");
   	        			System.out.println("Fees amount updated!!");
   	                    System.out.println("=======================================================================");

   	        		}
   	        		
   	        	 
   	         }
     				         
     				         
     				else if(input==6) {
   		        	 System.out.println("Enter Student Id:");
   		        	 long sid= scan.nextLong();
   		        	 ResultSet result=ob.fees(sid);
   		        	 while(result.next()) {
   		        		 System.out.println("=======================================================================");
   		        			System.out.println("---Fees Details ----");
   		                    System.out.println("=======================================================================");
   		                    
   		                    System.out.println("First Term :"+result.getInt(2));
   		        			System.out.println("Mid Term :"+result.getInt(3));
   		        			System.out.println("Balance Amount :"+result.getInt(4));
   		        	 
   		         }
   		        	 
   		     }
     				else if(input==7) {
   		        	 if(ob.logout()) {
   		        		 status=false;
   		        		    System.out.println("=======================================================================");
   		                 
   		        			System.out.println("You are successfully logged out!!");
   		        			System.out.println("Thank You.");
   		        			System.out.println("=======================================================================");

   		        	 }
   		         }
      				    } 
           	else
           	{
           		System.out.println("Login unsuccessfull!!");
           	}
           	
           	
           }
      		      else if(userType==2)
        		     {
        		    	    System.out.println("Enter your student id:");
        		        	long sid=scan.nextLong();
        		        	System.out.println("Enter Password:");
        		        	String password=scan.next();
        		        	
        		        	StudentOperations ob1 = new StudentOperations();
        		        	
        		        	if(ob1.login(sid, password))
        		        	{
        		        		System.out.println("=======================================================================");
        		        		System.out.println("Login Successfull!!");
        		        		System.out.println("=======================================================================");

        		        		System.out.println("1.Student Details\r\n"
        		        				+ "2.Mark sheet\r\n"
        		        				+ "3.Fees Details\r\n"
        		        				+ "4.Logout\r\n");
        		        		int operation=scan.nextInt();
        		        		if(operation==1)
        		        		{
        		        			System.out.println("Enter Student Id to check the Information:");
     			        		long sid1=scan.nextLong();
     			        		ResultSet result=ob1.student(sid1);
     			        		while(result.next())
     			        		{
     			        			System.out.println("=======================================================================");
     			        			System.out.println("---Student Details ----");
     			                    System.out.println("=======================================================================");
     			                  
     			                    System.out.println("Student Name :"+result.getString(2));
     			        			System.out.println("Student age :"+result.getInt(3));
     			        			System.out.println("Phone number :"+result.getLong(4));
     			        			System.out.println("Email :"+result.getString(5));
     			        			System.out.println("Address:"+result.getString(6));
     			        			
     			        			
     			        		}
        		        		}
        	 				   else if(operation==2) {
       			        	 System.out.println("Enter Student Id:");
       			        	 long sid1= scan.nextLong();
       			        	 ResultSet result=ob1.subject(sid1);
       			        	 while(result.next()) {
       			        		 System.out.println("=======================================================================");
       			        			System.out.println("---Marks Details ----");
       			                    System.out.println("=======================================================================");
       			                    
       			                    System.out.println("Physics :"+result.getDouble(2));
       			        			System.out.println("Chemistry :"+result.getDouble(3));
       			        			System.out.println("Maths :"+result.getDouble(4));
       			        		 
       			        	 }
       			         }
        		        		else if(operation==3) {
        			        	 System.out.println("Enter Student Id:");
        			        	 long sid1= scan.nextLong();
        			        	 ResultSet result=ob1.fees(sid1);
        			        	 while(result.next()) {
        			        		 System.out.println("=======================================================================");
        			        			System.out.println("---Fees Details ----");
        			                    System.out.println("=======================================================================");
        			                    
        			                    System.out.println("First Term :"+result.getInt(2));
        			        			System.out.println("Mid Term :"+result.getInt(3));
        			        			System.out.println("Balance Amount :"+result.getInt(4));
        			        	 
        			         }
        			        	 
        			     }
        		        		else if(operation==4) {
        			        	 if(ob1.logout()) {
        			        		 status=false;
        			        		    System.out.println("=======================================================================");
        			                 
        			        			System.out.println("You are successfully logged out!!");
        			        			System.out.println("Thank You.");
        			        			System.out.println("=======================================================================");

        			        	 }
        			         }
        		        		else {
           	    		    	    System.out.println("=======================================================================");
         	                        System.out.println("                       Login unsuccessfull!!                         ");
         					        System.out.println("=======================================================================");
        		        		}
        		        		
        		        	}
        
        else
        {
        	System.out.println("Please provide a valid input..!!");
        }
        		     }
      
        		     }	while(status);		
    		}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
        
        
        
    }
}


package com;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConClass {	
	
	public void MyConnection()  {
		System.out.println("I am in connection class");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);			
			String url = "jdbc:mysql://localhost:3306/my_jdbc";
			String UserName="root";
			String Password="root";			
			Connection conn = DriverManager.getConnection(url, UserName, Password);			
			Statement stmn = conn.createStatement();
			
			String myQuerry = "insert into mytable values ('4','Shubham','HR', 60000);";
			stmn.executeUpdate(myQuerry);
			System.out.println("Qurry executed succesfully");
			conn.close();
			
			
			
		}catch(Exception e) {
			System.out.println("Database exception==>"+e);
		}		
	}
	
	public void DeleteMethod() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);			
			String url = "jdbc:mysql://localhost:3306/my_jdbc";
			String UserName="root";
			String Password="root";			
			Connection conn = DriverManager.getConnection(url, UserName, Password);			
			Statement stmn = conn.createStatement();
			
			String DeleteQuery = "delete from mytable where id = '4';";
			stmn.executeUpdate(DeleteQuery);
			conn.close();
			System.out.println("Qurry executed succesfully");
			
			
			
			
		}catch(Exception e) {
			
			
		}
		
		
	}
	
	public void MyUpdateQuerry() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);			
			String url = "jdbc:mysql://localhost:3306/my_jdbc";
			String UserName="root";
			String Password="root";			
			Connection conn = DriverManager.getConnection(url, UserName, Password);			
			Statement stmn = conn.createStatement();
			
			String updateQuery = "UPDATE `mytable` SET `Salary` = '60000' WHERE (`id` = '3');\r\n"
					+ "";
			stmn.executeUpdate(updateQuery);
			conn.close();
			System.out.println("Qurry executed succesfully");
			
		}catch(Exception e) {
			
		}
	}
	
	public void MySelectQuery() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);			
			String url = "jdbc:mysql://localhost:3306/my_jdbc";
			String UserName="root";
			String Password="root";			
			Connection conn = DriverManager.getConnection(url, UserName, Password);			
			Statement stmn = conn.createStatement();
			
			String MyQuery = "select * from mytable ;";
			ResultSet rs = stmn.executeQuery(MyQuery);
			/*
			System.out.println("Qurry executed succesfully");
			System.out.println("rs==>"+rs.next());
			System.out.println("rs==>"+rs.getString("Fname"));
			System.out.println("rs==>"+rs.getString("Post"));
			System.out.println("rs==>"+rs.getString("Salary"));
			
			System.out.println("rs==>"+rs.next());
			System.out.println("rs==>"+rs.getString("Fname"));
			System.out.println("rs==>"+rs.getString("Post"));
			System.out.println("rs==>"+rs.getString("Salary"));
			
			System.out.println("rs==>"+rs.next());
			System.out.println("rs==>"+rs.getString("Fname"));
			System.out.println("rs==>"+rs.getString("Post"));
			System.out.println("rs==>"+rs.getString("Salary"));
			*/
			
			while(rs.next()) {
				//System.out.println("rs==>"+rs.getString("Fname"));
				//System.out.println("rs==>"+rs.getString("Post"));
				//System.out.println("rs==>"+rs.getString("Salary"));
				
				System.out.println("rs==>"+"Fname="+rs.getString("Fname")+" post= "+rs.getString("Post")+" Salary= "+rs.getString("Salary"));
				
			}
			
		}catch(Exception e) {
			
		}
	}
	
	
	
	
	public static void main(String[] args) {		
		MyConClass m = new  MyConClass();
		//m.MyConnection();
		//m.DeleteMethod();
		//m.MyUpdateQuerry();
		m.MySelectQuery();
	}
}

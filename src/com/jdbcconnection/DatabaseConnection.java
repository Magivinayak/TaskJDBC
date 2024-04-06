package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	public static void main(String[] args) {
		
		//connection 
		
		String url="jdbc:mysql://localhost";
		String user="root";
		String password="root";
		
		try {
			Connection connection=DriverManager.getConnection(url, user, password);
			
			if(connection!=null) {
				System.out.println("Connected to Mysql");
			}else {
				System.out.println("Not Connected to Mysql");
			}
			
			//creating the database
			Statement statement = connection.createStatement();
			
			String dbName="create database empl";
			String dbUse="use empl";
			String dbTable="create table empldata(empcode int,empname varchar(20),empage int,esalary int)";
			
			String dbInsert1="insert into empldata values(101,'Jenny',25,10000)";
			String dbInsert2="insert into empldata values(102,'Jacky',30,20000)";
			String dbInsert3="insert into empldata values(103,'Joe',20,40000)";
			String dbInsert4="insert into empldata values(104,'John',40,80000)";
			String dbInsert5="insert into empldata values(105,'Shameer',25,90000)";
			
			String dbSelect="select * from empldata";
			
			//executing the MySql queries
			statement.execute(dbName);
			statement.execute(dbUse);
			statement.execute(dbTable);
			statement.execute(dbInsert1);
			statement.execute(dbInsert2);
			statement.execute(dbInsert3);
			statement.execute(dbInsert4);
			statement.execute(dbInsert5);
			
			
			ResultSet rs = statement.executeQuery(dbSelect);
			
			System.out.println();
			
			//Display the output
			while(rs.next()) {		
								
				System.out.println(rs.getInt("empcode")+"   "+rs.getString("empname")+"   "+rs.getInt("empage")+"   " +rs.getInt("esalary"));
			}		
			
			connection.close();
			
			System.out.println();
			System.out.println("Connection closed");
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}

}

package com.example.demo.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.stereotype.Service;


import com.example.demo.model.*;
@Service
public class service {

		Hashtable <Integer,ArrayList<Item>> data= new Hashtable<>();
		ArrayList<Item> items;
		static Connection conn;
		public service() throws SQLException {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				items = new ArrayList<>();
				 
				connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		}
		public Item getItem(int tag) {
			if (data.contains(tag))
				return data.get(tag).get(tag);
			else
				return null;
		}
		public Hashtable <Integer,ArrayList<Item>> getAll(){
			return data;
		}
		private void connect() throws SQLException {
conn = DriverManager.getConnection("jdbc:sqlserver://Host:Port;database=DBname","Username","Password");
			
			System.out.println("LOG: Connection Established!");
			
			// 2. Execute your SQL Query using conn.createStatement.executeQuery() 
			//    and get the result as a ResultSet object.
			//    with your MySQL Database Credentails
	    
			ResultSet rs   = conn.createStatement().executeQuery("SELECT TOP (1000) * FROM [dbo].[items];");

			System.out.println("Query Results: \n\n");
			
			// Show Column Names
			
			// Getting the Results
			while (rs.next()){
				Item I = new Item();
				I.setTag(rs.getInt(1));
				I.setTitle(rs.getString(2));
				I.setPrice(rs.getString(3));
				I.setImage(rs.getString(4));

				if(data.containsKey(rs.getInt(1))) {
					
					data.get(rs.getInt(1)).add(I);
				}else {
					items = new ArrayList<>();
					items.add(I);
					
					data.put(rs.getInt(1), items);
				}

			}
		}
	}


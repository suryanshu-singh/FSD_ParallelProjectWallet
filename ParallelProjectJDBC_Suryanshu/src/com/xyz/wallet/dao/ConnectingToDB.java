package com.xyz.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectingToDB {
	public Connection dbCon;
	
	public ConnectingToDB() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/parallelproject?serverTimezone=IST", "root", "");
			System.out.println("dbcon="+dbCon);
		} catch (SQLException e) {
			System.out.println("Some issues while connecting : " + e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}

}
}

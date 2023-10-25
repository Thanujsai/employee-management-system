package com.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection con;
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		Class.forName ("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","system","Thanuj@123");
		return con;
	}

}

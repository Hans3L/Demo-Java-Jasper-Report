package com.creativity.stack.report_jasper.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection con = null;

	public  Connection getConexion()  {

		try {
			String username = "root";
			String password = "";
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/minimarket?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static Connection closeConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}

package dataAdapter;

import java.sql.*;

public class Connector {
	
	private Connection con;
	
	public void setCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Registro exitoso");

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		try {

			this.con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ZEN?autoReconnect=true&useSSL=false&"
							+ "user=root&password=admin");
			System.out.println("Conexion exitosa");


		} catch (SQLException ex) {

			System.out.println("SQLException: " + ex.getMessage());

		}
	}
	
	public Connection conectar() {
		
		System.out.println("Connecting database...");

		this.setCon();
		
		return this.con;
	}
}



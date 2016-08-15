package dataAdapter;

import java.sql.*;

import dataAdapter.Connector;

public class DataAdapter {
	
	private Connection con;
	private Connector conector = new Connector();
	private ResultSet rs = null;
	private Statement cmd = null;
	
	public ResultSet getListaClientes() {
		
		try {

		    con = conector.conectar();
			cmd = con.createStatement();
		    rs = cmd.executeQuery("SELECT * FROM zen.listaclientes");
		    
		} catch (SQLException ex) {

				System.out.println("SQLException: " + ex.getMessage());

		}
		
		return this.rs;
		
	}
	
	public ResultSet getListaEstadosCuenta() {
			
			try {
	
			    con = conector.conectar();
				cmd = con.createStatement();
			    rs = cmd.executeQuery("SELECT * FROM zen.listaestadoscuenta");
			    
			} catch (SQLException ex) {
	
					System.out.println("SQLException: " + ex.getMessage());
	
			}
			
			return rs;
			
		}
	
	public ResultSet getListaAbonos() {
			
			try {
	
			    con = conector.conectar();
				cmd = con.createStatement();
			    rs = cmd.executeQuery("SELECT * FROM zen.listaabonos");
			    
			} catch (SQLException ex) {
	
					System.out.println("SQLException: " + ex.getMessage());
	
			}
			
			return rs;
			
		}
	
	public ResultSet getDatosCliente() {
			
			try {
	
			    con = conector.conectar();
				cmd = con.createStatement();
			    rs = cmd.executeQuery("SELECT * FROM zen.datoscliente");
			    
			} catch (SQLException ex) {
	
					System.out.println("SQLException: " + ex.getMessage());
	
				}
			
			return rs;
		
	}

}

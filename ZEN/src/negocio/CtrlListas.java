package negocio;

import java.sql.*;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataAdapter.*;

public class CtrlListas {

	public void cargarListaClientes(JTable tabla) {

		ResultSet rs;
		DataAdapter da = new DataAdapter();
		rs = da.getListaClientes();
		try {
			tabla.setModel(buildTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarListaEstadosCuenta(JTable tabla) {

		ResultSet rs;
		DataAdapter da = new DataAdapter();
		rs = da.getListaEstadosCuenta();
		try {
			tabla.setModel(buildTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarListaAbonos(JTable tabla) {

		ResultSet rs;
		DataAdapter da = new DataAdapter();
		rs = da.getListaAbonos();
		try {
			tabla.setModel(buildTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
}

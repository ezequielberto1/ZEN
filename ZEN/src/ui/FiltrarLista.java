package ui;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class FiltrarLista {

	private JFrame frmFiltrar;
	private int filtro;
	private int i1, i2, i3;
	private String f1, f2, f3;

	/**
	 * Launch the application.
	 */
	public static void main(JTable lista) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiltrarLista window = new FiltrarLista(lista);
					window.frmFiltrar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FiltrarLista(JTable lista) {
		filtro = 1;
		Vector<String> columnNames = new Vector<String>();
		int columnCount = lista.getColumnCount();
		for (int column = 0; column <= columnCount-1; column++) {
			columnNames.add(lista.getColumnName(column));
		}	
		initialize(columnNames);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Vector<String> columnNames) {
		frmFiltrar = new JFrame();
		frmFiltrar.setTitle("Filtrar");
		frmFiltrar.setBounds(100, 100, 398, 334);
		frmFiltrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFiltrar.getContentPane().setLayout(null);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(10, 56, 63, 14);
		frmFiltrar.getContentPane().add(lblFiltrarPor);
		
		JComboBox cmbFiltro1 = new JComboBox();
		cmbFiltro1.setBounds(10, 76, 149, 21);
		frmFiltrar.getContentPane().add(cmbFiltro1);
		
		JTextField txtFiltro1 = new JTextField();
		txtFiltro1.setBounds(177, 76, 195, 21);
		frmFiltrar.getContentPane().add(txtFiltro1);
		
		JLabel lblYPor = new JLabel("y por:");
		lblYPor.setEnabled(false);
		lblYPor.setBounds(10, 115, 49, 14);
		frmFiltrar.getContentPane().add(lblYPor);
		
		JComboBox cmbFiltro2 = new JComboBox();
		cmbFiltro2.setEnabled(false);
		cmbFiltro2.setBounds(10, 135, 149, 21);
		frmFiltrar.getContentPane().add(cmbFiltro2);
		
		JTextField txtFiltro2 = new JTextField();
		txtFiltro2.setEnabled(false);
		txtFiltro2.setBounds(177, 135, 195, 21);
		frmFiltrar.getContentPane().add(txtFiltro2);
		
		JLabel lblYPor_1 = new JLabel("y por:");
		lblYPor_1.setEnabled(false);
		lblYPor_1.setBounds(10, 174, 49, 14);
		frmFiltrar.getContentPane().add(lblYPor_1);
		
		JComboBox cmbFiltro3 = new JComboBox();
		cmbFiltro3.setEnabled(false);
		cmbFiltro3.setBounds(10, 199, 149, 21);
		frmFiltrar.getContentPane().add(cmbFiltro3);
		
		JTextField txtFiltro3 = new JTextField();
		txtFiltro3.setEnabled(false);
		txtFiltro3.setBounds(177, 199, 195, 21);
		frmFiltrar.getContentPane().add(txtFiltro3);
		
		JButton btnAgregarFiltro = new JButton("Agregar filtro");
		btnAgregarFiltro.setIcon(new ImageIcon(FiltrarLista.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
		
		JButton btnQuitarFiltro = new JButton("Quitar filtro");
		btnQuitarFiltro.setIcon(new ImageIcon(FiltrarLista.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));

		
		btnAgregarFiltro.setBounds(10, 11, 118, 23);
		frmFiltrar.getContentPane().add(btnAgregarFiltro);
		
		btnAgregarFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (filtro) {
				case 1: {
					cmbFiltro2.setEnabled(true);
					txtFiltro2.setEnabled(true);
					btnQuitarFiltro.setEnabled(true);
					filtro = 2;
					break;
				}
				case 2: {
					cmbFiltro3.setEnabled(true);
					txtFiltro3.setEnabled(true);
					btnAgregarFiltro.setEnabled(false);
					filtro = 3;
					break;
				}
				}
			}
		});
		
		btnQuitarFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (filtro) {
				case 2: {
					cmbFiltro2.setEnabled(false);
					cmbFiltro2.setSelectedIndex(-1);
					txtFiltro2.setEnabled(false);
					btnQuitarFiltro.setEnabled(false);
					filtro = 1;
					break;
				}
				case 3: {
					cmbFiltro3.setEnabled(false);
					cmbFiltro3.setSelectedIndex(-1);
					txtFiltro3.setEnabled(false);
					btnAgregarFiltro.setEnabled(true);
					filtro = 2;
					break;
				}
				}
			}
		});
		btnQuitarFiltro.setEnabled(false);
		btnQuitarFiltro.setBounds(138, 11, 118, 23);
		frmFiltrar.getContentPane().add(btnQuitarFiltro);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(293, 262, 79, 23);
		frmFiltrar.getContentPane().add(btnCerrar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i1 = cmbFiltro1.getSelectedIndex();
				f1 = txtFiltro1.getText();
				if (filtro >= 2) {
					i2 = cmbFiltro2.getSelectedIndex();
					f2 = txtFiltro2.getText();
					if (filtro == 3) {
						i3 = cmbFiltro3.getSelectedIndex();
						f3 = txtFiltro3.getText();
					} 
				}
			}
		});
		btnConfirmar.setBounds(204, 262, 79, 23);
		frmFiltrar.getContentPane().add(btnConfirmar);
	}
	
	public void setCMBFiltrar(JComboBox cmb, Vector<String> items) {
		for (int i = 0; i < items.size(); i++) {
			cmb.addItem(items.get(i));
		}
	}

	public int getI1() {
		return i1;
	}

	public void setI1(int i1) {
		this.i1 = i1;
	}

	public int getI2() {
		return i2;
	}

	public void setI2(int i2) {
		this.i2 = i2;
	}

	public int getI3() {
		return i3;
	}

	public void setI3(int i3) {
		this.i3 = i3;
	}

	public String getF1() {
		return f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getF2() {
		return f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	public String getF3() {
		return f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	}

}

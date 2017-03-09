package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import negocio.CtrlABMCCliente;
import negocio.CtrlListas;

public class Main {
	
	private CtrlABMCCliente ctrlCliente;
	private CtrlListas ctrlListas;
	private JFrame frmZenDigitalSystem;
	private JTextField txtCNroCliente;
	private JTextField txtCNombre;
	private JTextField txtCApellido;
	private JTextField txtCRazonSocial;
	private JTextField txtCTelefono;
	private JTable tblListaClientes;
	private TableRowSorter<TableModel> sorterLC, sorterLEC, sorterLA;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZenDigitalSystem = new JFrame();
		frmZenDigitalSystem.setTitle("ZEN Digital System");
		frmZenDigitalSystem.setBounds(100, 100, 789, 746);
		frmZenDigitalSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmZenDigitalSystem.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		ClientesTab pnClientes = new ClientesTab();
		tabbedPane.addTab("Clientes", null, pnClientes, null);
		/*
		JPanel pnClientes = new JPanel();
		tabbedPane.addTab("Clientes", null, pnClientes, null);
		
		JPanel pnlDatosCliente = new JPanel();
		pnlDatosCliente.setBackground(SystemColor.inactiveCaption);
		pnlDatosCliente.setBorder(new TitledBorder(null, "Datos cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
				return;
			}
		});
		
		JButton button = new JButton("Agregar");
		
		JButton button_1 = new JButton("Eliminar");
		
		JButton button_2 = new JButton("Modificar");
		
		JScrollPane scrpnListaClientes = new JScrollPane();
		
		JButton btnOrdenarLC = new JButton("Ordenar...");
		
		
		JButton btnFiltrarLC = new JButton("Filtrar...");
		GroupLayout gl_pnClientes = new GroupLayout(pnClientes);
		gl_pnClientes.setHorizontalGroup(
			gl_pnClientes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnClientes.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnClientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnClientes.createSequentialGroup()
							.addComponent(scrpnListaClientes, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnClientes.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnClientes.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_pnClientes.createSequentialGroup()
										.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
										.addComponent(btnLimpiarCampos, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_pnClientes.createSequentialGroup()
										.addComponent(button, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addGap(14)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(pnlDatosCliente, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnClientes.createSequentialGroup()
							.addComponent(btnOrdenarLC)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnFiltrarLC, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnClientes.setVerticalGroup(
			gl_pnClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnClientes.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_pnClientes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOrdenarLC)
						.addComponent(btnFiltrarLC))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnClientes.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnClientes.createSequentialGroup()
							.addComponent(pnlDatosCliente, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnClientes.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuscar)
								.addComponent(btnLimpiarCampos))
							.addGap(18)
							.addGroup(gl_pnClientes.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_2)
								.addComponent(button_1))
							.addContainerGap())
						.addComponent(scrpnListaClientes, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)))
		);
		
		tblListaClientes = new JTable();
		tblListaClientes.setAutoCreateRowSorter(true);
		scrpnListaClientes.setViewportView(tblListaClientes);
		
		JLabel lblCTelefono = new JLabel("Tel\u00E9fono");
		lblCTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblCApellido = new JLabel("Apellido");
		lblCApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblCNroCliente = new JLabel("N\u00BA Cliente(*)");
		lblCNroCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCNroCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblCNombre = new JLabel("Nombre");
		lblCNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblCRazonSocial = new JLabel("Raz\u00F3n Social");
		lblCRazonSocial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCRazonSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtCNroCliente = new JTextField();
		txtCNroCliente.setColumns(10);
		
		txtCNombre = new JTextField();
		txtCNombre.setColumns(10);
		
		txtCApellido = new JTextField();
		txtCApellido.setColumns(10);
		
		txtCRazonSocial = new JTextField();
		txtCRazonSocial.setColumns(10);
		
		txtCTelefono = new JTextField();
		txtCTelefono.setColumns(10);
		
		JComboBox cmbCLocalidad = new JComboBox();
		cmbCLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblCLocalidad = new JLabel("Localidad");
		lblCLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblCNota = new JLabel("(*) Campo s\u00F3lo para b\u00FAsqueda. \r\nAl agregar un cliente, el N\u00BA es autogenerado.");
		lblCNota.setFont(new Font("Tahoma", Font.ITALIC, 8));
		
		JScrollPane scrAbonosCliente = new JScrollPane();
		scrAbonosCliente.setViewportBorder(new TitledBorder(null, "Abonos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel pnlAbonosCliente = new JPanel();
		scrAbonosCliente.setViewportView(pnlAbonosCliente);
		
		JButton btnVerAbonosCliente = new JButton("Ver...");
		btnVerAbonosCliente.setEnabled(false);
		
		JButton btnVerComprasCliente = new JButton("Ver...");
		btnVerComprasCliente.setEnabled(false);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Compras y services", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel pnlComprasCliente = new JPanel();
		scrollPane_2.setViewportView(pnlComprasCliente);
		GroupLayout gl_pnlDatosCliente = new GroupLayout(pnlDatosCliente);
		gl_pnlDatosCliente.setHorizontalGroup(
			gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(27)
					.addComponent(lblCNroCliente, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtCNroCliente, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(46)
					.addComponent(lblCNombre, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtCNombre, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(46)
					.addComponent(lblCApellido, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtCApellido, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(27)
					.addComponent(lblCRazonSocial, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtCRazonSocial, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(52)
					.addComponent(lblCTelefono)
					.addGap(18)
					.addComponent(txtCTelefono, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(48)
					.addComponent(lblCLocalidad, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cmbCLocalidad, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(4)
					.addComponent(scrAbonosCliente, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(301)
					.addComponent(btnVerAbonosCliente))
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(4)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCNota, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlDatosCliente.createSequentialGroup()
							.addGap(297)
							.addComponent(btnVerComprasCliente))))
		);
		gl_pnlDatosCliente.setVerticalGroup(
			gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDatosCliente.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDatosCliente.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCNroCliente))
						.addComponent(txtCNroCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDatosCliente.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCNombre))
						.addComponent(txtCNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDatosCliente.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCApellido))
						.addComponent(txtCApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDatosCliente.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCRazonSocial))
						.addComponent(txtCRazonSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDatosCliente.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCTelefono))
						.addComponent(txtCTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDatosCliente.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCLocalidad))
						.addComponent(cmbCLocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(scrAbonosCliente, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnVerAbonosCliente)
					.addGap(9)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(6)
					.addGroup(gl_pnlDatosCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDatosCliente.createSequentialGroup()
							.addGap(5)
							.addComponent(lblCNota, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnVerComprasCliente)))
		);
		pnlDatosCliente.setLayout(gl_pnlDatosCliente);
		pnClientes.setLayout(gl_pnClientes);
		*/
		JPanel pnAbonos = new JPanel();
		tabbedPane.addTab("Abonos", null, pnAbonos, null);
		
		JButton button_5 = new JButton("Agregar");
		
		JButton button_6 = new JButton("Eliminar");
		
		JButton button_7 = new JButton("Modificar");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.inactiveCaption);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Cliente");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		JLabel label_2 = new JLabel("Tipo");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JComboBox comboBox_1 = new JComboBox();
		
		JLabel label_3 = new JLabel("Localidad");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("Nombre");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		JLabel label_6 = new JLabel("Cuenta");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton button_8 = new JButton("Ver...");
		
		JButton button_9 = new JButton("Editar...");
		
		JButton button_10 = new JButton("Ordenar...");
		
		JButton button_11 = new JButton("Filtrar...");
		
		JScrollPane scrollPane = new JScrollPane();
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		
		JLabel lblTarifa = new JLabel("Tarifa");
		lblTarifa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTarifa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton button_4 = new JButton("Limpiar campos");
		
		JButton button_3 = new JButton("Buscar");
		GroupLayout gl_pnAbonos = new GroupLayout(pnAbonos);
		gl_pnAbonos.setHorizontalGroup(
			gl_pnAbonos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnAbonos.createSequentialGroup()
					.addGap(10)
					.addComponent(button_10)
					.addGap(10)
					.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_pnAbonos.createSequentialGroup()
					.addGap(363)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(Alignment.TRAILING, gl_pnAbonos.createSequentialGroup()
					.addGap(633)
					.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(gl_pnAbonos.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnAbonos.setVerticalGroup(
			gl_pnAbonos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnAbonos.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_pnAbonos.createParallelGroup(Alignment.LEADING)
						.addComponent(button_10)
						.addComponent(button_11))
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_pnAbonos.createParallelGroup(Alignment.LEADING)
						.addComponent(button_3)
						.addComponent(button_5)
						.addComponent(button_7))
					.addGap(11)
					.addComponent(button_6)
					.addGap(18))
		);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(4)
					.addComponent(lblCdigo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboBox, 0, 209, Short.MAX_VALUE)
					.addGap(26))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addGap(137)
					.addComponent(lblTarifa, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addGap(26))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
					.addGap(137)
					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboBox_1, 0, 209, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addGap(228)
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCdigo))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(label))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_9)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(label_2))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(label_5))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTarifa))
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(label_6))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_8))
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(label_3))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)))
						.addComponent(button_4)))
		);
		panel_1.setLayout(gl_panel_1);
		pnAbonos.setLayout(gl_pnAbonos);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_5, null);
		
		JTabbedPane tabListaAbonos = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabListaAbonos, null);
	}
	
	/*private void limpiarCampos() {
		txtCNroCliente.setText("");
		txtCApellido.setText("");
		txtCNombre.setText("");
		txtCTelefono.setText("");
		txtCRazonSocial.setText("");
	}

	protected void buscar() {
		Cliente c = ctrlCliente.getCliente(MapearDeFormulario());
		if(c!=null){
			MapearAFormulario(c);
		}
	}

	public void MapearAFormulario(Cliente c){
		txtCNroCliente.setText(String.valueOf( c.getNro_cliente()));
		txtCNombre.setText(c.getNombre());
		txtCApellido.setText(c.getApellido());
		txtCRazonSocial.setText(c.getRazon_social());
		txtCTelefono.setText(c.getTelefono());
		//cmbCLocalidad.set(c.getLocalidad());
	}
	
	public Cliente MapearDeFormulario(){
		Cliente c = new Cliente();
		c.setNro_cliente(Integer.parseInt(txtCNroCliente.getText()));
		c.setApellido(txtCApellido.getText());
		c.setNombre(txtCNombre.getText());
		c.setTelefono(txtCTelefono.getText());
		//c.setLocalidad(cmbCLocalidad.);
		
		return c;
	}*/
}

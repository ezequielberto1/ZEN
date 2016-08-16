package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import entidades.Cliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.ButtonGroup;

import negocio.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Gestion {

	private CtrlABMCCliente ctrlCliente;
	private CtrlListas ctrlListas;
	private JFrame frmZenDigitalSystem;
	private JTextField txtCNroCliente;
	private JTextField txtCNombre;
	private JTextField txtCApellido;
	private JTextField txtCRazonSocial;
	private JTextField txtCTelefono;
	private JTable tblListaClientes;
	private JTable tblListaEstadosCuenta;
	private JTable tblListaAbonos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion window = new Gestion();
					window.frmZenDigitalSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestion() {
		TableRowSorter<TableModel> sorter;
		int columnIndexToSort;
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		
		initialize();
		
		ctrlCliente= new CtrlABMCCliente();
		ctrlListas= new CtrlListas();
		
		//Carga de listas y ordenamiento inicial
		
		ctrlListas.cargarListaClientes(tblListaClientes);
		sorter = new TableRowSorter<>(tblListaClientes.getModel());
		tblListaClientes.setRowSorter(sorter);
		columnIndexToSort = 1;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
		ctrlListas.cargarListaAbonos(tblListaAbonos);
		sorter = new TableRowSorter<>(tblListaAbonos.getModel());
		tblListaAbonos.setRowSorter(sorter);
		columnIndexToSort = 1;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
		ctrlListas.cargarListaEstadosCuenta(tblListaEstadosCuenta);
		sorter = new TableRowSorter<>(tblListaEstadosCuenta.getModel());
		tblListaEstadosCuenta.setRowSorter(sorter);
		columnIndexToSort = 1;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		sorter.sort();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZenDigitalSystem = new JFrame();
		frmZenDigitalSystem.setTitle("ZEN Digital System");
		frmZenDigitalSystem.setBounds(100, 100, 789, 490);
		frmZenDigitalSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmZenDigitalSystem.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
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
		GroupLayout gl_pnClientes = new GroupLayout(pnClientes);
		gl_pnClientes.setHorizontalGroup(
			gl_pnClientes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnClientes.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrpnListaClientes, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_pnClientes.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlDatosCliente, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(46))
		);
		gl_pnClientes.setVerticalGroup(
			gl_pnClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnClientes.createSequentialGroup()
					.addGroup(gl_pnClientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnClientes.createSequentialGroup()
							.addGap(33)
							.addComponent(pnlDatosCliente, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnClientes.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuscar)
								.addComponent(btnLimpiarCampos))
							.addGap(18)
							.addGroup(gl_pnClientes.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_2)
								.addComponent(button_1)))
						.addGroup(gl_pnClientes.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrpnListaClientes, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		tblListaClientes = new JTable();
		tblListaClientes.setAutoCreateRowSorter(true);
		scrpnListaClientes.setViewportView(tblListaClientes);
		pnlDatosCliente.setLayout(null);
		
		JLabel lblCTelefono = new JLabel("Tel\u00E9fono");
		lblCTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCTelefono.setBounds(58, 190, 42, 14);
		pnlDatosCliente.add(lblCTelefono);
		
		JLabel lblCApellido = new JLabel("Apellido");
		lblCApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCApellido.setBounds(52, 114, 48, 14);
		pnlDatosCliente.add(lblCApellido);
		
		JLabel lblCNroCliente = new JLabel("N\u00BA Cliente(*)");
		lblCNroCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCNroCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNroCliente.setBounds(33, 38, 67, 14);
		pnlDatosCliente.add(lblCNroCliente);
		
		JLabel lblCNombre = new JLabel("Nombre");
		lblCNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNombre.setBounds(52, 76, 48, 14);
		pnlDatosCliente.add(lblCNombre);
		
		JLabel lblCRazonSocial = new JLabel("Raz\u00F3n Social");
		lblCRazonSocial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCRazonSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCRazonSocial.setBounds(33, 152, 67, 14);
		pnlDatosCliente.add(lblCRazonSocial);
		
		txtCNroCliente = new JTextField();
		txtCNroCliente.setColumns(10);
		txtCNroCliente.setBounds(118, 35, 44, 20);
		pnlDatosCliente.add(txtCNroCliente);
		
		txtCNombre = new JTextField();
		txtCNombre.setColumns(10);
		txtCNombre.setBounds(118, 73, 209, 20);
		pnlDatosCliente.add(txtCNombre);
		
		txtCApellido = new JTextField();
		txtCApellido.setColumns(10);
		txtCApellido.setBounds(118, 111, 209, 20);
		pnlDatosCliente.add(txtCApellido);
		
		txtCRazonSocial = new JTextField();
		txtCRazonSocial.setColumns(10);
		txtCRazonSocial.setBounds(118, 149, 209, 20);
		pnlDatosCliente.add(txtCRazonSocial);
		
		txtCTelefono = new JTextField();
		txtCTelefono.setColumns(10);
		txtCTelefono.setBounds(118, 187, 209, 20);
		pnlDatosCliente.add(txtCTelefono);
		
		JComboBox cmbCLocalidad = new JComboBox();
		cmbCLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cmbCLocalidad.setBounds(118, 225, 209, 20);
		pnlDatosCliente.add(cmbCLocalidad);
		
		JLabel lblCLocalidad = new JLabel("Localidad");
		lblCLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCLocalidad.setBounds(54, 228, 46, 14);
		pnlDatosCliente.add(lblCLocalidad);
		
		JLabel lblCNota = new JLabel("(*) Campo s\u00F3lo para b\u00FAsqueda. \r\nAl agregar un cliente, el N\u00BA es autogenerado.");
		lblCNota.setFont(new Font("Tahoma", Font.ITALIC, 8));
		lblCNota.setBounds(33, 256, 317, 14);
		pnlDatosCliente.add(lblCNota);
		pnClientes.setLayout(gl_pnClientes);
		
		JTabbedPane tabAbonos = new JTabbedPane(JTabbedPane.TOP);
		tabAbonos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabbedPane.addTab("Abonos", null, tabAbonos, null);
		
		JPanel pnListaAbonos = new JPanel();
		tabAbonos.addTab("Lista de abonos", null, pnListaAbonos, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		tblListaAbonos = new JTable();
		tblListaAbonos.setAutoCreateRowSorter(true);
		scrollPane_1.setViewportView(tblListaAbonos);
		GroupLayout gl_pnListaAbonos = new GroupLayout(pnListaAbonos);
		gl_pnListaAbonos.setHorizontalGroup(
			gl_pnListaAbonos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnListaAbonos.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_pnListaAbonos.setVerticalGroup(
			gl_pnListaAbonos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnListaAbonos.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
					.addGap(11))
		);
		pnListaAbonos.setLayout(gl_pnListaAbonos);
		
		JPanel pnListaEstadosCuenta = new JPanel();
		tabAbonos.addTab("Estados de cuenta", null, pnListaEstadosCuenta, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tblListaEstadosCuenta = new JTable();
		tblListaEstadosCuenta.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(tblListaEstadosCuenta);
		GroupLayout gl_pnListaEstadosCuenta = new GroupLayout(pnListaEstadosCuenta);
		gl_pnListaEstadosCuenta.setHorizontalGroup(
			gl_pnListaEstadosCuenta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnListaEstadosCuenta.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_pnListaEstadosCuenta.setVerticalGroup(
			gl_pnListaEstadosCuenta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnListaEstadosCuenta.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
					.addGap(11))
		);
		pnListaEstadosCuenta.setLayout(gl_pnListaEstadosCuenta);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_5, null);
		
		JTabbedPane tabListaAbonos = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabListaAbonos, null);
	}
	
	private void limpiarCampos() {
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
	}
	
	
}

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import entidades.Cliente;
import negocio.CtrlABMCCliente;
import negocio.CtrlListas;

public class ClientesTab extends JPanel {
	
	private CtrlABMCCliente ctrlCliente;
	private CtrlListas ctrlListas;
	private JFrame frmZenDigitalSystem;
	private JTextField txtCNroCliente;
	private JTextField txtCNombre;
	private JTextField txtCApellido;
	private JTextField txtCRazonSocial;
	private JTextField txtCTelefono;
	private JTable tblListaClientes;
	
	public ClientesTab(){
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
		GroupLayout gl_pnClientes = new GroupLayout(this);
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
		this.setLayout(gl_pnClientes);
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

package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Paciente;
//import logico.Fabrica;
//import logico.Factura;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Label;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ObjMedico extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6597844453066971494L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtP_Nombre;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTable tabClientes;
	
	//extra
	private DefaultTableModel tabModelo;
	//private Fabrica fabrica;
	Object[] fila;
	private JButton btnEditar;
	private JButton btnEliminar; 
	private JButton btnRegistrar; 
	private JButton cancelButton;
	private JPasswordField passwordField;
	private JTextField txtS_Nombre;
	private JTextField textP_Apellido;
	private JTextField txtS_Apellido;
	private JTextField txtFechaNacimiento;
	private JLabel lblGrupoSanguineo;
	private JTextField txtGrupoSanguioneo;
	private JLabel lblSexo;
	private JTextField txtSexo;
	private JLabel lblTelefono;
	private JTextField txtTelefono2;
	private JTextField txtID_Municipio;
	private JTextField txtID_Especial;
	private JLabel lblIdMedico;
	private JTextField txtID_Medico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ObjMedico dialog = new ObjMedico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			//extra
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ObjMedico() {
		//extra
		setResizable(false);
		
		
		setTitle("Manejador De Medicos");
		setBounds(100, 100, 852, 769);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 798, 385);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(10, 22, 70, 14);
			panel.add(lblNombre);
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n :");
			lblDireccion.setBounds(10, 346, 70, 14);
			panel.add(lblDireccion);
			
			JLabel lblCedula = new JLabel("C\u00E9dula :");
			lblCedula.setBounds(10, 130, 70, 14);
			panel.add(lblCedula);
			
			txtP_Nombre = new JTextField();
			txtP_Nombre.setBounds(78, 16, 100, 20);
			panel.add(txtP_Nombre);
			txtP_Nombre.setColumns(10);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(78, 124, 185, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtDireccion = new JTextField();
			txtDireccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRegistrar.requestFocus();
					btnRegistrar.doClick();
				}
			});
			txtDireccion.setBounds(98, 340, 336, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblTelefono1 = new JLabel("Telefono (1):");
			lblTelefono1.setBounds(10, 202, 70, 14);
			panel.add(lblTelefono1);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(98, 196, 185, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
			lblContrasea.setBounds(10, 166, 70, 14);
			panel.add(lblContrasea);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(88, 160, 185, 20);
			panel.add(passwordField);
			
			JLabel lblS_nombre = new JLabel("Segundo Nombre :");
			lblS_nombre.setBounds(215, 22, 100, 14);
			panel.add(lblS_nombre);
			
			txtS_Nombre = new JTextField();
			txtS_Nombre.setColumns(10);
			txtS_Nombre.setBounds(325, 16, 100, 20);
			panel.add(txtS_Nombre);
			
			JLabel lblApellido = new JLabel("Apellido :");
			lblApellido.setBounds(10, 58, 58, 14);
			panel.add(lblApellido);
			
			textP_Apellido = new JTextField();
			textP_Apellido.setBounds(78, 52, 100, 20);
			panel.add(textP_Apellido);
			textP_Apellido.setColumns(10);
			
			JLabel lblS_Apellido = new JLabel("Segundo Apellido :");
			lblS_Apellido.setBounds(215, 58, 100, 14);
			panel.add(lblS_Apellido);
			
			txtS_Apellido = new JTextField();
			txtS_Apellido.setBounds(325, 52, 100, 20);
			panel.add(txtS_Apellido);
			txtS_Apellido.setColumns(10);
			
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento (dd/mm/aaaa) :");
			lblFechaDeNacimiento.setBounds(454, 22, 185, 14);
			panel.add(lblFechaDeNacimiento);
			
			txtFechaNacimiento = new JTextField();
			txtFechaNacimiento.setBounds(654, 16, 83, 20);
			panel.add(txtFechaNacimiento);
			txtFechaNacimiento.setColumns(10);
			
			lblGrupoSanguineo = new JLabel("Grupo Sanguineo : ");
			lblGrupoSanguineo.setBounds(454, 58, 100, 14);
			panel.add(lblGrupoSanguineo);
			
			txtGrupoSanguioneo = new JTextField();
			txtGrupoSanguioneo.setBounds(553, 52, 40, 20);
			panel.add(txtGrupoSanguioneo);
			txtGrupoSanguioneo.setColumns(10);
			
			lblSexo = new JLabel("Sexo :");
			lblSexo.setBounds(215, 94, 46, 14);
			panel.add(lblSexo);
			
			txtSexo = new JTextField();
			txtSexo.setBounds(254, 93, 40, 20);
			panel.add(txtSexo);
			txtSexo.setColumns(10);
			
			lblTelefono = new JLabel("Telefono (2) :");
			lblTelefono.setBounds(12, 238, 68, 14);
			panel.add(lblTelefono);
			
			txtTelefono2 = new JTextField();
			txtTelefono2.setBounds(98, 232, 185, 20);
			panel.add(txtTelefono2);
			txtTelefono2.setColumns(10);
			
			JLabel lblIdMunicipio = new JLabel("ID Municipio :");
			lblIdMunicipio.setBounds(10, 274, 70, 14);
			panel.add(lblIdMunicipio);
			
			txtID_Municipio = new JTextField();
			txtID_Municipio.setBounds(99, 268, 40, 20);
			panel.add(txtID_Municipio);
			txtID_Municipio.setColumns(10);
			
			JLabel lblIdEspecial = new JLabel("ID Especial :");
			lblIdEspecial.setBounds(10, 310, 68, 14);
			panel.add(lblIdEspecial);
			
			txtID_Especial = new JTextField();
			txtID_Especial.setBounds(99, 304, 40, 20);
			panel.add(txtID_Especial);
			txtID_Especial.setColumns(10);
			
			lblIdMedico = new JLabel("ID Medico :");
			lblIdMedico.setBounds(10, 94, 70, 14);
			panel.add(lblIdMedico);
			
			txtID_Medico = new JTextField();
			txtID_Medico.setBounds(78, 91, 100, 20);
			panel.add(txtID_Medico);
			txtID_Medico.setColumns(10);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(ObjMedico.class.getResource("/imagenes/doctor_icono.png")));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(-45, -202, 1274, 850);
			panel.add(label);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 407, 826, 262);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 806, 215);
		panel.add(scrollPane);
		
		tabClientes = new JTable();
		tabClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEditar.setEnabled(true);
				btnEliminar.setEnabled(true);
				btnRegistrar.setEnabled(false);
			}
		});
		
		//Extra
		
		
		
		scrollPane.setViewportView(tabClientes);
		///extras
		String[] colnStr = {"Nombre" , "Cédula", "Telefono", "Dirección"};
		tabModelo = new DefaultTableModel(); // Creando tabla 0x0
		tabModelo.setColumnIdentifiers(colnStr);
		tabClientes.getTableHeader().setResizingAllowed(false);
		tabClientes.getTableHeader().setReorderingAllowed(false);
		tabClientes.setModel(tabModelo);
		
		//Extra
		tabClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//CargarTab();
		
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			 btnRegistrar = new JButton("A\u00F1adir");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Verificando Los campos
					if(txtP_Nombre.getText().equalsIgnoreCase("")||txtCedula.getText().equalsIgnoreCase("")||txtDireccion.getText().equalsIgnoreCase("")||txtTelefono.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Verifique que lo campos esten corectamente");
					}
					//Creando nuevo cliente
					else {
						//Cliente cliente = new Cliente(txtP_Nombre.getText(),txtCedula.getText(),txtDireccion.getText(),Integer.parseUnsignedInt(txtTelefono.getText()));
						//Fabrica.getInstancias().AddCliente(cliente); // 
						
						LimpiarTab();
					//	CargarTab();
						
					}
				}
			});
			buttonPane.add(btnRegistrar);
			
			 btnEliminar = new JButton("Eliminar");
			//btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//int index = tabClientes.getSelectedRow();
					int n = JOptionPane.showConfirmDialog(null, "Desea Eliminar este Cliente?", null,  JOptionPane.OK_CANCEL_OPTION);
					if( n == JOptionPane.YES_OPTION) {
						//DelFactura(Fabrica.getInstancias().getClientes().get(tabClientes.getSelectedRow()));
						//Fabrica.getInstancias().getClientes().remove(tabClientes.getSelectedRow());
						//
						btnEliminar.setEnabled(false);
						btnEditar.setEnabled(false);
						LimpiarTab();
					//	CargarTab();
						
					}
				}
			});
			buttonPane.add(btnEliminar);
			btnEliminar.setEnabled(false);
			
			 btnEditar = new JButton("Editar");
			btnEditar.setEnabled(false);
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = tabClientes.getSelectedRow();
					switch(btnEditar.getText()) {
					
					case "Editar":
						btnEliminar.setEnabled(false);
						btnRegistrar.setEnabled(false);
						txtP_Nombre.setText(tabClientes.getValueAt(index, 0).toString());
						txtCedula.setText(tabClientes.getValueAt(index, 1).toString());
						txtTelefono.setText(tabClientes.getValueAt(index, 2).toString());
						txtDireccion.setText(tabClientes.getValueAt(index,3).toString());
						btnEditar.setText("Guardar");
						break;
						
					case "Guardar":
						/*Cliente client = Fabrica.getInstancias().getClientes().get(index);
						client.setNombre(txtP_Nombre.getText());
						client.setID(txtCedula.getText());
						client.setTelefono(Integer.parseInt(txtTelefono.getText()));
						client.setDireccion(txtDireccion.getText());
						LimpiarTab();
						JOptionPane.showMessageDialog(null, "Cliente Modificado", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
						CargarTab();
						btnEditar.setText("Editar");
						btnEditar.setEnabled(false);
						btnRegistrar.setEnabled(true);*/
						break;
					}
					
				}
			});
			buttonPane.add(btnEditar);
			{
				 cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void LimpiarTab() {
		txtCedula.setText("");
		txtCedula.requestFocus();
		txtTelefono.setText("");
		txtTelefono.requestFocus();
		txtDireccion.setText("");
		txtDireccion.requestFocus();
		txtP_Nombre.setText("");
		txtP_Nombre.requestFocus();
	}
	/*
	public void CargarTab() {
		tabModelo.setRowCount(0); //Inicializando la tabla en 0
		fila = new Object[tabModelo.getColumnCount()]; //Creando Arreglo de Objetos por la cantidad de Columnas
		
	
		for(Cliente cliente : Fabrica.getInstancias().getClientes()) {
			fila[0] = cliente.getNombre();
			fila[1] = cliente.getID();
			fila[2] = cliente.getTelefono();
			fila[3] = cliente.getDireccion();
			
			tabModelo.addRow(fila);
		}
		tabClientes.setModel(tabModelo);	
	}
	
	public void DelFactura(Cliente cliente) {
		Fabrica fabrica = Fabrica.getInstancias();
		
		for(Factura aux : fabrica.getFacturas()) {
			if(aux == fabrica.BuscarFacturaByCliente(cliente)) 
				fabrica.getFacturas().remove(fabrica.BuscarFacturaByCliente(cliente));
				
		}
	}
	*/
}

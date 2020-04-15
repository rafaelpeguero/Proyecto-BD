package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.MainArs;
import logico.Paciente;
//import logico.Fabrica;
//import logico.Factura;
import logico.Receta_Medico;

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

public class ObjAutorizacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6597844453066971494L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtP_Nombre;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	
	private JTable tabPacientes; // Esta tabla muestra la lista de pacientes
	
	//extra
	private DefaultTableModel tabModelo;
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
	private JLabel lblIdPaciente;
	private JTextField txtID_Paciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ObjAutorizacion dialog = new ObjAutorizacion();
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
	public ObjAutorizacion() {
		//extra
		setResizable(false);
		
		
		setTitle("Manejador De Pacientes");
		setBounds(100, 100, 852, 769);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 826, 385);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(10, 22, 100, 14);
			panel.add(lblNombre);
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n :");
			lblDireccion.setBounds(10, 346, 100, 14);
			panel.add(lblDireccion);
			
			JLabel lblCedula = new JLabel("C\u00E9dula :");
			lblCedula.setBounds(10, 130, 100, 14);
			panel.add(lblCedula);
			
			txtP_Nombre = new JTextField();
			txtP_Nombre.setBounds(120, 16, 100, 20);
			panel.add(txtP_Nombre);
			txtP_Nombre.setColumns(10);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(120, 124, 185, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtDireccion = new JTextField();
			txtDireccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRegistrar.requestFocus();
					btnRegistrar.doClick();
				}
			});
			txtDireccion.setBounds(120, 340, 336, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblTelefono1 = new JLabel("Telefono (1):");
			lblTelefono1.setBounds(10, 202, 100, 14);
			panel.add(lblTelefono1);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(120, 196, 185, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
			lblContrasea.setBounds(10, 166, 100, 14);
			panel.add(lblContrasea);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(120, 160, 185, 20);
			panel.add(passwordField);
			
			JLabel lblS_nombre = new JLabel("Segundo Nombre :");
			lblS_nombre.setBounds(281, 22, 120, 14);
			panel.add(lblS_nombre);
			
			txtS_Nombre = new JTextField();
			txtS_Nombre.setColumns(10);
			txtS_Nombre.setBounds(411, 16, 100, 20);
			panel.add(txtS_Nombre);
			
			JLabel lblApellido = new JLabel("Apellido :");
			lblApellido.setBounds(10, 58, 100, 14);
			panel.add(lblApellido);
			
			textP_Apellido = new JTextField();
			textP_Apellido.setBounds(120, 52, 100, 20);
			panel.add(textP_Apellido);
			textP_Apellido.setColumns(10);
			
			JLabel lblS_Apellido = new JLabel("Segundo Apellido :");
			lblS_Apellido.setBounds(281, 58, 120, 14);
			panel.add(lblS_Apellido);
			
			txtS_Apellido = new JTextField();
			txtS_Apellido.setBounds(411, 52, 100, 20);
			panel.add(txtS_Apellido);
			txtS_Apellido.setColumns(10);
			
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento (dd/mm/aaaa) :");
			lblFechaDeNacimiento.setBounds(328, 130, 220, 14);
			panel.add(lblFechaDeNacimiento);
			
			txtFechaNacimiento = new JTextField();
			txtFechaNacimiento.setBounds(540, 127, 83, 20);
			panel.add(txtFechaNacimiento);
			txtFechaNacimiento.setColumns(10);
			
			lblGrupoSanguineo = new JLabel("Grupo Sanguineo : ");
			lblGrupoSanguineo.setBounds(540, 22, 120, 14);
			panel.add(lblGrupoSanguineo);
			
			txtGrupoSanguioneo = new JTextField();
			txtGrupoSanguioneo.setBounds(670, 19, 40, 20);
			panel.add(txtGrupoSanguioneo);
			txtGrupoSanguioneo.setColumns(10);
			
			lblSexo = new JLabel("Sexo :");
			lblSexo.setBounds(328, 97, 46, 14);
			panel.add(lblSexo);
			
			txtSexo = new JTextField();
			txtSexo.setBounds(416, 94, 40, 20);
			panel.add(txtSexo);
			txtSexo.setColumns(10);
			
			lblTelefono = new JLabel("Telefono (2) :");
			lblTelefono.setBounds(12, 238, 100, 14);
			panel.add(lblTelefono);
			
			txtTelefono2 = new JTextField();
			txtTelefono2.setBounds(120, 232, 185, 20);
			panel.add(txtTelefono2);
			txtTelefono2.setColumns(10);
			
			JLabel lblIdMunicipio = new JLabel("ID Municipio :");
			lblIdMunicipio.setBounds(10, 274, 100, 14);
			panel.add(lblIdMunicipio);
			
			txtID_Municipio = new JTextField();
			txtID_Municipio.setBounds(120, 268, 40, 20);
			panel.add(txtID_Municipio);
			txtID_Municipio.setColumns(10);
			
			JLabel lblIdEspecial = new JLabel("ID Especial :");
			lblIdEspecial.setBounds(10, 310, 100, 14);
			panel.add(lblIdEspecial);
			
			txtID_Especial = new JTextField();
			txtID_Especial.setBounds(120, 304, 40, 20);
			panel.add(txtID_Especial);
			txtID_Especial.setColumns(10);
			
			lblIdPaciente = new JLabel("ID Paciente :");
			lblIdPaciente.setBounds(10, 94, 100, 14);
			panel.add(lblIdPaciente);
			
			txtID_Paciente = new JTextField();
			txtID_Paciente.setBounds(120, 91, 100, 20);
			panel.add(txtID_Paciente);
			txtID_Paciente.setColumns(10);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(ObjAutorizacion.class.getResource("/imagenes/icoPaciente.jpg")));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(48, -163, 1274, 850);
			panel.add(label);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 407, 826, 262);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 23, 806, 215);
		panel.add(scrollPane);
		
		tabPacientes = new JTable();
		tabPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEditar.setEnabled(true);
				btnEliminar.setEnabled(true);
				btnRegistrar.setEnabled(false);
			}
		});
		
		//Extra
		scrollPane.setViewportView(tabPacientes);
		///extras
		String[] colnStr = {"Nombre" , "Cédula", "Telefono", "Dirección"};
		tabModelo = new DefaultTableModel(); // Creando tabla 0x0
		tabModelo.setColumnIdentifiers(colnStr);
		tabPacientes.getTableHeader().setResizingAllowed(false);
		tabPacientes.getTableHeader().setReorderingAllowed(false);
		tabPacientes.setModel(tabModelo);
		
		//Extra
		tabPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CargarTab();
		
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			 btnRegistrar = new JButton("A\u00F1adir");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Verificando Los campos
					if(txtP_Nombre.getText().equalsIgnoreCase("")
							||txtCedula.getText().equalsIgnoreCase("")
							||txtDireccion.getText().equalsIgnoreCase("")
							||txtTelefono.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Verifique que lo campos esten corectamente");
					}
					//Creando nuevo cliente
					else {
						@SuppressWarnings("deprecation")
						Paciente paciente = new Paciente( 
								Integer.parseInt(txtID_Paciente.getText()),
								txtCedula.getText(),
								passwordField.getText(),
								txtP_Nombre.getText(),
								txtS_Nombre.getText(),
								textP_Apellido.getText(),
								txtS_Apellido.getText(),
								txtFechaNacimiento.getText(),
								txtSexo.getText(),
								txtGrupoSanguioneo.getText(),
								txtDireccion.getText(),
								txtTelefono.getText(),
								txtTelefono2.getText(),
								Integer.parseInt(txtID_Municipio.getText()),
								Integer.parseInt(txtID_Especial.getText())
								);
						
						MainArs.getInstancias().AddPaciente(paciente); // 
						
						LimpiarTab();
						CargarTab();
						
					}
				}
			});
			buttonPane.add(btnRegistrar);
			
			 btnEliminar = new JButton("Eliminar");
			//btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = tabPacientes.getSelectedRow();
					int n = JOptionPane.showConfirmDialog(null, "Desea Eliminar este Paciente?", null,  JOptionPane.OK_CANCEL_OPTION);
					if( n == JOptionPane.YES_OPTION) {
						//DelPaciente(MainArs.getInstancias().getPacientes().get(tabPacientes.getSelectedRow()));  --> Para eliminar una receta
						MainArs.getInstancias().getPacientes().remove(tabPacientes.getSelectedRow());
						//
						btnEliminar.setEnabled(false);
						btnEditar.setEnabled(false);
						LimpiarTab();
						CargarTab();
						
					}
				}
			});
			buttonPane.add(btnEliminar);
			btnEliminar.setEnabled(false);
			
			 btnEditar = new JButton("Editar");
			btnEditar.setEnabled(false);
			btnEditar.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					int index = tabPacientes.getSelectedRow();
					switch(btnEditar.getText()) {
					
					case "Editar":
						btnEliminar.setEnabled(false);
						btnRegistrar.setEnabled(false);
						txtP_Nombre.setText(tabPacientes.getValueAt(index, 0).toString());
						txtCedula.setText(tabPacientes.getValueAt(index, 1).toString());
						txtTelefono.setText(tabPacientes.getValueAt(index, 2).toString());
						txtDireccion.setText(tabPacientes.getValueAt(index,3).toString());
						btnEditar.setText("Guardar");
						break;
						
					case "Guardar":
						Paciente paciente = MainArs.getInstancias().getPacientes().get(index);
						
						paciente.setID_Paciente(Integer.parseInt(txtID_Paciente.getText()));
						paciente.setCedula(txtCedula.getText());
						paciente.setContrasena(passwordField.getText());
						paciente.setP_Nombre(txtP_Nombre.getText());
						paciente.setS_Nombre(txtS_Nombre.getText());
						paciente.setP_Apellido(textP_Apellido.getText());
						paciente.setS_Apellido(txtS_Apellido.getText());
						paciente.setF_Nacimiento(txtFechaNacimiento.getText());
						paciente.setSexo(txtSexo.getText());
						paciente.setDireccion(txtDireccion.getText());
						paciente.setTelefono1(txtTelefono.getText());
						paciente.setTelefono2(txtTelefono2.getText());
						paciente.setID_Municipio(Integer.parseInt(txtID_Municipio.getText()));
						paciente.setID_Especial(Integer.parseInt(txtID_Especial.getText()));
						
						LimpiarTab();
						JOptionPane.showMessageDialog(null, "Paciente Modificado", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
						CargarTab();
						btnEditar.setText("Editar");
						btnEditar.setEnabled(false);
						btnRegistrar.setEnabled(true);
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
		txtID_Paciente.setText("");
		txtID_Paciente.requestFocus();
		txtCedula.setText("");
		txtCedula.requestFocus();
		passwordField.setText("");
		passwordField.requestFocus();
		txtP_Nombre.setText("");
		txtP_Nombre.requestFocus();
		txtS_Nombre.setText("");
		txtS_Nombre.requestFocus();
		textP_Apellido.setText("");
		textP_Apellido.requestFocus();
		txtS_Apellido.setText("");
		txtS_Apellido.requestFocus();
		txtFechaNacimiento.setText("");
		txtFechaNacimiento.requestFocus();
		txtSexo.setText("");
		txtSexo.requestFocus();
		txtGrupoSanguioneo.setText("");
		txtGrupoSanguioneo.requestFocus();
		txtDireccion.setText("");
		txtDireccion.requestFocus();
		txtTelefono.setText("");
		txtTelefono.requestFocus();
		txtTelefono2.setText("");
		txtTelefono2.requestFocus();
		txtID_Municipio.setText("");
		txtID_Municipio.requestFocus();
		txtID_Especial.setText("");
		txtID_Especial.requestFocus();
		
	}
	public void CargarTab() {
		tabModelo.setRowCount(0); //Inicializando la tabla en 0
		fila = new Object[tabModelo.getColumnCount()]; //Creando Arreglo de Objetos por la cantidad de Columnas
		
		for(Paciente paciente : MainArs.getInstancias().getPacientes()) {
			fila[0] = paciente.getP_Nombre();
			fila[1] = paciente.getID_Paciente();
			fila[2] = paciente.getTelefono1();
			fila[3] = paciente.getDireccion();
			
			tabModelo.addRow(fila);
		}
		tabPacientes.setModel(tabModelo);	
	}
	public void DelRecetaMedica(Paciente paciente) {
		MainArs mainArs = MainArs.getInstancias();
		
		for(Receta_Medico aux : mainArs.getRecetas_medicas()) {
			if(aux == mainArs.BuscarRecetaMedicaByPaciente(paciente)) 
				mainArs.getRecetas_medicas().remove(mainArs.BuscarRecetaMedicaByPaciente(paciente));
				
		}
	}
}

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
import logico.Medicos;
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
	private JTextField txtID_Medico;
	
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
	private JLabel lblIdPaciente;
	private JTextField txtID_Paciente;

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
			panel.setBounds(10, 11, 826, 385);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(10, 25, 70, 14);
			panel.add(lblNombre);
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n :");
			lblDireccion.setBounds(10, 337, 76, 14);
			panel.add(lblDireccion);
			
			JLabel lblCedula = new JLabel("C\u00E9dula :");
			lblCedula.setBounds(10, 142, 70, 14);
			panel.add(lblCedula);
			
			txtP_Nombre = new JTextField();
			txtP_Nombre.setBounds(88, 22, 100, 20);
			panel.add(txtP_Nombre);
			txtP_Nombre.setColumns(10);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(88, 140, 185, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtDireccion = new JTextField();
			txtDireccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRegistrar.requestFocus();
					btnRegistrar.doClick();
				}
			});
			txtDireccion.setBounds(88, 340, 336, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblTelefono1 = new JLabel("Telefono (1):");
			lblTelefono1.setBounds(10, 220, 76, 14);
			panel.add(lblTelefono1);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(88, 220, 185, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
			lblContrasea.setBounds(10, 181, 76, 14);
			panel.add(lblContrasea);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(88, 180, 185, 20);
			panel.add(passwordField);
			
			JLabel lblS_nombre = new JLabel("Segundo Nombre :");
			lblS_nombre.setBounds(215, 22, 120, 14);
			panel.add(lblS_nombre);
			
			txtS_Nombre = new JTextField();
			txtS_Nombre.setColumns(10);
			txtS_Nombre.setBounds(334, 19, 100, 20);
			panel.add(txtS_Nombre);
			
			JLabel lblApellido = new JLabel("Apellido :");
			lblApellido.setBounds(10, 64, 58, 14);
			panel.add(lblApellido);
			
			textP_Apellido = new JTextField();
			textP_Apellido.setBounds(88, 60, 100, 20);
			panel.add(textP_Apellido);
			textP_Apellido.setColumns(10);
			
			JLabel lblS_Apellido = new JLabel("Segundo Apellido :");
			lblS_Apellido.setBounds(215, 58, 120, 14);
			panel.add(lblS_Apellido);
			
			txtS_Apellido = new JTextField();
			txtS_Apellido.setBounds(334, 61, 100, 20);
			panel.add(txtS_Apellido);
			txtS_Apellido.setColumns(10);
			
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento (dd/mm/aaaa) :");
			lblFechaDeNacimiento.setBounds(454, 22, 226, 14);
			panel.add(lblFechaDeNacimiento);
			
			txtFechaNacimiento = new JTextField();
			txtFechaNacimiento.setBounds(690, 22, 83, 20);
			panel.add(txtFechaNacimiento);
			txtFechaNacimiento.setColumns(10);
			
			lblGrupoSanguineo = new JLabel("Grupo Sanguineo : ");
			lblGrupoSanguineo.setBounds(553, 64, 127, 14);
			panel.add(lblGrupoSanguineo);
			
			txtGrupoSanguioneo = new JTextField();
			txtGrupoSanguioneo.setBounds(690, 61, 40, 20);
			panel.add(txtGrupoSanguioneo);
			txtGrupoSanguioneo.setColumns(10);
			
			lblSexo = new JLabel("Sexo :");
			lblSexo.setBounds(251, 103, 46, 14);
			panel.add(lblSexo);
			
			txtSexo = new JTextField();
			txtSexo.setBounds(334, 100, 40, 20);
			panel.add(txtSexo);
			txtSexo.setColumns(10);
			
			lblTelefono = new JLabel("Telefono (2) :");
			lblTelefono.setBounds(12, 259, 76, 14);
			panel.add(lblTelefono);
			
			txtTelefono2 = new JTextField();
			txtTelefono2.setBounds(88, 260, 185, 20);
			panel.add(txtTelefono2);
			txtTelefono2.setColumns(10);
			
			JLabel lblIdMunicipio = new JLabel("ID Municipio :");
			lblIdMunicipio.setBounds(10, 298, 76, 14);
			panel.add(lblIdMunicipio);
			
			txtID_Municipio = new JTextField();
			txtID_Municipio.setBounds(88, 300, 40, 20);
			panel.add(txtID_Municipio);
			txtID_Municipio.setColumns(10);
			
			JLabel lblIdMedico = new JLabel("ID Medico :");
			lblIdMedico.setBounds(10, 103, 70, 14);
			panel.add(lblIdMedico);
			
			txtID_Medico = new JTextField();
			txtID_Medico.setBounds(88, 100, 100, 20);
			panel.add(txtID_Medico);
			txtID_Medico.setColumns(10);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(Obj_C_Medico.class.getResource("/imagenes/doctor_icono.png")));
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
		scrollPane.setBounds(20, 23, 796, 215);
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
						Medicos medico = new Medicos( 
								Integer.parseInt(txtID_Medico.getText()),
								txtCedula.getText(),
								passwordField.getText(),
								txtP_Nombre.getText(),
								txtS_Nombre.getText(),
								textP_Apellido.getText(),
								txtS_Apellido.getText(),
								txtFechaNacimiento.getText(),
								txtSexo.getText(),
								txtDireccion.getText(),
								txtTelefono.getText(),
								txtTelefono2.getText(),
								Integer.parseInt(txtID_Municipio.getText())
								);
						
						MainArs.getInstancias().AddMedico(medico); // 
						
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
						MainArs.getInstancias().getMedicos().remove(tabPacientes.getSelectedRow());
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
						Medicos medico = MainArs.getInstancias().getMedicos().get(index);
						
						medico.setID_Medico(Integer.parseInt(txtID_Paciente.getText()));
						medico.setCedula(txtCedula.getText());
						medico.setContrasena(passwordField.getText());
						medico.setP_Nombre(txtP_Nombre.getText());
						medico.setS_Nombre(txtS_Nombre.getText());
						medico.setP_Apellido(textP_Apellido.getText());
						medico.setS_Apellido(txtS_Apellido.getText());
						medico.setF_Nacimiento(txtFechaNacimiento.getText());
						medico.setSexo(txtSexo.getText());
						medico.setDireccion(txtDireccion.getText());
						medico.setTelefono1(txtTelefono.getText());
						medico.setTelefono2(txtTelefono2.getText());
						medico.setID_Municipio(Integer.parseInt(txtID_Municipio.getText()));
			
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
		txtID_Medico.setText("");
		txtID_Medico.requestFocus();
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
		txtDireccion.setText("");
		txtDireccion.requestFocus();
		txtTelefono.setText("");
		txtTelefono.requestFocus();
		txtTelefono2.setText("");
		txtTelefono2.requestFocus();
		txtID_Municipio.setText("");
		txtID_Municipio.requestFocus();
		
	}
	public void CargarTab() {
		tabModelo.setRowCount(0); //Inicializando la tabla en 0
		fila = new Object[tabModelo.getColumnCount()]; //Creando Arreglo de Objetos por la cantidad de Columnas
		
		for(Medicos medico : MainArs.getInstancias().getMedicos()) {
			fila[0] = medico.getP_Nombre();
			fila[1] = medico.getID_Medico();
			fila[2] = medico.getTelefono1();
			fila[3] = medico.getDireccion();
			
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

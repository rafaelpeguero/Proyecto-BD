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
import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ObjAutorizacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6597844453066971494L;
	private final JPanel contentPanel = new JPanel();
	
	private JTable tabPacientes; // Esta tabla muestra la lista de pacientes
	
	//extra
	private DefaultTableModel tabModelo;
	Object[] fila;
	
	private JButton btnEditar;
	private JButton btnEliminar; 
	private JButton btnRegistrar; 
	private JButton cancelButton;
	private JLabel lblIdPaciente;
	private JTextField txtID_Paciente;
	private JLabel lblIdSolicitacion;
	private JTextField txtID_Solicitacion;
	private JTextField txtID_Receta;
	private JTextField txtID_Centro_Salud;
	private JTextField txtFecha_Solicitud;
	private JTextField txtFecha_Aprobacion;

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
		
		
		setTitle("Autorizacion");
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
			
			lblIdPaciente = new JLabel("ID Paciente :");
			lblIdPaciente.setBounds(10, 132, 100, 14);
			panel.add(lblIdPaciente);
			
			txtID_Paciente = new JTextField();
			txtID_Paciente.setBounds(120, 129, 100, 20);
			panel.add(txtID_Paciente);
			txtID_Paciente.setColumns(10);
			
			lblIdSolicitacion = new JLabel("ID Solicitacion :");
			lblIdSolicitacion.setBounds(10, 62, 100, 14);
			panel.add(lblIdSolicitacion);
			
			txtID_Solicitacion = new JTextField();
			txtID_Solicitacion.setBounds(120, 59, 86, 20);
			panel.add(txtID_Solicitacion);
			txtID_Solicitacion.setColumns(10);
			
			JLabel lblIdReceta = new JLabel("ID Receta :");
			lblIdReceta.setBounds(10, 104, 100, 14);
			panel.add(lblIdReceta);
			
			txtID_Receta = new JTextField();
			txtID_Receta.setBounds(120, 101, 86, 20);
			panel.add(txtID_Receta);
			txtID_Receta.setColumns(10);
			
			JLabel lblIdCentroSalud = new JLabel("ID Centro Salud :");
			lblIdCentroSalud.setBounds(10, 175, 100, 14);
			panel.add(lblIdCentroSalud);
			
			txtID_Centro_Salud = new JTextField();
			txtID_Centro_Salud.setBounds(120, 172, 86, 20);
			panel.add(txtID_Centro_Salud);
			txtID_Centro_Salud.setColumns(10);
			
			JLabel lblFechaSolicitud = new JLabel("Fecha Solicitud :");
			lblFechaSolicitud.setBounds(10, 224, 100, 14);
			panel.add(lblFechaSolicitud);
			
			txtFecha_Solicitud = new JTextField();
			txtFecha_Solicitud.setBounds(120, 221, 86, 20);
			panel.add(txtFecha_Solicitud);
			txtFecha_Solicitud.setColumns(10);
			
			JLabel lblAprobacion = new JLabel("Aprobacion :");
			lblAprobacion.setBounds(10, 273, 100, 14);
			panel.add(lblAprobacion);
			
			txtFecha_Aprobacion = new JTextField();
			txtFecha_Aprobacion.setBounds(120, 309, 86, 20);
			panel.add(txtFecha_Aprobacion);
			txtFecha_Aprobacion.setColumns(10);
			
			JLabel lblFechaAprobacion = new JLabel("Fecha Aprobacion :");
			lblFechaAprobacion.setBounds(10, 312, 100, 14);
			panel.add(lblFechaAprobacion);
			
			Checkbox checkbox_Aprobado = new Checkbox("Aprobado");
			checkbox_Aprobado.setBounds(120, 273, 95, 22);
			panel.add(checkbox_Aprobado);
			
			Checkbox checkbox_Denegado = new Checkbox("Denegado");
			checkbox_Denegado.setBounds(221, 273, 95, 22);
			panel.add(checkbox_Denegado);
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

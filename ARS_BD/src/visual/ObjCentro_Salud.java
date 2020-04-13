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

public class ObjCentro_Salud extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6597844453066971494L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtP_Nombre;
	private JTextField txtDireccion;
	private JTable tabClientes;
	
	//extra
	private DefaultTableModel tabModelo;
	//private Fabrica fabrica;
	Object[] fila;
	private JButton btnEditar;
	private JButton btnEliminar; 
	private JButton btnRegistrar; 
	private JButton cancelButton;
	private JTextField textP_Apellido;
	private JTextField txtID_Municipio;
	private JLabel lblIdCentro_Salud;
	private JTextField txtID_Paciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ObjCentro_Salud dialog = new ObjCentro_Salud();
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
	public ObjCentro_Salud() {
		//extra
		setResizable(false);
		
		
		setTitle("Manejador De Centros de Salud");
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
			lblNombre.setBounds(10, 52, 70, 14);
			panel.add(lblNombre);
			
			JLabel lblDescripcion = new JLabel("Descripci\u00F3n :");
			lblDescripcion.setBounds(10, 316, 70, 14);
			panel.add(lblDescripcion);
			
			txtP_Nombre = new JTextField();
			txtP_Nombre.setBounds(78, 49, 100, 20);
			panel.add(txtP_Nombre);
			txtP_Nombre.setColumns(10);
			
			txtDireccion = new JTextField();
			txtDireccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRegistrar.requestFocus();
					btnRegistrar.doClick();
				}
			});
			txtDireccion.setBounds(98, 315, 336, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblApellido = new JLabel("Apellido :");
			lblApellido.setBounds(10, 118, 58, 14);
			panel.add(lblApellido);
			
			textP_Apellido = new JTextField();
			textP_Apellido.setBounds(78, 115, 100, 20);
			panel.add(textP_Apellido);
			textP_Apellido.setColumns(10);
			
			JLabel lblIdMunicipio = new JLabel("ID Municipio :");
			lblIdMunicipio.setBounds(10, 250, 70, 14);
			panel.add(lblIdMunicipio);
			
			txtID_Municipio = new JTextField();
			txtID_Municipio.setBounds(94, 248, 40, 20);
			panel.add(txtID_Municipio);
			txtID_Municipio.setColumns(10);
			
			lblIdCentro_Salud = new JLabel("ID Centro :");
			lblIdCentro_Salud.setBounds(10, 184, 70, 14);
			panel.add(lblIdCentro_Salud);
			
			txtID_Paciente = new JTextField();
			txtID_Paciente.setBounds(78, 181, 100, 20);
			panel.add(txtID_Paciente);
			txtID_Paciente.setColumns(10);
			
			JLabel label = new JLabel("");
			label.setBounds(-56, -266, 1274, 850);
			panel.add(label);
			label.setIcon(new ImageIcon(ObjCentro_Salud.class.getResource("/imagenes/centro_icono3.png")));
			label.setHorizontalAlignment(SwingConstants.CENTER);
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
		CargarTab();
		
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
						Cliente cliente = new Cliente(txtP_Nombre.getText(),txtCedula.getText(),txtDireccion.getText(),Integer.parseUnsignedInt(txtTelefono.getText()));
						Fabrica.getInstancias().AddCliente(cliente); // 
						
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
					//int index = tabClientes.getSelectedRow();
					int n = JOptionPane.showConfirmDialog(null, "Desea Eliminar este Cliente?", null,  JOptionPane.OK_CANCEL_OPTION);
					if( n == JOptionPane.YES_OPTION) {
						DelFactura(Fabrica.getInstancias().getClientes().get(tabClientes.getSelectedRow()));
						Fabrica.getInstancias().getClientes().remove(tabClientes.getSelectedRow());
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
						Cliente client = Fabrica.getInstancias().getClientes().get(index);
						client.setNombre(txtP_Nombre.getText());
						client.setID(txtCedula.getText());
						client.setTelefono(Integer.parseInt(txtTelefono.getText()));
						client.setDireccion(txtDireccion.getText());
						LimpiarTab();
						JOptionPane.showMessageDialog(null, "Cliente Modificado", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
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
		txtCedula.setText("");
		txtCedula.requestFocus();
		txtTelefono.setText("");
		txtTelefono.requestFocus();
		txtDireccion.setText("");
		txtDireccion.requestFocus();
		txtP_Nombre.setText("");
		txtP_Nombre.requestFocus();
	}
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
}

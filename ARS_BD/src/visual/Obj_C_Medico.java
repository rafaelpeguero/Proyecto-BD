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

public class Obj_C_Medico extends JDialog {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Obj_C_Medico dialog = new Obj_C_Medico();
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
	public Obj_C_Medico() {
		//extra
		setResizable(false);
		
		
		setTitle("Consulta de Medicos");
		setBounds(100, 100, 1280, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 1254, 716);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 1234, 693);
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
		String[] colnStr = {
				"ID",
				"Cédula",
				"P_Nombre",
				"S_Nombre",
				"P_Apellido",
				"S_Apellido" , 
				"Nacimiento", 
				"Sexo",
				"Dirección",
				"Telefono_1",
				"Telefono_2",
				"ID_Municipio",
				};
		
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
					ObjMedico o = new ObjMedico();
					o.setVisible(true);
					o.setLocationRelativeTo(null);
					dispose();
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

	public void CargarTab() {
		tabModelo.setRowCount(0); //Inicializando la tabla en 0
		fila = new Object[tabModelo.getColumnCount()]; //Creando Arreglo de Objetos por la cantidad de Columnas
		
		for(Medicos paciente : MainArs.getInstancias().getMedicos()) {
			fila[0] = paciente.getID_Medico();
			fila[1] = paciente.getCedula();
			fila[2] = paciente.getP_Nombre();
			fila[3] = paciente.getS_Nombre();
			fila[4] = paciente.getP_Apellido();
			fila[5] = paciente.getS_Apellido();
			fila[6] = paciente.getF_Nacimiento();
			fila[7] = paciente.getSexo();
			fila[8] = paciente.getDireccion();
			fila[9] = paciente.getTelefono1();
			fila[10] = paciente.getTelefono2();
			fila[11] = paciente.getID_Municipio();

			tabModelo.addRow(fila);
		}
		tabPacientes.setModel(tabModelo);	
	}
	
}

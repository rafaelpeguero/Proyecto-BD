package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import NET.ClienteTCP;
import logico.Cliente;
import logico.Fabrica;
import logico.Factura;
import logico.Queso;
import logico.Queso_Cilindrico;
import logico.Queso_esfera;
import logico.Queso_hueco;


import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SpinnerNumberModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Component;

public class Facturar extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtDirec;
	private JTextField txtTel;
	private static  DefaultTableModel model;
	private static DefaultTableModel model1;
	private static Object[] row;
	private JSpinner spnCredito;
	private JTextField txtcredact;
	private JTable table_quesos;
	private JTable table_carrito;
	private JButton btnDevolver;
	private JButton btnAgregar;
	private ArrayList<Queso> miquesocompra = new ArrayList<Queso>();
	private JTextField txtTot;
	private float tot = 0f;
	private JComboBox cbxType;
	private int inde;
	private JTextField txtCod;
	private JButton btnRegis;
	private static DefaultTableCellRenderer centrar;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Facturar() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/imagenes/Sales-by-payment-method_25410.png")));
		setTitle("Factura");
		setResizable(false);
		setBounds(100, 100, 803, 714);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JLabel lblCliente = new JLabel("Cliente ID:");
			lblCliente.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
			lblCliente.setBounds(199, 22, 72, 26);
			contentPanel.add(lblCliente);
		}
		{
			txtId = new JTextField();
			txtId.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
			txtId.setBounds(281, 26, 119, 20);
			contentPanel.add(txtId);
			txtId.setColumns(10);
		}
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/icons8-b\u00FAsqueda-15.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite un id para la busquedad", "Advertencia", JOptionPane.WARNING_MESSAGE);

				}else if(Fabrica.getInstance().findClientebyId(txtId.getText()) != null) {
					Cliente aux = Fabrica.getInstance().findClientebyId(txtId.getText());
					txtNombre.setText(aux.getNombre().toString());
					txtDirec.setText(aux.getDireccion().toString());
					txtTel.setText(aux.getTelefono().toString());
					txtcredact.setText(String.valueOf(aux.getCredito()));
					txtNombre.setEnabled(true);
					txtDirec.setEnabled(true);
					txtTel.setEnabled(true);



				}else if(Fabrica.getInstance().findClientebyId(txtId.toString()) == null) {
					int option = JOptionPane.showConfirmDialog(null, "No se encuentra este cliente, Desea crear uno nuevo?", "Información", JOptionPane.INFORMATION_MESSAGE);
					if(option == JOptionPane.OK_OPTION) {
						txtNombre.setEnabled(true);
						txtDirec.setEnabled(true);
						txtTel.setEnabled(true);
						spnCredito.setEnabled(true);
						txtNombre.setEditable(true);
						txtDirec.setEditable(true);
						txtTel.setEditable(true);											
						btnBuscar.setEnabled(false);
						btnRegis.setEnabled(true);
						

					}
				}



			}
		});
		btnBuscar.setBounds(410, 26, 101, 23);
		contentPanel.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblNombre.setBounds(99, 61, 72, 26);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setEditable(false);
		txtNombre.setEnabled(false);
		txtNombre.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(190, 65, 119, 20);
		contentPanel.add(txtNombre);
		{
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
			lblDireccion.setBounds(99, 108, 72, 26);
			contentPanel.add(lblDireccion);
		}
		{
			txtDirec = new JTextField();
			txtDirec.setBackground(Color.WHITE);
			txtDirec.setEditable(false);
			txtDirec.setEnabled(false);
			txtDirec.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
			txtDirec.setColumns(10);
			txtDirec.setBounds(190, 112, 119, 20);
			contentPanel.add(txtDirec);
		}
		{
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
			lblTelefono.setBounds(439, 61, 89, 26);
			contentPanel.add(lblTelefono);
		}
		{
			txtTel = new JTextField();
			txtTel.setBackground(Color.WHITE);
			txtTel.setEditable(false);
			txtTel.setEnabled(false);
			txtTel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
			txtTel.setColumns(10);
			txtTel.setBounds(538, 65, 119, 20);
			contentPanel.add(txtTel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 212, 360, 359);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
		
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
			String[] header = {"Código     ", "Precio Uni","Precio", "Cantidad"};
			String[] header2 = {"Código", "Precio Unitario", "Precio"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(header);
			model1 = new DefaultTableModel();
			model1.setColumnIdentifiers(header2);
			
			table_quesos = new JTable();
			table_quesos.setRowHeight(50);
			table_quesos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table_quesos.setAlignmentX(Component.RIGHT_ALIGNMENT);
			table_quesos.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			table_quesos.setVerifyInputWhenFocusTarget(false);
			table_quesos.setSelectionBackground(Color.RED);
			table_quesos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			table_quesos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			table_quesos.setBackground(Color.ORANGE);
			table_quesos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			table_quesos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(table_quesos.getSelectedRow() >= 0) {
						//indexx = table_quesos.getSelectedRow();
						btnAgregar.setEnabled(true);
						//btnDevolver.setEnabled(true);
						String cod = table_quesos.getModel().getValueAt(table_quesos.getSelectedRow(), 0).toString();
						Fabrica.getInstance().findquesobycod(cod);
						


					}
				}
			});
			table_quesos.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
			scrollPane.setViewportView(table_quesos);
			{

			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(498, 212, 275, 325);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);

			table_carrito = new JTable();
			table_carrito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			table_carrito.setVerifyInputWhenFocusTarget(false);
			table_carrito.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			table_carrito.setBackground(new Color(255, 165, 0));
			table_carrito.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(table_carrito.getSelectedRow() >= 0) {
						btnDevolver.setEnabled(true);

					}
				}
			});
			table_carrito.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_carrito.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
			table_quesos.setModel(model);
			table_carrito.setModel(model1);
			
			scrollPane.setViewportView(table_carrito);
			loadtable(0);

		}

		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/icons8-flecha-ancha-derecha-16.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexx = table_quesos.getSelectedRow();
				if(txtNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay Cliente para realizar la compra", "Advertencia", JOptionPane.WARNING_MESSAGE);

				}else if(Fabrica.getInstance().getMisquesos().get(indexx).getCant() > 0)  {
					Fabrica.getInstance().getMisquesos().get(indexx).setCant(Fabrica.getInstance().getMisquesos().get(indexx).getCant() - 1);
					loadtable(cbxType.getSelectedIndex());
					filltableitems(indexx);
				}else {
					JOptionPane.showMessageDialog(null, "No hay más quesos disponible", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAgregar.setEnabled(false);
		btnAgregar.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnAgregar.setBounds(380, 304, 108, 32);
		contentPanel.add(btnAgregar);

		btnDevolver = new JButton("Devolver");
		btnDevolver.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/icons8-flecha-ancha-izquierda-16.png")));
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_carrito.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "No se encuentra ningún elemento seleccionado", "Advertencia", JOptionPane.WARNING_MESSAGE);

				}else {
					inde = table_carrito.getSelectedRow();
					model1.removeRow(inde);
					tot -= miquesocompra.get(inde).precio();
					tot = Math.round(tot * 1000) / 1000f;
					txtTot.setText(String.valueOf(tot));
					
					for (int i = 0; i < Fabrica.getInstance().getMisquesos().size(); i++) {
						if(Fabrica.getInstance().getMisquesos().get(i).equals(miquesocompra.get(inde))) {
							Fabrica.getInstance().getMisquesos().get(i).setCant(Fabrica.getInstance().getMisquesos().get(i).getCant() + 1);
							loadtable(cbxType.getSelectedIndex());
							
						}
						
					}
					miquesocompra.remove(inde);
					if(tot < 0 || miquesocompra.size() == 0) {
						tot = 0;
					}
					txtTot.setText(String.valueOf(tot));
					
				}


			}
		});
		btnDevolver.setEnabled(false);
		btnDevolver.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnDevolver.setBounds(380, 373, 108, 32);
		contentPanel.add(btnDevolver);

		JLabel lblCredito = new JLabel("Credito:");
		lblCredito.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblCredito.setBounds(439, 108, 72, 26);
		contentPanel.add(lblCredito);

		spnCredito = new JSpinner();
		spnCredito.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnCredito.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		spnCredito.setEnabled(false);
		spnCredito.setBounds(538, 112, 119, 20);
		contentPanel.add(spnCredito);
		{
			JLabel lblCreditoActual = new JLabel("Credito Actual:");
			lblCreditoActual.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
			lblCreditoActual.setBounds(515, 175, 102, 26);
			contentPanel.add(lblCreditoActual);
		}

		txtcredact = new JTextField();
		txtcredact.setForeground(new Color(0, 0, 205));
		txtcredact.setEditable(false);
		txtcredact.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		txtcredact.setColumns(10);
		txtcredact.setBounds(627, 179, 119, 20);
		contentPanel.add(txtcredact);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblTipo.setBounds(36, 159, 46, 26);
		contentPanel.add(lblTipo);
		
		cbxType = new JComboBox();
		cbxType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadtable(cbxType.getSelectedIndex());
			}
		});
		cbxType.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		cbxType.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Cilíndrico", "Esférico", "Hueco"}));
		cbxType.setBounds(85, 163, 119, 22);
		contentPanel.add(cbxType);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblTotal.setBounds(538, 545, 46, 26);
		contentPanel.add(lblTotal);

		txtTot = new JTextField();
		txtTot.setForeground(new Color(255, 0, 0));
		txtTot.setEditable(false);
		txtTot.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		txtTot.setColumns(10);
		txtTot.setBounds(607, 548, 119, 20);
		contentPanel.add(txtTot);
		
		JLabel lblCodigoDeFactura = new JLabel("Codigo de factura:");
		lblCodigoDeFactura.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblCodigoDeFactura.setBounds(455, 582, 129, 26);
		contentPanel.add(lblCodigoDeFactura);
		
		txtCod = new JTextField();
		txtCod.setForeground(Color.BLACK);
		txtCod.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		txtCod.setEditable(false);
		txtCod.setText("F-" +(Fabrica.getInstance().codfactu));
		txtCod.setColumns(10);
		txtCod.setBounds(607, 586, 119, 20);
		contentPanel.add(txtCod);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegis = new JButton("Registrar");
				btnRegis.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/icons8-usuario-femenino-30.png")));
				btnRegis.setEnabled(false);
				btnRegis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = txtId.getText();
						String name= txtNombre.getText();
						String direc = txtDirec.getText();
						String tel = txtTel.getText();
						float cred = Float.parseFloat(spnCredito.getValue().toString());
						if(!name.equalsIgnoreCase("") && !direc.equalsIgnoreCase("") && !tel.equalsIgnoreCase("")) {
							Cliente aux = new Cliente(name, direc, tel, id, cred,0);
							Fabrica.getInstance().insertarCliente(aux);
							JOptionPane.showMessageDialog(null, "Operación Satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE, null);
							clean();
							txtDirec.setEditable(false);
							txtNombre.setEditable(false);
							txtTel.setEditable(false);
							spnCredito.setEnabled(false);	
							txtcredact.setText(String.valueOf(aux.getCredito()));
							btnRegis.setEnabled(false);
							btnBuscar.setEnabled(true);

						}else {
							JOptionPane.showMessageDialog(null, "Revise que completo todos los datos", "Validación", JOptionPane.WARNING_MESSAGE);

						}




					}

					private void clean() {
						/*txtNombre.setText("");
						txtDirec.setText("");
						txtTel.setText("");
						txtId.setText("");*/
						spnCredito.setValue(new Integer(0));
						
					}
				});
				String[] typepago = {"Crédito", "Efectivo"};
				
				JButton btnNewButton = new JButton("Hacer Compra");
				btnNewButton.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/icons8-caja-registradora-30.png")));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(miquesocompra.size() == 0) {
							JOptionPane.showMessageDialog(null, "No hay quesos para hacer la compra", "Advertencia", JOptionPane.WARNING_MESSAGE);
						}else if(miquesocompra.size() > 0) {
							
							String resp = (String) JOptionPane.showInputDialog(null, "Seleccione forma de pagoo", "Tipo de pago", JOptionPane.DEFAULT_OPTION, null, typepago, typepago[0]);
							if(resp.equalsIgnoreCase("Crédito")) {
								hacercompracred(txtId.getText(), tot);		
								
								
							}else if(resp.equalsIgnoreCase("Efectivo")) {
								Cliente aux = Fabrica.getInstance().findClientebyId(txtId.getText());
								String forma = "Efectivo";
								if(tot > 6000) {
									JOptionPane.showMessageDialog(null, "Ha excedido el límite por compra", "Advertencia", JOptionPane.WARNING_MESSAGE);
								}else {
									Factura cliente = new Factura(aux, miquesocompra, forma, tot, txtCod.getText());
									//Fabrica.getInstance().insertarlafrekingfactura(txtId.getText(), cliente);
									JOptionPane.showMessageDialog(null, "Operación con éxito, Gracias por preferirnos!", "Información", JOptionPane.INFORMATION_MESSAGE);
									txtcredact.setText(String.valueOf(aux.getCredito()));
									ClienteTCP client = new ClienteTCP();
									client.start(cliente);
									restore2();
									cleancarrito();
								}
								
							}
						}
					}
				});
				buttonPane.add(btnNewButton);
				btnRegis.setActionCommand("OK");
				buttonPane.add(btnRegis);
				getRootPane().setDefaultButton(btnRegis);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/icons8-eliminar-30.png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						restore();
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

	}
	public static void loadtable(int index) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		switch(index) {
		case 0:
			for (Queso aux : Fabrica.getInstance().getMisquesos()) {
				if(aux instanceof Queso_Cilindrico && !(aux instanceof Queso_hueco)) {
					row[0] = aux.getCodigo()+"-Cilíndrico";
				}else if(aux instanceof Queso_esfera) {
					row[0] = aux.getCodigo()+"-Esférico";
				}else if(aux instanceof Queso_hueco) {
					row[0] = aux.getCodigo()+"-Hueco";					
				}				
				row[1] = aux.getPrecio_uni();
				row[2] = aux.precio();
				row[3] = aux.getCant();
				
				model.addRow(row);

			}
			break;

		case 1:
			for (Queso aux : Fabrica.getInstance().getMisquesos()) {
				if(aux instanceof Queso_Cilindrico && !(aux instanceof Queso_hueco)) {
					row[0] = aux.getCodigo()+"-Cilíndrico";
					row[1] = aux.getPrecio_uni();
					row[2] = aux.precio();
					row[3] = aux.getCant();
					model.addRow(row);

				}

			}
			break;
		case 2:
			for (Queso aux : Fabrica.getInstance().getMisquesos()) {
				if(aux instanceof Queso_esfera) {
					row[0] = aux.getCodigo()+"-Esférico";
					row[1] = aux.getPrecio_uni();
					row[2] = aux.precio();
					row[3] = aux.getCant();
					model.addRow(row);
				}

			}
			break;
		case 3:
			for (Queso aux : Fabrica.getInstance().getMisquesos()) {
				if(aux instanceof Queso_hueco) {
					row[0] = aux.getCodigo()+"-Hueco";
					row[1] = aux.getPrecio_uni();
					row[2] = aux.precio();
					row[3] = aux.getCant();
					model.addRow(row);
				}

			}
			break;



		}
		
		
	}

	public void filltableitems(int selection) {
		
		row[0] = Fabrica.getInstance().getMisquesos().get(selection).getCodigo();
		row[1] = Fabrica.getInstance().getMisquesos().get(selection).getPrecio_uni();
		row[2] = Fabrica.getInstance().getMisquesos().get(selection).precio();
		
		
		miquesocompra.add(Fabrica.getInstance().getMisquesos().get(selection));
		
		model1.addRow(row);
	

		tot += Fabrica.getInstance().getMisquesos().get(selection).precio();

		txtTot.setText(String.valueOf(tot));


	}
	
	public void hacercompracred(String id, float pago) {
		Cliente aux = Fabrica.getInstance().findClientebyId(id);
		String forma = "Crédito";
		if(pago > aux.getCredito()) {
			JOptionPane.showMessageDialog(null, "No tiene suficientes créditos para realizar la compra, tiene que pagar en efectivo", "Advertencia", JOptionPane.WARNING_MESSAGE);
		
		}else if(pago > 6000) {
			JOptionPane.showMessageDialog(null, "Ha excedido el límite por compra", "Advertencia", JOptionPane.WARNING_MESSAGE);
			
		}else {
			aux.setCredito(aux.getCredito() - pago);
			Factura cliente = new Factura(aux, miquesocompra, forma, tot, txtCod.getText());	
			Fabrica.getInstance().insertarlafrekingfactura(txtId.getText(), cliente);
			JOptionPane.showMessageDialog(null, "Operación con éxito, Gracias por preferirnos!", "Información", JOptionPane.INFORMATION_MESSAGE);
			txtcredact.setText(String.valueOf(aux.getCredito()));
			ClienteTCP client = new ClienteTCP();
			client.start(cliente);
			restore2();
			cleancarrito();
			
			
		}
		
	}
	
	
	public void cleancarrito() {
		int in = model1.getRowCount()-1;
		for (int i = in; i >= 0; i--) {
			model1.removeRow(model1.getRowCount()-1);
			
		}
		txtCod.setText(String.valueOf("F-" +(Fabrica.getInstance().codfactu)));
		tot = 0;
		txtTot.setText(String.valueOf(tot));
		miquesocompra = new ArrayList<Queso>();
		
		
		
		
	}
	
	public void restore() {
		int cant = 0;
		for (Queso aux : Fabrica.getInstance().getMisquesos()) {
			cant = Fabrica.getInstance().cantactu(aux.getCodigo());
			aux.setCant(cant);			
		}
		
	}
	public void restore2() {
		int cant = 0;
		for (Queso aux : Fabrica.getInstance().getMisquesos()) {
			cant = Fabrica.getInstance().actualizar(aux.getCodigo());
			aux.setCant_actua(cant);
			
		}
		
	}
	
	
	
		
	
}

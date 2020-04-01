package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Fabrica;
import logico.Factura;
import logico.Queso;
import logico.Queso_Cilindrico;
import logico.Queso_esfera;
import logico.Queso_hueco;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class listfactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model;
	private static DefaultTableModel model1;
	private static Object[] row1;
	private static Object[] row;
	private static Cliente miclient;
	private static Factura mifact;
	private JButton btnVer;
	private static JTable tabladecompra;
	private static JTextField txtTipodepago;
	private static JTextField txtTotal;
	private static JTable table;
	private static JTextField txtcliente;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public listfactura(Cliente cli) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(listfactura.class.getResource("/imagenes/icons8-b\u00FAsqueda-de-propiedad-50.png")));
		this.miclient = cli;
		setTitle("Lista de Facturas");
		setResizable(false);
		setBounds(100, 100, 725, 442);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		{
			{
				String[] header = {"Factura"};
				model = new DefaultTableModel();
				model.setColumnIdentifiers(header);
				loadfactura();
				
			}
		}
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(10, 11, 282, 348);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
			panel.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
			table.setBackground(Color.WHITE);
			table.setVerifyInputWhenFocusTarget(false);
			table.setSelectionBackground(Color.ORANGE);
			table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(table.getSelectedRow() >= 0) {
						btnVer.setEnabled(true);
						String cod = table.getModel().getValueAt(table.getSelectedRow(),0).toString();
						mifact = miclient.findfacturabycliente(cod);
						
					}
				}
			});
			table.setModel(model);
			scrollPane.setViewportView(table);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(302, 11, 399, 348);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCompra = new JLabel("Compra:");
		lblCompra.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblCompra.setBounds(50, 11, 67, 24);
		panel.add(lblCompra);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 46, 172, 291);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		panel_1.add(scrollPane, BorderLayout.CENTER);
		String[] header = {"Codigo    ", "Precio"};
		tabladecompra = new JTable();
		tabladecompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabladecompra.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		model1 = new DefaultTableModel();
		model1.setColumnIdentifiers(header);
		tabladecompra.setModel(model1);	
		scrollPane.setViewportView(tabladecompra);
		
		JLabel lblTipoDePago = new JLabel("Tipo de pago:");
		lblTipoDePago.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblTipoDePago.setBounds(230, 142, 100, 24);
		panel.add(lblTipoDePago);
		
		txtTipodepago = new JTextField();
		txtTipodepago.setEditable(false);
		txtTipodepago.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		txtTipodepago.setBounds(215, 177, 124, 20);
		panel.add(txtTipodepago);
		txtTipodepago.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblTotal.setBounds(245, 249, 67, 24);
		panel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(215, 284, 124, 20);
		panel.add(txtTotal);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblCliente.setBounds(245, 49, 67, 24);
		panel.add(lblCliente);
		
		txtcliente = new JTextField();
		txtcliente.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		txtcliente.setEditable(false);
		txtcliente.setColumns(10);
		txtcliente.setBounds(215, 84, 124, 20);
		panel.add(txtcliente);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 719, 376);
		contentPanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(listfactura.class.getResource("/imagenes/3a1d8fbb9969563b162baf1a59868f61.jpg")));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVer = new JButton("Ver");
				btnVer.setIcon(new ImageIcon(listfactura.class.getResource("/imagenes/icons8-letra-peque\u00F1a-25.png")));
				btnVer.setEnabled(false);
				btnVer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(table.getSelectedRow() < 0) {
							JOptionPane.showMessageDialog(null, "No se encuentra ningún elemento seleccionado", "Advertencia", JOptionPane.WARNING_MESSAGE);

						}else {
							
							loadinfofact(mifact);
							
							
						}
					}
				});
				btnVer.setActionCommand("OK");
				buttonPane.add(btnVer);
				getRootPane().setDefaultButton(btnVer);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(listfactura.class.getResource("/imagenes/icons8-eliminar-25.png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadfactura();
		
	}
	
	public static void loadfactura() {
	    model.setRowCount(0);
	    row = new Object[model.getColumnCount()];
	    for (int i = 0; i < miclient.getMisfacturas().size() ; i++) {
	    	row[0] = miclient.getMisfacturas().get(i).getCodigo();
	    	
	    	model.addRow(row);
	    	
	    	
			
		}
		
	}
	public static void loadinfofact(Factura fact) {
		model1.setRowCount(0);
		row1 = new Object[model1.getColumnCount()];
		for (int i = 0; i < fact.getQuesoscomprados().size(); i++) {
			if(fact.getQuesoscomprados().get(i) instanceof Queso_Cilindrico && !(fact.getQuesoscomprados().get(i) instanceof Queso_hueco)) {
				row1[0] = fact.quesoscomprados().get(i).getCodigo()+"-Cilíndrico";
			}else if(fact.getQuesoscomprados().get(i) instanceof Queso_esfera) {
				row1[0] = fact.quesoscomprados().get(i).getCodigo()+"-Esférico";
			}else if(fact.getQuesoscomprados().get(i) instanceof Queso_hueco) {
				row1[0] = fact.quesoscomprados().get(i).getCodigo()+"-Hueco";
			}
			
			row1[1] = fact.quesoscomprados().get(i).precio();
			model1.addRow(row1);
			
		}
		
		txtTipodepago.setText(fact.getTipodefactura());
		txtTotal.setText(String.valueOf(fact.getPrecio_tot()));
		txtcliente.setText(fact.getMyclient().getNombre());
		
	}
	
}

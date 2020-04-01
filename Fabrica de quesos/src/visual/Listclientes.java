package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import logico.Cliente;
import logico.Fabrica;
import logico.Factura;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Listclientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private int index;
	private JButton btnFacts;
	private Cliente cli;
	private JButton btnModificar;
	private String elrealcliente;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public Listclientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Listclientes.class.getResource("/imagenes/tienda-online (2).png")));
		setResizable(false);
		setTitle("Lista de clientes ");
		setBounds(100, 100, 786, 617);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
				table.setDefaultRenderer(String.class, centerRenderer);
				table.setVerifyInputWhenFocusTarget(false);
				table.setSelectionBackground(Color.ORANGE);
				table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(table.getSelectedRow() >= 0) {
							index = table.getSelectedRow();
							btnFacts.setEnabled(true);
							btnModificar.setEnabled(true);
							
							String cod = table.getModel().getValueAt(table.getSelectedRow(),0).toString();
							cli = Fabrica.getInstance().findClientebyId(cod);
							btnFacts.setEnabled(true);
							elrealcliente = (String) table.getValueAt(index,0);
							
							
						}
					}
				});
				 String[] header = {"ID", "Nombre", "Dirección", "Telefono","Cantidad Facturas"};
				 model = new DefaultTableModel();
				 model.setColumnIdentifiers(header);
				 //centrar(table, SwingConstants.CENTER);
				 table.setModel(model);
				scrollPane.setViewportView(table);
				loadtableclient();
				
			}
		}
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFacts = new JButton("Facturas");
				btnFacts.setIcon(new ImageIcon(Listclientes.class.getResource("/imagenes/icons8-esc\u00E1ner-de-c\u00F3digo-de-barras-25.png")));
				btnFacts.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						listfactura list = new listfactura(cli);
						list.setModal(true);
						list.setVisible(true);
						
						
						
					}
				});
				
					btnModificar = new JButton("Modificar");
					btnModificar.setIcon(new ImageIcon(Listclientes.class.getResource("/imagenes/icons8-editar-usuaria-25.png")));
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Modificarcliente aux = new Modificarcliente(cli);
							aux.setModal(true);
							aux.setVisible(true);
							
						}
					});
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				
				btnFacts.setEnabled(false);
				btnFacts.setActionCommand("OK");
				buttonPane.add(btnFacts);
				getRootPane().setDefaultButton(btnFacts);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(Listclientes.class.getResource("/imagenes/icons8-eliminar-25.png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		
		
		
		centrar(table, SwingConstants.CENTER);

	}
	
	public static void loadtableclient() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		
		for (Cliente aux : Fabrica.getInstance().getMiclient()) {
			
			row[0] = aux.getId();
			row[1] = aux.getNombre();
			row[2] = aux.getDireccion();
			row[3] = aux.getTelefono();
			row[4] = aux.getCantfacturas();
			
			model.addRow(row);
			
			
		}
		
		
		
	}
	public static void centrar(JTable table, int alinear) {
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(alinear);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(center);
        }
    }
}

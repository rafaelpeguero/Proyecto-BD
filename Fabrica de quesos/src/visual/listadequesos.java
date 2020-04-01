package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Fabrica;
import logico.Queso;
import logico.Queso_Cilindrico;
import logico.Queso_esfera;
import logico.Queso_hueco;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class listadequesos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Object[] row;
	private static DefaultTableModel model;
	private JTable table;
	private JComboBox cbxTip;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public listadequesos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(listadequesos.class.getResource("/imagenes/icons8-mostrar-propiedad-25.png")));
		setTitle("Lista de quesos");
		setResizable(false);
		setBounds(100, 100, 458, 539);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 51, 424, 371);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		String[] header = {"Codigo", "Precio"};
		table = new JTable();
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() >= 0) {
					int index = table.getSelectedRow();
					
				}
			}
		});
		model = new DefaultTableModel();
		model.setColumnIdentifiers(header);
		table.setModel(model);
		loadtable(0);
		
		scrollPane.setViewportView(table);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		lblTipo.setBounds(124, 26, 48, 14);
		contentPanel.add(lblTipo);
		
		cbxTip = new JComboBox();
		cbxTip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadtable(cbxTip.getSelectedIndex());
			}
		});
		cbxTip.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Cilíndrico", "Esférico", "Hueco"}));
		cbxTip.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		cbxTip.setBounds(182, 23, 112, 22);
		contentPanel.add(cbxTip);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(listadequesos.class.getResource("/imagenes/icons8-eliminar-30.png")));
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
				row[1] = aux.precio();

				model.addRow(row);

			}
			break;

		case 1:
			for (Queso aux : Fabrica.getInstance().getMisquesos()) {
				if(aux instanceof Queso_Cilindrico && !(aux instanceof Queso_hueco)) {
					row[0] = aux.getCodigo()+"-Cilíndrico";
					row[1] = aux.precio();
					
					model.addRow(row);

				}

			}
			break;
		case 2:
			for (Queso aux : Fabrica.getInstance().getMisquesos()) {
				if(aux instanceof Queso_esfera) {
					row[0] = aux.getCodigo()+"-Esférico";
					row[1] = aux.precio();
					
					model.addRow(row);
				}

			}
			break;
		case 3:
			for (Queso aux : Fabrica.getInstance().getMisquesos()) {
				if(aux instanceof Queso_hueco) {
					row[0] = aux.getCodigo()+"-Hueco";
					row[1] = aux.precio();
					
					model.addRow(row);
				}

			}
			break;



		}
	}
}

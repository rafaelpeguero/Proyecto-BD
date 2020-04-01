package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Fabrica;
import logico.Queso;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class CantQuesos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCant;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public CantQuesos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CantQuesos.class.getResource("/imagenes/estadisticas.png")));
		setTitle("Cantidad de Quesos");
		setResizable(false);
		setBounds(100, 100, 392, 314);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTipoDeQueso = new JLabel("Tipo de Queso:");
			lblTipoDeQueso.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
			lblTipoDeQueso.setBounds(127, 11, 111, 30);
			contentPanel.add(lblTipoDeQueso);
		}
		
		JComboBox cbxType = new JComboBox();
		cbxType.setBackground(Color.WHITE);
		cbxType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cantidades(cbxType.getSelectedIndex());
			}
		});
		cbxType.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Cilindrico", "Esferico", "Hueco"}));
		cbxType.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		cbxType.setBounds(105, 52, 153, 33);
		contentPanel.add(cbxType);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
		lblCantidad.setBounds(147, 109, 111, 30);
		contentPanel.add(lblCantidad);
		
		txtCant = new JTextField();
		txtCant.setEditable(false);
		txtCant.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		txtCant.setBounds(105, 160, 153, 30);
		contentPanel.add(txtCant);
		txtCant.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CantQuesos.class.getResource("/imagenes/tablero-laminado-sobre-fondo-amarillo-pastel-puede-poner-o-montar-sus-productos_34008-26.jpg")));
		lblNewLabel.setBounds(0, 0, 386, 248);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(CantQuesos.class.getResource("/imagenes/icons8-eliminar-25.png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cantidades(0);
	}
	public void cantidades(int index) {
		
		switch (index) {
		case 0:
				
			txtCant.setText(String.valueOf(Fabrica.getInstance().cantquesos()));				

			
			break;

		case 1:
			txtCant.setText(String.valueOf(Fabrica.getInstance().cantQueso_cili()));
			break;
		case 2:
			txtCant.setText(String.valueOf(Fabrica.getInstance().cantQueso_esferico()));
			break;
		case 3:
			txtCant.setText(String.valueOf(Fabrica.getInstance().cantQueso_hueco()));
			break;
		}
		
	}
}

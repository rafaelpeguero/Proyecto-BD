package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Fabrica;
import logico.Factura;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Canjearpuntos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtPuntos;
	private JButton btnCanjear;
	private JButton btnBuscar;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public Canjearpuntos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Canjearpuntos.class.getResource("/imagenes/icons8-conseguir-dinero-en-efectivo-30.png")));
		setTitle("Canjear Puntos");
		setResizable(false);
		setBounds(100, 100, 359, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Puntos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JLabel lblIdDelCliene = new JLabel("ID del cliene:");
			lblIdDelCliene.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
			lblIdDelCliene.setBounds(63, 39, 98, 20);
			contentPanel.add(lblIdDelCliene);
		}
		{
			txtId = new JTextField();
			txtId.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
			txtId.setBounds(171, 40, 118, 20);
			contentPanel.add(txtId);
			txtId.setColumns(10);
		}
		{
			btnBuscar = 
					new JButton("Buscar");
			btnBuscar.setIcon(new ImageIcon(Canjearpuntos.class.getResource("/imagenes/icons8-b\u00FAsqueda-15.png")));
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente aux = Fabrica.getInstance().findClientebyId(txtId.getText());
					if(aux != null) {
						btnCanjear.setEnabled(true);
						txtPuntos.setText(String.valueOf(aux.getPuntos()));
						
					}
					
				}
			});
			btnBuscar.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 12));
			btnBuscar.setBounds(129, 84, 89, 23);
			contentPanel.add(btnBuscar);
		}
		{
			JLabel lblPuntosAcumulados = new JLabel("Puntos acumulados:");
			lblPuntosAcumulados.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
			lblPuntosAcumulados.setBounds(33, 173, 134, 20);
			contentPanel.add(lblPuntosAcumulados);
		}
		{
			txtPuntos = new JTextField();
			txtPuntos.setEditable(false);
			txtPuntos.setBounds(171, 174, 118, 20);
			contentPanel.add(txtPuntos);
			txtPuntos.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCanjear = new JButton("Canjear");
				btnCanjear.setIcon(new ImageIcon(Canjearpuntos.class.getResource("/imagenes/icons8-tarjeta-en-uso-25.png")));
				btnCanjear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtId.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "No hay ningun ID", "Advertencia", JOptionPane.WARNING_MESSAGE);
						}else {
							int option = JOptionPane.showConfirmDialog(null, "Seguro que desea cangear los puntos?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION) {
								Fabrica.getInstance().canjearpuntos(txtId.getText());
								clean();
							}
						}
					}
				});
				btnCanjear.setEnabled(false);
				btnCanjear.setActionCommand("OK");
				buttonPane.add(btnCanjear);
				getRootPane().setDefaultButton(btnCanjear);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(Canjearpuntos.class.getResource("/imagenes/icons8-eliminar-25.png")));
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
	private void clean() {
		txtId.setText("");
		txtPuntos.setText("");
		btnCanjear.setEnabled(false);
		
	}
	

}

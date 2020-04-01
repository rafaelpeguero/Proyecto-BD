package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



import logico.Cliente;
import logico.Fabrica;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Modificarcliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtDire;
	private JTextField txtTel;
	private JSpinner spncred;
	private JPanel panel;
	private Cliente cli;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public Modificarcliente(Cliente client) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modificarcliente.class.getResource("/imagenes/avatar_people_person_profile_user_woman_icon_123359.png")));
		this.cli = client;
		setTitle("Modificar Cliente");
		setResizable(false);
		setBounds(100, 100, 380, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("ID:");
			lblId.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
			lblId.setBounds(89, 32, 40, 23);
			contentPanel.add(lblId);
		}
		
		txtId = new JTextField();
		txtId.setBounds(139, 34, 108, 23);
		contentPanel.add(txtId);
		txtId.setColumns(10);
		{
			panel = new JPanel();
			panel.setBackground(new Color(255, 245, 238));
			panel.setVisible(false);
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 79, 336, 214);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(33, 35, 78, 23);
				panel.add(lblNombre);
				lblNombre.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
			}
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(110, 37, 157, 23);
				panel.add(txtNombre);
			}
			{
				JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
				lblDireccion.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
				lblDireccion.setBounds(33, 86, 78, 23);
				panel.add(lblDireccion);
			}
			{
				txtDire = new JTextField();
				txtDire.setColumns(10);
				txtDire.setBounds(110, 89, 157, 23);
				panel.add(txtDire);
			}
			{
				JLabel lblTelefono = new JLabel("Telefono:");
				lblTelefono.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
				lblTelefono.setBounds(33, 135, 78, 23);
				panel.add(lblTelefono);
			}
			{
				txtTel = new JTextField();
				txtTel.setColumns(10);
				txtTel.setBounds(110, 137, 157, 23);
				panel.add(txtTel);
			}
			{
				JLabel lblCredito = new JLabel("Credito:");
				lblCredito.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
				lblCredito.setBounds(33, 180, 78, 23);
				panel.add(lblCredito);
			}
			
			spncred = new JSpinner();
			spncred.setBackground(Color.RED);
			spncred.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
			spncred.setModel(new SpinnerNumberModel(new Float(1), new Float(1), new Float(500), new Float(5)));
			spncred.setBounds(110, 180, 157, 23);
			panel.add(spncred);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			loadclients(cli);
			{
				JButton btnModificar = new JButton("Modificar");
				btnModificar.setIcon(new ImageIcon(Modificarcliente.class.getResource("/imagenes/icons8-editar-usuaria-25.png")));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cli.setNombre(txtNombre.getText());
						cli.setDireccion(txtDire.getText());
						cli.setTelefono(txtTel.getText());
						if(cli.getCredito() >= 700 || cli.getPuntos() < 10) {
							JOptionPane.showMessageDialog(null, "Usted no califica para aunmentar su crédito", "Advertencia", JOptionPane.WARNING_MESSAGE);
							
						}else{
						
							cli.setCredito((float)spncred.getValue( )+ cli.getCredito());				
							
						}
						Fabrica.getInstance().editclient(cli);
						Listclientes.loadtableclient();
						dispose();
						
					}
				});
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(Modificarcliente.class.getResource("/imagenes/icons8-eliminar-25.png")));
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
	public void loadclients(Cliente cli) {
		//Cliente aux = Fabrica.getInstance().findClientebyId(id);
		panel.setVisible(true);
		txtId.setEditable(false);
		txtId.setText(cli.getId());		
		txtNombre.setText(cli.getNombre());
		txtDire.setText(cli.getDireccion());
		txtTel.setText(cli.getTelefono());
		//spncred.setValue(cli.getCredito());
		
		
		
	}
}

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
import javax.swing.border.TitledBorder;

import logico.Fabrica;
import logico.Queso;
import logico.Queso_Cilindrico;
import logico.Queso_esfera;
import logico.Queso_hueco;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class RegQueso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JSpinner spnRadInte;
	private JRadioButton rdbtnQuesoEsferico;
	private JRadioButton rdbtnQuesoHueco;
	private JSpinner spnBase;
	private JSpinner spnUni;
	private JSpinner spnradHueco;
	private JSpinner spnRadEsfe;
	private JSpinner spnLongiCili;
	private JSpinner spnRadCili;
	private JPanel Panel_hueco;
	private JPanel panel_esfe;
	private JPanel Panel_cilin;
	private JPanel panel_prin;
	private JLabel lblLongitud_1;
	private JSpinner spnLongiHueco;
	private JLabel lblCantidad;
	private JSpinner spncantqueso;
	private JLabel lblNewLabel_1;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public RegQueso( ) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegQueso.class.getResource("/imagenes/etiqueta-del-precio.png")));

		setTitle("Registrar Queso");


		setResizable(false);
		setBounds(100, 100, 506, 554);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 472, 153);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblPrecioBase = new JLabel("Precio Base:");
		lblPrecioBase.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblPrecioBase.setBounds(10, 26, 76, 19);
		panel.add(lblPrecioBase);

		spnBase = new JSpinner();
		spnBase.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		spnBase.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 12));
		spnBase.setBounds(96, 26, 89, 20);
		panel.add(spnBase);

		JLabel lblPrecioUnitario = new JLabel("Precio Unitario:");
		lblPrecioUnitario.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblPrecioUnitario.setBounds(10, 83, 95, 19);
		panel.add(lblPrecioUnitario);

		spnUni = new JSpinner();
		spnUni.setBackground(Color.ORANGE);
		spnUni.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		spnUni.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 12));
		spnUni.setBounds(96, 83, 89, 20);
		panel.add(spnUni);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblCodigo.setBounds(242, 38, 64, 19);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		txtCodigo.setBackground(Color.ORANGE);
		txtCodigo.setEditable(false);
		txtCodigo.setText("Q-"+(Fabrica.getInstance().codqueso));
		txtCodigo.setBounds(310, 38, 123, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblCantidad.setBounds(242, 83, 64, 19);
		panel.add(lblCantidad);

		spncantqueso = new JSpinner();
		spncantqueso.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spncantqueso.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 12));
		spncantqueso.setBounds(310, 82, 123, 20);
		panel.add(spncantqueso);

		JPanel panel_selec = new JPanel();
		panel_selec.setBackground(Color.WHITE);
		panel_selec.setBorder(new TitledBorder(null, "Tipo de Queso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_selec.setBounds(10, 175, 472, 145);
		contentPanel.add(panel_selec);
		panel_selec.setLayout(null);

		JRadioButton rdbtnQuesoCilindrico = new JRadioButton("Queso Cilindrico");
		rdbtnQuesoCilindrico.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		rdbtnQuesoCilindrico.setBackground(Color.WHITE);
		rdbtnQuesoCilindrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnQuesoCilindrico.setSelected(true);
				rdbtnQuesoEsferico.setSelected(false);
				rdbtnQuesoHueco.setSelected(false);
				panel_esfe.setVisible(false);
				panel_prin.setVisible(false);
				Panel_hueco.setVisible(false);
				Panel_cilin.setVisible(true);	
				spnRadCili.setVisible(true);
				spnLongiCili.setVisible(true);


			}
		});
		rdbtnQuesoCilindrico.setSelected(true);
		rdbtnQuesoCilindrico.setBounds(6, 60, 130, 23);
		panel_selec.add(rdbtnQuesoCilindrico);

		rdbtnQuesoEsferico = new JRadioButton("Queso Esferico");
		rdbtnQuesoEsferico.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		rdbtnQuesoEsferico.setBackground(Color.WHITE);
		rdbtnQuesoEsferico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnQuesoEsferico.setSelected(true);
				rdbtnQuesoCilindrico.setSelected(false);
				rdbtnQuesoHueco.setSelected(false);
				panel_esfe.setVisible(true);
				panel_prin.setVisible(false);
				Panel_hueco.setVisible(false);
				Panel_cilin.setVisible(false);
				spnRadEsfe.setVisible(true);

			}
		});
		rdbtnQuesoEsferico.setBounds(162, 60, 130, 23);
		panel_selec.add(rdbtnQuesoEsferico);

		rdbtnQuesoHueco = new JRadioButton("Queso Hueco");
		rdbtnQuesoHueco.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		rdbtnQuesoHueco.setBackground(Color.WHITE);
		rdbtnQuesoHueco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnQuesoEsferico.setSelected(false);
				rdbtnQuesoCilindrico.setSelected(false);
				rdbtnQuesoHueco.setSelected(true);
				panel_esfe.setVisible(false);
				panel_prin.setVisible(false);
				Panel_hueco.setVisible(true);
				Panel_cilin.setVisible(false);
				spnradHueco.setVisible(true);
				spnRadInte.setVisible(true);
				spnLongiHueco.setVisible(true);
				

			}
		});
		rdbtnQuesoHueco.setBounds(325, 60, 109, 23);
		panel_selec.add(rdbtnQuesoHueco);

		Panel_hueco = new JPanel();
		Panel_hueco.setBackground(Color.WHITE);
		Panel_hueco.setVisible(false);
		Panel_hueco.setBorder(new TitledBorder(null, "Tama\u00F1o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_hueco.setBounds(10, 331, 472, 117);
		contentPanel.add(Panel_hueco);
		Panel_hueco.setLayout(null);

		JLabel lblNewLabel = new JLabel("Radio:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 28, 58, 24);
		Panel_hueco.add(lblNewLabel);

		spnradHueco = new JSpinner();
		spnradHueco.setVisible(false);
		spnradHueco.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnradHueco.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		spnradHueco.setBounds(78, 30, 95, 20);
		Panel_hueco.add(spnradHueco);

		JLabel lblRadioInterior = new JLabel("Radio Interior:");
		lblRadioInterior.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblRadioInterior.setBounds(226, 28, 95, 24);
		Panel_hueco.add(lblRadioInterior);

		spnRadInte = new JSpinner();
		spnRadInte.setVisible(false);
		spnRadInte.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnRadInte.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		spnRadInte.setBounds(331, 30, 95, 20);
		Panel_hueco.add(spnRadInte);

		lblLongitud_1 = new JLabel("Longitud:");
		lblLongitud_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblLongitud_1.setBounds(138, 71, 72, 24);
		Panel_hueco.add(lblLongitud_1);

		spnLongiHueco = new JSpinner();
		spnLongiHueco.setVisible(false);
		spnLongiHueco.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnLongiHueco.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		spnLongiHueco.setBounds(201, 74, 102, 20);
		Panel_hueco.add(spnLongiHueco);

		panel_esfe = new JPanel();
		panel_esfe.setBackground(Color.WHITE);
		panel_esfe.setVisible(false);
		panel_esfe.setBounds(10, 331, 472, 117);
		contentPanel.add(panel_esfe);
		panel_esfe.setBorder(new TitledBorder(null, "Tama\u00F1o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_esfe.setLayout(null);

		JLabel lblRadio_1 = new JLabel("Radio:");
		lblRadio_1.setBounds(143, 37, 56, 26);
		lblRadio_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		panel_esfe.add(lblRadio_1);

		spnRadEsfe = new JSpinner();
		spnRadEsfe.setVisible(false);
		spnRadEsfe.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnRadEsfe.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		spnRadEsfe.setBounds(209, 41, 102, 20);
		panel_esfe.add(spnRadEsfe);

		Panel_cilin = new JPanel();
		Panel_cilin.setBackground(Color.WHITE);
		Panel_cilin.setBounds(10, 331, 472, 117);
		contentPanel.add(Panel_cilin);
		Panel_cilin.setBorder(new TitledBorder(null, "Tama\u00F1o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_cilin.setLayout(null);

		spnLongiCili = new JSpinner();
		spnLongiCili.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnLongiCili.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 12));
		spnLongiCili.setBounds(71, 49, 85, 20);
		Panel_cilin.add(spnLongiCili);

		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(10, 49, 76, 19);
		Panel_cilin.add(lblLongitud);
		lblLongitud.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 12));

		JLabel lblRadio = new JLabel("Radio:");
		lblRadio.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 12));
		lblRadio.setBounds(222, 52, 55, 19);
		Panel_cilin.add(lblRadio);

		spnRadCili = new JSpinner();
		spnRadCili.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnRadCili.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 12));
		spnRadCili.setBounds(287, 52, 76, 20);
		Panel_cilin.add(spnRadCili);

		panel_prin = new JPanel();
		panel_prin.setBackground(Color.WHITE);
		panel_prin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_prin.setBounds(10, 331, 472, 117);
		contentPanel.add(panel_prin);
		panel_prin.setLayout(null);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(RegQueso.class.getResource("/imagenes/fondo-patron-queso_1236-182.jpg")));
		lblNewLabel_1.setBounds(0, 0, 500, 473);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setIcon(new ImageIcon(RegQueso.class.getResource("/imagenes/icons8-hogaza-de-pan-25.png")));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String cod = txtCodigo.getText();
						float precio_base = Float.parseFloat(spnBase.getValue().toString());
						float precio_uni = Float.parseFloat(spnUni.getValue().toString());
						int cantidad = Integer.parseInt(spncantqueso.getValue().toString());

						if(rdbtnQuesoCilindrico.isSelected()) {
							int radio = Integer.parseInt(spnRadCili.getValue().toString());
							int longi = Integer.parseInt(spnLongiCili.getValue().toString());
							Queso_Cilindrico cili = new Queso_Cilindrico(precio_base, precio_uni, cod, longi, radio,cantidad);
							Fabrica.getInstance().insertarQueso(cili);
						}else if(rdbtnQuesoEsferico.isSelected()) {
							int rad_esf = Integer.parseInt(spnRadEsfe.getValue().toString());
							Queso_esfera esfe = new Queso_esfera(precio_base, precio_uni, cod, rad_esf, cantidad);
							Fabrica.getInstance().insertarQueso(esfe);

						}else if(rdbtnQuesoHueco.isSelected()) {
							int rad_inte = Integer.parseInt(spnRadInte.getValue().toString());
							int rad_hueco = Integer.parseInt(spnradHueco.getValue().toString());
							int longitud = Integer.parseInt(spnLongiHueco.getValue().toString());
							Queso_hueco hueco = new Queso_hueco(precio_base, precio_uni, cod, longitud, rad_hueco, rad_inte,cantidad);
							Fabrica.getInstance().insertarQueso(hueco);
						}
						JOptionPane.showMessageDialog(null, "Operación satisfactoria ", "Información", JOptionPane.INFORMATION_MESSAGE); 
						clean();

					}

					private void clean() {
						txtCodigo.setText(String.valueOf("Q-"+(Fabrica.getInstance().codqueso)));
						spnBase.setValue(new Integer(1));
						spnUni.setValue(new Integer(1));
						spnLongiCili.setValue(new Integer(1));
						spnLongiHueco.setValue(new Integer(1));
						spnRadCili.setValue(new Integer(1));
						spnRadEsfe.setValue(new Integer(1));
						spnRadInte.setValue(new Integer(1));
						spncantqueso.setValue(new Integer(0));

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(RegQueso.class.getResource("/imagenes/icons8-eliminar-25.png")));
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

}

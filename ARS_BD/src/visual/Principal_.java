package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Principal_ {

	private JFrame frmArsPucmm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_ window = new Principal_();
					window.frmArsPucmm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal_() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmArsPucmm = new JFrame();
		frmArsPucmm.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal_.class.getResource("/imagenes/faviconnew.png")));
		frmArsPucmm.setTitle("ARS PUCMM\r\n");
		frmArsPucmm.setResizable(false);
		frmArsPucmm.setBounds(100, 100, 1280, 900);
		frmArsPucmm.setLocationRelativeTo(null);
		frmArsPucmm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmArsPucmm.setJMenuBar(menuBar);
		
		JMenu mnAdministracion = new JMenu("Administracion");
		menuBar.add(mnAdministracion);
		
		JMenu mnPaciente = new JMenu("Paciente");
		menuBar.add(mnPaciente);
		
		JMenuItem mntmregistrar = new JMenuItem("Registrar");
		mnPaciente.add(mntmregistrar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnPaciente.add(mntmConsultar);
		
		JMenu mnMedico = new JMenu("Medico");
		menuBar.add(mnMedico);
		
		JMenuItem menuItem = new JMenuItem("Registrar");
		mnMedico.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Consultar");
		mnMedico.add(menuItem_1);
		
		JMenu mnProvedor = new JMenu("Provedor");
		menuBar.add(mnProvedor);
		
		JMenuItem menuItem_2 = new JMenuItem("Registrar");
		mnProvedor.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Consultar");
		mnProvedor.add(menuItem_3);
		
		JMenu mnAutorizaciones = new JMenu("Autorizaciones");
		menuBar.add(mnAutorizaciones);
		
		JMenuItem mntmRealizar = new JMenuItem("Realizar");
		mnAutorizaciones.add(mntmRealizar);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mnAutorizaciones.add(mntmConsulta);
		
		JMenuItem mntmReporte = new JMenuItem("Reporte");
		mnAutorizaciones.add(mntmReporte);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Principal_.class.getResource("/imagenes/Logo 1052x402 px #3.png")));
		frmArsPucmm.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}

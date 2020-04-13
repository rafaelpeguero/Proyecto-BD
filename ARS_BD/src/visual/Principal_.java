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
		frmArsPucmm.setTitle("ARS PUCMM\r\n");
		frmArsPucmm.setResizable(false);
		frmArsPucmm.setBounds(100, 100, 1440, 900);
		frmArsPucmm.setLocationRelativeTo(null);
		frmArsPucmm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmArsPucmm.setJMenuBar(menuBar);
		
		JMenu mnAdministracion = new JMenu("Administracion");
		menuBar.add(mnAdministracion);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmregistrar = new JMenuItem("Registrar");
		mnClientes.add(mntmregistrar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnClientes.add(mntmConsultar);
		
		JMenu mnProvedores = new JMenu("Provedores");
		menuBar.add(mnProvedores);
		
		JMenuItem menuItem = new JMenuItem("Registrar");
		mnProvedores.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Consultar");
		mnProvedores.add(menuItem_1);
		
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

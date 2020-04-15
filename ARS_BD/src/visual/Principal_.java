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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frmArsPucmm.setBounds(100, 100, 1400, 900);
		frmArsPucmm.setLocationRelativeTo(null);
		frmArsPucmm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmArsPucmm.setJMenuBar(menuBar);
		
		JMenu mnAdministracion = new JMenu("Administracion");
		menuBar.add(mnAdministracion);
		
		JMenu mnPaciente = new JMenu("Paciente");
		menuBar.add(mnPaciente);
		
		JMenuItem mntmregistrar = new JMenuItem("Registrar");
		mntmregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjPaciente obj = new ObjPaciente();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				
				
				
			}
		});
		mnPaciente.add(mntmregistrar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				ObjConsultaPaciente obj_c_p = new ObjConsultaPaciente();
				obj_c_p.setVisible(true);
				obj_c_p.setLocationRelativeTo(null);
	
				
				
			}
		});
		mnPaciente.add(mntmConsultar);
		
		JMenu mnMedico = new JMenu("Medico");
		menuBar.add(mnMedico);
		
		JMenuItem menuItem = new JMenuItem("Registrar");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjMedico obj = new ObjMedico();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		mnMedico.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Consultar");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Obj_C_Medico obj = new Obj_C_Medico();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		mnMedico.add(menuItem_1);
		
		JMenu mnStaff = new JMenu("Staff");
		menuBar.add(mnStaff);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjStaff obj = new ObjStaff();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		mnStaff.add(mntmRegistrar);
		
		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Obj_C_Staff obj = new Obj_C_Staff();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		mnStaff.add(mntmConsultar_1);
		
		JMenu mnProvedor = new JMenu("Provedor");
		menuBar.add(mnProvedor);
		
		JMenuItem menuItem_2 = new JMenuItem("Registrar");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjProvedor obj = new ObjProvedor();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		mnProvedor.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Consultar");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Obj_C_Provedor obj = new Obj_C_Provedor();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		mnProvedor.add(menuItem_3);
		
		JMenu mnAutorizaciones = new JMenu("Autorizaciones");
		menuBar.add(mnAutorizaciones);
		
		JMenuItem mntmRealizar = new JMenuItem("Realizar");
		mntmRealizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Obj_C_Autorizacion obj = new Obj_C_Autorizacion();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		mnAutorizaciones.add(mntmRealizar);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Obj_C_Autorizacion obj = new Obj_C_Autorizacion();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		mnAutorizaciones.add(mntmConsulta);
		
		JMenuItem mntmReporte = new JMenuItem("Reporte");
		mnAutorizaciones.add(mntmReporte);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Principal_.class.getResource("/imagenes/Logo 1052x402 px #3.png")));
		frmArsPucmm.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}

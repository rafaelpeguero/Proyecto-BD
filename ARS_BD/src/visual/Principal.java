package visual;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Fabrica;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JSeparator;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		File  datos = new File("Fabrica.dat");
		if(datos.exists()) {
			FileInputStream entradafile;
			try {
				entradafile = new FileInputStream(datos);
				ObjectInputStream entrada = new ObjectInputStream(entradafile);
				Fabrica.setInstance((Fabrica)entrada.readObject());
				entradafile.close();
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				FileOutputStream f;
				try {
					f = new FileOutputStream("Fabrica.dat");
					ObjectOutputStream save = new ObjectOutputStream(f);
					save.writeObject(Fabrica.getInstance());
					f.close();
				} catch (FileNotFoundException e) {
					// TODO: handle exception
					e.printStackTrace();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
					
				}
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/tienda-online (1).png")));
		setTitle("Fabrica de Quesos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 617);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnQuesos = new JMenu("Administrador");
		mnQuesos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-m\u00E1s-30.png")));
		menuBar.add(mnQuesos);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar ");
		mntmRegistrar.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-hogaza-de-pan-30.png")));
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegQueso queso = new RegQueso(); //Ahi se esta creando una instancia de RegQueso
				queso.setModal(true);
				queso.setVisible(true);
			}
		});
		mnQuesos.add(mntmRegistrar);
		
		JMenu mnDisponibilidad = new JMenu("Paciente ");
		mnDisponibilidad.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-entrar-32.png")));
		menuBar.add(mnDisponibilidad);
		
		JMenuItem mntmCantidadDeQueoss = new JMenuItem("Cantidad de Quesos");
		mntmCantidadDeQueoss.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-carpeta-de-documentos-30.png")));
		mntmCantidadDeQueoss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CantQuesos cant = new CantQuesos(); //Ahi se esta creando una instancia d
				cant.setModal(true);
				cant.setVisible(true);
			}
		});
		mnDisponibilidad.add(mntmCantidadDeQueoss);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mnDisponibilidad.add(mntmNewMenuItem);
		
		JMenu mnFacturacion = new JMenu("Facturacion");
		mnFacturacion.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-recibo-30.png")));
		menuBar.add(mnFacturacion);
		
		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-verificar-30.png")));
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar fa = new Facturar();
				fa.setModal(true);
				fa.setVisible(true);
			}
		});
		mnFacturacion.add(mntmFacturar);
		
		JMenu mnInformacion = new JMenu("Informaci\u00F3n");
		mnInformacion.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-carpeta-30.png")));
		menuBar.add(mnInformacion);
		
		JMenuItem mntmListaDeClientes = new JMenuItem("Lista de clientes");
		mntmListaDeClientes.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-mostrar-propiedad-25.png")));
		mntmListaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listclientes cli = new Listclientes();
				cli.setModal(true);
				cli.setVisible(true);
				
			}
		});
		mnInformacion.add(mntmListaDeClientes);
		
		JMenuItem mntmListaDeQuesos = new JMenuItem("Lista de quesos");
		mntmListaDeQuesos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-lista-de-transacciones-25.png")));
		mntmListaDeQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadequesos aux = new listadequesos();
				aux.setModal(true);
				aux.setVisible(true);
				
			}
		});
		
		JSeparator separator = new JSeparator();
		mnInformacion.add(separator);
		mnInformacion.add(mntmListaDeQuesos);
		
		JSeparator separator_1 = new JSeparator();
		mnInformacion.add(separator_1);
		
		JMenuItem mntmCanjearPuntos = new JMenuItem("Canjear puntos");
		mntmCanjearPuntos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8-pago-online-30.png")));
		mntmCanjearPuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Canjearpuntos aux = new Canjearpuntos();
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnInformacion.add(mntmCanjearPuntos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/thumb-1920-583515.jpg")));
		lblNewLabel.setBounds(0, 0, 1594, 849);
		contentPane.add(lblNewLabel);
	}
}

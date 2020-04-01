package visual;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JTextPane;

public class ConsolaServer extends JFrame implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnMain;
	private JTextPane taTextPane;
	
	public ConsolaServer() {
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		this.setResizable(false);
		this.setTitle("Consola Servidor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 600, 480);
		pnMain = new JPanel();
		pnMain.setBackground(Color.BLACK);
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnMain);
		pnMain.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scpnMensaje = new JScrollPane();
		pnMain.add(scpnMensaje, BorderLayout.CENTER);
		
		taTextPane = new JTextPane();
		taTextPane.setEditable(false);
		taTextPane.setForeground(Color.WHITE);
		taTextPane.setFont(new Font("Consolas", Font.PLAIN, 12));
		taTextPane.setBackground(Color.DARK_GRAY);
		scpnMensaje.setViewportView(taTextPane);
	}
	
	private void escribirConsola(final String msg, Color C) {
		/* 
		 * Formamos el String del mensaje.
		 * 1. Obtenemos la fecha y hora actual del mensaje.
		 * 2. Lo concatenamos y ya esta.
		 * */ 
		String mensaje;
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date();   
		if(taTextPane.getText().length() == 0) {
			mensaje = formatter.format(date) + " >> " + msg;
		} else {
			mensaje = "\n";
			mensaje += formatter.format(date) + " >> " + msg;
		}
		
		/*
		 * Ahora solo falta enviar el mensaje al JTextPane.
		 * 1. Obtenemos el Estilo de Contexto por defecto.
		 * 2. Luego, agregamos un atributo al estilo de contexto, en este caso, el color que deseamos.
		 * 3. Obtenemos el length del JTextPane.
		 * 4. Obtenemos el Estilo del documento actual y lo cambiamos.
		 *  */
		StyleContext temp_sc = StyleContext.getDefaultStyleContext();
		AttributeSet miAtributo = temp_sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, C);
		int len = taTextPane.getDocument().getLength();
		StyledDocument miDocumento = taTextPane.getStyledDocument();
		try {
			miDocumento.insertString(len, mensaje, miAtributo);
		} catch (BadLocationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error al tratar de escribir en la consola.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void escribirLogInfo(final String msg) {
		escribirConsola("(INFO) " + msg, Color.WHITE);
	}
	
	public void escribirLogError(final String msg) {
		escribirConsola("(ERROR) " + msg, Color.RED);
	}
	
	public void escribirLogWarning(final String msg) {
		escribirConsola("(WARNING) " + msg, Color.ORANGE);
	}
}

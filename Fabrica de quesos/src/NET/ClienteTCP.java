package NET;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import logico.Factura;

public class ClienteTCP {
	private Socket socket_cliente;
	
	public ClienteTCP() {
		try {
			socket_cliente = new Socket("127.0.0.1", 8080);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "No se pudo resolver la conexion con el servidor.", "Error", 
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudieron enviar los datos al servidor, porque no se encontro"
					+ " el servidor.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void start(Factura datos) {
		OutputStream os;
		try {
			os = socket_cliente.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(datos);
			oos.close();
			os.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al enviar los datos al servidor.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

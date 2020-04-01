package NET;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import logico.Factura;
import logico.Queso;
import visual.ConsolaServer;

public class ServerTCP extends Thread {
	private ServerSocket server_socket = null;
	private Socket socket_cliente = null;
	private ArrayList<Factura> misFacturas;
	private ConsolaServer consola;
	
	public ServerTCP(int puerto) {
		consola = new ConsolaServer();
		consola.setVisible(true);
		cargarFacturaFichero();
		try {
			server_socket = new ServerSocket(puerto);
			consola.escribirLogInfo("IP: 127.0.0.1; Puerto: 8080");
			consola.escribirLogInfo("El servidor se ha iniciado correctamente.");
			consola.escribirLogInfo("Esperando por datos de un usuario.");
		} catch (IOException e) {
			consola.escribirLogError("El servidor no se pudo crear porque el puerto se esta usando.");
		}
	}
		
	private void obtenerInfoUsuario() throws IOException, ClassNotFoundException {
		InputStream is = socket_cliente.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		Factura nuevo = (Factura)ois.readObject();
		if (nuevo != null) {
			misFacturas.add(nuevo);
			consola.escribirLogInfo("Datos de la factura recibidos.");
			imprimirReporte(nuevo);
			salvarFicheroUSuarios();
		}
		is.close();
	}
	
	
	private void cargarFacturaFichero() {
		FileInputStream cargar_fichero;
		try {
			cargar_fichero = new FileInputStream(new File("facturas.bin"));
			ObjectInputStream lector = new ObjectInputStream(cargar_fichero);
			misFacturas = (ArrayList<Factura>) lector.readObject();
			lector.close();
		} catch (FileNotFoundException e1) {
			// Crear el fichero 
			misFacturas = new ArrayList<Factura>();
			salvarFicheroUSuarios();
		} catch (IOException e) {
			consola.escribirLogError("Error al leer el fichero de las facturas registradss.");
		} catch (ClassNotFoundException e) {
			consola.escribirLogError("Archivo de las facturas registradas esta corrompido.");
			System.exit(-1);
		}
	}
	
	private void salvarFicheroUSuarios() {
		FileOutputStream creador;
		try {
			creador = new FileOutputStream(new File("facturas.bin"));
			ObjectOutputStream escritor = new ObjectOutputStream(creador);
			escritor.writeObject(misFacturas);
			escritor.close();
		} catch (IOException e) {
			consola.escribirLogError("Error al escribir al fichero de facturas.");
		}
	}
	
	private void imprimirReporte(Factura fac) {
		Date date = new Date();   
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");  
		String path = "Factura" + formatter.format(date) + ".txt";
		FileWriter fichero;
		try {
			fichero = new FileWriter(path);
			fichero.write("Fabrica de quesos\n");
			fichero.write("Direccion: El Egido, Calle #5. Telefono: 849-223-4321\n");
			fichero.write("Codigo Factura: " +  fac.getCodigo() + "\n");
			fichero.write("Nombre Cliente: " + fac.getMyclient().getNombre() + "\n");
			fichero.write("Fecha: " + LocalDate.now().toString() + "\n");
			fichero.write("Tipo Factura: " + fac.getTipodefactura() + "\n");
			fichero.write("Items Comprados: \n");
			for (Queso q : fac.getQuesoscomprados()) {
				fichero.write(q.getCodigo() + "............. " + q.precio() + "\n");
			}
			fichero.write("Precio Total: " + fac.getPrecio_tot() + "\n");
			fichero.flush();
			consola.escribirLogInfo("El reporte de la factura se realizo con exito!");
		} catch (IOException e) {
			consola.escribirLogWarning("Los datos se han recibido, pero el reporte no se imprimio con exito.");
		}
	}
	
	public void run() {
		while(true) {
			try {
				socket_cliente = server_socket.accept();
				if(socket_cliente != null) {
					obtenerInfoUsuario();
				}
			} catch (IOException e) {
				consola.escribirLogError(e.getMessage());
			} catch (ClassNotFoundException e) {
				consola.escribirLogError(e.getMessage());
			}
		}
	}
		
	public static void main(String[] args) {
		ServerTCP s = new ServerTCP(8080);
		s.start();
	}
}

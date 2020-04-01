package logico;

import java.io.Serializable;
import java.util.ArrayList;


public class Fabrica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> miclient;
	private ArrayList<Factura> miFacturas;
	private ArrayList<Queso> misquesos;
	private static Fabrica fabri;
	public static int codqueso;
	public static int codfactu;
	
	private Fabrica() {
		super();
		this.miclient = new ArrayList<Cliente>();
		this.miFacturas = new ArrayList<Factura>();
		this.misquesos = new ArrayList<Queso>();
		this.codqueso = misquesos.size();
		this.codfactu = miFacturas.size();
	}
	
	public static Fabrica getInstance() {
		if(fabri == null) {
			fabri = new Fabrica();
		}
		return fabri;
	}
	
	public static void setInstance(Fabrica fabrica) {
		if(fabri == null) {
			fabri = fabrica;
		}
		
	}
	

	public ArrayList<Cliente> getMiclient() {
		return miclient;
	}
	public void setMiclient(ArrayList<Cliente> miclient) {
		this.miclient = miclient;
	}
	public ArrayList<Factura> getMiFacturas() {
		return miFacturas;
	}
	public void setMiFacturas(ArrayList<Factura> miFacturas) {
		this.miFacturas = miFacturas;
	}
	public ArrayList<Queso> getMisquesos() {
		return misquesos;
	}
	public void setMisquesos(ArrayList<Queso> misquesos) {
		this.misquesos = misquesos;
	}
	
	public void insertarQueso(Queso cheese) {
		misquesos.add(cheese);
		codqueso++;
		
	}
	
	public void insertfactura(Factura factura) {
		miFacturas.add(factura);
	}
	
	public void insertarlafrekingfactura(String id, Factura fact) {
		Cliente aux = findClientebyId(id);
		aux.insertfactura(fact);
		agregarpuntos(id, fact);
		codfactu++;
		
	}	

	public static int getCodqueso() {
		return codqueso;
	}

	public static void setCodqueso(int codqueso) {
		Fabrica.codqueso = codqueso;
	}

	public void insertarCliente(Cliente client) {
		miclient.add(client);
	}
	
	public int cantquesos() {
		int cant = 0;
		for (Queso aux : misquesos) {
			cant += aux.getCant();
			
		}
		
		return cant;
	}
	
	public int cantQueso_cili() {
		int cant = 0;
		for (Queso aux : misquesos) {
			if(aux instanceof Queso_Cilindrico && !(aux instanceof Queso_hueco)) {
				cant+= aux.getCant();
			}
			
		}
		return cant;
	}
	public int cantQueso_esferico() {
		int cant = 0;
		for (Queso aux : misquesos) {
			if(aux instanceof Queso_esfera) {
				cant += aux.getCant();
			}
			
		}
		return cant;
	}
	public int cantQueso_hueco() {
		int cant = 0;
		for (Queso aux : misquesos) {
			if(aux instanceof Queso_hueco) {
				cant+= aux.getCant();
			}
			
		}
		return cant;
	}
	
		public float preciodequeso_esferico() {
		float price = 0;
		float volumen = 0;
		for (Queso aux : misquesos) {
			if(aux instanceof Queso_esfera) {
				if(aux.volumen() > volumen) {
					volumen = aux.volumen();
					price = aux.getPrecio_base();
				}
			}
			
		}
		
		
		
		
		return price;
	}
	
		public Factura findfacturabycliente(String cod) {
			Factura aux = null;
			boolean encontrado = false;
			int i = 0;
			while(i <  miFacturas.size() && !encontrado) {
				if(miFacturas.get(i).getCodigo().equalsIgnoreCase(cod)) {
					aux = miFacturas.get(i);
					encontrado = true;
				}
				i++;
			}
			
			return aux;
		}
		public void agregarpuntos(String id,Factura fact) {
			Cliente aux = findClientebyId(id);
			//Factura aux1 = findfacturabycliente(idfact);
			int puntos = 0;
			if( aux != null) {
				puntos = (int) (fact.getPrecio_tot()/50);
				aux.setPuntos(aux.getPuntos() + puntos);
			}
			
		}
		
		public void canjearpuntos(String id) {
			Cliente aux = findClientebyId(id);
			int canjear = 0;
			if(aux != null) {
				canjear =  aux.getPuntos() * 20;
				aux.setCredito(aux.getCredito() + canjear);
			}
			
		}
		
	
		
		public int cantactu(String id) {
			int cant = 0;
			Queso aux = findquesobycod(id);
			cant = aux.getCant_actua();
			
			return cant;
			
		}
		
	public Queso findquesobycod(String cod) {
		Queso aux = null;
		boolean encontrado = false;
		int i = 0;
		while(i < misquesos.size() && !encontrado) {
			if(misquesos.get(i).getCodigo().equalsIgnoreCase(cod)) {
				aux = misquesos.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public Cliente findClientebyId(String Id) {
		Cliente aux = null;
		boolean encontrado = false;
		int i = 0;
		while(i <miclient.size() && !encontrado) {
			if(miclient.get(i).getId().equalsIgnoreCase(Id)) {
				aux = miclient.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public ArrayList<Queso> quesoscomprados(String id) {
		ArrayList<Queso> aux = new ArrayList<Queso>();
		
		for (Factura fact : miFacturas) {
			if(fact.getCodigo().equalsIgnoreCase(id)) {
				aux.addAll(fact.getQuesoscomprados());
			}
			
		}
		
		return aux;
	}
	private int findcheesebyindex(String id) {
		int aux = -1;
		boolean finded = false;
		int i = 0;
		while(!finded && i < misquesos.size()) {
			if(misquesos.get(i).getCodigo().equalsIgnoreCase(id)) {
				finded = true;
				aux = i;
			}
			i++;
		}
		return aux;
	}
	public int findclientebyidex(String ID) {
		int aux = -1;
		boolean finded = false;
		int i = 0;
		while(!finded && i < miclient.size()) {
			if(miclient.get(i).getId().equalsIgnoreCase(ID)) {
				finded = true;
				aux = i;
			}
		}
		return aux;
	}
	public void EliminarQueso(String id) {
		int index = -1;
		int aux = 0;
		if(findcheesebyindex(id) > -1) {
			index = findcheesebyindex(id);
			aux = index;
			while(aux < misquesos.size()) {
				misquesos.remove(aux);
				aux++;
			}
			
			
			
			
			
		}
		
	}
	public void editclient(Cliente client) {
		int aux = findclientebyidex(client.getId());
		miclient.set(aux, client);
	}
	
	
	public int actualizar(String id) {
		int actualizar = 0;
		Queso aux = findquesobycod(id);
		actualizar = aux.getCant();
		
		return actualizar;
	}
	
	

}

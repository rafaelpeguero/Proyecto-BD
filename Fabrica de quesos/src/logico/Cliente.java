package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private String nombre;
	private String direccion;
	private String telefono;
	private String id;
	private float credito;
	public int cantfacturas = 0;
	private ArrayList<Factura> misfacturas;
	private int puntos;
	
	
	public Cliente(String nombre, String direccion, String telefono, String id, float credito, int puntos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.id = id;
		this.credito = credito;
		this.misfacturas = new ArrayList<Factura>();
		this.puntos = puntos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getCredito() {
		return credito;
	}
	public void insertfactura(Factura factura) {
		misfacturas.add(factura);
		cantfacturas++;
	}
	public void setCredito(float credito) {
		this.credito = credito;
	}
	public int getCantfacturas() {
		return cantfacturas;
	}
	
	public void setCantfacturas(int cantfacturas) {
		this.cantfacturas = cantfacturas;
	}
	public ArrayList<Factura> getMisfacturas() {
		return misfacturas;
	}
	public void setMisfacturas(ArrayList<Factura> misfacturas) {
		this.misfacturas = misfacturas;
	}	
	
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Factura findfacturabycliente( String cod) {
		Factura aux = null;
		boolean encontrado = false;
		int i = 0;
		while(i <  misfacturas.size() && !encontrado) {
			if(misfacturas.get(i).getCodigo() == cod) {
				aux = misfacturas.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	
	
	
	

}

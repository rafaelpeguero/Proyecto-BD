package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente myclient;
	private ArrayList<Queso> quesoscomprados;
	private String tipodefactura;
	private float precio_tot;
	private String codigo;
	
	public Factura(Cliente myclient, ArrayList<Queso> quesoscomprados, String tipodefactura, float precio_tot, String codigo) {
		super();
		this.myclient = myclient;
		this.quesoscomprados = quesoscomprados;
		this.tipodefactura = tipodefactura;
		this.precio_tot = precio_tot;
		this.codigo = codigo;
	}


	public Cliente getMyclient() {
		return myclient;
	}


	public void setMyclient(Cliente myclient) {
		this.myclient = myclient;
	}


	public float getPrecio_tot() {
		return precio_tot;
	}

	public void setPrecio_tot(float precio_tot) {
		this.precio_tot = precio_tot;
	}

	public String getTipodefactura() {
		return tipodefactura;
	}

	public void setTipodefactura(String tipodefactura) {
		this.tipodefactura = tipodefactura;
	}

	public ArrayList<Queso> getQuesoscomprados() {
		return quesoscomprados;
	}
	

	public void setQuesoscomprados(ArrayList<Queso> quesoscomprados) {
		this.quesoscomprados = quesoscomprados;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public ArrayList<Queso> quesoscomprados() {
		ArrayList<Queso> aux = new ArrayList<Queso>();
		
		for (int i = 0; i < quesoscomprados.size(); i++) {
			aux.add(quesoscomprados.get(i));			
		}
		
		return aux;
	}
}

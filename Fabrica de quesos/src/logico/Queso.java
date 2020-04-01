package logico;

import java.io.Serializable;

public abstract class Queso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float precio_base;
	protected float precio_uni;
	protected String codigo;
	public int cant;
	public int cant_actua;
	
	
	public Queso(float precio_base, float precio_uni, String codigo, int cant) {
		super();
		this.precio_base = precio_base;
		this.precio_uni = precio_uni;
		this.codigo = codigo;
		this.cant = cant;
		this.cant_actua = cant;
	}

	

	public float getPrecio_base() {
		return precio_base;
	}



	public void setPrecio_base(float precio_base) {
		this.precio_base = precio_base;
	}



	public float getPrecio_uni() {
		return precio_uni;
	}

	public void setPrecio_uni(float precio_uni) {
		this.precio_uni = precio_uni;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public int getCant() {
		return cant;
	}



	public int getCant_actua() {
		return cant_actua;
	}



	public void setCant_actua(int cant_actua) {
		this.cant_actua = cant_actua;
	}



	public void setCant(int cant) {
		this.cant = cant;
	}



	abstract float volumen();
	
	public float precio() {
		float tot_price = 0f;
		 tot_price = precio_base + precio_uni * volumen();
		 tot_price = Math.round(tot_price * 1000)/ 1000f;
		 return tot_price;
	}
	
	

}

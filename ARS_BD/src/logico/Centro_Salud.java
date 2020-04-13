package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Centro_Salud implements Serializable{
	
	private int ID_Centro_Salud;
	private String Nombre;
	private int ID_Municipio;
	private String Descripcion;
	
	public Centro_Salud (int ID_Centro_Salud , String Nombre ,int ID_Municipio,String Descripcion ) {
		super();
		this.ID_Centro_Salud = ID_Centro_Salud;
		this.Nombre = Nombre;
		this.ID_Municipio = ID_Municipio;
		this.Descripcion = Descripcion;
		
	}

	public int getID_Centro_Salud() {
		return ID_Centro_Salud;
	}

	public void setID_Centro_Salud(int iD_Centro_Salud) {
		ID_Centro_Salud = iD_Centro_Salud;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getID_Municipio() {
		return ID_Municipio;
	}

	public void setID_Municipio(int iD_Municipio) {
		ID_Municipio = iD_Municipio;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	

}


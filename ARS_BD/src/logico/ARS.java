package logico;

import java.io.Serializable;

public class ARS implements Serializable{
	
	private int ID_ARS;
	private String Nombre;
	private String Descripcion;
	
	public ARS(int iD_ARS, String nombre, String descripcion) {
		super();
		ID_ARS = iD_ARS;
		Nombre = nombre;
		Descripcion = descripcion;
	}

	public int getID_ARS() {
		return ID_ARS;
	}

	public void setID_ARS(int iD_ARS) {
		ID_ARS = iD_ARS;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	
	
	
	
	/*create table ARS
(
	ID_ARS int primary key,
	Nombre varchar (40),
	Descripcion varchar (50),
)*/

}

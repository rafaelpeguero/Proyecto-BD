package logico;

import java.io.Serializable;

public class Tipo_Servicio implements Serializable{
	
	private int ID_Tipo_Servicio;
	private String Nombre;
	private String Descripcion;
	public Tipo_Servicio(int iD_Tipo_Servicio, String nombre, String descripcion) {
		super();
		this.ID_Tipo_Servicio = iD_Tipo_Servicio;
		this.Nombre = nombre;
		this.Descripcion = descripcion;
	}
	public int getID_Tipo_Servicio() {
		return ID_Tipo_Servicio;
	}
	public void setID_Tipo_Servicio(int iD_Tipo_Servicio) {
		ID_Tipo_Servicio = iD_Tipo_Servicio;
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
	
	
	/*create table Tipo_Servicio
(
	ID_Tipo_Servicio int primary key, --(PK)
	Nombre varchar(50),
	Descripcion varchar(max)
)*/

}

package logico;

import java.io.Serializable;

public class Especializacion implements Serializable{
	
	private int ID_Especializacion;
	private String Nombre;
	public Especializacion(int iD_Especializacion, String nombre) {
		super();
		this.ID_Especializacion = iD_Especializacion;
		this.Nombre = nombre;
	}
	public int getID_Especializacion() {
		return ID_Especializacion;
	}
	public void setID_Especializacion(int iD_Especializacion) {
		ID_Especializacion = iD_Especializacion;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
	/*create table especializacion 
(
	ID_Especializacion int primary key,
	Nombre varchar(25),
	)*/

}

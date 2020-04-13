package logico;

import java.io.Serializable;

public class Medicamento implements Serializable{
	
	private int ID_Medicamento;
	private float Precio;
	private String Nombre;
	public Medicamento(int iD_Medicamento, float precio, String nombre) {
		super();
		this.ID_Medicamento = iD_Medicamento;
		this.Precio = precio;
		this.Nombre = nombre;
	}
	public int getID_Medicamento() {
		return ID_Medicamento;
	}
	public void setID_Medicamento(int iD_Medicamento) {
		ID_Medicamento = iD_Medicamento;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float precio) {
		Precio = precio;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	/*create table Medicamento
(
	ID_Medicamento int primary key,
	Nombre varchar(50),
	Precio float,
	Abreviatura varchar(50)
)*/

}

package logico;

import java.io.Serializable;

public class Enfermedad implements Serializable{
	
	private int ID_Enfermedad;
	private int Nivel_Riesgo;
	private String Nombre_Enfermedad;
	private String Abrviatura;
	public Enfermedad(int iD_Enfermedad, int nivel_Riesgo, String nombre_Enfermedad, String abrviatura) {
		super();
		this.ID_Enfermedad = iD_Enfermedad;
		this.Nivel_Riesgo = nivel_Riesgo;
		this.Nombre_Enfermedad = nombre_Enfermedad;
		this.Abrviatura = abrviatura;
	}
	public int getID_Enfermedad() {
		return ID_Enfermedad;
	}
	public void setID_Enfermedad(int iD_Enfermedad) {
		ID_Enfermedad = iD_Enfermedad;
	}
	public int getNivel_Riesgo() {
		return Nivel_Riesgo;
	}
	public void setNivel_Riesgo(int nivel_Riesgo) {
		Nivel_Riesgo = nivel_Riesgo;
	}
	public String getNombre_Enfermedad() {
		return Nombre_Enfermedad;
	}
	public void setNombre_Enfermedad(String nombre_Enfermedad) {
		Nombre_Enfermedad = nombre_Enfermedad;
	}
	public String getAbrviatura() {
		return Abrviatura;
	}
	public void setAbrviatura(String abrviatura) {
		Abrviatura = abrviatura;
	}
	
	
	/*create table Enfermedad
(
	ID_Enfermedad int primary key, --(PK)
	Nivel_Riesgo int not null, --(INT) (0-10)
	Nombre_Enfermedad varchar(max),
	Abreviatura varchar(50)
)*/

}

package logico;

import java.io.Serializable;

public class Municipio implements Serializable {
	
private int ID_Municipio;
private int ID_Provincia;
private String Nombre;

public Municipio(int iD_Municipio, int iD_Provincia, String nombre) {
	super();
	this.ID_Municipio = iD_Municipio;
	this.ID_Provincia = iD_Provincia;
	this.Nombre = nombre;
}

public int getID_Municipio() {
	return ID_Municipio;
}

public void setID_Municipio(int iD_Municipio) {
	ID_Municipio = iD_Municipio;
}

public int getID_Provincia() {
	return ID_Provincia;
}

public void setID_Provincia(int iD_Provincia) {
	ID_Provincia = iD_Provincia;
}

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
} 




 /*create table Municipio
(
	ID_Municipio int primary key, --(PK)
	ID_Provincia int, --(FK)
	Nombre varchar(50),
	foreign key (ID_Provincia) references Provincia(ID_Provincia)
)*/

}

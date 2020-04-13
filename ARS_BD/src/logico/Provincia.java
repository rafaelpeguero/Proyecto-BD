package logico;

import java.io.Serializable;

public class Provincia implements Serializable {
	
private int ID_Provincia;
private String Nombre;

public Provincia(int iD_Provincia, String nombre) {
	super();
	
	this.ID_Provincia = iD_Provincia;
	this.Nombre = nombre;
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



/*create table Provincia
(
	ID_Provincia int primary key, --(PK)
	Nombre varchar(50)
)*/

}

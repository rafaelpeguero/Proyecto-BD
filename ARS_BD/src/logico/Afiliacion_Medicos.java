package logico;

import java.io.Serializable;

public class Afiliacion_Medicos implements Serializable{
	
	private int ID_Afiliacion ;
	private int ID_Centro_Salud;
	private int ID_Medico;
	public Afiliacion_Medicos(int iD_Afiliacion, int iD_Centro_Salud, int iD_Medico) {
		super();
		this.ID_Afiliacion = iD_Afiliacion;
		this.ID_Centro_Salud = iD_Centro_Salud;
		this.ID_Medico = iD_Medico;
	}
	public int getID_Afiliacion() {
		return ID_Afiliacion;
	}
	public void setID_Afiliacion(int iD_Afiliacion) {
		ID_Afiliacion = iD_Afiliacion;
	}
	public int getID_Centro_Salud() {
		return ID_Centro_Salud;
	}
	public void setID_Centro_Salud(int iD_Centro_Salud) {
		ID_Centro_Salud = iD_Centro_Salud;
	}
	public int getID_Medico() {
		return ID_Medico;
	}
	public void setID_Medico(int iD_Medico) {
		ID_Medico = iD_Medico;
	}
	
	
	/*create table Afiliacion_Medicos
(
	ID_Afiliacion int primary key,
	ID_Centro_Salud int, --FK
	ID_Medico int, --FK
	foreign key (ID_Centro_Salud) references Centro_Salud (ID_Centro_Salud),
	foreign key (ID_Medico) references Medicos(ID_Medico)
)*/

}

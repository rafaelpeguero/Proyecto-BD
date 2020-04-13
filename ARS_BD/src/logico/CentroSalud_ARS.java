package logico;

import java.io.Serializable;

public class CentroSalud_ARS implements Serializable{
	
	private int ID_Centro_Salud;
	private int ID_ARS;
	private int ID_Paciente;
	
	public CentroSalud_ARS(int iD_Centro_Salud, int iD_ARS, int iD_Paciente) {
		super();
		this.ID_Centro_Salud = iD_Centro_Salud;
		this.ID_ARS = iD_ARS;
		this.ID_Paciente = iD_Paciente;
	}

	public int getID_Centro_Salud() {
		return ID_Centro_Salud;
	}

	public void setID_Centro_Salud(int iD_Centro_Salud) {
		ID_Centro_Salud = iD_Centro_Salud;
	}

	public int getID_ARS() {
		return ID_ARS;
	}

	public void setID_ARS(int iD_ARS) {
		ID_ARS = iD_ARS;
	}

	public int getID_Paciente() {
		return ID_Paciente;
	}

	public void setID_Paciente(int iD_Paciente) {
		ID_Paciente = iD_Paciente;
	}
	
	
	
	
	
	
	
	/*create table CentroSalud_ARS
(
	ID_Centro_Salud int, --FK
	ID_ARS int, --FK
	foreign key (ID_Centro_Salud) references Centro_Salud(ID_Centro_Salud),
	foreign key (ID_ARS) references ARS(ID_ARS),
	primary key(ID_Centro_Salud,ID_ARS)
	)

go*/
}

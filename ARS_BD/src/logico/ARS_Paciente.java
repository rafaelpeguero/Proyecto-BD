package logico;

import java.io.Serializable;

public class ARS_Paciente implements Serializable{
	
	private int ID_ARS;
	private int ID_Paciente;
	private String Estado;
	public ARS_Paciente(int iD_ARS, int iD_Paciente, String estado) {
		super();
		this.ID_ARS = iD_ARS;
		this.ID_Paciente = iD_Paciente;
		this.Estado = estado;
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
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
	
	
	
	
	
	
	/*create table ARS_Paciente
(
	ID_Ars int,
	ID_Paciente int, 
	Estado varchar(50) NOT NULL,
	foreign key (ID_ARS) references ARS(ID_ARS),
	foreign key (ID_Paciente) references Paciente(ID_Paciente),
	primary key(ID_ARS,ID_Paciente)
	)*/
}

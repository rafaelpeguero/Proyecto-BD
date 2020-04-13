package logico;

import java.io.Serializable;

public class Especializacion_Doctor implements Serializable{
	
	private int ID_Medico;
	private int ID_Especializacion;
	public Especializacion_Doctor(int iD_Medico, int iD_Especializacion) {
		super();
		this.ID_Medico = iD_Medico;
		this.ID_Especializacion = iD_Especializacion;
	}
	public int getID_Medico() {
		return ID_Medico;
	}
	public void setID_Medico(int iD_Medico) {
		ID_Medico = iD_Medico;
	}
	public int getID_Especializacion() {
		return ID_Especializacion;
	}
	public void setID_Especializacion(int iD_Especializacion) {
		ID_Especializacion = iD_Especializacion;
	}
	
	
	/*	create table Especializacion_Doctor
	(ID_Medico int,
	ID_Especializacion int,
	foreign key (ID_Medico) references Medicos(ID_Medico),
	foreign key (ID_Especializacion) references especializacion(ID_Especializacion),
	primary key(ID_Medico,ID_Especializacion)
	)*/

}

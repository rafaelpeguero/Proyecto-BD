package logico;

import java.io.Serializable;

public class Cobertura_Medicamento implements Serializable{
	
	private int ID_Cobertura;
	private int ID_Receta;
	private int ID_ARS;
	public Cobertura_Medicamento(int iD_Cobertura, int iD_Receta, int iD_ARS) {
		super();
		this.ID_Cobertura = iD_Cobertura;
		this.ID_Receta = iD_Receta;
		this.ID_ARS = iD_ARS;
		
	}
	public int getID_Cobertura() {
		return ID_Cobertura;
	}
	public void setID_Cobertura(int iD_Cobertura) {
		ID_Cobertura = iD_Cobertura;
	}
	public int getID_Receta() {
		return ID_Receta;
	}
	public void setID_Receta(int iD_Receta) {
		ID_Receta = iD_Receta;
	}
	public int getID_ARS() {
		return ID_ARS;
	}
	public void setID_ARS(int iD_ARS) {
		ID_ARS = iD_ARS;
	}
	
	
	
	/*Create table Cobertura_Medicamento
(
	ID_Cobertura int primary key,
	ID_Receta int,
	ID_ARS int,
	foreign key (ID_Receta) references Receta_Medico (ID_Receta),
	foreign key (ID_ARS) references ARS(ID_ARS)
	)*/

}

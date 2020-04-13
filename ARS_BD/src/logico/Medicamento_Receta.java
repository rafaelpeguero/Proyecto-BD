package logico;

import java.io.Serializable;

public class Medicamento_Receta implements Serializable{
	
	private int ID_Receta;
	private int ID_Medicamento;
	private  int Cantidad;
	public Medicamento_Receta(int iD_Receta, int iD_Medicamento, int cantidad) {
		super();
		this.ID_Receta = iD_Receta;
		this.ID_Medicamento = iD_Medicamento;
		this.Cantidad = cantidad;
	}
	public int getID_Receta() {
		return ID_Receta;
	}
	public void setID_Receta(int iD_Receta) {
		ID_Receta = iD_Receta;
	}
	public int getID_Medicamento() {
		return ID_Medicamento;
	}
	public void setID_Medicamento(int iD_Medicamento) {
		ID_Medicamento = iD_Medicamento;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	
	
	
	/*create table Medicamento_Receta
(
	ID_Receta int,
	ID_Medicamento int,
	Cantidad int,
	foreign key (ID_Receta) references Receta_Medico (ID_Receta),
	foreign key (ID_Medicamento) references Medicamento(ID_Medicamento),
	primary key (ID_Receta, ID_Medicamento) 
)*/

}

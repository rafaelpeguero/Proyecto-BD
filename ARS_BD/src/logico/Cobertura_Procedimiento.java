package logico;

import java.io.Serializable;

public class Cobertura_Procedimiento implements Serializable{
	
	private int ID_Cobertura;
	private int ID_Procedimiento;
	private float Descuento;
	public Cobertura_Procedimiento(int iD_Cobertura, int iD_Procedimiento, float descuento) {
		super();
		this.ID_Cobertura = iD_Cobertura;
		this.ID_Procedimiento = iD_Procedimiento;
		this.Descuento = descuento;
	}
	public int getID_Cobertura() {
		return ID_Cobertura;
	}
	public void setID_Cobertura(int iD_Cobertura) {
		ID_Cobertura = iD_Cobertura;
	}
	public int getID_Procedimiento() {
		return ID_Procedimiento;
	}
	public void setID_Procedimiento(int iD_Procedimiento) {
		ID_Procedimiento = iD_Procedimiento;
	}
	public float getDescuento() {
		return Descuento;
	}
	public void setDescuento(float descuento) {
		Descuento = descuento;
	}
	
	/*Create table Cobertura_Procedimiento
(	ID_Cobertura int primary key,
	ID_Procedimiento int,
	Descuento float,
	foreign key (ID_Procedimiento) references Procedimiento(ID_Procedimiento),
	)*/

}

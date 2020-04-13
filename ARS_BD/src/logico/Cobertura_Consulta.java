package logico;

import java.io.Serializable;

public class Cobertura_Consulta implements Serializable{
	
	private int ID_Cobertua;
	private int ID_Consulta;
	private float Descuento;
	
	public Cobertura_Consulta(int iD_Cobertua, int iD_Consulta, float descuento) {
		super();
		this.ID_Cobertua = iD_Cobertua;
		this.ID_Consulta = iD_Consulta;
		this.Descuento = descuento;
	}

	public int getID_Cobertua() {
		return ID_Cobertua;
	}

	public void setID_Cobertua(int iD_Cobertua) {
		ID_Cobertua = iD_Cobertua;
	}

	public int getID_Consulta() {
		return ID_Consulta;
	}

	public void setID_Consulta(int iD_Consulta) {
		ID_Consulta = iD_Consulta;
	}

	public float getDescuento() {
		return Descuento;
	}

	public void setDescuento(float descuento) {
		Descuento = descuento;
	}
	
	
	
	
	/*Create table Cobertura_Consulta
(	ID_Cobertura int primary key,
	ID_Consulta int,
	Descuento float,
	foreign key (ID_Consulta) references Consulta(ID_Consulta),
	)*/

}

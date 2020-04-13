package logico;

import java.io.Serializable;

public class Receta_Medico implements Serializable{
	
	private int ID_Receta;
	private int ID_Paciente;
	private int ID_Medico;
	private String Fecha_Recetada;
	public Receta_Medico(int iD_Receta, int iD_Paciente, int iD_Medico, String fecha_Recetada) {
		super();
		this.ID_Receta = iD_Receta;
		this.ID_Paciente = iD_Paciente;
		this.ID_Medico = iD_Medico;
		this.Fecha_Recetada = fecha_Recetada;
	}
	public int getID_Receta() {
		return ID_Receta;
	}
	public void setID_Receta(int iD_Receta) {
		ID_Receta = iD_Receta;
	}
	public int getID_Paciente() {
		return ID_Paciente;
	}
	public void setID_Paciente(int iD_Paciente) {
		ID_Paciente = iD_Paciente;
	}
	public int getID_Medico() {
		return ID_Medico;
	}
	public void setID_Medico(int iD_Medico) {
		ID_Medico = iD_Medico;
	}
	public String getFecha_Recetada() {
		return Fecha_Recetada;
	}
	public void setFecha_Recetada(String fecha_Recetada) {
		Fecha_Recetada = fecha_Recetada;
	}
	
	
	
	
	/*create table Receta_Medico
(
ID_Receta int primary key,
ID_Paciente int, --(FK)
ID_Medico int, --(FK)
Fecha_Recetada datetime,
foreign key (ID_Paciente) references Paciente(ID_Paciente),
foreign key (ID_Medico) references Medicos(ID_Medico),
)*/

}

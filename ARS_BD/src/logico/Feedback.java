package logico;

import java.io.Serializable;

public class Feedback implements Serializable{
	
	private int ID_Feedback;
	private int ID_Paciente;
	private int ID_Medico;
	private String Fecha_Feedback;
	public Feedback(int iD_Feedback, int iD_Paciente, int iD_Medico, String fecha_Feedback) {
		super();
		this.ID_Feedback = iD_Feedback;
		this.ID_Paciente = iD_Paciente;
		this.ID_Medico = iD_Medico;
		this.Fecha_Feedback = fecha_Feedback;
	}
	public int getID_Feedback() {
		return ID_Feedback;
	}
	public void setID_Feedback(int iD_Feedback) {
		ID_Feedback = iD_Feedback;
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
	public String getFecha_Feedback() {
		return Fecha_Feedback;
	}
	public void setFecha_Feedback(String fecha_Feedback) {
		Fecha_Feedback = fecha_Feedback;
	}
	
	
	/*	create table Feedback(
	ID_Feedback int primary key,
	ID_Paciente int,
	ID_Medico int,
	Fecha_Feedback datetime,
	foreign key (ID_Medico) references Medicos(ID_Medico),
	foreign key (ID_Paciente) references Paciente(ID_Paciente)
	)*/

}

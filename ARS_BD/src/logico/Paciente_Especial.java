package logico;

import java.io.Serializable;

public class Paciente_Especial implements Serializable{
	
	private int ID_Paciente;
	private int ID_Enfermedad;
	private String Descripcion;
	private String FechaInicial;
	private String FechaFinal;
	public Paciente_Especial(int iD_Paciente, int iD_Enfermedad, String descripcion, String fechaInicial,
			String fechaFinal) {
		super();
		this.ID_Paciente = iD_Paciente;
		this.ID_Enfermedad = iD_Enfermedad;
		this.Descripcion = descripcion;
		this.FechaInicial = fechaInicial;
		this.FechaFinal = fechaFinal;
	}
	public int getID_Paciente() {
		return ID_Paciente;
	}
	public void setID_Paciente(int iD_Paciente) {
		ID_Paciente = iD_Paciente;
	}
	public int getID_Enfermedad() {
		return ID_Enfermedad;
	}
	public void setID_Enfermedad(int iD_Enfermedad) {
		ID_Enfermedad = iD_Enfermedad;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getFechaInicial() {
		return FechaInicial;
	}
	public void setFechaInicial(String fechaInicial) {
		FechaInicial = fechaInicial;
	}
	public String getFechaFinal() {
		return FechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		FechaFinal = fechaFinal;
	}
	
	
	
	
	
	
	
	/*create table Paciente_Especial
	(
		ID_Paciente int,
		ID_Enfermedad int,
		Descripcion varchar(max),
		FechaInicial Date,
		FechaFinal DATE,
		foreign key (ID_PAciente) references Paciente (ID_Paciente),
		foreign key (ID_Enfermedad) references Enfermedad (ID_Enfermedad),
		primary key (ID_Paciente, ID_Enfermedad)*/

}

package logico;

import java.io.Serializable;

public class Procedimiento implements Serializable{
	
	private int ID_Procedimiento;
	private int ID_Paciente;
	private int ID_Medico;
	private int ID_Tipo;
	private int ID_Centro_Salud;
	private int ID_ARS;
	private String Fecha_Creada;
	private String Fecha_Procedimiento;
	public Procedimiento(int iD_Procedimiento, int iD_Paciente, int iD_Medico, int iD_Tipo, int iD_Centro_Salud,
			int iD_ARS, String fecha_Creada, String fecha_Procedimiento) {
		super();
		this.ID_Procedimiento = iD_Procedimiento;
		this.ID_Paciente = iD_Paciente;
		this.ID_Medico = iD_Medico;
		this.ID_Tipo = iD_Tipo;
		this.ID_Centro_Salud = iD_Centro_Salud;
		this.ID_ARS = iD_ARS;
		this.Fecha_Creada = fecha_Creada;
		this.Fecha_Procedimiento = fecha_Procedimiento;
	}
	public int getID_Procedimiento() {
		return ID_Procedimiento;
	}
	public void setID_Procedimiento(int iD_Procedimiento) {
		ID_Procedimiento = iD_Procedimiento;
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
	public int getID_Tipo() {
		return ID_Tipo;
	}
	public void setID_Tipo(int iD_Tipo) {
		ID_Tipo = iD_Tipo;
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
	public String getFecha_Creada() {
		return Fecha_Creada;
	}
	public void setFecha_Creada(String fecha_Creada) {
		Fecha_Creada = fecha_Creada;
	}
	public String getFecha_Procedimiento() {
		return Fecha_Procedimiento;
	}
	public void setFecha_Procedimiento(String fecha_Procedimiento) {
		Fecha_Procedimiento = fecha_Procedimiento;
	}
	
	
	
	/*create table Procedimiento
	(
		ID_Procedimiento int primary key, --(PK)
		ID_Paciente int, --(FK)
		ID_Medico int, --(FK)
		ID_Tipo int, --(FK)
		ID_Centro_Salud int, --(FK)
		ID_ARS int, --FK
		Fecha_Creada datetime,
		Fecha_Procedimiento datetime,
		foreign key (ID_ARS) references ARS(ID_ARS),
		foreign key (ID_Paciente) references Paciente(ID_Paciente),
		foreign key (ID_Medico) references Medicos(ID_Medico),
		foreign key (ID_Centro_Salud) references Centro_Salud (ID_Centro_Salud),
		foreign key (ID_Tipo) references Tipo_Procedimiento (ID_Tipo)
	)*/

}

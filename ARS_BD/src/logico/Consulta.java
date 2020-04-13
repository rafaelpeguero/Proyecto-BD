package logico;

import java.io.Serializable;

public class Consulta implements Serializable{
	
	private int ID_Consulta;
	private int ID_Paciente;
	private int ID_Medico;
	private int ID_Tipo;
	private int ID_Centro_Salud;
	private int ID_ARS;
	private String Fecha_Creada;
	private String Fecha_Consulta;
	public Consulta(int iD_Consulta, int iD_Paciente, int iD_Medico, int iD_Tipo, int iD_Centro_Salud, int iD_ARS,
			String fecha_Creada, String fecha_Consulta) {
		super();
		this.ID_Consulta = iD_Consulta;
		this.ID_Paciente = iD_Paciente;
		this.ID_Medico = iD_Medico;
		this.ID_Tipo = iD_Tipo;
		this.ID_Centro_Salud = iD_Centro_Salud;
		this.ID_ARS = iD_ARS;
		this.Fecha_Creada = fecha_Creada;
		this.Fecha_Consulta = fecha_Consulta;
	}
	public int getID_Consulta() {
		return ID_Consulta;
	}
	public void setID_Consulta(int iD_Consulta) {
		ID_Consulta = iD_Consulta;
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
	public String getFecha_Consulta() {
		return Fecha_Consulta;
	}
	public void setFecha_Consulta(String fecha_Consulta) {
		Fecha_Consulta = fecha_Consulta;
	}
	
	
	/*create table Consulta
(
	ID_Consulta int primary key,
	ID_Paciente int, --(FK)
	ID_Medico int, --(FK)
	ID_Tipo int, --(FK)
	ID_Centro_Salud int, --(FK)
	ID_ARS int,
	Fecha_Creada datetime not null,
	Fecha_Consulta datetime,
	foreign key (ID_ARS) references ARS(ID_ARS),
	foreign key (ID_Paciente) references Paciente(ID_Paciente),
	foreign key (ID_Medico) references Medicos(ID_Medico),
	foreign key (ID_Tipo) references Tipo_Consulta(ID_Tipo),
	foreign key (ID_Centro_Salud) references Centro_Salud(ID_Centro_Salud)
)*/

}

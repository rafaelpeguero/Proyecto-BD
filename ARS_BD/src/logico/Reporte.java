package logico;

import java.io.Serializable;

public class Reporte implements Serializable{
	
	private int ID_Reporte;
	private int ID_Paciente;
	private int ID_Medico;
	private int ID_Centro_Salud;
	private String Reporte;
	private String Comentario;
	public Reporte(int iD_Reporte, int iD_Paciente, int iD_Medico, int iD_Centro_Salud, String reporte,
			String comentario) {
		super();
		ID_Reporte = iD_Reporte;
		ID_Paciente = iD_Paciente;
		ID_Medico = iD_Medico;
		ID_Centro_Salud = iD_Centro_Salud;
		Reporte = reporte;
		Comentario = comentario;
	}
	public int getID_Reporte() {
		return ID_Reporte;
	}
	public void setID_Reporte(int iD_Reporte) {
		ID_Reporte = iD_Reporte;
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
	public int getID_Centro_Salud() {
		return ID_Centro_Salud;
	}
	public void setID_Centro_Salud(int iD_Centro_Salud) {
		ID_Centro_Salud = iD_Centro_Salud;
	}
	public String getReporte() {
		return Reporte;
	}
	public void setReporte(String reporte) {
		Reporte = reporte;
	}
	public String getComentario() {
		return Comentario;
	}
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	

	
	/*create table Reporte
(
	ID_Reporte int primary key,
	ID_Paciente int, --(FK)
	ID_Medico int, --(FK)
	ID_Centro_Salud int, --(FK)
	Reporte varchar(max), --se puede almacenar como un string64 de caracteres, o la ruta de acceso al archivo --(PDF o Imagen)
	Comentario varchar(max),
	foreign key (ID_Paciente) references Paciente (ID_Paciente),
	foreign key (ID_Medico) references Medicos(ID_Medico),
	foreign key (ID_Centro_Salud) references Centro_Salud (ID_Centro_Salud)
)*/

}

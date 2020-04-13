package logico;

import java.io.Serializable;

public class Solicitacion_Medicamento implements Serializable{
	
	private int ID_Solicitacion;
	private int ID_Receta;
	private int ID_Paciente;
	private int ID_Centro_Salud;
	private String Fecha_Solicitacion;
	private Boolean Estado_Aprobacion;
	private String Fecha_Aprovacion;
	
	public Solicitacion_Medicamento(int iD_Solicitacion, int iD_Receta, int iD_Paciente, int iD_Centro_Salud,
			String fecha_Solicitacion, Boolean estado_Aprobacion, String fecha_Aprovacion) {
		super();
		this.ID_Solicitacion = iD_Solicitacion;
		this.ID_Receta = iD_Receta;
		this.ID_Paciente = iD_Paciente;
		this.ID_Centro_Salud = iD_Centro_Salud;
		this.Fecha_Solicitacion = fecha_Solicitacion;
		this.Estado_Aprobacion = estado_Aprobacion;
		this.Fecha_Aprovacion = fecha_Aprovacion;
		
	}

	public int getID_Solicitacion() {
		return ID_Solicitacion;
	}

	public void setID_Solicitacion(int iD_Solicitacion) {
		ID_Solicitacion = iD_Solicitacion;
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

	public int getID_Centro_Salud() {
		return ID_Centro_Salud;
	}

	public void setID_Centro_Salud(int iD_Centro_Salud) {
		ID_Centro_Salud = iD_Centro_Salud;
	}

	public String getFecha_Solicitacion() {
		return Fecha_Solicitacion;
	}

	public void setFecha_Solicitacion(String fecha_Solicitacion) {
		Fecha_Solicitacion = fecha_Solicitacion;
	}

	public Boolean getEstado_Aprobacion() {
		return Estado_Aprobacion;
	}

	public void setEstado_Aprobacion(Boolean estado_Aprobacion) {
		Estado_Aprobacion = estado_Aprobacion;
	}

	public String getFecha_Aprovacion() {
		return Fecha_Aprovacion;
	}

	public void setFecha_Aprovacion(String fecha_Aprovacion) {
		Fecha_Aprovacion = fecha_Aprovacion;
	}
	 
	
	
	
	
	/*create table Solicitacion_Medicamento
(
	ID_Solicitacion int primary key,
	ID_Paciente int, --(FK)
	ID_Receta int, --(FK)
	ID_Centro_Salud int, --(FK)
	Fecha_Solicitacion datetime,
	Estado_Aprobacion bit,
	Fecha_Aprobacion datetime,
	foreign key (ID_Paciente) references Paciente(ID_Paciente),
	foreign key (ID_Centro_Salud) references Centro_Salud(ID_Centro_Salud),
	foreign key (ID_Receta) references Receta_Medico (ID_Receta)
)*/

}

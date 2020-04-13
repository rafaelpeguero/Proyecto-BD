package logico;

import java.io.Serializable;

public class Solicitacion_Servicio implements Serializable{
	
	private int ID_Solicitacion;
	private int ID_Paciente;
	private int ID_Medico;
	private int ID_Receta;
	private int ID_Tipo_Servicio;
	private int ID_Centro_Salud;
	private String Fecha_Solicitacion;
	private boolean Estado_Aprobacion;
	private String Fecha_Aprobacion;
	private float Descuento;
	public Solicitacion_Servicio(int iD_Solicitacion, int iD_Paciente, int iD_Medico, int iD_Receta,
			int iD_Tipo_Servicio, int iD_Centro_Salud, String fecha_Solicitacion, boolean estado_Aprobacion,
			String fecha_Aprobacion, float descuento) {
		super();
		this.ID_Solicitacion = iD_Solicitacion;
		this.ID_Paciente = iD_Paciente;
		this.ID_Medico = iD_Medico;
		this.ID_Receta = iD_Receta;
		this.ID_Tipo_Servicio = iD_Tipo_Servicio;
		this.ID_Centro_Salud = iD_Centro_Salud;
		this.Fecha_Solicitacion = fecha_Solicitacion;
		this.Estado_Aprobacion = estado_Aprobacion;
		this.Fecha_Aprobacion = fecha_Aprobacion;
		this.Descuento = descuento;
	}
	public int getID_Solicitacion() {
		return ID_Solicitacion;
	}
	public void setID_Solicitacion(int iD_Solicitacion) {
		ID_Solicitacion = iD_Solicitacion;
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
	public int getID_Receta() {
		return ID_Receta;
	}
	public void setID_Receta(int iD_Receta) {
		ID_Receta = iD_Receta;
	}
	public int getID_Tipo_Servicio() {
		return ID_Tipo_Servicio;
	}
	public void setID_Tipo_Servicio(int iD_Tipo_Servicio) {
		ID_Tipo_Servicio = iD_Tipo_Servicio;
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
	public boolean isEstado_Aprobacion() {
		return Estado_Aprobacion;
	}
	public void setEstado_Aprobacion(boolean estado_Aprobacion) {
		Estado_Aprobacion = estado_Aprobacion;
	}
	public String getFecha_Aprobacion() {
		return Fecha_Aprobacion;
	}
	public void setFecha_Aprobacion(String fecha_Aprobacion) {
		Fecha_Aprobacion = fecha_Aprobacion;
	}
	public float getDescuento() {
		return Descuento;
	}
	public void setDescuento(float descuento) {
		Descuento = descuento;
	}
	
	
	/*create table Solicitacion_Servicio
(
	ID_Solicitacion int primary key,
	ID_Paciente int, --(FK)
	ID_Medico int, --(FK)
	ID_Receta int,
	ID_Tipo_Servicio int, -- (FK)
	ID_Centro_Salud int, --(FK)
	Fecha_Solicitacion datetime,
	Estado_Aprobacion bit,
	Fecha_Aprobacion datetime,
	foreign key (ID_Paciente) references Paciente (ID_Paciente),
	foreign key (ID_Medico) references Medicos(ID_Medico),
	foreign key (ID_Centro_Salud) references Centro_Salud (ID_Centro_Salud),
	foreign key (ID_Receta) references Receta_Medico (ID_Receta),
	foreign key (ID_Tipo_Servicio) references Tipo_Servicio (ID_Tipo_Servicio)
)*/

}

package logico;

import java.io.Serializable;

public class Medicos implements Serializable{
	
	private int ID_Medico;
	private String Cedula;
	private String Contrasena;
	private String P_Nombre;
	private String S_Nombre;
	private String P_Apellido;
	private String S_Apellido;
	private String F_Nacimiento;
	private String Sexo;
	private String Direccion;
	private String Telefono1;
	private String Telefono2;
	private int ID_Municipio;
	
	public Medicos(int iD_Medico, String cedula, String contrasena, String p_Nombre, String s_Nombre, String p_Apellido,
			String s_Apellido, String f_Nacimiento, String sexo, String direccion, String telefono1, String telefono2,
			int iD_Municipio) {
		super();
		this.ID_Medico = iD_Medico;
		this.Cedula = cedula;
		this.Contrasena = contrasena;
		this.P_Nombre = p_Nombre;
		this.S_Nombre = s_Nombre;
		this.P_Apellido = p_Apellido;
		this.S_Apellido = s_Apellido;
		this.F_Nacimiento = f_Nacimiento;
		this.Sexo = sexo;
		this.Direccion = direccion;
		this.Telefono1 = telefono1;
		this.Telefono2 = telefono2;
		this.ID_Municipio = iD_Municipio;
	}

	public int getID_Medico() {
		return ID_Medico;
	}

	public void setID_Medico(int iD_Medico) {
		ID_Medico = iD_Medico;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public String getP_Nombre() {
		return P_Nombre;
	}

	public void setP_Nombre(String p_Nombre) {
		P_Nombre = p_Nombre;
	}

	public String getS_Nombre() {
		return S_Nombre;
	}

	public void setS_Nombre(String s_Nombre) {
		S_Nombre = s_Nombre;
	}

	public String getP_Apellido() {
		return P_Apellido;
	}

	public void setP_Apellido(String p_Apellido) {
		P_Apellido = p_Apellido;
	}

	public String getS_Apellido() {
		return S_Apellido;
	}

	public void setS_Apellido(String s_Apellido) {
		S_Apellido = s_Apellido;
	}

	public String getF_Nacimiento() {
		return F_Nacimiento;
	}

	public void setF_Nacimiento(String f_Nacimiento) {
		F_Nacimiento = f_Nacimiento;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono1() {
		return Telefono1;
	}

	public void setTelefono1(String telefono1) {
		Telefono1 = telefono1;
	}

	public String getTelefono2() {
		return Telefono2;
	}

	public void setTelefono2(String telefono2) {
		Telefono2 = telefono2;
	}

	public int getID_Municipio() {
		return ID_Municipio;
	}

	public void setID_Municipio(int iD_Municipio) {
		ID_Municipio = iD_Municipio;
	}
	
	

	
	/*create table Medicos
(
	ID_Medico int primary key,
	Cedula varchar(50) not null,
	Contrasena varchar(50) not null,
	P_Nombre varchar(50) not null,
	S_Nombre varchar(50) null,
	P_Apellido varchar(50) not null,
	S_Apellido varchar(50) null,
	F_Nacimiento varchar(50) not null,
	Sexo varchar(50) not null,
	Direccion varchar(50) not null,
	Telefono1 varchar(50) not null,
	Telefono2 varchar(50) null,
	ID_Municipio int, --(FK)
	foreign key (ID_Municipio) references Municipio(ID_Municipio)
)*/

}

package logico;

import java.io.Serializable;

public class Paciente implements Serializable{
	
	private int ID_Paciente;
	private String Cedula;
	private String Contrasena;
	private String P_Nombre;
	private String S_Nombre;
	private String P_Apellido;
	private String S_Apellido;
	private String F_Nacimiento;
	private String Sexo;
	private String Tipo_Sangre;
	private String Direccion;
	private String Telefono1;
	private String Telefono2;
	private int ID_Municipio;
	private int ID_Especial;



	public Paciente(
			int iD_Paciente, 
			String cedula, 
			String contrasena, 
			String p_Nombre, 
			String s_Nombre,
			String p_Apellido, 
			String s_Apellido, 
			String f_Nacimiento, 
			String sexo, 
			String tipo_Sangre,
			String direccion, 
			String telefono1, 
			String telefono2, 
			int iD_Municipio, 
			int iD_Especial) {
		super();
		ID_Paciente = iD_Paciente;
		Cedula = cedula;
		Contrasena = contrasena;
		P_Nombre = p_Nombre;
		S_Nombre = s_Nombre;
		P_Apellido = p_Apellido;
		S_Apellido = s_Apellido;
		F_Nacimiento = f_Nacimiento;
		Sexo = sexo;
		Tipo_Sangre = tipo_Sangre;
		Direccion = direccion;
		Telefono1 = telefono1;
		Telefono2 = telefono2;
		ID_Municipio = iD_Municipio;
		ID_Especial = iD_Especial;
	}	
	
	public int getID_Paciente() {
		return ID_Paciente;
	}


	public void setID_Paciente(int iD_Paciente) {
		ID_Paciente = iD_Paciente;
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

	public String getTipo_Sangre() {
		return Tipo_Sangre;
	}

	public void setTipo_Sangre(String tipo_Sangre) {
		Tipo_Sangre = tipo_Sangre;
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

	public int getID_Especial() {
		return ID_Especial;
	}

	public void setID_Especial(int iD_Especial) {
		ID_Especial = iD_Especial;
	}
	
	/*create table Paciente
(
	ID_Paciente int primary key,
	Cedula varchar(50) not null,
	Contrasena varchar(50) not null,
	P_Nombre varchar(50) not null,
	S_Nombre varchar(50) null,
	P_Apellido varchar(50) not null,
	S_Apellido varchar(50) null,
	F_Nacimiento varchar(50) not null,
	Sexo varchar(50) not null,
	Tipo_Sangre varchar(50) not null,
	Direccion varchar(50) not null,
	Telefono1 varchar(50) null,
	Telefono2 varchar(50) null,
	ID_Municipio int, --(FK)
	ID_Especial int, --(FK) (NULL)
	foreign key (ID_Municipio) references Municipio(ID_Municipio)
)*/

}

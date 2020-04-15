package logico;


// Esta clase es el centro de todo

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class MainArs {

	public ArrayList <Paciente> pacientes;
	public ArrayList <Medicos> medicos;
	public ArrayList <Staff> staffs;
	//public ArrayList <Provedor> provedores;
	public ArrayList <Solicitacion_Medicamento> autorizaciones_Medicina;
	public ArrayList <Solicitacion_Servicio> autorizaciones_Servicio;
	public ArrayList <Centro_Salud> centros_salud;
	public ArrayList <Municipio> municipios;
	public ArrayList <Provincia> provincias;
	public ArrayList <Receta_Medico> recetas_medicas;
	
	static MainArs obj_mainArs;  // Estancia de la ARS

	//static SalvarFacturaClass sfc;
	
	//CONSTRUCTOR
	public MainArs() {
		// ARRAY LISTS P CLIENTES Y FACTURAS
		pacientes = new ArrayList<Paciente>();
		medicos = new ArrayList<Medicos>();
		staffs = new ArrayList<Staff>();
		autorizaciones_Medicina = new ArrayList<Solicitacion_Medicamento>();
		autorizaciones_Servicio = new ArrayList<Solicitacion_Servicio>();
		centros_salud = new ArrayList<Centro_Salud>();
		municipios = new ArrayList<Municipio>();
		provincias = new ArrayList<Provincia>();
		recetas_medicas = new ArrayList<Receta_Medico>();	
	}

	
	
	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}



	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}



	public ArrayList<Medicos> getMedicos() {
		return medicos;
	}



	public void setMedicos(ArrayList<Medicos> medicos) {
		this.medicos = medicos;
	}



	public ArrayList<Staff> getStaffs() {
		return staffs;
	}



	public void setStaffs(ArrayList<Staff> staffs) {
		this.staffs = staffs;
	}



	public ArrayList<Solicitacion_Medicamento> getAutorizaciones_Medicina() {
		return autorizaciones_Medicina;
	}



	public void setAutorizaciones_Medicina(ArrayList<Solicitacion_Medicamento> autorizaciones_Medicina) {
		this.autorizaciones_Medicina = autorizaciones_Medicina;
	}



	public ArrayList<Solicitacion_Servicio> getAutorizaciones_Servicio() {
		return autorizaciones_Servicio;
	}



	public void setAutorizaciones_Servicio(ArrayList<Solicitacion_Servicio> autorizaciones_Servicio) {
		this.autorizaciones_Servicio = autorizaciones_Servicio;
	}



	public ArrayList<Centro_Salud> getCentros_salud() {
		return centros_salud;
	}



	public void setCentros_salud(ArrayList<Centro_Salud> centros_salud) {
		this.centros_salud = centros_salud;
	}



	public ArrayList<Municipio> getMunicipios() {
		return municipios;
	}



	public void setMunicipios(ArrayList<Municipio> municipios) {
		this.municipios = municipios;
	}



	public ArrayList<Provincia> getProvincias() {
		return provincias;
	}



	public void setProvincias(ArrayList<Provincia> provincias) {
		this.provincias = provincias;
	}



	public ArrayList<Receta_Medico> getRecetas_medicas() {
		return recetas_medicas;
	}



	public void setRecetas_medicas(ArrayList<Receta_Medico> recetas_medicas) {
		this.recetas_medicas = recetas_medicas;
	}



	//METODOS
	public static MainArs getInstancias(){
		if(obj_mainArs == null) {
			obj_mainArs = new MainArs();
		}
		return obj_mainArs;
	}

	public void AddPaciente(Paciente paciente) {
		//Annadiendo al ArrayList
		pacientes.add(paciente);
	}
	
	public void AddMedico(Medicos medico) {
		//Annadiendo al ArrayList
		medicos.add(medico);
	}
	public void AddStaff(Staff paciente) {
		//Annadiendo al ArrayList
		staffs.add(paciente);
	}
	public void AddAutorizacionMedicina(Solicitacion_Medicamento paciente) {
		//Annadiendo al ArrayList
		autorizaciones_Medicina.add(paciente);
	}
	public void AddAutorizacionServicio(Solicitacion_Servicio paciente) {
		//Annadiendo al ArrayList
		autorizaciones_Servicio.add(paciente);
	}
	
	
	public void AddRecetas_Medicas(Receta_Medico receta) {
		//Annadiendo al ArrayList 
		recetas_medicas.add(receta);
	}

	public boolean DelPacienteByIndex(int index) {
		boolean eliminado = false;
		//Removiendo del ArrayList
		if(pacientes.remove(index) != null) {
			eliminado = true;
		}
		return eliminado;
	}

	public Paciente BuscarPacienteByNombre(String nombre) {
		for(Paciente aux : pacientes) {
			if(aux.getP_Nombre().equalsIgnoreCase(nombre))
				return aux;
		}
		return null;
	}

	public Receta_Medico BuscarRecetaMedicaById(int id) { //Falta prueba
		for(Receta_Medico aux : recetas_medicas) {
			if(aux.getID_Receta() == id)
				return aux;
		}
		return null;
	}

	public Receta_Medico BuscarRecetaMedicaByPaciente(Paciente paciente) {//Falta prueba
		for(Receta_Medico aux : recetas_medicas) {
		if(aux.getID_Paciente() == paciente.getID_Paciente()) 
				return aux;
			}
		
	return null;
	}

	public void DelPacienteByNombre(String nombre) {
		pacientes.remove(BuscarPacienteByNombre(nombre));
	}

	public void ModificarPaciente(int index,
	 int 	ID_Paciente,
	 String Cedula,
	 String Contrasena,
	 String P_Nombre,
	 String S_Nombre,
	 String P_Apellido,
	 String S_Apellido,
	 String F_Nacimiento,
	 String Sexo,
	 String Tipo_Sangre,
	 String Direccion,
	 String Telefono1,
	 String Telefono2,
	 int ID_Municipio,
	 int ID_Especial) {
		pacientes.get(index).setID_Paciente(ID_Paciente);
		pacientes.get(index).setCedula(Cedula);
		pacientes.get(index).setContrasena(Contrasena);
		pacientes.get(index).setP_Nombre(P_Nombre);
		pacientes.get(index).setS_Nombre(S_Nombre);
		pacientes.get(index).setP_Apellido(P_Apellido);
		pacientes.get(index).setS_Apellido(S_Apellido);
		pacientes.get(index).setF_Nacimiento(F_Nacimiento);
		pacientes.get(index).setSexo(Sexo);
		pacientes.get(index).setTipo_Sangre(Tipo_Sangre);
		pacientes.get(index).setDireccion(Direccion);
		pacientes.get(index).setTelefono1(Telefono1);
		pacientes.get(index).setTelefono2(Telefono2);
		pacientes.get(index).setID_Municipio(ID_Municipio);
		pacientes.get(index).setID_Especial(ID_Especial);
	}

	public Receta_Medico getRecetaMedica(int id) {
		for(Receta_Medico aux : recetas_medicas) {
	 	if(aux.getID_Receta() == id)
				return aux;
		}
		return null;
	}

	public void DelRecetaMedica(int id) {
		recetas_medicas.remove(BuscarRecetaMedicaById(id));
	}

	public void DelRecetaMedicaByIndex(int index) {
		recetas_medicas.remove(index);
	}

	public void DelRecetaByObj(Receta_Medico receta) {
		recetas_medicas.remove(receta);
	}

	
	/*
	public void SalvarReceta(Medicamento_Receta receta) {
		System.out.println("Salvando....");
		try {
			
		int puerto = 9002;
		Socket s = new Socket(InetAddress.getLocalHost(),puerto);
		OutputStream os = s.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		//Factura f = new Factura("aba212", null, null);
		oos.writeObject(eceta);
		//oos.writeObject(new String("Otro Objeto"));
		oos.close();
		os.close();
		s.close();
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}*/

	/*public void SalvarFactura(Factura factura) {
		 Socket s = null;
		 int puerto_servidor = 9001;
		 OutputStream ops_s = null;
		 ObjectOutputStream obj_ops = null;
		 
		 Factura aux5;
		 aux5 = new Factura("fact", null,null);
		 
		try {
			s = new Socket (InetAddress.getLocalHost(),puerto_servidor);
		
		} catch (UnknownHostException e) {
			System.out.println("Error 1");
			e.printStackTrace();
		
		} catch (IOException e) {
			System.out.println("Error 2");
			e.printStackTrace();
		} //Estoy solicitando la direccion de puerto servidor
		
		
		try {
			ops_s = s.getOutputStream();
		} catch (IOException e) {
			System.out.println("Error 3");
			e.printStackTrace();
		}
		
		try {
			obj_ops = new ObjectOutputStream(ops_s);
		} catch (IOException e) {
			System.out.println("Error 4");
			e.printStackTrace();
		}
				
		System.out.println("Guardando la factura en el servidor.....");
		try {
			obj_ops.writeObject(aux5);
			s.close();
		} catch (IOException e) {
			System.out.println("Error 5");
			e.printStackTrace();
		} 
		
		
	} */

	
	
	
	
}

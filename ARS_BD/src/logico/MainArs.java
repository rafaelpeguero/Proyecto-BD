package logico;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class MainArs {

	public ArrayList <Paciente> pacientes;
	public ArrayList <Medicos> medicos;
	public ArrayList <Centro_Salud> centros_salud;
	public ArrayList <Municipio> municipios;
	public ArrayList <Provincia> provincias;
	
	//public Inventario quesos;
	public ArrayList <Receta_Medico> recetas_medicas;
	
	static MainArs obj_mainArs;  // Estancia de la ARS

	//static SalvarFacturaClass sfc;
	
	//CONSTRUCTOR
	public MainArs() {
		// ARRAY LISTS P CLIENTES Y FACTURAS
		pacientes = new ArrayList<Paciente>();
		medicos = new ArrayList<Medicos>();
		centros_salud = new ArrayList<Centro_Salud>();
		municipios = new ArrayList<Municipio>();
		provincias = new ArrayList<Provincia>();

	  //	quesos = new Inventario();  
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

	public Receta_Medico BuscarRecetaMedicaById(String id) {
		for(Receta_Medico aux : recetas_medicas) {
			//if(aux.getID().equalsIgnoreCase(id))
				return aux;
		}
		return null;
	}

	public Receta_Medico BuscarRecetaMedicaByPaciente(Paciente paciente) {
		for(Receta_Medico aux : recetas_medicas) {
//			if(aux.getFactura_cliente() == client) 
				return aux;
			}
		
	return null;
	}

	public void DelPacienteByNombre(String nombre) {
		pacientes.remove(BuscarPacienteByNombre(nombre));
	}

	public void ModificarPaciente(int index, String nombre, String id, String direccion) {
		pacientes.get(index).setP_Nombre(nombre);
		//pacientes.get(index).setID(id);
		pacientes.get(index).setDireccion(direccion);
	}

	public Receta_Medico getRecetaMedica(String id) {
		for(Receta_Medico aux : recetas_medicas) {
	//		if(aux.getID().equalsIgnoreCase(id))
				return aux;
		}
		return null;
	}

	public void DelRecetaMedica(String id) {
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

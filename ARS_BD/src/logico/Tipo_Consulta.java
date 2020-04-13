package logico;

import java.io.Serializable;

public class Tipo_Consulta implements Serializable {
			
		private int ID_Tipo;
		private float Costo;
		private String Descripcion;
		
		public Tipo_Consulta(int iD_Tipo, float costo, String descripcion) {
			super();
			this.ID_Tipo = iD_Tipo;
			this.Costo = costo;
			this.Descripcion = descripcion;
		}

		public int getID_Tipo() {
			return ID_Tipo;
		}

		public void setID_Tipo(int iD_Tipo) {
			ID_Tipo = iD_Tipo;
		}

		public float getCosto() {
			return Costo;
		}

		public void setCosto(float costo) {
			Costo = costo;
		}

		public String getDescripcion() {
			return Descripcion;
		}

		public void setDescripcion(String descripcion) {
			Descripcion = descripcion;
		}
		
	
		
		
		/*ID_Tipo int primary key, --(PK)
	Costo money,
	Descripcion varchar(max)*/

}

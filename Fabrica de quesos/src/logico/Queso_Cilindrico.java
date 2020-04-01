package logico;

public class  Queso_Cilindrico extends Queso {
	private int longitud;
	private int radio;

	


	public Queso_Cilindrico(float precio_base, float precio_uni, String codigo, int longitud, int radio, int cant) {
		super(precio_base, precio_uni, codigo, cant);
		this.longitud = longitud;
		this.radio = radio;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	float volumen() {
		return (float) area_base() * longitud;
	}
	
	public float area_base() {
		return (float) ((float) Math.PI * Math.pow(radio, 2));
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	

}

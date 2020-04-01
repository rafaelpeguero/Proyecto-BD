package logico;

public class Queso_esfera extends Queso{
	private int radio;

	

	public Queso_esfera(float precio_base, float precio_uni, String codigo, int radio, int cant) {
		super(precio_base, precio_uni, codigo,cant);
		this.radio = radio;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	float volumen() {
		return (float) (4/3 * Math.PI * Math.pow(radio, 3));
	}

	
}

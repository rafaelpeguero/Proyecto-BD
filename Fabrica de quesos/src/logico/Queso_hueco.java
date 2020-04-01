package logico;

public class Queso_hueco extends Queso_Cilindrico {
	private int radio_inte;
	private int radio;
	

	

	public Queso_hueco(float precio_base, float precio_uni, String codigo, int longitud, int radio, int radio_inte,int cant) {
		super(precio_base, precio_uni, codigo, longitud, radio, cant);
		this.radio_inte = radio_inte;
		this.radio = radio;
	}

	public int getRadio_inte() {
		return radio_inte;
	}

	public void setRadio_inte(int radio_inte) {
		this.radio_inte = radio_inte;
	}
	
	public float area_bas() {
		return (float) ((float) Math.PI * Math.pow(radio, 2));
	}
	
	
	

}

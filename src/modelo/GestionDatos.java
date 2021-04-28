package modelo;

import utiles.RespuestaColocacion;

public class GestionDatos {

	TableroAleatorio tableroAleatorio;
	
	
	public GestionDatos() {
		super();
	}

	public void crearTablero(int tamaño, int minas) {
		tableroAleatorio = new TableroAleatorio(tamaño, cantidadMinas(tamaño, minas));
	}
	
	public int cantidadMinas(int tamaño, int minas) {
		return ((tamaño*tamaño)*minas)/100;
	}
	

	
	
}

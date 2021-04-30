package modelo;

import utiles.RespuestaColocacion;

public class GestionDatos {

	private TableroAleatorio tableroAleatorio;
	
	
	public GestionDatos() {
		super();
	}

	public void crearTablero(int tamaño, int minas) {
		tableroAleatorio = new TableroAleatorio(tamaño, cantidadMinas(tamaño, minas));
	}
	
	public int cantidadMinas(int tamaño, int minas) {
		return ((tamaño*tamaño)*minas)/100;
	}
	public RespuestaColocacion desvelarCasillas(Coordenada coord) {
		if(tableroAleatorio.getCasilla(coord).isMina()) {
			return new RespuestaColocacion(true, "M");
		}else {
			return new RespuestaColocacion(true, String.valueOf(tableroAleatorio.getCasilla(coord).getMinasAlrededor()));
		}
	}
	public boolean[][] desvelarCeros(){
		return this.tableroAleatorio.getCasillasDesveladas();
	}
	

	
	
}

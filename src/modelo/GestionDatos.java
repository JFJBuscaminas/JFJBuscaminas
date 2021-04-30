package modelo;

import utiles.RespuestaColocacion;

public class GestionDatos {

	private TableroAleatorio tableroAleatorio;
	
	
	public GestionDatos() {
		super();
	}

	public void crearTablero(int tama�o, int minas) {
		tableroAleatorio = new TableroAleatorio(tama�o, cantidadMinas(tama�o, minas));
	}
	
	public int cantidadMinas(int tama�o, int minas) {
		return ((tama�o*tama�o)*minas)/100;
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

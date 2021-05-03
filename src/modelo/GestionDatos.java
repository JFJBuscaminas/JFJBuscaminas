package modelo;

import utiles.RespuestaDesvelo;

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
	
	public RespuestaDesvelo getRespuestaDesvelo() {
		RespuestaDesvelo respuesta=new RespuestaDesvelo(tableroAleatorio.getAlto());
		for (int i = 0; i < tableroAleatorio.getAlto(); i++) {
			for (int j = 0; j < tableroAleatorio.getAlto(); j++) {
				Coordenada coord = new Coordenada(i, j);
				respuesta.setVeloPosicion(coord, tableroAleatorio.getCasilla(coord).isVelada());
			}
		}
		return respuesta;
	}

	public void desvelarCasillas(Coordenada coord) {
		tableroAleatorio.desvelarContiguas(coord);
	}

	

	
	
}

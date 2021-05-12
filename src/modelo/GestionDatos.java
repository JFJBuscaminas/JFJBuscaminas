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
	
	public RespuestaDesvelo contarMinasCasilla(Coordenada coord) {
		if(tableroAleatorio.getCasilla(coord).isMina()) {
			return new RespuestaDesvelo("M", true);
		} else {
			return new RespuestaDesvelo(String.valueOf(tableroAleatorio.getCasilla(coord).getMinasAlrededor()), false);
		}
	}
	
	public void marcarCasilla(Coordenada coord) {
		tableroAleatorio.marcarCasilla(coord);
	}
	
	private void desvelarMinas() {
		for (int i = 0; i < tableroAleatorio.getAlto() ;i++) {
			for (int j = 0; j < tableroAleatorio.getAncho(); j++) {
				Coordenada casilla = new Coordenada(i, j);
				if(tableroAleatorio.getCasilla(casilla).isMina()) {
					tableroAleatorio.getCasilla(casilla).setVelada(false);
				}
			}
			
		}
	}
	
	
}

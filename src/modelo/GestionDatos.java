package modelo;

import utiles.RespuestaDesvelo;

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

package control;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.GestionDatos;
import utiles.RespuestaColocacion;
import utiles.RespuestaDesvelo;

public class Controlador {
	
	private GestionDatos gestion;
	
	
	public Controlador() {
		super();
		gestion = new GestionDatos();
	}

	public void crearTablero(int tama�o, int minas) {
		gestion.crearTablero(tama�o, minas);
	}
	
	public RespuestaDesvelo casillasDesveladasTablero() {
		return this.gestion.getRespuestaDesvelo();
	}
	public void desvelarCasillas(Coordenada coord) {
		gestion.desvelarCasillas(coord);
	}

	
}

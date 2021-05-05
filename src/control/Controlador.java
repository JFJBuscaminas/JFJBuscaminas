package control;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.GestionDatos;
import utiles.RespuestaDesvelo;

public class Controlador {
	
	private GestionDatos gestion;
	
	
	public Controlador() {
		super();
		gestion = new GestionDatos();
	}

	public void crearTablero(int tamaño, int minas) {
		gestion.crearTablero(tamaño, minas);
	}
	
	public RespuestaDesvelo getRespuestaDesvelo() {
		return this.gestion.getRespuestaDesvelo();
	}
	public void desvelarCasillas(Coordenada coord) {
		gestion.desvelarCasillas(coord);
	}

	public RespuestaDesvelo contarMinasCasilla(Coordenada coord) {
		return gestion.contarMinasCasilla(coord);
	}
	
	public void marcarCasilla(Coordenada coord) {
		gestion.marcarCasilla(coord);
	}
}

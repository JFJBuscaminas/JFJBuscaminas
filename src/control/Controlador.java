package control;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.GestionDatos;
import utiles.RespuestaColocacion;

public class Controlador {
	
	private GestionDatos gestion;
	
	
	public Controlador() {
		super();
		gestion = new GestionDatos();
	}

	public void crearTablero(int tamaño, int minas) {
		gestion.crearTablero(tamaño, minas);
	}
	
	public RespuestaColocacion desvelarCasillas(Coordenada coord) {
		return this.gestion.desvelarCasillas(coord);
	}
	public boolean[][] desvelarCeros() {
		return this.gestion.desvelarCeros();
	}
	
}

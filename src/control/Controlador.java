package control;

import modelo.Densidad;
import modelo.Dificultad;
import modelo.GestionDatos;

public class Controlador {
	
	GestionDatos gestion = new GestionDatos();
	
	public void crearTablero(int tama�o, int minas) {
		gestion.crearTablero(tama�o, minas);
	}
	
	
}

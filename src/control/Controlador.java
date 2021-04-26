package control;

import modelo.Densidad;
import modelo.Dificultad;
import modelo.GestionDatos;

public class Controlador {
	
	GestionDatos gestion = new GestionDatos();
	
	public void crearTablero(int tamaño, int minas) {
		gestion.crearTablero(tamaño, minas);
	}
	
	
}

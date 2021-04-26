package modelo;

public class GestionDatos {

	TableroAleatorio tableroAleatorio;

	
	public void crearTablero(int tama�o, int minas) {
		tableroAleatorio = new TableroAleatorio(tama�o, cantidadMinas(tama�o, minas));
	}
	
	public int cantidadMinas(int tama�o, int minas) {
		return ((tama�o*tama�o)*minas)/100;
	}
	

	
	
}

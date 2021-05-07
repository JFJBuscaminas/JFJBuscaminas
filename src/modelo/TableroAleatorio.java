package modelo;

import java.util.ArrayList;

import utiles.Utiles;

public class TableroAleatorio extends Tablero {
	private boolean terminado = false;
	private boolean acabado = false;
	
	//Constructor aleatorio
	public TableroAleatorio(int lado, int minas) {
		super(lado);
		ArrayList<Coordenada> posiciones = generaAleatorio(minas, lado);
		disponerTablero(posiciones);
	}
	
	//constructor no aleatorio
	public TableroAleatorio(int lado,ArrayList<Coordenada> posiciones) {
		super(lado);
		disponerTablero(posiciones);
	}
	
	private void disponerTablero(ArrayList<Coordenada> posiciones) {
		colocarMinas(posiciones);
		contarMinasAlrededor(posiciones);
	}


	public void contarMinasAlrededor(ArrayList<Coordenada> posiciones) {

		for (Coordenada coordenada : posiciones) {
			for (int i = coordenada.getPosX()-1; i <= coordenada.getPosX()+1; i++) {
				for (int j = coordenada.getPosY()-1; j <= coordenada.getPosY()+1; j++) {
					if(i>=0 && j >= 0 && i< getAlto() && j< getAncho()) {
						Casilla casilla = getCasilla(new Coordenada(i, j));
						if(!casilla.isMina()) {
							casilla.setMinasAlrededor(casilla.getMinasAlrededor()+1);
						}
					}
				}
			}
		}
		
	}
	
	public boolean[][] getCasillasDesveladas() {
		boolean resultados[][] = new boolean[getAlto()][getAncho()];
		for (int i = 0; i < resultados.length; i++) {
			for (int j = 0; j < resultados[i].length; j++) {
				resultados[i][j] = getCasilla(new Coordenada(i, j)).isVelada();
			}
		}
		return resultados;
	}
	
	public void desvelarContiguas(Coordenada lugar) {
		if (getCasilla(lugar).isVelada()&&!getCasilla(lugar).isMarcada()) {
			getCasilla(lugar).setVelada(false);
			if (getCasilla(lugar).isMina()) {
				this.terminado = true;
			} else {
				if (getCasilla(lugar).getMinasAlrededor() == 0) {
					// proceso recursivo
					int alrededor = 8;
					for (int i = 0; i < alrededor; i++) {
						int[] coordenada = Utiles.damePosicionAlrededor(i);
						Coordenada lugarRelativo = new Coordenada(lugar.getPosX() + coordenada[0],
								lugar.getPosY() + coordenada[1]);
						if (lugarRelativo.isInToLimits(getAncho(),getAlto())) {
							desvelarContiguas(lugarRelativo);
						}
					}
				}
			}
		} else {
			if(getCasilla(lugar).getMinasAlrededor() == getCasilla(lugar).getMarcadasAlrededor() && getCasilla(lugar).getMarcadasAlrededor()>0 && this.acabado == false){
			//si alrededor tiene tantas casillas marcadas como minas alrededor
			//tiene la propia casilla
			//si el caso anterior es negativo NADA QUE HACER
			//si es positivo
			//repito el proceso de arriba
				int alrededor = 8;
				for (int i = 0; i < alrededor; i++) {
					int[] coordenada = Utiles.damePosicionAlrededor(i);
					Coordenada lugarRelativo = new Coordenada(lugar.getPosX() + coordenada[0],
							lugar.getPosY() + coordenada[1]);
					if (lugarRelativo.isInToLimits(getAncho(),getAlto())) {
//						getCasilla(lugarRelativo).setVelada(false);
						if(getCasilla(lugarRelativo).isMina()) {
							getCasilla(lugarRelativo).setVelada(true);
						}
						desvelarContiguas(lugarRelativo);
						this.acabado = true;
					}
				}
				this.acabado = false;
			
			}
		}
	}

	public void contarMarcadasAlrededor(Coordenada coordenada) {
		
		// hay que traer la coord de la marcada y a partir de esa sumar 1 a su alrededor
		for (int i = coordenada.getPosX()-1; i <= coordenada.getPosX()+1; i++) {
			for (int j = coordenada.getPosY()-1; j <= coordenada.getPosY()+1; j++) {
				if(i>=0 && j >= 0 && i< getAlto() && j< getAncho()) {
					Casilla casilla = getCasilla(new Coordenada(i, j));
					if(!casilla.isMarcada()) {
						casilla.setMarcadasAlrededor(casilla.getMarcadasAlrededor()+1);
					}
					
				}
			}
		}
	}
	
	public void marcarCasilla(Coordenada coord) {
		getCasilla(coord).setMarcada(true);
		contarMarcadasAlrededor(coord);
	}
	

	private void colocarMinas(ArrayList<Coordenada> posiciones) {
		for (Coordenada coordenada : posiciones) {
			ponerMina(coordenada);
		}
	}

	private void ponerMina(Coordenada coordenada) {
		getCasilla(coordenada).setMina(true);
	}

	public ArrayList<Coordenada> generaAleatorio(int minas, int longitud) {
		assert minas > 0 && longitud > 0;
		assert minas < longitud * longitud;
//		long inicio = System.currentTimeMillis();
		ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();
		for (int i = 0; i < minas; i++) {
			Coordenada coord;
			do {
				coord = dameCoordenada(longitud);
			} while (existeCoord(coord, coordenadas));
			coordenadas.add(coord);
		}
//		 long fin = System.currentTimeMillis();
//		 System.out.println("en milis "+(fin-inicio));
		return coordenadas;
	}

	private Coordenada dameCoordenada(int lado) {
		return new Coordenada(Utiles.dameNumero(lado), Utiles.dameNumero(lado));
	}

	private boolean existeCoord(Coordenada coord, ArrayList<Coordenada> coordenadas) {
		for (int i = 0; i < coordenadas.size(); i++) {
			if (coord.equals(coordenadas.get(i))) {
				return true;
			}
		}
		return false;
	}

}

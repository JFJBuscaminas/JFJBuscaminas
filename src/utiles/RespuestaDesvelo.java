package utiles;

import modelo.Coordenada;

public class RespuestaDesvelo {

		public boolean veladas[][];
		private String mensaje;

		public RespuestaDesvelo(int lado) {
			super();
			this.veladas = new boolean [lado][lado];
		}
		
		public RespuestaDesvelo(String mensaje) {
			super();
			this.mensaje = mensaje;
		}

		public void setVeloPosicion(Coordenada coordenada,boolean velada) {
			veladas[coordenada.getPosX()][coordenada.getPosY()]=velada;
		}
		
		public boolean getVeloPosicion(Coordenada coordenada) {
			return veladas[coordenada.getPosX()][coordenada.getPosY()];
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		
}


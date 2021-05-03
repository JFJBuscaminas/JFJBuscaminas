package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.TableroAleatorio;
import utiles.RespuestaColocacion;
import utiles.RespuestaDesvelo;
import vista.UI;

public class ParaUI extends UI {

	private Controlador controlador;

	public ParaUI() {
		super();
		this.jugar();
		controlador=new Controlador();
	}
	
	
	private void jugar() {
		
		getBtnIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Densidad densidad = (Densidad) getCmbDensidad().getSelectedItem();
				Dificultad dificultad = (Dificultad) getCmbDificultad().getSelectedItem();
				controlador.crearTablero(dificultad.getLongitud(), densidad.getPorcentaje());
				addBotones(dificultad.getLongitud());
				asociarBotones();
			}
		});	
	}
	
	public void pintaBotones(RespuestaDesvelo respuestaDesvelo) {
		for (int i = 0; i < this.botonera.getAlto(); i++) {
			for (int j = 0; j < this.botonera.getAncho(); j++) {
				Coordenada coordenada = new Coordenada(i, j);
				boolean veloPosicion = respuestaDesvelo.getVeloPosicion(coordenada);
				//Y aqui desvelas o no el boton
//				botonera.getButton(coordenada).setText(veloPosicion);
			}
		}
	}
	
	private void asociarBotones() {
		for (int i = 0; i < this.botonera.getAlto(); i++) {
			for (int j = 0; j < this.botonera.getAncho(); j++) {
				Coordenada coordenada = new Coordenada(i, j);
				botonera.getButton(coordenada).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						if(e.getButton()==1) {
							System.out.println("boton izquierdo");
							JButton boton = (JButton) e.getSource();
							Coordenada coordenada2 = botonera.getCoordenada(boton);
							
							controlador.desvelarCasillas(coordenada2);
							pintaBotones(controlador.casillasDesveladasTablero());
							}
							
						if(e.getButton()==3) {
							System.out.println("boton derecho");
							JButton boton = (JButton) e.getSource();
							Coordenada coordenada2 = botonera.getCoordenada(boton);
							boton.setText("X");
							//Conmutar el valor de marcada en la casilla
//							tablero.getCasilla(coordenada2).setMarcada(!tablero.getCasilla(coordenada2).isMarcada());
						}
					}
				});
				;
			}
		}
	}

}

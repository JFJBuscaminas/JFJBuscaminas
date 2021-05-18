package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.TableroAleatorio;
import utiles.RespuestaDesvelo;
import vista.JPanelReiniciar;
import vista.UI;

public class ParaUI extends UI {

	private Controlador controlador;
	private boolean terminado = false;
	private boolean reiniciarBotonera = false;

	public ParaUI() {
		super();
		this.jugar();
		controlador=new Controlador();
	}
	
//	private void Reiniciar() {
//		getBtnReiniciar().addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				terminado = false;
//				getBtnIniciar().setEnabled(true);
//				getCmbDensidad().setEnabled(true);
//				getCmbDificultad().setEnabled(true);
//				jugar();
//				
//			}
//		});
//	}
//	
	private void jugar() {
		
		getBtnIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getBtnIniciar().setEnabled(false);
				Densidad densidad = (Densidad) getCmbDensidad().getSelectedItem();
				Dificultad dificultad = (Dificultad) getCmbDificultad().getSelectedItem();
				getCmbDensidad().setEnabled(false);
				getCmbDificultad().setEnabled(false);
				controlador.crearTablero(dificultad.getLongitud(), densidad.getPorcentaje());
				addBotones(dificultad.getLongitud());
				asociarBotones();
//				Reiniciar();
				
			}
		});	
	}
	
	public void pintaBotones(RespuestaDesvelo respuestaDesvelo) {
		for (int i = 0; i < this.botonera.getAlto(); i++) {
			for (int j = 0; j < this.botonera.getAncho(); j++) {
				Coordenada coordenada = new Coordenada(i, j);
				boolean veloPosicion = respuestaDesvelo.getVeloPosicion(coordenada);
				RespuestaDesvelo contarMinasCasilla = controlador.contarMinasCasilla(coordenada);
				JButton boton = botonera.getButton(coordenada);
				if(!veloPosicion) {
					boton.setText(contarMinasCasilla.getMensaje());
					if(contarMinasCasilla.isMina()) {
						for (int k = 0; k < this.botonera.getAlto(); k++) {
							for (int k2 = 0; k2 < this.botonera.getAncho(); k2++) {
								Coordenada mina = new Coordenada(k, k2);
								RespuestaDesvelo desvelarMinas = controlador.contarMinasCasilla(mina);
								if(desvelarMinas.isMina()) {
									boton = botonera.getButton(mina);
									boton.setText(desvelarMinas.getMensaje());
									boton.setBackground(new Color(234,98,98));
								}
								this.terminado = true;
							}
						}
					}
				}
					
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
						if(e.getButton()==1 && terminado == false) {
							System.out.println("boton izquierdo");
							JButton boton = (JButton) e.getSource();
							Coordenada coordenada2 = botonera.getCoordenada(boton);
							
							controlador.desvelarCasillas(coordenada2);
							pintaBotones(controlador.getRespuestaDesvelo());
//							if(terminado) {
//								botonera.setVisible(false);
//								addReinicio();
//							}
						}
							
						if(e.getButton()==3 && terminado == false) {
							System.out.println("boton derecho");
							JButton boton = (JButton) e.getSource();
							Coordenada coordenada2 = botonera.getCoordenada(boton);
							if(boton.getText() == "" || boton.getText() == "X") {
								controlador.marcarCasilla(coordenada2);
								if(boton.getText() == "X") {
									boton.setText("");
								}else {
									boton.setText("X");
								}
							}
						}
					}
				});
				;
			}
		}
	}

}

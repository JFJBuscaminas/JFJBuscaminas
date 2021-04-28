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
import vista.UI;

public class ParaUI extends UI {

	private Controlador controlador;

	public ParaUI() {
		super();
		this.iniciarJuego();
		controlador=new Controlador();
		// leyes de demeter
		// para solucionar esto es crear metodos delegados
//		jPanelOpciones.btnIniciar.addActionListener(l);
	}
	private void iniciarJuego() {
		this.jugar();
		
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

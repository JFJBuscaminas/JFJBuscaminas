package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.asociarBotones();
	}
	
	
	private void jugar() {
		
		getBtnIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Densidad densidad = (Densidad) getCmbDensidad().getSelectedItem();
				Dificultad dificultad = (Dificultad) getCmbDificultad().getSelectedItem();
				controlador.crearTablero(dificultad.getLongitud(), densidad.getPorcentaje());
				addBotones(dificultad.getLongitud());
			}
		});	
	}
	private void asociarBotones() {
		for (int i = 0; i < this.botonera.getAlto(); i++) {
			for (int j = 0; j < this.botonera.getAncho(); j++) {
				Coordenada coordenada = new Coordenada(i, j);
				botonera.getButton(coordenada).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton boton = (JButton) e.getSource();
						Coordenada coordenada2 = botonera.getCoordenada(boton);
						int minasAlrededor = tablero.getCasilla(coordenada2).getMinasAlrededor();
						boton.setText(String.valueOf(minasAlrededor));
						
					}
				});
				;
			}
		}
	}

}

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
		controlador=new Controlador();
		// leyes de demeter
		// para solucionar esto es crear metodos delegados
//		jPanelOpciones.btnIniciar.addActionListener(l);
		getBtnIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Densidad densidad = (Densidad) getCmbDensidad().getSelectedItem();
				System.out.println(densidad);
				Dificultad dificultad = (Dificultad) getCmbDificultad().getSelectedItem();
				System.out.println(dificultad.getLongitud());
				controlador.dameValores(densidad, dificultad);
//				jPanelOpciones.getCmbDensidad();
				tablero = new TableroAleatorio(dificultad.getLongitud(), 5);
				addBotones(dificultad.getLongitud());
				
			}
		});	
	}

}

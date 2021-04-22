package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.TableroAleatorio;

import javax.swing.JLabel;

public class UI extends JFrame {
	
	private JPanel contentPane;
	public JPanelOpciones jPanelOpciones;
	private JTextField textField;
	protected TableroAleatorio tablero = new TableroAleatorio(Dificultad.medio.getLongitud(), 5);
	protected Botonera botonera;

	
	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		jPanelOpciones=new JPanelOpciones();
		contentPane.add(jPanelOpciones, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		textField = new JTextField();
		textField.setColumns(10);
	}
	
	public void addBotones(int longitud) {
		botonera = new Botonera(longitud);
		contentPane.add(botonera, BorderLayout.CENTER);
	}

	public void tomaValores(Densidad densidad, Dificultad dificultad) {
		System.out.println(densidad+" "+dificultad);
		
	}

	public JButton getBtnIniciar() {
		return jPanelOpciones.getBtnIniciar();
	}

	public JComboBox getCmbDificultad() {
		return jPanelOpciones.getCmbDificultad();
	}

	public JComboBox getCmbDensidad() {
		return jPanelOpciones.getCmbDensidad();
	}

}

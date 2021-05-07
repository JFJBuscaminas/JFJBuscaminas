package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class JPanelReiniciar extends JPanel {

	private JButton btnNewButton;
	/**
	 * Create the panel.
	 */
	public JPanelReiniciar() {
		setLayout(null);
		
		btnNewButton = new JButton("Reiniciar");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(51, 153, 255));
		btnNewButton.setBounds(167, 113, 89, 23);
		add(btnNewButton);

	}
	
	public JButton getBtnReiniciar() {
		return btnNewButton;
	}
}

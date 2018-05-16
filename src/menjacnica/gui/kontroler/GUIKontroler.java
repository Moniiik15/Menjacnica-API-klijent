package menjacnica.gui.kontroler;

import java.awt.EventQueue;

import menjacnica.Menjacnica;
import menjacnica.gui.GlavniProzor;

public class GUIKontroler {

	public static Menjacnica menjacnica = new Menjacnica();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

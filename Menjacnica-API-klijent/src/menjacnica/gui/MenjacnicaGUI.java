package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblIzValuteZemlje;
	private JLabel lblUValutuZemlje;
	private JComboBox comboBox;
	private JLabel lblIznos;
	private JTextField textField;
	private JComboBox comboBox_1;
	private JLabel lblIznos_1;
	private JTextField textField_1;
	private JButton btnKonvertuj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIzValuteZemlje());
		contentPane.add(getLblUValutuZemlje());
		contentPane.add(getComboBox());
		contentPane.add(getLblIznos());
		contentPane.add(getTextField());
		contentPane.add(getComboBox_1());
		contentPane.add(getLblIznos_1());
		contentPane.add(getTextField_1());
		contentPane.add(getBtnKonvertuj());
	}
	private JLabel getLblIzValuteZemlje() {
		if (lblIzValuteZemlje == null) {
			lblIzValuteZemlje = new JLabel("Iz valute zemlje:");
			lblIzValuteZemlje.setBounds(44, 38, 117, 20);
		}
		return lblIzValuteZemlje;
	}
	private JLabel getLblUValutuZemlje() {
		if (lblUValutuZemlje == null) {
			lblUValutuZemlje = new JLabel("U valutu zemlje:");
			lblUValutuZemlje.setBounds(242, 38, 127, 20);
		}
		return lblUValutuZemlje;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<>();
			comboBox.setBounds(44, 69, 117, 26);
		}
		return comboBox;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos:");
			lblIznos.setBounds(44, 111, 117, 20);
		}
		return lblIznos;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(44, 146, 146, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(241, 69, 128, 26);
		}
		return comboBox_1;
	}
	private JLabel getLblIznos_1() {
		if (lblIznos_1 == null) {
			lblIznos_1 = new JLabel("Iznos: ");
			lblIznos_1.setBounds(242, 111, 69, 20);
		}
		return lblIznos_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(242, 146, 146, 26);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.setBounds(156, 199, 115, 29);
		}
		return btnKonvertuj;
	}
}

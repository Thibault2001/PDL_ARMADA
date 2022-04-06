package GUI.Zone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SupprimerZone {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerZone window = new SupprimerZone();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupprimerZone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.setBounds(51, 232, 101, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(321, 232, 85, 21);
		frame.getContentPane().add(btnRetour);
		
		JLabel lblNewLabel = new JLabel("Nom de la zone \u00E0 supprimer :");
		lblNewLabel.setBounds(51, 131, 186, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(231, 128, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Supprimer une zone");
		lblNewLabel_1.setBounds(129, 44, 155, 13);
		frame.getContentPane().add(lblNewLabel_1);
	}

}

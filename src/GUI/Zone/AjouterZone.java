package GUI.Zone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AjouterZone {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterZone window = new AjouterZone();
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
	public AjouterZone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom de la zone \u00E0 ajouter : ");
		lblNewLabel.setBounds(46, 95, 148, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(199, 92, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIndiquerLaPlage = new JLabel("Indiquer la plage horaire (matin ou soir) :\r\n\r\n");
		lblIndiquerLaPlage.setBounds(46, 131, 126, 13);
		frame.getContentPane().add(lblIndiquerLaPlage);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(199, 128, 96, 19);
		frame.getContentPane().add(textField_1);
		
		JLabel lblIndiquerLeNombre = new JLabel("Indiquer le nombre de place :\r\n\r\n\r\n");
		lblIndiquerLeNombre.setBounds(46, 168, 126, 13);
		frame.getContentPane().add(lblIndiquerLeNombre);
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 165, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTypeDeLa = new JLabel("Type de la zone (locataire ou service public) :");
		lblTypeDeLa.setBounds(46, 200, 227, 13);
		frame.getContentPane().add(lblTypeDeLa);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(284, 197, 96, 19);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNombreDePlace = new JLabel("Nombre de place r\u00E9serv\u00E9e(s) :");
		lblNombreDePlace.setBounds(46, 240, 148, 13);
		frame.getContentPane().add(lblNombreDePlace);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(199, 237, 96, 19);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter une zone");
		lblNewLabel_1.setBounds(197, 22, 110, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(341, 236, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}

}

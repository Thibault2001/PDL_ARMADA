package GUI.Zone;

import DAO.*;
import Lot1.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		frame.setBounds(100, 100, 587, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom de la zone \u00E0 ajouter : ");
		lblNewLabel.setBounds(46, 61, 176, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(406, 58, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIndiquerLaPlage = new JLabel("Indiquer la plage horaire (matin ou soir) :\r\n\r\n");
		lblIndiquerLaPlage.setBounds(46, 134, 235, 13);
		frame.getContentPane().add(lblIndiquerLaPlage);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(406, 95, 96, 19);
		frame.getContentPane().add(textField_1);
		
		JLabel lblIndiquerLeNombre = new JLabel("Indiquer le nombre de place :\r\n\r\n\r\n");
		lblIndiquerLeNombre.setBounds(46, 98, 176, 13);
		frame.getContentPane().add(lblIndiquerLeNombre);
		
		textField_2 = new JTextField();
		textField_2.setBounds(406, 131, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTypeDeLa = new JLabel("Type de la zone (locataire ou service public) :");
		lblTypeDeLa.setBounds(46, 168, 261, 13);
		frame.getContentPane().add(lblTypeDeLa);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(406, 165, 96, 19);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNombreDePlace = new JLabel("Nombre de place r\u00E9serv\u00E9e(s) :");
		lblNombreDePlace.setBounds(46, 201, 196, 13);
		frame.getContentPane().add(lblNombreDePlace);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(406, 198, 96, 19);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter une zone");
		lblNewLabel_1.setBounds(197, 22, 110, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue;
				Zone zone = new Zone (textField.getText(),Integer.parseInt(textField_1.getText()), textField_2.getText(), textField_3.getText(), Integer.parseInt(textField_4.getText()));
				ZoneDAO zoneDAO =new ZoneDAO();
				returnValue=zoneDAO.addZone(zone);
				frame.dispose();
				System.out.println(returnValue + " zone ajoutee(s)");
				ZoneGUI nextpage = new ZoneGUI();
				nextpage.main(null);
				frame.dispose();
			}
		});
		btnValider.setBounds(406, 274, 134, 44);
		frame.getContentPane().add(btnValider);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZoneGUI nextpage = new ZoneGUI();
				nextpage.main(null);
				frame.dispose();
			}
		});
		btnRetour.setBounds(46, 274, 134, 44);
		frame.getContentPane().add(btnRetour);
	}
}

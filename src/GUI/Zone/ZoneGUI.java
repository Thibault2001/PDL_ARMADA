package GUI.Zone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.TextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZoneGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZoneGUI window = new ZoneGUI();
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
	public ZoneGUI() {
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Serafini Thibault\\Desktop\\Eclipse\\ARMADA 2023\\src\\GUI\\Esigelec.png"));
		lblNewLabel_1.setBounds(10, 10, 159, 88);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnSupprimerZone = new JButton("Supprimer une zone");
		btnSupprimerZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerZone nextpage = new SupprimerZone();
				nextpage.main(null);
				frame.dispose();
			}
		});
		btnSupprimerZone.setBounds(78, 149, 134, 44);
		frame.getContentPane().add(btnSupprimerZone);
		
		JButton btnAjouterZone = new JButton("Ajouter une zone");
		btnAjouterZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterZone nextpage = new AjouterZone();
				nextpage.main(null);
				frame.dispose();
			}
		});
		btnAjouterZone.setBounds(257, 149, 134, 44);
		frame.getContentPane().add(btnAjouterZone);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Serafini Thibault\\Desktop\\Eclipse\\ARMADA 2023\\src\\GUI\\Armada.jpg"));
		lblNewLabel.setBounds(243, 23, 183, 123);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnListeDesZones = new JButton("Liste des zones");
		btnListeDesZones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Bouton liste des zones
			}
		});
		btnListeDesZones.setBounds(171, 209, 134, 44);
		frame.getContentPane().add(btnListeDesZones);
	}
}

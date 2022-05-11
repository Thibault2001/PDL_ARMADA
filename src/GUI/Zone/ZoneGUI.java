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
		
		JButton btnSupprimerZone = new JButton("Supprimer une zone");
		btnSupprimerZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerZone nextpage = new SupprimerZone();
				nextpage.main(null);
				frame.dispose();
			}
		});
		btnSupprimerZone.setBounds(10, 98, 183, 34);
		frame.getContentPane().add(btnSupprimerZone);
		
		JButton btnAjouterZone = new JButton("Ajouter une zone");
		btnAjouterZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterZone nextpage = new AjouterZone();
				nextpage.main(null);
				frame.dispose();
			}
		});
		btnAjouterZone.setBounds(242, 98, 182, 33);
		frame.getContentPane().add(btnAjouterZone);
		
		JButton btnListeDesZones = new JButton("Liste des zones");
		btnListeDesZones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeZone nextPage = new ListeZone();
				nextPage.getFrame().setVisible(true);
			}
		});
		btnListeDesZones.setBounds(124, 159, 182, 34);
		frame.getContentPane().add(btnListeDesZones);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(176, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblGestionDesZones = new JLabel("Gestion des zones");
		lblGestionDesZones.setFont(new Font("Perpetua", Font.BOLD, 21));
		lblGestionDesZones.setBounds(138, 11, 164, 33);
		frame.getContentPane().add(lblGestionDesZones);
	}
}

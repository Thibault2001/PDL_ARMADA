package GUI.Organisateur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.GererInscriptions;
import GUI.Zone.SupprimerZone;
import GUI.Zone.ZoneGUI;
import Tronc_commun.Organisateur;

//import GUI.Zone.SupprimerZone;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe qui affiche la fenetre d'acceuil d'un organisateur
 * 
 * @author SERAFINI Thibault & TEGUE Elisée
 * */
public class MenuOrganisateur {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOrganisateur window = new MenuOrganisateur();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param l'organisateur qui s'est connecte 
	 */
	public MenuOrganisateur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Organisateur\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(98, 25, 268, 35);
		getFrame().getContentPane().add(lblNewLabel);
		
		JButton GererLP = new JButton("G\u00E9rer les laissez-passer");
		GererLP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GererLP.setBounds(21, 95, 210, 44);
		getFrame().getContentPane().add(GererLP);
		
		JButton GererInscription = new JButton("G\u00E9rer les participants");
		GererInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GererInscription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GererInscription.setBounds(21, 171, 187, 44);
		getFrame().getContentPane().add(GererInscription);
		
		JButton GererZone = new JButton("G\u00E9rer les zones");
		GererZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZoneGUI nextpage = new ZoneGUI();
				nextpage.main(null);
				frame.dispose();
			}
		});
		GererZone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GererZone.setBounds(244, 95, 161, 44);
		getFrame().getContentPane().add(GererZone);
		
		JButton GererParticipant = new JButton("G\u00E9rer les inscriptions");
		GererParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						GererInscriptions nextpage = new GererInscriptions();
						nextpage.main(null);
						//getFrame().dispose();
			}
		});
		GererParticipant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GererParticipant.setBounds(218, 171, 187, 44);
		getFrame().getContentPane().add(GererParticipant);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
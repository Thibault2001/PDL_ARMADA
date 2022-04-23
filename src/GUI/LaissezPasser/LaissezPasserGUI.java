package GUI.LaissezPasser;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.*;
import GUI.Participant.*;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LaissezPasserGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaissezPasserGUI window = new LaissezPasserGUI();
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
	public LaissezPasserGUI() {
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
		
		JLabel GererLP = new JLabel("Laissez-Passer");
		GererLP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GererLP.setBounds(107, 10, 305, 62);
		frame.getContentPane().add(GererLP);
		
		JButton DemandeLP = new JButton("Demande de laissez-passer");
		DemandeLP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemandeLP nextpage = new DemandeLP();
				nextpage.main(null);
				frame.dispose();
			}
		});
		DemandeLP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DemandeLP.setBounds(75, 65, 287, 45);
		frame.getContentPane().add(DemandeLP);
		
		JButton EtatDeLaDemande = new JButton("Suivre l'\u00E9tat de ma demande");
		EtatDeLaDemande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EtatDeLaDemande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EtatDeLaDemande.setBounds(75, 120, 287, 40);
		frame.getContentPane().add(EtatDeLaDemande);
		
		JButton ModifierDemande = new JButton("Modifier ma demande");
		ModifierDemande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ModifierDemande.setBounds(75, 170, 287, 40);
		frame.getContentPane().add(ModifierDemande);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuParticipant nextpage = new MenuParticipant(null);
				nextpage.main(null);
				frame.dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRetour.setBounds(20, 232, 98, 21);
		frame.getContentPane().add(btnRetour);
	}

}

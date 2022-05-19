package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Lot1.DisplayRequestsForRegistration;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GererLaissezPasser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GererLaissezPasser window = new GererLaissezPasser();
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
	public GererLaissezPasser() {
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
		
		JLabel GererLP = new JLabel("Gestion les Laissez-Passer");
		GererLP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		GererLP.setBounds(99, 10, 327, 33);
		frame.getContentPane().add(GererLP);
		
		JButton ConsulterListeParticipant = new JButton("Consulter la liste des laissez-passer");
		ConsulterListeParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ListOfRequests window = new ListOfRequests();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		ConsulterListeParticipant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ConsulterListeParticipant.setBounds(94, 55, 243, 47);
		frame.getContentPane().add(ConsulterListeParticipant);
		
		JButton btnModifierUnParticipant = new JButton("Modifier un laissez-passer");
		btnModifierUnParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UpdateRequests window = new UpdateRequests();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnModifierUnParticipant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModifierUnParticipant.setBounds(125, 171, 187, 39);
		frame.getContentPane().add(btnModifierUnParticipant);
		
		JButton btnSupprimerUnParticipant = new JButton("Valider des laissez-passer");
		btnSupprimerUnParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new DisplayRequestsForRegistration();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSupprimerUnParticipant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSupprimerUnParticipant.setBounds(115, 113, 203, 47);
		frame.getContentPane().add(btnSupprimerUnParticipant);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(176, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
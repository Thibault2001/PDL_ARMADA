package GUI.Organisateur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class GererParticipant {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GererParticipant window = new GererParticipant();
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
	public GererParticipant() {
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
		
		JLabel GererParticipant = new JLabel("G\u00E9rer les Participants");
		GererParticipant.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GererParticipant.setBounds(70, 10, 356, 54);
		frame.getContentPane().add(GererParticipant);
		
		JButton ConsulterListeParticipant = new JButton("Consulter la liste des participants");
		ConsulterListeParticipant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ConsulterListeParticipant.setBounds(98, 188, 270, 47);
		frame.getContentPane().add(ConsulterListeParticipant);
		
		JButton btnModifierUnParticipant = new JButton("Modifier un participant");
		btnModifierUnParticipant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModifierUnParticipant.setBounds(126, 74, 200, 47);
		frame.getContentPane().add(btnModifierUnParticipant);
		
		JButton btnSupprimerUnParticipant = new JButton("Supprimer un participant");
		btnSupprimerUnParticipant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSupprimerUnParticipant.setBounds(114, 131, 238, 47);
		frame.getContentPane().add(btnSupprimerUnParticipant);
	}

}

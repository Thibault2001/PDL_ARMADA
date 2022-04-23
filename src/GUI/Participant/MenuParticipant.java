package GUI.Participant;

/**
 * Classe qui affiche la fenetre d'acceuil d'un participant
 * 
 * @author SERAFINI Thibault & TEGUE Elisée
 * */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Tronc_commun.PersonneMorale;

import java.awt.Font;
import javax.swing.JButton;
//import GUI.LaissezPasser.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MenuParticipant {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuParticipant window = new MenuParticipant(null);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param la personne morale rattache au participant qui s'est connecte
	 */
	public MenuParticipant(PersonneMorale pers) {
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
		
		JLabel MenuParticipant = new JLabel("Menu Participant");
		MenuParticipant.setFont(new Font("Tahoma", Font.PLAIN, 30));
		MenuParticipant.setBounds(92, 11, 235, 63);
		getFrame().getContentPane().add(MenuParticipant);
		
		JButton LP = new JButton("Laissez-Passer");
		LP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*LaissezPasserGUI nextpage = new LaissezPasserGUI();
				nextpage.main(null);
				frame.dispose();*/
			}
		});
		LP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LP.setBounds(139, 118, 150, 55);
		getFrame().getContentPane().add(LP);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
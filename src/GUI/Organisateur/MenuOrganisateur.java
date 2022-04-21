package GUI.Organisateur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	public MenuOrganisateur() {
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
		
		JLabel lblNewLabel = new JLabel("Menu Organisateur\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(98, 25, 268, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton GererLP = new JButton("G\u00E9rer les laissez-passer");
		GererLP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GererLP.setBounds(21, 95, 187, 44);
		frame.getContentPane().add(GererLP);
		
		JButton GererInscription = new JButton("G\u00E9rer les Inscriptions");
		GererInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GererInscription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GererInscription.setBounds(218, 95, 187, 44);
		frame.getContentPane().add(GererInscription);
		
		JButton GererZone = new JButton("G\u00E9rer les Zones");
		GererZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GererZone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GererZone.setBounds(21, 171, 187, 44);
		frame.getContentPane().add(GererZone);
		
		JButton GererParticipant = new JButton("G\u00E9rer les Participants");
		GererParticipant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GererParticipant.setBounds(218, 171, 187, 44);
		frame.getContentPane().add(GererParticipant);
	}

}

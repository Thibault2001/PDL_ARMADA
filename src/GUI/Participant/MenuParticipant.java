package GUI.Participant;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import GUI.LaissezPasser.*;

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
					MenuParticipant window = new MenuParticipant();
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
	public MenuParticipant() {
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
		
		JLabel MenuParticipant = new JLabel("Menu Participant");
		MenuParticipant.setFont(new Font("Tahoma", Font.PLAIN, 30));
		MenuParticipant.setBounds(92, 21, 313, 63);
		frame.getContentPane().add(MenuParticipant);
		
		JButton LP = new JButton("Laissez-Passer");
		LP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LaissezPasserGUI nextpage = new LaissezPasserGUI();
				nextpage.main(null);
				frame.dispose();
			}
		});
		LP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LP.setBounds(139, 118, 150, 55);
		frame.getContentPane().add(LP);
	}

}

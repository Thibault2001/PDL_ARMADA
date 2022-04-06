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
		
		JButton btnNewButton = new JButton("Supprimer une zone");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ajouter la fenetre suivante
			}
		});
		btnNewButton.setBounds(78, 149, 134, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAjouterUneZone = new JButton("Ajouter une zone");
		btnAjouterUneZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterZone nextpage = new AjouterZone();
				nextpage.main(null);
				frame.dispose();
			}
		});
		btnAjouterUneZone.setBounds(257, 149, 134, 44);
		frame.getContentPane().add(btnAjouterUneZone);
	}
}

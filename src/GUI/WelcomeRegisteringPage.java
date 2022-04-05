package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeRegisteringPage {

	private JFrame frame;
	private String selectedItem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeRegisteringPage window = new WelcomeRegisteringPage();
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
	public WelcomeRegisteringPage() {
		initialize();
	}
	/**
	 * Applies the feature "Un bateau"
	 */
	private void UnBateau() {
		try {
			RegisteringForm RegForm = new RegisteringForm();
			RegForm.getFrame().setVisible(true);
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * get the frame.
	 */
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * set the frame.
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ARMADA 2023");
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel.setBounds(266, 11, 168, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\PDL charts\\logo_Esig_real.png"));
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel_2.setBounds(0, 0, 168, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNom_1 = new JLabel("Vous \u00EAtes");
		lblNom_1.setFont(new Font("Perpetua", Font.BOLD, 14));
		lblNom_1.setBounds(10, 146, 81, 31);
		frame.getContentPane().add(lblNom_1);
		
		JLabel lblInscription = new JLabel("Vous faites bien de vous inscrire \u00E0 l'un des \u00E9v\u00E8nements phare de la ville Rouen...");
		lblInscription.setFont(new Font("Perpetua", Font.PLAIN, 15));
		lblInscription.setBounds(0, 83, 444, 31);
		frame.getContentPane().add(lblInscription);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItem = (String) comboBox.getSelectedItem(); //get the selected item
				}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Une d\u00E9l\u00E9gation", "Une entreprise ", "Un commer\u00E7ant ", "Un bateau", "Une famille d\u2019accueil", "Un VIP "}));
		comboBox.setBounds(89, 150, 132, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(selectedItem) {
				case "Un bateau":
					UnBateau();
					break;
				case "Une entreprise":
					break;
				default:
					break;
				}
			}
		});
		btnNewButton.setBounds(19, 232, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(332, 232, 89, 23);
		frame.getContentPane().add(btnAnnuler);
		
	}
}

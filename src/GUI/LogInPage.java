package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class LogInPage {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPage window = new LogInPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public LogInPage() {
		initialize();
	}

	/**
	 * Applies the feature "Faire une demande"
	 */
	private void FaireDemande() {
		try {
			RegisteringForm RegForm = new RegisteringForm();
			RegForm.getFrame().setVisible(true);
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Applies the feature "Quitter"
	 */
	private void quitter() {
		try {
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ARMADA 2023");
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel.setBounds(305, 11, 168, 40);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\PDL charts\\logo_Esig_real.png"));
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel_2.setBounds(0, 0, 168, 40);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNom = new JLabel("Identifiant ");
		lblNom.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblNom.setBounds(0, 92, 99, 26);
		frame.getContentPane().add(lblNom);

		textField = new JTextField();
		textField.setBounds(94, 93, 327, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblPrnom = new JLabel("Mot de passe ");
		lblPrnom.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblPrnom.setBounds(0, 129, 124, 26);
		frame.getContentPane().add(lblPrnom);

		JLabel lblInscription = new JLabel("Espace personnel participant");
		lblInscription.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblInscription.setBounds(94, 51, 290, 26);
		frame.getContentPane().add(lblInscription);

		JButton btnNewButton = new JButton("Se connecter ");
		btnNewButton.setBounds(172, 169, 124, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnAnnuler = new JButton("Quitter");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitter(); // this method is previously declared (the same method is called with the "S'inscrire" button)
			}
		});
		btnAnnuler.setBounds(374, 217, 89, 23);
		frame.getContentPane().add(btnAnnuler);

		JButton btnNewButton_1 = new JButton("Faire une demande");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FaireDemande(); // this method is previously declared (the same method is called with the "S'inscrire" button)
			}
		});
		btnNewButton_1.setBounds(136, 217, 149, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Pas encore inscrit ?");
		lblNewLabel_1.setBounds(10, 219, 114, 19);
		frame.getContentPane().add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(94, 132, 327, 20);
		frame.getContentPane().add(passwordField);
	}
}

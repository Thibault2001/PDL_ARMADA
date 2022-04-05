package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisteringForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteringForm window = new RegisteringForm();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisteringForm() {
		initialize();
	}
	/**
	 * Applies the feature "Annuler"
	 */
	private void Annuler() {
		try {
			LogInPage LogPage = new LogInPage();
			LogPage.getFrame().setVisible(true);
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 692, 441);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ARMADA 2023");
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel.setBounds(511, 11, 168, 40);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\PDL charts\\logo_Esig_real.png"));
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel_2.setBounds(0, 0, 168, 40);
		getFrame().getContentPane().add(lblNewLabel_2);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblNom.setBounds(0, 233, 50, 26);
		getFrame().getContentPane().add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(53, 235, 248, 20);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblPrnom.setBounds(311, 233, 62, 26);
		getFrame().getContentPane().add(lblPrnom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(383, 236, 289, 20);
		getFrame().getContentPane().add(textField_1);
		
		JLabel lblInscription = new JLabel("DEMANDE D'INSCRIPTION ");
		lblInscription.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblInscription.setBounds(234, 56, 230, 26);
		getFrame().getContentPane().add(lblInscription);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 357, 89, 23);
		getFrame().getContentPane().add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Annuler();
			}
		});
		btnAnnuler.setBounds(577, 357, 89, 23);
		getFrame().getContentPane().add(btnAnnuler);
		
		JLabel lblPrnom_1_1 = new JLabel("Informations sur la personne morale associ\u00E9e au participant :");
		lblPrnom_1_1.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		lblPrnom_1_1.setBounds(0, 195, 474, 26);
		frame.getContentPane().add(lblPrnom_1_1);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
		lblDateDeNaissance.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblDateDeNaissance.setBounds(0, 272, 137, 26);
		frame.getContentPane().add(lblDateDeNaissance);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setBounds(175, 276, 38, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("JJ");
		lblNewLabel_1.setBounds(149, 272, 19, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("MM");
		lblNewLabel_1_1.setBounds(223, 270, 30, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Fev", "Mars", "Avril", "Mai", "Juin", "Juillet", "Mai", "Ao\u00FBt", "Sept", "Oct", "Nov", "Dec"}));
		comboBox_1.setBounds(263, 274, 62, 22);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("YY");
		lblNewLabel_1_1_1.setBounds(335, 270, 30, 31);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"", "1950\u200E ", "1951\u200E ", "1952\u200E", "1953\u200E ", "1954\u200E ", "1955\u200E ", "1956\u200E ", "1957\u200E ", "1958\u200E ", "1959\u200E ", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		comboBox_1_1.setBounds(375, 274, 89, 22);
		frame.getContentPane().add(comboBox_1_1);
		
		JLabel lblEmail = new JLabel("email :");
		lblEmail.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblEmail.setBounds(0, 309, 50, 26);
		frame.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(53, 312, 289, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblInscription_1 = new JLabel("Vous faites bien de vous inscrire \u00E0 l'un des \u00E9v\u00E8nements phare de la ville Rouen...");
		lblInscription_1.setFont(new Font("Perpetua", Font.PLAIN, 16));
		lblInscription_1.setBounds(0, 99, 672, 31);
		frame.getContentPane().add(lblInscription_1);
		
		JLabel lblNom_1 = new JLabel("Vous \u00EAtes");
		lblNom_1.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblNom_1.setBounds(0, 142, 81, 31);
		frame.getContentPane().add(lblNom_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Une d\u00E9l\u00E9gation", "Une entreprise ", "Un commer\u00E7ant ", "Un bateau", "Une famille d\u2019accueil", "Un VIP "}));
		comboBox_2.setBounds(79, 146, 150, 22);
		frame.getContentPane().add(comboBox_2);
	}
}

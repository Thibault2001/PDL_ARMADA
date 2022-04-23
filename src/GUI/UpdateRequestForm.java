package GUI;
import java.awt.Dimension;
import java.util.regex.*;    
import java.util.*; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import DAO.*;
import Tronc_commun.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class UpdateRequestForm {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int FieldsFilled = 0;
	private Object getProfile;

	/**
	 * Create the application.
	 * @param idInsc l'identifiant de l'inscription a modifier
	 */
	public UpdateRequestForm(int idInsc) {
		initialize(idInsc);
	}   
	public boolean EmailValidation(String email){     // verifies if the entered email is valid or not 
	        //Regular Expressions   
	        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.$";  
	        //Compile regular expression to get the pattern  
	        Pattern pattern = Pattern.compile(regx);  
	        //Create instance of matcher   
	        Matcher matcher = pattern.matcher(email); 
	        boolean result = matcher.matches(); //return true if the entered email has the caracters "@" and "." and false else
	        int index1 = email.indexOf(".");  //check the caracter "." in the entered email
	        int index2 = email.indexOf("@.");  //check the string "@." to avoid invalid email
	        if(index2==-1)
	        	return(result&&(index1 == email.length()-3||index1 == email.length()-4)); 
	        else
	        	return false;
	}	  
	/**
	 * Applies the feature "Annuler"
	 */
	private void Annuler() {
		try {
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
	 * @param idInsc l'identifiant de l'inscription a modifier
	 */
	private void initialize(int idInsc) {
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
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText() != null) {	//controle de la présence d'un texte saisi par l'utilisateur
					
					FieldsFilled++;
				}
				else {
					FieldsFilled--;
				}
			}
		});
		textField.setBounds(53, 235, 248, 20);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblPrnom.setBounds(311, 233, 62, 26);
		getFrame().getContentPane().add(lblPrnom);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText() != null) {	//controle de la présence d'un texte saisi par l'utilisateur
					
					FieldsFilled++;
				}
				else {
					FieldsFilled--;
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(383, 236, 289, 20);
		getFrame().getContentPane().add(textField_1);
		
		JLabel lblInscription = new JLabel("MODIFICATION D'UNE DEMANDE D'INSCRIPTION ");
		lblInscription.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblInscription.setBounds(122, 80, 428, 26);
		getFrame().getContentPane().add(lblInscription);
		
		JButton btnNewButton = new JButton("Valider");
		
		JButton btnAnnuler = new JButton("Retour");
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
		
		JLabel lblEmail = new JLabel("email :");
		lblEmail.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblEmail.setBounds(0, 309, 50, 26);
		frame.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText() != null) 	//controle de la présence d'un texte saisi par l'utilisateur
					FieldsFilled++;
				else 
					FieldsFilled--;
				
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(53, 312, 332, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNom_1 = new JLabel("Profil");
		lblNom_1.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblNom_1.setBounds(0, 142, 81, 31);
		frame.getContentPane().add(lblNom_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(comboBox_2.getSelectedItem() == null) {
						comboBox_2.setSelectedItem("");
						btnNewButton.setEnabled(false);
						btnAnnuler.setEnabled(true);
						FieldsFilled--;
					}
					else {

						getProfile = comboBox_2.getSelectedItem();
						FieldsFilled++;
						btnNewButton.setEnabled(true);
						btnAnnuler.setEnabled(true);
					}
				}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "Une d\u00E9l\u00E9gation", "Une entreprise ", "Un commer\u00E7ant ", "Un bateau", "Une famille d\u2019accueil", "Un VIP "}));
		comboBox_2.setBounds(53, 146, 150, 22);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(comboBox_3.getSelectedItem() != null) {  //controle de la présence d'un choix effectué par l'utilisateur
						FieldsFilled++;
					}
					else {
						FieldsFilled--;

					}
				}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "F", "M"}));
		comboBox_3.setBounds(383, 277, 62, 22);
		frame.getContentPane().add(comboBox_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(147, 278, 154, 20);
		frame.getContentPane().add(dateChooser);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EmailValidation(textField_2.getText()) == true)
				{
					if(dateChooser.getDate() != null) {  //controle de la présence d'un choix effectué par l'utilisateur
						FieldsFilled++;
					}
					else {
						FieldsFilled--;

					}
					//controle de la présence d'un choix effectué par l'utilisateur
					if(dateChooser.getDate() != null&&comboBox_3.getSelectedItem() != null&&comboBox_2.getSelectedItem() != null&&textField_2.getText() != null&&textField_2.getText()!=null&&textField.getText()!=null) 
					{  
						String profile = getProfile.toString();
						PersonneMorale addedPersMor = new PersonneMorale(0, textField.getText(), textField_1.getText(), comboBox_3.getSelectedItem().toString(),String.format("%1$td/%1$tm/%1$tY", dateChooser.getDate()),textField_2.getText());
						Participant addedParticip = new Participant(0, profile, addedPersMor);
						PersonneMoraleDAO personneMoraleDAO = new PersonneMoraleDAO();
						int returnValuePM = personneMoraleDAO.add(addedPersMor);
						InscriptionDAO inscriptionDAO = new InscriptionDAO();
						int returnValueIns = inscriptionDAO.update(new Inscription(idInsc, addedParticip));
						if(returnValueIns!=0)
							{
								JFrame frame1 = new JFrame();	
								int ok = JOptionPane.showOptionDialog(frame1, "Votre modification a bien \u00E9t\u00E9 effectu\u00E9e", "Message", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
								if(ok==-1||ok==0)
								{
									frame.setVisible(false);
								}
							}
						btnNewButton.setEnabled(true);
						btnAnnuler.setEnabled(true);
					
					}
					else {
						try {
							ErrorWindowsRegisteringForm ErrorWinRegForm = new ErrorWindowsRegisteringForm();
							ErrorWinRegForm.getFrame().setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}	
				}
				else
				{
					try {
						MailErrorWindowsRegisteringForm MailErrorWinRegForm = new MailErrorWindowsRegisteringForm();
						MailErrorWinRegForm.getFrame().setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(10, 357, 89, 23);
		getFrame().getContentPane().add(btnNewButton);
		
		JLabel lblSexe = new JLabel("Sexe :");
		lblSexe.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblSexe.setBounds(311, 275, 62, 26);
		frame.getContentPane().add(lblSexe);
	}
}
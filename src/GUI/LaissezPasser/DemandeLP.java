package GUI.LaissezPasser;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

import javax.swing.*;

import DAO.*;
import GUI.*;
import Lot1.*;

public class DemandeLP {

	private JFrame frameDemandeLP;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldMetier;
	private JTextField textFieldEntreprise;
	private JTextField textFieldVehiculeImmatriculation;
	private JTextField textFieldPlageHoraire;
	private JTextField textFieldVehiculeModele;
	private JTextField textFieldVehiculeLongueur;
	private JTextField textFieldVehiculeLargeur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemandeLP window = new DemandeLP();
					window.frameDemandeLP.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DemandeLP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frameDemandeLP.
	 */
	private void initialize() {
		frameDemandeLP = new JFrame();
		frameDemandeLP.setBounds(100, 100, 450, 300);
		frameDemandeLP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDemandeLP.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Demande de laissez-passer\r\n");
		lblNewLabel.setBounds(173, 34, 151, 31);
		frameDemandeLP.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Veuillez remplir les champs ci-dessous :");
		lblNewLabel_1.setBounds(34, 70, 219, 13);
		frameDemandeLP.getContentPane().add(lblNewLabel_1);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(127, 106, 96, 19);
		frameDemandeLP.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom : \r\n");
		lblNewLabel_2.setBounds(34, 109, 45, 13);
		frameDemandeLP.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pr\u00E9nom :\r\n");
		lblNewLabel_2_1.setBounds(34, 132, 58, 13);
		frameDemandeLP.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("M\u00E9tier :");
		lblNewLabel_2_2.setBounds(34, 155, 45, 13);
		frameDemandeLP.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Entreprise :\r\n");
		lblNewLabel_2_3.setBounds(34, 178, 45, 13);
		frameDemandeLP.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("*V\u00E9hicule immatriculation/modele/longueur/largeur");
		lblNewLabel_2_4.setBounds(34, 201, 45, 13);
		frameDemandeLP.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("*Plage horaire (matin et/ou soir) :");
		lblNewLabel_2_5.setBounds(34, 224, 45, 13);
		frameDemandeLP.getContentPane().add(lblNewLabel_2_5);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(127, 129, 96, 19);
		frameDemandeLP.getContentPane().add(textFieldPrenom);
		
		textFieldMetier = new JTextField();
		textFieldMetier.setColumns(10);
		textFieldMetier.setBounds(127, 152, 96, 19);
		frameDemandeLP.getContentPane().add(textFieldMetier);
		
		textFieldEntreprise = new JTextField();
		textFieldEntreprise.setColumns(10);
		textFieldEntreprise.setBounds(127, 175, 96, 19);
		frameDemandeLP.getContentPane().add(textFieldEntreprise);
		
		textFieldVehiculeImmatriculation = new JTextField();
		textFieldVehiculeImmatriculation.setColumns(10);
		textFieldVehiculeImmatriculation.setBounds(127, 198, 38, 19);
		frameDemandeLP.getContentPane().add(textFieldVehiculeImmatriculation);
		
		textFieldPlageHoraire = new JTextField();
		textFieldPlageHoraire.setColumns(10);
		textFieldPlageHoraire.setBounds(127, 221, 96, 19);
		frameDemandeLP.getContentPane().add(textFieldPlageHoraire);
		
		JLabel lblNewLabel_3 = new JLabel("* : champ obligatoirement non vide");
		lblNewLabel_3.setBounds(34, 250, 189, 13);
		frameDemandeLP.getContentPane().add(lblNewLabel_3);
		
		textFieldVehiculeModele = new JTextField();
		textFieldVehiculeModele.setColumns(10);
		textFieldVehiculeModele.setBounds(173, 198, 32, 19);
		frameDemandeLP.getContentPane().add(textFieldVehiculeModele);
		
		textFieldVehiculeLongueur = new JTextField();
		textFieldVehiculeLongueur.setColumns(10);
		textFieldVehiculeLongueur.setBounds(215, 198, 38, 19);
		frameDemandeLP.getContentPane().add(textFieldVehiculeLongueur);
		
		textFieldVehiculeLargeur = new JTextField();
		textFieldVehiculeLargeur.setColumns(10);
		textFieldVehiculeLargeur.setBounds(263, 198, 38, 19);
		frameDemandeLP.getContentPane().add(textFieldVehiculeLargeur);
		
		JButton btnValider = new JButton("Valider\r\n");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldVehiculeImmatriculation.getText().length()>0 && textFieldPlageHoraire.getText().length()>0)
				{
					Vehicule vehicule =new Vehicule (textFieldVehiculeImmatriculation.getText(), textFieldVehiculeModele.getText(), Double.parseDouble(textFieldVehiculeLongueur.getText()), Double.parseDouble(textFieldVehiculeLargeur.getText()));
					ArrayList <Vehicule> listeVehicule =new ArrayList <Vehicule> ();
					listeVehicule.add(vehicule);
					LaissezPasser laissezPasser = new LaissezPasser (textFieldNom.getText(),textFieldPrenom.getText(), textFieldMetier.getText(), textFieldEntreprise.getText(), listeVehicule, textFieldPlageHoraire.getText(), false, false);
					new LaissezPasserDAO().addLaissezPasser(laissezPasser);
					
					//nextpage.main(null);
					frameDemandeLP.dispose();
				}
				else
				{
					DemandeLP nextpage = new DemandeLP();
					ErrorSaisie nextpage2 = new ErrorSaisie();
					nextpage.main(null);
					nextpage2.main(null);
					frameDemandeLP.dispose();
				}
			}
		});
		btnValider.setBounds(318, 232, 85, 21);
		frameDemandeLP.getContentPane().add(btnValider);
		
	}
}

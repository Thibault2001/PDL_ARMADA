package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import DAO.CompteDAO;
import DAO.InscriptionDAO;
import DAO.ParticipantDAO;
import DAO.PersonneMoraleDAO;
import Tronc_commun.*;

import javax.swing.JScrollPane;

/**
*Classe permettant d'afficher une fenetre n'ayant pas un bouton "suivant"
* 
* @author SERAFINI Thibault & TEGUE Elisée
* @version 1.0
* */

public class RequestsForRegistrationWithoutNext  {
	
	private JFrame frame;
	private JTable table_1;

	/**
	 * Getter pour la frame courante
	 * 
	 * @return retourne la frame courante
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Setter pour la frame courante
	 * 
	 * @param la nouvelle frame 
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Constructor
	 * 
	 * @param position cet entier indique si la fenetre est la toute première à etre affichée ou elle est affichée à la suite d'une autre
	 * @param nbOfElmts le nombre d'élements (demandes d'inscription) que contient la fenetre
	 */
	public RequestsForRegistrationWithoutNext (int position, int nbOfElmts) {
		initialize(position, nbOfElmts);
	}
	
	/**
	 * Applies the feature "Retour"
	 */
	private void retour() {
		try {
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize the contents of the frame
	 * 
	 * @param position cet entier indique si la fenetre est la toute première à etre affichée ou elle est affichée à la suite d'une autre
	 * @param nbOfElmts le nombre d'élements (demandes d'inscription) que contient la fenetre
	 */
	private void initialize(int position, int nbOfElmts) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ARMADA 2023");
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel.setBounds(716, 11, 168, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\PDL charts\\logo_Esig_real.png"));
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel_2.setBounds(0, 0, 168, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblInscription = new JLabel("Liste des demandes d'inscription");
		lblInscription.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblInscription.setBounds(289, 43, 318, 26);
		frame.getContentPane().add(lblInscription);
		
		JButton btnNewButton_1 = new JButton("Retour\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retour(); // cette méthode précédemment déclarée est appelée lors du click sur le bouton "retour" et permet de fermer la fenetre
			}
		});
		btnNewButton_1.setBounds(10, 527, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 864, 436);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1); //Redimensionne la table des demandes d'inscription
		ArrayList<Inscription> list = InscriptionDAO.getList();
		String[][] ListOfAttendees = new String[nbOfElmts][4];		//Le tableau multi-dimensionnel comportant les infromations sur les demandes d'inscription
		int cpt =-1;						// Ce compteur assurera une iteration pour chaque nouvelle inscription
		if(position==0)
		{
			cpt =0;	//initialisation
			for(Inscription i : list){
						ListOfAttendees[cpt][0] = i.getParticipant().getProfile();
						ListOfAttendees[cpt][1] = i.getParticipant().getPersonneMorale().getFirstName()+" "+i.getParticipant().getPersonneMorale().getName(); 
						ListOfAttendees[cpt][2] = i.getParticipant().getPersonneMorale().getEmail();
						ListOfAttendees[cpt][3] = null;
						cpt++;
			}
		}
		else
		{	
			//Ce cas se présente lorsque cette fenetre est affichée à la suite une autre 
			cpt=0;
			int index=0;
			//Itération des 26 éléments et saut de ceux-ci car ils ont déjà été affichés dans la page précédente
			for(Inscription i : list){
				index++;
				if(index>26)
				{
					ListOfAttendees[cpt][0] = i.getParticipant().getProfile();
					ListOfAttendees[cpt][1] = i.getParticipant().getPersonneMorale().getFirstName()+" "+i.getParticipant().getPersonneMorale().getName(); 
					ListOfAttendees[cpt][2] = i.getParticipant().getPersonneMorale().getEmail();
					ListOfAttendees[cpt][3] = null;
					cpt++;
				}
			}
		}
	
		table_1.setModel(new DefaultTableModel(ListOfAttendees,
				new String[] {
						"Profil", "Nom complet personne morale", "email ", "Valider ? o : oui/n : non"
					}		
				){
			boolean[] columnEditables = new boolean[] {
					false, false, false, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		table_1.setColumnSelectionAllowed(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(127);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(123);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(96);
		table_1.getColumnModel().getColumn(3).setMinWidth(116);
		table_1.getColumnModel().getColumn(3).setMaxWidth(2147483646);
		
		JButton btnValiderLaSaisie = new JButton("Valider la saisie");
		btnValiderLaSaisie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nbChampsVides=0;
				int nbChampsMalRemplis=0;
				for(int ligne=0; ligne<list.size(); ligne++)
				{
					if(table_1.getValueAt(ligne,3)==null)
							{
								nbChampsVides++;
							}
					else if(table_1.getValueAt(ligne,3).toString().equals("o")==false&&table_1.getValueAt(ligne,3).toString().equals("n")==false)
					{
						nbChampsMalRemplis++;
					}
				}
				if(nbChampsVides!=0)
				{
					JFrame frame1 = new JFrame();	
					JOptionPane.showMessageDialog(frame1, "Veuillez vous assurer de remplir tous les champs", "Erreur",JOptionPane.WARNING_MESSAGE);
				}
				else if(nbChampsMalRemplis!=0)
				{
					JFrame frame2 = new JFrame();	
					JOptionPane.showMessageDialog(frame2, "Veuillez vous assurer d'entrer de bonnes valeurs pour la validation des inscriptions", "Erreur",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int debut;
					if(list.size()<=26)
						debut = 0;
					else
						debut = 26;
					for(int ligne=debut; ligne<list.size(); ligne++)
					{
						if(table_1.getValueAt(ligne,3).toString().equals("o"))
								{
									//creation du participant et ajout de celui dans la table participant  
									PersonneMoraleDAO persMorDAO = new PersonneMoraleDAO();
									String[] Infos = persMorDAO.getInfosPM(table_1.getValueAt(ligne,2).toString());
									PersonneMorale PersMor = new PersonneMorale(Integer.valueOf(Infos[0]), null, null, null, table_1.getValueAt(ligne,2).toString(), null);
									Participant addedParticip = new Participant(0, table_1.getValueAt(ligne,0).toString(), PersMor);
									ParticipantDAO participantDAO = new ParticipantDAO();
									participantDAO.add(addedParticip);
									//Suppression de l'inscription dans la BD
									InscriptionDAO inscriptionDAO = new InscriptionDAO();
									//Inscription insc = new Inscription(0,addedParticip);
									inscriptionDAO.delete(list.get(ligne));
									//creation du compte du participant 
									Compte cmptPart = new Compte(Infos[1],table_1.getValueAt(ligne,2).toString());
									CompteDAO compteDAO = new CompteDAO();
									compteDAO.add(cmptPart);
								}
					}
					JFrame frame3 = new JFrame();	
					JOptionPane.showMessageDialog(frame3, "Votre validation a bien \u00E9t\u00E9 \u00E9ffectu\u00E9e");
					}
				}
			});
			btnValiderLaSaisie.setBounds(745, 527, 129, 23);
			frame.getContentPane().add(btnValiderLaSaisie);
		}
	}
	
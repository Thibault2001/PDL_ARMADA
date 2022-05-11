package GUI;
import java.awt.Dimension;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import DAO.*;

import Tronc_commun.Compte;
import Lot1.DisplayRequestsForRegistration;
import Tronc_commun.Inscription;
import Tronc_commun.Participant;
import Tronc_commun.PersonneMorale;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
* Classe permettant d'afficher une fenetre comportant un bouton "suivant"
* 
* @author SERAFINI Thibault & TEGUE Elisée
* @version 1.0
* */


public class RequestsForRegistrationWithNext  {
	
	private JFrame frame;
	private JTable table;
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
	 * @param nbOfElmts the number of registrations to display in the windows
	 */
	public RequestsForRegistrationWithNext (int nbOfElmts) {
		initialize(nbOfElmts);
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
	 * Initialize the contents of the frame.
	 * @param nbOfElmts the number of registrations to display in the windows
	 */
	private void initialize(int nbOfElmts) {
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
		lblNewLabel_2.setIcon(new ImageIcon("C:\\\\Users\\\\Serafini Thibault\\\\Desktop\\\\Eclipse\\\\ARMADA 2023\\\\src\\\\GUI\\\\Esigelec.png"));
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
				retour();
		}});
		btnNewButton_1.setBounds(10, 527, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.addActionListener(new ActionListener() { //This display a new windows without a "next" button that contains information not displayed on the previous windows
			public void actionPerformed(ActionEvent e) {
				ArrayList<Inscription> list = InscriptionDAO.getList();
				RequestsForRegistrationWithoutNext  window = new RequestsForRegistrationWithoutNext (1,26);
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				window.getFrame().setLocation((screen.width - window.getFrame().getSize().width)/2,(screen.height - window.getFrame().getSize().height)/2);
				window.getFrame().setVisible(true);
			}
		});
		btnSuivant.setBounds(378, 527, 156, 23);
		frame.getContentPane().add(btnSuivant);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 864, 436);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1); //resizing the attendees table
		ArrayList<Inscription> list = InscriptionDAO.getList();
		String[][] ListOfAttendees = new String[nbOfElmts][4];		//A multi-dim array that contains information of all registrations
		int cpt =0;						//iterate after each inscription i
		for(Inscription i : list){
					ListOfAttendees[cpt][0] = i.getParticipant().getProfile();
					ListOfAttendees[cpt][1] = i.getParticipant().getPersonneMorale().getFirstName()+" "+i.getParticipant().getPersonneMorale().getName(); 
					ListOfAttendees[cpt][2] = i.getParticipant().getPersonneMorale().getEmail();
					ListOfAttendees[cpt][3] = null;
					cpt++;
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
		table_1.getColumnModel().getColumn(1).setPreferredWidth(127);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(123);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(96);
		table_1.getColumnModel().getColumn(3).setMinWidth(116);
		table_1.getColumnModel().getColumn(3).setMaxWidth(2147483646);
		
		JButton btnValiderSaisie = new JButton("Valider la saisie");
		btnValiderSaisie.addActionListener(new ActionListener() {
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
					for(int ligne=0; ligne<26; ligne++)
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
		btnValiderSaisie.setBounds(745, 527, 129, 23);
		frame.getContentPane().add(btnValiderSaisie);
	}
}
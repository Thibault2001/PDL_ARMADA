package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;

import DAO.CompteDAO;
import DAO.InscriptionDAO;
import DAO.ParticipantDAO;
import DAO.PersonneMoraleDAO;
import Tronc_commun.*;

import javax.swing.JScrollPane;

/**
*Classe permettant d'afficher une fenetre contenant la liste des demandes d'inscription pour modification
* 
* @author SERAFINI Thibault & TEGUE Elisée
* @version 1.0
* */

public class UpdateRequests {
	
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRequests window = new UpdateRequests();
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					window.frame.setLocation((screen.width - window.frame.getSize().width)/2,(screen.height - window.frame.getSize().height)/2);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Constructor
	 * 
	 * @param position cet entier indique si la fenetre est la toute première à etre affichée ou elle est affichée à la suite d'une autre
	 * @param nbOfElmts le nombre d'élements (demandes d'inscription) que contient la fenetre
	 */
	public UpdateRequests () {
		initialize();
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
	private void initialize() {
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
		String[][] ListOfAttendees = new String[Math.min(list.size(), 26)][4];
		int cpt=0; 	//initialisation
			for(Inscription i : list){
						ListOfAttendees[cpt][0] = i.getParticipant().getProfile();
						ListOfAttendees[cpt][1] = i.getParticipant().getPersonneMorale().getFirstName()+" "+i.getParticipant().getPersonneMorale().getName(); 
						ListOfAttendees[cpt][2] = i.getParticipant().getPersonneMorale().getEmail();
						cpt++;
			}

	
	
		table_1.setModel(new DefaultTableModel(ListOfAttendees,
				new String[] {
						"Profil", "Nom complet personne morale", "email "
					}		
				){
			boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		table_1.setColumnSelectionAllowed(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(127);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(123);
		
		JButton btnModifier = new JButton("Modifier cette demande");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(table_1.getSelectedRow()!=-1)
								{
									/*//creation du participant et ajout de celui dans la table participant  
									PersonneMoraleDAO persMorDAO = new PersonneMoraleDAO();
									String[] Infos = persMorDAO.getInfosPM(table_1.getValueAt(table_1.getSelectedRow(),2).toString());
									PersonneMorale PersMor = new PersonneMorale(Integer.valueOf(Infos[0]), null, null, null, table_1.getValueAt(table_1.getSelectedRow(),2).toString(), null);
									Participant addedParticip = new Participant(0, table_1.getValueAt(table_1.getSelectedRow(),0).toString(), PersMor);
									ParticipantDAO participantDAO = new ParticipantDAO();
									participantDAO.add(addedParticip);*/
									
									//Obtention de l'id de l'inscription 
									InscriptionDAO inscriptionDAO = new InscriptionDAO();
									int idInsc = inscriptionDAO.getId(table_1.getValueAt(table_1.getSelectedRow(),2).toString());
									
									//ouverture de la fenetre de modification de l'inscription relative a cet id
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												UpdateRequestForm window = new UpdateRequestForm(idInsc);
												Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
												window.getFrame().setLocation((screen.width - window.getFrame().getSize().width)/2,(screen.height - window.getFrame().getSize().height)/2);
												window.getFrame().setVisible(true);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
					}
						else
						{
							JFrame frame3 = new JFrame();	
							JOptionPane.showMessageDialog(frame3, "Veuillez s\u00E9lectionner une demande d'inscription", "Erreur", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			);
			btnModifier.setBounds(682, 527, 192, 23);
			frame.getContentPane().add(btnModifier);
		}
	}
	
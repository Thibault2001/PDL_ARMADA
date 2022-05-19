package GUI;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import DAO.InscriptionDAO;
import Tronc_commun.*;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ListOfAttendees {
	
	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ListOfAttendees window = new ListOfAttendees();
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					window.frame.setLocation((screen.width - window.frame.getSize().width)/2,(screen.height - window.frame.getSize().height)/2);
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
	public ListOfAttendees() {
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
		String chemin = "Esig_real.png";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel_2.setIcon(new ImageIcon(resource));
		lblNewLabel_2.setIcon(new ImageIcon(resource));
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel_2.setBounds(0, 0, 168, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblInscription = new JLabel("Liste des demandes d'inscription");
		lblInscription.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblInscription.setBounds(289, 43, 318, 26);
		frame.getContentPane().add(lblInscription);
		
		JButton btnAnnuler = new JButton("Suivant");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitter(); // this method is previously declared (the same method is called with the "S'inscrire" button)
			}
		});
		btnAnnuler.setBounds(785, 527, 89, 23);
		frame.getContentPane().add(btnAnnuler);
		
		JButton btnNewButton_1 = new JButton("Retour\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FaireDemande(); // this method is previously declared (the same method is called with the "S'inscrire" button)
			}
		});
		btnNewButton_1.setBounds(10, 527, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnValiderLaSaisie = new JButton("Valider la saisie");
		btnValiderLaSaisie.setBounds(378, 527, 156, 23);
		frame.getContentPane().add(btnValiderLaSaisie);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 864, 436);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1); //resizing the attendees table
		ArrayList<Inscription> list = InscriptionDAO.getList();
		int nbInsc = list.size();
		String[][] ListOfAttendees = new String[26][4];		//A multi-dim array that contains information of all registrations
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
				));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(127);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(123);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(96);
		table_1.getColumnModel().getColumn(3).setMinWidth(116);
		table_1.getColumnModel().getColumn(3).setMaxWidth(2147483646);
	}
}
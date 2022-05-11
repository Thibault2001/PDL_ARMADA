package GUI.Zone;

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

import javax.swing.table.DefaultTableModel;

import DAO.*;
import Lot1.Zone;
import Tronc_commun.*;


import javax.swing.JScrollPane;

/**
 *Classe permettant d'afficher une fenetre contenant la liste des zones
 * 
 * @author SERAFINI Thibault & TEGUE Elisée
 * @version 1.0
 * */

public class ListeZone {

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
					ListeZone window = new ListeZone();
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					window.getFrame().setLocation((screen.width - window.getFrame().getSize().width)/2,(screen.height - window.frame.getSize().height)/2);
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
	public ListeZone() {
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
		lblNewLabel_2.setIcon(new ImageIcon("C:/Users/Serafini%20Thibault/Desktop/Eclipse/ARMADA%202023/src/GUI/Esigelec.png"));
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		lblNewLabel_2.setBounds(0, 0, 168, 40);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblInscription = new JLabel("Liste des zones");
		lblInscription.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblInscription.setBounds(377, 43, 146, 26);
		frame.getContentPane().add(lblInscription);

		JButton btnNewButton_1 = new JButton("Retour\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retour(); // cette méthode précédemment déclarée est appelée lors du click sur le bouton "retour" et permet de fermer la fenetre
			}
		});
		btnNewButton_1.setBounds(399, 527, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 864, 436);
		frame.getContentPane().add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1); //Redimensionne la table des demandes d'inscription
		ZoneDAO zoneDAO = new ZoneDAO();
		ArrayList<Zone> list = zoneDAO.getList();
		String[][] ListeZones = new String[Math.min(list.size(), 26)][5];
		int cpt=0; 	//initialisation
		for(Zone z : list){
			ListeZones[cpt][0] = z.getNomZone();
			ListeZones[cpt][1] = z.getTypeZone(); 
			ListeZones[cpt][2] = z.getPlageHoraire();
			ListeZones[cpt][3] = String.valueOf(z.getPlaceParking());
			ListeZones[cpt][4] = String.valueOf(z.getNbrPlaceReserve());
			cpt++;
		}



		table_1.setModel(new DefaultTableModel(ListeZones,
				new String[] {
						"Nom", "Type", "Plage horaire", "Nombre de places parking", "Nombre de places reservees"
		}		
				){
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.setColumnSelectionAllowed(false);

		JButton btnSupprimer = new JButton("Supprimer\r\n");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Zone zone = new Zone (table_1.getValueAt(table_1.getSelectedRow(),0).toString(),Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(),3).toString()), table_1.getValueAt(table_1.getSelectedRow(),2).toString(), table_1.getValueAt(table_1.getSelectedRow(),1).toString(), Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(),4).toString()));
					new ZoneDAO().delete(zone);
			}
		});
		btnSupprimer.setBounds(736, 528, 124, 23);
		frame.getContentPane().add(btnSupprimer);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(127);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(123);
	}
}


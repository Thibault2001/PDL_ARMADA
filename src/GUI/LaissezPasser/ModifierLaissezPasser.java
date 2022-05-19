package GUI.LaissezPasser;

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
import Lot1.LaissezPasser;
import Tronc_commun.*;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
*Classe permettant de modifier un laissez-passer
* 
* @author SERAFINI Thibault & TEGUE Elisée
* @version 1.0
* */

public class ModifierLaissezPasser {
	
	private JFrame frame;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
					ModifierLaissezPasser window = new ModifierLaissezPasser();
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
	 * @param nbOfElmts le nombre d'élements (de laissez-passer) que contient la fenetre
	 */
	public ModifierLaissezPasser() {
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
	 * @param nbOfElmts le nombre d'élements (de laissez-passer) que contient la fenetre
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
		
		JLabel lblInscription = new JLabel("Liste des laissez-passer");
		lblInscription.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblInscription.setBounds(338, 42, 224, 26);
		frame.getContentPane().add(lblInscription);
		
		JButton btnNewButton_1 = new JButton("Retour\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retour(); // cette méthode précédemment déclarée est appelée lors du click sur le bouton "retour" et permet de fermer la fenetre
			}
		});
		btnNewButton_1.setBounds(399, 527, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane table = new JScrollPane();
		table.setBounds(10, 325, 864, 191);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table.setViewportView(table_1); //Redimensionne la table des laissez passer
		LaissezPasserDAO laissezPasserDAO = new LaissezPasserDAO();
		ArrayList<LaissezPasser> listLP = laissezPasserDAO.getList();
		String[][] listeLaissezPasser = new String[Math.min(listLP.size(), 26)][4];
		int cpt=0; 	//initialisation
			for(LaissezPasser lp : listLP){
				listeLaissezPasser[cpt][0] = lp.getNomLP();
				listeLaissezPasser[cpt][1] = lp.getPrenomLP();
				listeLaissezPasser[cpt][2] = lp.getEntrepriseLP();
				listeLaissezPasser[cpt][3] = lp.getPlageHoraireLP();
						cpt++;
			}

	
	
		table_1.setModel(new DefaultTableModel(listeLaissezPasser,
				new String[] {
						"Nom", "Prenom", "Entreprise", "Plage horaire"
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
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(52, 98, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom");
		lblNewLabel_1_1.setBounds(52, 128, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Entreprise");
		lblNewLabel_1_2.setBounds(52, 151, 89, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Plage Horaire");
		lblNewLabel_1_3.setBounds(52, 174, 89, 13);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(179, 95, 168, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 125, 168, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(179, 148, 168, 19);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(179, 171, 168, 19);
		frame.getContentPane().add(textField_3);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel)table_1.getModel();
				if(table_1.getSelectedRowCount()==1) {
					String nom = textField.getText();
					String prenom =textField_1.getText();
					String entreprise = textField_2.getText();
					String plageHoraire =textField_3.getText();
					
					tblModel.setValueAt(nom, table_1.getSelectedRow(), 0);
					tblModel.setValueAt(prenom, table_1.getSelectedRow(), 0);
					tblModel.setValueAt(entreprise, table_1.getSelectedRow(), 0);
					tblModel.setValueAt(plageHoraire, table_1.getSelectedRow(), 0);
				}
				else {
					if(table_1.getRowCount()==0) {
						JOptionPane.showMessageDialog(null,"tableau vide");
					}
					else {
						JOptionPane.showMessageDialog(null,"Une seule ligne doit etre selectionnee");
					}
				}
			}
			
		});
		btnModifier.setBounds(473, 147, 89, 23);
		frame.getContentPane().add(btnModifier);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(127);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(123);
		
		
		}
	/**
	 * Transmet les infos du tableau à des textFields pour modification
	 * 
	 * @param action de la souris
	 */
	public void jTableSelectionSouris (java.awt.event.MouseEvent evt) {
		
		//modifie les infos dans les textFields
		DefaultTableModel tblModel = (DefaultTableModel)table_1.getModel();
		
		//modifie les infos dans les textFields quand ils sont selectionnes
		String tblNom = tblModel.getValueAt(table_1.getSelectedRow(), 0).toString();
		String tblPrenom = tblModel.getValueAt(table_1.getSelectedRow(), 1).toString();
		String tblEntreprise = tblModel.getValueAt(table_1.getSelectedRow(), 2).toString();
		String tblPlageHoraire = tblModel.getValueAt(table_1.getSelectedRow(), 3).toString();
		
		// modifie les textFields
		textField.setText(tblNom);
		textField_1.setText(tblPrenom);
		textField_2.setText(tblEntreprise);
		textField_3.setText(tblPlageHoraire);
	}
	}
	

package GUI.Zone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.*;
import Lot1.*;
import GUI.*;

public class SupprimerZone 
{

	private JFrame frameSupprimerZone;
	private JTextField textFieldNomZone;
	private JTextField textFieldNbrPlace;
	private JTextField textFieldPlageHoraire;
	private JTextField textFieldTypeZone;
	private JTextField textFieldNbrPlaceReserve;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					SupprimerZone window = new SupprimerZone();
					window.frameSupprimerZone.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupprimerZone() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

private void initialize() {
	frameSupprimerZone = new JFrame();
	frameSupprimerZone.setBounds(100, 100, 587, 386);
	frameSupprimerZone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frameSupprimerZone.getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Nom de la zone \u00E0 supprimer : ");
	lblNewLabel.setBounds(46, 61, 176, 13);
	frameSupprimerZone.getContentPane().add(lblNewLabel);
	
	textFieldNomZone = new JTextField();
	textFieldNomZone.setBounds(406, 58, 96, 19);
	frameSupprimerZone.getContentPane().add(textFieldNomZone);
	textFieldNomZone.setColumns(10);
	
	JLabel lblIndiquerLaPlage = new JLabel("Indiquer la plage horaire (matin ou soir) :\r\n\r\n");
	lblIndiquerLaPlage.setBounds(46, 134, 235, 13);
	frameSupprimerZone.getContentPane().add(lblIndiquerLaPlage);
	
	textFieldPlageHoraire = new JTextField();
	textFieldPlageHoraire.setColumns(10);
	textFieldPlageHoraire.setBounds(406, 131, 96, 19);
	frameSupprimerZone.getContentPane().add(textFieldPlageHoraire);
	
	JLabel lblIndiquerLeNombre = new JLabel("Indiquer le nombre de place :\r\n\r\n\r\n");
	lblIndiquerLeNombre.setBounds(46, 98, 176, 13);
	frameSupprimerZone.getContentPane().add(lblIndiquerLeNombre);
	
	textFieldNbrPlace = new JTextField();
	textFieldNbrPlace.setBounds(406, 95, 96, 19);
	frameSupprimerZone.getContentPane().add(textFieldNbrPlace);
	textFieldNbrPlace.setColumns(10);
	
	JLabel lblTypeDeLa = new JLabel("Type de la zone (locataire ou service public) :");
	lblTypeDeLa.setBounds(46, 168, 261, 13);
	frameSupprimerZone.getContentPane().add(lblTypeDeLa);
	
	textFieldTypeZone = new JTextField();
	textFieldTypeZone.setColumns(10);
	textFieldTypeZone.setBounds(406, 165, 96, 19);
	frameSupprimerZone.getContentPane().add(textFieldTypeZone);
	
	JLabel lblNombreDePlace = new JLabel("Nombre de place r\u00E9serv\u00E9e(s) :");
	lblNombreDePlace.setBounds(46, 201, 196, 13);
	frameSupprimerZone.getContentPane().add(lblNombreDePlace);
	
	textFieldNbrPlaceReserve = new JTextField();
	textFieldNbrPlaceReserve.setColumns(10);
	textFieldNbrPlaceReserve.setBounds(406, 198, 96, 19);
	frameSupprimerZone.getContentPane().add(textFieldNbrPlaceReserve);
	
	JLabel lblNewLabel_1 = new JLabel("Supprimer une zone");
	lblNewLabel_1.setBounds(197, 22, 110, 13);
	frameSupprimerZone.getContentPane().add(lblNewLabel_1);
	
	JButton btnValider = new JButton("Valider");
	btnValider.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			if(textFieldNomZone.getText().length()>0 && textFieldNbrPlace.getText().length()>0 && textFieldNbrPlaceReserve.getText().length()>0 )
			{
				Zone zone = new Zone (textFieldNomZone.getText(),Integer.parseInt(textFieldNbrPlace.getText()), textFieldNbrPlace.getText(), textFieldTypeZone.getText(), Integer.parseInt(textFieldNbrPlaceReserve.getText()));
				new ZoneDAO().delete(zone);
				
				ZoneGUI nextpage = new ZoneGUI();
				nextpage.main(null);
				frameSupprimerZone.dispose();
			}
			else
			{
				SupprimerZone nextpage = new SupprimerZone();
				nextpage.main(null);
				ErrorSaisie nextpage2 = new ErrorSaisie();
				nextpage2.main(null);
				frameSupprimerZone.dispose();
			}
		}
	});
	btnValider.setBounds(406, 274, 134, 44);
	frameSupprimerZone.getContentPane().add(btnValider);
	
	JButton btnRetour = new JButton("Retour");
	btnRetour.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ZoneGUI nextpage = new ZoneGUI();
			nextpage.main(null);
			frameSupprimerZone.dispose();
		}
	});
	btnRetour.setBounds(46, 274, 134, 44);
	frameSupprimerZone.getContentPane().add(btnRetour);
}
}

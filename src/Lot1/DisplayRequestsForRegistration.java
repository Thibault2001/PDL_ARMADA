package Lot1;

import Tronc_commun.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Toolkit;
import GUI.RequestsForRegistrationWithNext;
import GUI.RequestsForRegistrationWithoutNext;
import DAO.*;
/**
 *Classe permettant d'afficher le nombre de fentres appropriées en fonction du nombre de participants
 * 
 * @author SERAFINI Thibault & TEGUE Elisée
 * @version 1.0
 * */
public class DisplayRequestsForRegistration {
	public DisplayRequestsForRegistration()
	{	
		ArrayList<Inscription> list = InscriptionDAO.getList();
		double nbInsc = (double)list.size();
		double nbOfWind = nbInsc/26;
		int nbOfWindRequired = (int) Math.ceil(nbOfWind); //calcul du nombre de fenetre necessaire
			if(nbOfWindRequired==0)
			{
				JFrame frame = new JFrame();	
				JOptionPane.showMessageDialog(frame, "Aucune nouvelle demande d'inscription pour l'instant !");
			}
			/*else if(nbOfWindRequired ==1)	//s'il ne necessite qu'une seule fenetre, afficher une fenetre n'ayant pas de bouton "suivant"
			{
				RequestsForRegistrationWithoutNext  window = new RequestsForRegistrationWithoutNext (0,list.size());
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				window.getFrame().setLocation((screen.width - window.getFrame().getSize().width)/2,(screen.height - window.getFrame().getSize().height)/2);
				window.getFrame().setVisible(true);
			}*/
			else	//sinon, afficher une fenetre avec un bouton "suivant" afin de permettre à l'utilisateur d'afficher la suite de la liste
			{
				RequestsForRegistrationWithNext  window_1 = new RequestsForRegistrationWithNext (26);
				Dimension screen_1 = Toolkit.getDefaultToolkit().getScreenSize();
				window_1.getFrame().setLocation((screen_1.width - window_1.getFrame().getSize().width)/2,(screen_1.height - window_1.getFrame().getSize().height)/2);
				window_1.getFrame().setVisible(true);
			}
	}
}
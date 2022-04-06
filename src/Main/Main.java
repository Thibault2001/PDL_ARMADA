package Main;

import Tronc_commun.*;
import GUI.*;
import DAO.*;
import Lot1.*;

public class Main
{
	public static void main(String[] args) 
	{
		Inscription inscription1 = new Inscription("thib@gmail.com", "23005034", "Thib", "Seraf", "Vendeur", "Aucun", false);
		inscription1.afficher();
		
		
		int returnValue;
		ZoneDAO ZoneDAO = new ZoneDAO();
		// test du constructeur
		Zone z1 = new Zone(1, 10, "matin", "locataire",0);
		/**
		Zone z2 = new Zone("2", 11, "soir", "services publics",5);
		Zone z3 = new Zone("3", 5, "matin", "services publics",10);
		// test de la methode addZone
		returnValue = ZoneDAO.addZone(z1);
		System.out.println(returnValue + " zone ajoutee(s)");
		returnValue = ZoneDAO.addZone(z2);
		System.out.println(returnValue + " zone ajoutee(s)");
		returnValue = ZoneDAO.addZone(z3);
		System.out.println(returnValue + " zone ajoutee(s)");
		System.out.println();
		*/
		//test de la méthode deleteZone
		returnValue = ZoneDAO.deleteZone(z1);
		System.out.println(returnValue + " zone supprimee(s)");
	}

}

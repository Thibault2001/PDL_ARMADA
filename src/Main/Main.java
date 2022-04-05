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
		Zone z1 = new Zone(1, 100, "matin", "locataire",0);
		Zone z2 = new Zone(2, 200, "Soir", "services publics",30);
		Zone z3 = new Zone(3, 300, "matin", "services publics",100);
		// test de la methode add
		returnValue = ZoneDAO.addZone(z1);
		System.out.println(returnValue + " zone ajoutee(s)");
		returnValue = ZoneDAO.addZone(z2);
		System.out.println(returnValue + " zone ajoutee(s)");
		returnValue = ZoneDAO.addZone(z3);
		System.out.println(returnValue + " zone ajoutee(s)");
		System.out.println();
	}

}

package Main;

import Tronc_commun.Bateau;
import Tronc_commun.Compte;
import Tronc_commun.FamilleAccueil;
import Tronc_commun.Inscription;
import Tronc_commun.Organisateur;
import Tronc_commun.Participant;
import Tronc_commun.PersonneMorale;
import Tronc_commun.Vip;


public class Main
{
	public static void main(String[] args) 
	{
		Inscription inscription1 = new Inscription("romain.burguet@groupe-esigelec.org", "17740776", "Romain", "Burguet", "Vendeur de légumes", "Je viens vendre des légumes afin de gagner de l'argent", false);
		inscription1.afficher();
	}

}

package Lot1;

import java.util.*;
import Lot1.*;

public class LaissezPasser {
	private String nomLP;
	private String prenomLP;
	private String metierLP;
	private String entrepriseLP;
	private ArrayList <Vehicule> listeVehicule =new ArrayList <Vehicule> ();
	private String plageHoraireLP;
	private boolean valide;
	private boolean archive;
	
	public LaissezPasser(String nomLP, String prenomLP, String metierLP, String entrepriseLP, ArrayList<Vehicule> listeVehicule, String plageHoraireLP, boolean valide, boolean archive) {
		this.nomLP=nomLP;
		this.prenomLP=prenomLP;
		this.metierLP=metierLP;
		this.entrepriseLP=entrepriseLP;
		this.listeVehicule=listeVehicule;
		this.plageHoraireLP=plageHoraireLP;
		this.valide=valide;
		this.archive=archive;
		
	}
	
}

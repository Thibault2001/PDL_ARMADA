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

	public String getNomLP() {
		return nomLP;
	}

	public void setNomLP(String nomLP) {
		this.nomLP = nomLP;
	}

	public String getPrenomLP() {
		return prenomLP;
	}

	public void setPrenomLP(String prenomLP) {
		this.prenomLP = prenomLP;
	}

	public String getMetierLP() {
		return metierLP;
	}

	public void setMetierLP(String metierLP) {
		this.metierLP = metierLP;
	}

	public String getEntrepriseLP() {
		return entrepriseLP;
	}

	public void setEntrepriseLP(String entrepriseLP) {
		this.entrepriseLP = entrepriseLP;
	}

	public ArrayList<Vehicule> getListeVehicule() {
		return listeVehicule;
	}

	public void setListeVehicule(ArrayList<Vehicule> listeVehicule) {
		this.listeVehicule = listeVehicule;
	}

	public String getPlageHoraireLP() {
		return plageHoraireLP;
	}

	public void setPlageHoraireLP(String plageHoraireLP) {
		this.plageHoraireLP = plageHoraireLP;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	
}

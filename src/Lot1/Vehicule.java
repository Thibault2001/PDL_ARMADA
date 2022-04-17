package Lot1;

public class Vehicule {
	private int idVehicule;
	private String immatriculation;
	private String modele;
	private double longueur;
	private double largeur;
	
	public Vehicule(String immatriculation, String modele, double longueur, double largeur) {
		this.immatriculation=immatriculation;
		this.modele=modele;
		this.longueur=longueur;
		this.largeur=largeur;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public int getIdVehicule() {
		return idVehicule;
	}
}

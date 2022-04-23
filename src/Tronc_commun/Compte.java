package Tronc_commun;

/**
 * Classe Compte
 * @author SERAFINI Thibault & Elisée TEGUE 
 * @version 1.2
 * */
public class Compte {
	/** 
	 * identifiant du compte
	 */
	private String identifiant;
	/**
	 *mot de passe du compte
	 */
	private String mdp;	
	
	/**
	 * Constructeur
	 * @param idPM identifiant de la personne morale
	 * @param name nom 
	 * @param firstName prenom
	 * @param email adresse mail
	 */
	public Compte(String identifiant, String mdp) {
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	/**
	 * getter pour l'attribut identifiant
	 * @return valeur de l'identifiant du compte
	 */
	public String getIdentifiant() {
		return identifiant;
	}
	/**
	 * getter pour l'attribut mot de passe
	 * @return valeur du mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * setter pour l'attribut identifiant
	 * @param name : nouvelle valeur de l'identifiant
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	/**
	 * setter pour l'attribut mdp
	 * @param address : nouvelle valeur du mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
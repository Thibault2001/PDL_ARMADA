package Tronc_commun;

/**
 * Classe Supplier
 * @author ESIGELEC - TIC Department
 * @version 1.2
 * */
public class Participant {
	/** 
	 * reference du participant
	 */
	private int id;
	/**
	 * profil
	 */
	private String profile;	
	/**
	 * personneMorale
	 */
	private PersonneMorale personneMorale;	
	/**
	 * Constructor
	 * @param id identifiant du participant
	 * @param profile profil du participant
	 */
	public Participant(int id, String profile, PersonneMorale personneMorale) {
		this.id = id;
		this.profile = profile;
		this.personneMorale = personneMorale;
	}
	/**
	 * getter pour l'attribut reference
	 * @return valeur de la reference du participant
	 */
	public int getId() {
		return id;
	}
	/**
	 * getter pour l'attribut name
	 * @return valeur du nom
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * setter pour l'attribut profile
	 * @param profile : nouvelle valeur du nom du fournisseur
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

}

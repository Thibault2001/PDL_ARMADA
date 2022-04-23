package Tronc_commun;

/**
 * Classe Supplier
 * @author ESIGELEC - TIC Department
 * @version 1.2
 * */
public class PersonneMorale {
	/** 
	 * reference du participant
	 */
	private int idPM;
	/**
	 * nom
	 */
	private String name;	
	/**
	 * prenom
	 */
	private String firstName;	
	/**
	 * email
	 */
	private String email;
	/**
	/**
	 * @param idPM identifiant de la personne morale
	 * @param name nom 
	 * @param firstName prenom
	 * @param email adresse mail
	 */
	public PersonneMorale(int idPM, String name, String firstName, String email) {
		this.idPM = idPM;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
	}
	/**
	 * getter pour l'attribut reference
	 * @return valeur de la reference fournisseur
	 */
	public int getIdPM() {
		return idPM;
	}
	/**
	 * getter pour l'attribut name
	 * @return valeur du nom
	 */
	public String getName() {
		return name;
	}
	/**
	 * setter pour l'attribut name
	 * @param name : nouvelle valeur du nom du participant
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter pour l'attribut firstName
	 * @return valeur du prénom du participant
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * setter pour l'attribut firstName
	 * @param address : nouvelle valeur du prénom du participant
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * getter pour l'attribut email
	 * @return valeur de l'adresse mail
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * setter pour l'attribut email
	 * @param email : nouvelle valeur de l'adresse mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
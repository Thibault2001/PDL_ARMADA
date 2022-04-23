package Tronc_commun;

/**
 * Classe Organisateur
 * @param prenomOrganisateur
 * @param nomOrganisateur
 * @param idOrganisateur
 * @author SERAFINI Thibault & TEGUE YOMBI
 * @version 1.0
 */

public class Organisateur 
{
	/**
	 * email de l'organisateur
	 */
	String emailOrganisateur;
	/**
	 * prenom de l'organisateur
	 */
	private String prenomOrganisateur;
	
	/**
	 * nom de l'organisateur
	 */
	private String nomOrganisateur;
	
	/**
	 * identifiant de l'organisateur
	 */
	private int idOrganisateur;
	
	/**
	 * Constructeur de la classe Organisateur
	 * @param prenomOrganisateur
	 * @param nomOrganisateur
	 * @param idOrganisateur
	 */
	// CONSTRUCTEUR
	public Organisateur(String emailOrganisateur, String prenomOrganisateur, String nomOrganisateur, int idOrganisateur)
	{
		this.emailOrganisateur = emailOrganisateur;
		this.prenomOrganisateur = prenomOrganisateur;
		this.nomOrganisateur = nomOrganisateur;
		this.idOrganisateur = idOrganisateur;
	}
	
	
	// GETTER
	/**
	 * getter attribut emailOrganisateur
	 */
	public String getEmailOrganisateur() {
		// TODO Auto-generated method stub
		return emailOrganisateur;
	}
	
	/**
	 * getter attribut prenomOrganisateur
	 */
	public String getPrenomOrganisateur()
	{
		return this.prenomOrganisateur;
	}
	
	/**
	 * getter attribut nomOrganisateur
	 */
	public String getNomOrganisateur()
	{
		return this.nomOrganisateur;
	}
	
	/**
	 * getter attribut idOrganisateur
	 */
	public int getIdOrganisateur()
	{
		return this.idOrganisateur;
	}
	
	
	// SETTER
	/**
	 * setter attribut prenomOrganisateur
	 */
	public void setPrenomOrganisateur(String prenomOrganisateur)
	{
		this.prenomOrganisateur = prenomOrganisateur;
	}
	
	/**
	 * setter attribut nomOrganisateur
	 */
	public void setNomOrganisateur(String nomOrganisateur)
	{
		this.nomOrganisateur = nomOrganisateur;
	}
	
	/**
	 * setter attribut idOrganisateur
	 */
	public void setIdOrganisateur(int idOrganisateur)
	{
		this.idOrganisateur = idOrganisateur;
	}
}
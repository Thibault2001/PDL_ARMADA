package Tronc_commun;

/**
 * Classe Organisateur
 * @param prenomOrganisateur
 * @param nomOrganisateur
 * @param idOrganisateur
 * @author Romain
 * @version 1.0
 */

public class Organisateur 
{
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
	private String idOrganisateur;
	
	/**
	 * Constructeur de la classe Organisateur
	 * @param prenomOrganisateur
	 * @param nomOrganisateur
	 * @param idOrganisateur
	 */
	// CONSTRUCTEUR
	public Organisateur(String prenomOrganisateur, String nomOrganisateur, String idOrganisateur)
	{
		this.prenomOrganisateur = prenomOrganisateur;
		this.nomOrganisateur = nomOrganisateur;
		this.idOrganisateur = idOrganisateur;
	}
	
	
	// GETTER
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
	public String getIdOrganisateur()
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
	public void setIdOrganisateur(String idOrganisateur)
	{
		this.idOrganisateur = idOrganisateur;
	}
	
	
	// AUTRES METHODES
}

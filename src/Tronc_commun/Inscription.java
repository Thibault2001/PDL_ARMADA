package Tronc_commun;

/**
 * Classe Inscription
 * @param mailInscription
 * @param idInscription
 * @param prenomInscription
 * @param nomInscription
 * @param activite
 * @param motivation
 * @param validation
 * @author Romain
 * @version 1.0
 */

public class Inscription 
{
	/**
	 * adresse mail de l'inscrit
	 */
	private String mailInscription;
	
	/**
	 * Identifiant de l'inscrit
	 */
	private String idInscription;
	
	/**
	 * prenom de l'inscrit
	 */
	private String prenomInscription;
	
	/**
	 * nom de l'inscrit
	 */
	private String nomInscription;
	
	/**
	 * activité de l'inscrit
	 */
	private String activite;
	
	/**
	 * motivation de l'inscrit
	 */
	private String motivation;
	
	/**
	 * état de l'inscription
	 */
	private boolean validation;
	
	/**
	 * Constructeur de la classe Inscription
	 * @param mailInscription
	 * @param idInscription
	 * @param prenomInscription
	 * @param nomInscription
	 * @param activite
	 * @param motivation
	 * @param validation
	 */
	// CONSTRUCTEUR
	public Inscription(String mailInscription, String idInscription, String prenomInscription, String nomInscription, String activite, String motivation, boolean validation)
	{
		this.mailInscription = mailInscription;
		this.idInscription = idInscription;
		this.prenomInscription = prenomInscription;
		this.nomInscription = nomInscription;
		this.activite = activite;
		this.motivation = motivation;
		this.validation = validation;
	}
	
	
	// GETTER
	/**
	 * getter attribut mailInscription
	 */
	public String getMailInscription()
	{
		return this.mailInscription;
	}
	
	/**
	 * getter attribut idInscription
	 */
	public String getIdInscription()
	{
		return this.idInscription;
	}
	
	/**
	 * getter attribut prenomInscription
	 */
	public String getPrenomInscription()
	{
		return this.prenomInscription;
	}
	
	/**
	 * getter attribut nomInscription
	 */
	public String getNomInscription()
	{
		return this.nomInscription;
	}
	
	/**
	 * getter attribut activite
	 */
	public String getActivite()
	{
		return this.activite;
	}
	
	/**
	 * getter attribut motivation
	 */
	public String getMotivation()
	{
		return this.motivation;
	}
	
	/**
	 * getter attribut validation
	 */
	public boolean getValidation()
	{
		return this.validation;
	}
	
	//SETTER
	/**
	 * setter attribut mailInscription
	 */
	public void setMailInscription(String mailInscription)
	{
		this.mailInscription = mailInscription;
	}
	
	/**
	 * setter attribut idInscription
	 */
	public void setIdInscription(String idInscription)
	{
		this.idInscription = idInscription;
	}
	
	/**
	 * setter attribut prenomInscription
	 */
	public void setPrenomInscription(String prenomInscription)
	{
		this.prenomInscription = prenomInscription;
	}
	
	/**
	 * setter attribut nomInscription
	 */
	public void setNomInscription(String nomInscription)
	{
		this.nomInscription = nomInscription;
	}
	
	/**
	 * setter attribut activite
	 */
	public void setActivite(String activite)
	{
		this.activite = activite;
	}
	
	/**
	 * setter attribut motivation
	 */
	public void setmotivation(String motivation)
	{
		this.motivation = motivation;
	}
	
	
	// AUTRES METHODES
	/**
	 * Fonction validerInscription
	 */
	public void validerInscription(boolean validation)
	{
		this.validation = true;
	}
	
	/**
	 * Fonction supprimerInscription
	 */
	public void supprimerInscription(boolean validation)
	{
		// à faire
	}
	
	/**
	 * Fonction afficher
	 */
	public void afficher()
	{
		System.out.println("Participant" + "\nAdresse mail : " + mailInscription + "\nIdentifiant : " + idInscription + "\nPrenom : " + prenomInscription + "\nNom : " + nomInscription + "\nActivité : " + activite + "\nMotivation : " + motivation + "\nValidation de l'inscription : " + validation);
	}
}

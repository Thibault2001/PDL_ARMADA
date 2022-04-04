package Tronc_commun;

/**
 * Classe Compte
 * @param idCompte
 * @param mdpCompte
 * @param mailCompte
 * @author Romain
 * @version 1.0
 */

public class Compte
{
	/**
	 * Identifiant du compte
	 */
	private String idCompte;
	
	/**
	 * Mot de passe du compte
	 */
	private String mdpCompte;
	
	/**
	 * Adresse mail du compte
	 */
	private String mailCompte;
	
	
	/**
	 * Constructeur de la classe Compte
	 * @param idCompte
	 * @param mdpCompte
	 * @param mailCompte
	 */
	// CONSTRUCTEUR
	public Compte(String idCompte, String mdpCompte, String mailCompte)
	{
		this.idCompte = idCompte;
		this.mdpCompte = mdpCompte;
		this.mailCompte = mailCompte;
	}
	
	
	// GETTER
	/**
	 * getter attribut idCompte
	 */
	public String getIdCompte()
	{
		return this.idCompte;
	}
	
	/**
	 * getter attribut mdpCompte
	 */
	public String getMdpCompte()
	{
		return this.mdpCompte;
	}
	
	/**
	 * getter attribut mailCompte
	 */
	public String getMailCompte()
	{
		return this.mailCompte;
	}
	
	
	// SETTER 
	/**
	 * setter attribut idCompte
	 */
	public void setIdCompte(String idCompte)
	{
		this.idCompte = idCompte;
	}
	
	/**
	 * setter attribut mdpCompte
	 */
	public void setMotDePasse(String mdpCompte)
	{
		this.mdpCompte = mdpCompte;
	}
	
	/**
	 * setter attribut mailCompte
	 */
	public void setMailCompte(String mailCompte)
	{
		this.mailCompte = mailCompte;
	}
	
	
	// AUTRES METHODES
	/**
	 * Fonction connexionCompte
	 */
	public void connexionCompte()
	{
		// à faire
	}
	
	/**
	 * Fonction modifierCompte
	 */
	public void modifierCompte()
	{
		// à faire
	}
	
	/**
	 * Fonction supprimerCompte
	 */
	public void supprimerCompte()
	{
		// à faire
	}
	
	/**
	 * Fonction déconnexionCompte
	 */
	public void deconnexionCompte()
	{
		// à faire
	}
	
	/**
	 * Fonction afficher
	 */
	public void afficher()
	{
		System.out.println("Participant" + "\nIdCompte : " + idCompte + "\nMot de passe : " + mdpCompte + "\nAdresse mail : " + mailCompte);
	}
}

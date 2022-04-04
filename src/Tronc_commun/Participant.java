package Tronc_commun;

/**
 * Classe Participant
 * @param profil
 * @param idParticipant
 * @author Romain
 * @version 1.0
 */

public class Participant 
{
	/**
	 * profil du participant
	 */
	protected String profil;
	
	/**
	 * identifiant du participant
	 */
	protected String idParticipant;
	
	/**
	 * personne morale associée au participant
	 */
	private PersonneMorale personneMorale = new PersonneMorale();
	
	// CONSTRUCTEUR
	/**
	 * Constructeur de la classe Participant
	 * @param profil
	 * @param idParticipant
	 */
	public Participant(String profil, String idParticipant)
	{
		this.profil = profil;
		this.idParticipant = idParticipant;
	}
	
	
	// GETTER
	/**
	 * getter attribut profil
	 */
	public String getProfil()
	{
		return this.profil;
	}
	
	/**
	 * getter attribut idParticipant
	 */
	public String getIdParticipant()
	{
		return this.idParticipant;
	}
	
	
	// SETTER
	/**
	 * setter attribut profil
	 */
	public void setProfil(String profil)
	{
		this.profil = profil;
	}
	
	/**
	 * setter attribut idParticipant
	 */
	public void setIdParticipant(String idParticipant)
	{
		this.idParticipant = idParticipant;
	}
	
	
	// AUTRES METHODES
	/**
	 * Fonction supprimerParticipant
	 */
	public void supprimerParticipant()
	{
		// à faire
	}
	
	/**
	 * Fonction afficher
	 */
	public void afficher()
	{
		System.out.println("Participant" + "\nProfil : " + profil + "\nIdParticipant : " + idParticipant);
		personneMorale.afficher();
	}
}

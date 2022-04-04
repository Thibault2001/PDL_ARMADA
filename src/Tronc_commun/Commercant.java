package Tronc_commun;
/**
 * classe commer�ant
 * @author William
 * @param activite
 * @version 1.0
 */

public class Commercant extends Participant
{
	/**
	 * activit� de l'entreprise
	 */
	private String activite;
	
	/**
	 * Constructeur de la classe Commercant
	 * @param activite
	 */
	public Commercant(String profil, String idParticipant, String activite)
	{
		super(profil, idParticipant);
		this.activite = activite;
	}
	
	/**
	 * Getter attribut activite
	 */
	public String getNomEntreprise()
	{
		return activite;
	}
	
	/**
	 * Setter attribut activite
	 */
	public void setActivite(String activite) 
	{
		this.activite = activite;
	}
	
	/**
	 * fonction modifier qui permet de modifier n'importe quel attribut
	 */
	public void modifier() 
	{
		System.out.print("Attribut a modifier: 1=activite");
		//a faire
	}
	
	/**
	 * fonction afficher 
	 */
	public void afficher() 
	{
		super.afficher();
		System.out.println("Commer�ant : Activite : "+activite);
	}
}



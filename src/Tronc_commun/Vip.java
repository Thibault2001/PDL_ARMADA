package Tronc_commun;

/**
 * Classe Vip
 * @param isVip 
 * @author Lilian
 * @version 1.0
 */

public class Vip extends Participant
{
	/**
	 * Attribut isVip 
	 */
	private boolean isVip;
	
	/**
	 * Constructeur de la classe Vip
	 * @param isVip 
	 */
	public Vip(String profil, String idParticipant, boolean isVip) 
	{
		super(profil, idParticipant);
		this.isVip=isVip;
	}
	
	/**
	 * getter attribut isVip
	 */
	public boolean getIsVip() 
	{
		return isVip;
	}
	
	/**
	 * setter attribut isVip
	 */
	public void setIsVip(boolean isVip)
	{
		this.isVip=isVip;
	}
	
	/**
	 * Fonction modifier
	 */
	public void modifier() 
	{
	}
	
	/**
	 * Fonction display
	 */
	public void afficher() 
	{
		super.afficher();
		System.out.print("Est Vip : "+ isVip);
	}
}

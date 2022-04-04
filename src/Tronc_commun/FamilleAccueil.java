package Tronc_commun;

/**
 * Classe FamilleAccueil
 * @param nombreDePlace 
 * @author lilian
 * @version 1.0
 */

public class FamilleAccueil extends Participant
{
	/**
	 * Nombre de place
	 */
	private int nombreDePlace ;
	
	private Adresse adresse = new Adresse();
	
	/**
	 * Constructeur de la classe FamilleAccueil
	 * @param nombreDePlace 
	 */
	public FamilleAccueil(String profil, String idParticipant, int nombreDePlace) 
	{
		super(profil, idParticipant);
		this.nombreDePlace=nombreDePlace;
	}
	
	/**
	 * getter attribut nombreDePlace
	 */
	public int getNombreDePlace() 
	{
		return nombreDePlace;
	}
	
	/**
	 * setter attribut nombreDePlace
	 */
	public void setNombreDePlace(int nombreDePlace) 
	{
		this.nombreDePlace=nombreDePlace;
	}
	
	/**
	 * Fonction modifier
	 */
	public void modifier() 
	{
	}
	
	/**
	 * Fonction afficher
	 */
	public void afficher() 
	{
		super.afficher();
		adresse.afficher();
		System.out.print("Nombre de place : "+ nombreDePlace);
	}
}

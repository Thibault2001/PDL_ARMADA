package Tronc_commun;

/**
 * Classe Delegation 
 * 
 * @param pays
 * @param nombreDePersonne
 * @author Romain
 * @version 1.0
 *
 */

public class Delegation extends Participant
{
	/**
	 * Pays associé à la délégation
	 */
	private String pays;
	/**
	 * Nombre de membres dans la délégation
	 */
	private int nombreDePersonne;
	
	
	/**
	 * Constructeur de la classe Delegation
	 * @param pays
	 * @param nombreDePersonne
	 */
	public Delegation(String profil, String idParticipant,String pays, int nombreDePersonne)
	{
		super(profil, idParticipant);
		this.pays=pays;
		this.nombreDePersonne = nombreDePersonne;
	}
	
	/**
	 * Getter attribut pays
	 */
	public String getPays()
	{
		return pays;
	}
	
	/**
	 * getter attribut nombreDePersonne
	 */
	public int getNombreDePersonne() 
	{
		return nombreDePersonne;
	}
	
	/**
	 * Setter attribut pays
	 */
	public void setPays(String pays)
	{
		this.pays=pays;
	}
	
	/**
	 * Setter attribut nombreDePersonne
	 */
	public void setNombreDePersonne(int nombredePersonne)
	{
		this.nombreDePersonne = nombredePersonne;
	}
	
	/**
	 * fonction modifier qui permet de modifier n'importe quel attribut
	 */
	public void modifier() 
	{
		//a faire
	}
	
	/**
	 * fonction afficher 
	 */
	public void afficher() 
	{
		super.afficher();
		System.out.println("Délégation : Pays : "+ pays +" , Nombre de Personnes : " + nombreDePersonne);
	}

}

package Tronc_commun;

/**
 * @param nomEntreprise
 * @param numeroImmatriculation
 * @author Lilian
 * @version 1.0
 */

public class Entreprise extends Participant
{
	/**
	 * nom associé à l'entreprise
	 */
	private String nomEntreprise;
	/**
	 * Numéro d'immatriculation de l'entreprise
	 */
	private String numeroImmatriculation;
	
	
	/**
	 * Constructeur de la classe Entreprise
	 * @param nomEntreprise
	 * @param numeroImmatriculation
	 */
	public Entreprise(String profil, String idParticipant,String nomEntreprise, String numeroImmatriculation)
	{
		super(profil, idParticipant);
		this.nomEntreprise = nomEntreprise;
		this.numeroImmatriculation = numeroImmatriculation;
	}
	
	/**
	 * Getter attribut nomEntreprise
	 */
	public String getNomEntreprise()
	{
		return nomEntreprise;
	}
	
	/**
	 * getter attribut numeroImmatriculation
	 */
	public String getNumeroImmatriculation()
	{
		return numeroImmatriculation;
	}
	
	/**
	 * Setter attribut pays
	 */
	public void setNomEntreprise(String nomEntreprise)
	{
		this.nomEntreprise = nomEntreprise;
	}
	
	/**
	 * Setter attribut numeroImmatriculation
	 */
	public void setNumeroImmatriculation(String numeroImmatriculation)
	{
		this.numeroImmatriculation = numeroImmatriculation;
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
		System.out.println("Entreprise : Nom : "+nomEntreprise+" , Numéro Immatriculation : "+numeroImmatriculation);
	}

}


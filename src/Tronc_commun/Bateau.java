package Tronc_commun;

/**
 * Classe Bateau
 * @param nomBateau
 * @param tailleBateau
 * @param pavillon
 * @author lilian
 * @version 1.0
 */

public class Bateau extends Participant
{
	/**
	 * Nom du bateau
	 */
	private String nomBateau;
	
	/**
	 * Taille du bateau
	 */
	private double tailleBateau;
	
	/**
	 * Pavillon du bateau
	 */
	private String pavillon;
	
	/**
	 * Constructeur de la classe Bateau
	 * @param nomBateau
	 * @param tailleBateau
	 * @param pavillon
	 */
	
	public Bateau(String profil, String idParticipant, String nomBateau, double tailleBateau, String pavillon) 
	{
		super(profil, idParticipant);
		this.nomBateau=nomBateau;
		this.tailleBateau=tailleBateau;
		this.pavillon=pavillon;
	}
	
	/**
	 * getter attribut nomBateau
	 */
	public String getNomBateau() 
	{
		return nomBateau;
	}
	
	/**
	 * getter attribut tailleBateau
	 */
	public double getTailleBateau() 
	{
		return tailleBateau;
	}
	/**
	 * getter attribut pavillon
	 */
	public String getPavillon()
	{
		return pavillon;
	}
	
	/**
	 * setter attribut nomBateau
	 */
	public void setNomBateau(String nomBateau) 
	{
		this.nomBateau=nomBateau;
	}

	/**
	 * setter attribut tailleBateau
	 */
	public void setTailleBateau(double tailleBateau) 
	{
		this.tailleBateau=tailleBateau;
	}
	
	/**
	 * setter attribut dateDeNaissance
	 */
	public void setPavillon(String pavillon) 
	{
		this.pavillon=pavillon;
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
		System.out.println("Nom du bateau : "+ nomBateau + "Taille du bateau : " + tailleBateau + "Pavillon du bateau : " + pavillon);
	}
}

package Tronc_commun;

/**
 * Classe PersonneMorale
 * @param nom
 * @param prenom
 * @param dateDeNaissance
 * @author Lilian
 * @version 1.0
 */
public class PersonneMorale
{
	
	/**
	 * Nom de la personne morale
	 */
	private String nom;
	
	/**
	 * Prénom de la personne morale
	 */
	private String prenom;
	
	/**
	 * Date de naissance de la personne morale
	 */
	private String dateDeNaissance;
	
	private Adresse adresse = new Adresse();
	
	// initialise le constructeur par défaut 
	public PersonneMorale()
	{
		super();
	}
	
	/**
	 * Constructeur de la classe PersonneMorale
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 */
	
	public PersonneMorale(String nom, String prenom, String dateDeNaissance) 
	{
		this.nom=nom;
		this.prenom=prenom;
		this.dateDeNaissance=dateDeNaissance;
	}
	
	/**
	 * getter attribut nom
	 */
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * getter attribut prenom
	 */
	public String getPrenom() 
	{
		return prenom;
	}
	/**
	 * getter attribut dateDeNaissance
	 */
	public String getDateDeNaissance() 
	{
		return dateDeNaissance;
	}
	
	/**
	 * setter attribut nom
	 */
	public void setNom(String nom) 
	{
		this.nom=nom;
	}

	/**
	 * setter attribut prenom
	 */
	public void setPrenom(String prenom) 
	{
		this.prenom=prenom;
	}
	
	/**
	 * setter attribut dateDeNaissance
	 */
	public void setDateDeNaissance(String dateDeNaissance) 
	{
		this.dateDeNaissance=dateDeNaissance;
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
		adresse.afficher();
		System.out.println("Nom : "+ nom + "Prénom : " + prenom + "Date de naissance : " + dateDeNaissance);
	}
}
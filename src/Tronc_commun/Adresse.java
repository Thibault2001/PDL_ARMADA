package Tronc_commun;

public class Adresse 
{
	private String numero;
	private String rue;
	private String ville;
	private int region;
	private String pays;
	
	// initialise le constructeur par défaut 
	public Adresse()
	{
		super();
	}
		
	public Adresse(String numero, String rue, String ville, int region, String pays)
	{
		this.numero = numero;
		this.rue = rue;
		this.ville = rue;
		this.region = region;
		this.pays = pays;
	}
	
	public String getNumero()
	{
		return numero;
	}
	
	public String getRue()
	{
		return rue;
	}
	
	public String getVille()
	{
		return ville;
	}
	
	public Integer getRegion()
	{
		return region;
	}
	
	public String getPays()
	{
		return pays;
	}
	
	
	
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
	public void setRue(String rue)
	{
		this.rue = rue;
	}
	
	public void setVille(String ville)
	{
		this.ville = ville;
	}
	
	public void setRegion(Integer region)
	{
		this.region = region;
	}
	
	public void setPays(String pays)
	{
		this.pays = pays;
	}
	
	public void modifier()
	{
		
	}
	
	public void afficher()
	{
		System.out.println("Adresse : " + "\nNumero : " + numero + "\nRue : " + rue + "\nVille : " + ville + "\nRegion : " + region + "\nPays : " + pays);	
	}	
}

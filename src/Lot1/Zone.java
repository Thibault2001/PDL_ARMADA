package Lot1;

public class Zone {
	private String nomZone; //numéro de la zone
	private int placeParking;
	private String plageHoraire; //matin ou soir
	private String typeZone; //locataire ou service public
	private int nbrPlaceReserve;
	
	public Zone(String nomZone, int placeParking,String plageHoraire,String typeZone,int nbrPlaceReserve) {
		this.nomZone=nomZone;
		this.placeParking=placeParking;
		this.plageHoraire=plageHoraire;
		this.typeZone=typeZone;
		this.nbrPlaceReserve=nbrPlaceReserve;
	}
	public String getnomZone() {
		return nomZone;
	}
	public String getPlageHoraire() {
		return plageHoraire;
	}
	public void setPlageHoraire(String plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	public int getPlaceParking() {
		return placeParking;
	}
	public String getTypeZone() {
		return typeZone;
	}
	public int getNbrPlaceReserve() {
		return nbrPlaceReserve;
	}
	public void setNbrPlaceReserve(int nbrPlaceReserve) {
		this.nbrPlaceReserve = nbrPlaceReserve;
	}
	public String getNomZone() {
		return nomZone;
	}
	public void setNomZone(String nomZone) {
		this.nomZone = nomZone;
	}

}

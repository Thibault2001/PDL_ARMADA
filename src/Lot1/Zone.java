package Lot1;

public class Zone {
	int idZone; //numéro de la zone
	int placeParking;
	String plageHoraire; //matin ou soir
	String typeZone; //locataire ou service public
	int nbrPlaceReserve;
	boolean plein; //parking plein ou non
	public Zone(int idZone, int placeParking,String plageHoraire,String typeZone,int nbrPlaceReserve) {
		this.placeParking=placeParking;
		this.plageHoraire=plageHoraire;
		this.typeZone=typeZone;
		this.nbrPlaceReserve=nbrPlaceReserve;
	}
	public int getIdZone() {
		return idZone;
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

}

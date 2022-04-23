package Tronc_commun;

/**
 * Classe Inscription
 * @author SERAFINI Thibault & TEGUE YOMBI Elisée 
 * @version 1.0
 * */
public class Inscription {
	/** 
	 * reference de l'inscription
	 */
	private int idInsc;
	/**
	 * participant
	 */
	private Participant participant = new Participant(0, null, null);	
	/**
	/**
	 * @param idPM identifiant de ll'inscription
	 * @param participant le participant associé 
	 */
	public Inscription(int idInsc, Participant participant) {
		this.idInsc = idInsc;
		this.participant = participant;
	}
	/**
	 * getter pour l'attribut reference
	 * @return valeur de la reference de l'inscription
	 */
	public int getIdInsc() {
		return idInsc;
	}
	/**
	 * getter pour l'attribut participant
	 * @return le participant associé à l'inscription
	 */
	public Participant getParticipant() {
		return participant;
	}
}
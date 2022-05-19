package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import Lot1.*;
import Tronc_commun.Inscription;
import Tronc_commun.Participant;
import Tronc_commun.PersonneMorale;

public class LaissezPasserDAO extends ConnexionDAO {
	Scanner lectureClavier = new Scanner(System.in);
	public LaissezPasserDAO() {
		super();
	}
	public int addLaissezPasser(LaissezPasser laissezPasser) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO laissezPasser (idLP, nomLP, prenomLP, entrepriseLP, plageHoraireLP, valide, archive, idVehicule) VALUES (IDLAISSEZPASSER_SEQ.nextVal, ? , ? ,? , ?,?,?,IDVEHICULE_SEQ.nextVal)");
			ps.setString(1, laissezPasser.getNomLP());
			ps.setString(2, laissezPasser.getPrenomLP());
			ps.setString(3, laissezPasser.getEntrepriseLP());
			ps.setString(4, laissezPasser.getPlageHoraireLP());
			ps.setBoolean(5, laissezPasser.isValide());
			ps.setBoolean(6, laissezPasser.isArchive());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant existe deja");
			else
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	
	public int addVehicule(Vehicule vehicule) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO vehicule (idVehicule, immatriculation, modele, longueur, largeur) VALUES (IDVEHICULE_SEQ.nextVal, ? , ? ,? , ?)");
			ps.setString(1, vehicule.getImmatriculation());
			ps.setString(2, vehicule.getModele());
			ps.setDouble(3, vehicule.getLongueur());
			ps.setDouble(4, vehicule.getLargeur());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant existe deja");
			else
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	public int delete(LaissezPasser laissezPasser) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try 
		{
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur du numZone à supprimer
			// le getter permet de recuperer la valeur dun numZone de l'Zone
			ps = con.prepareStatement("DELETE FROM Zone WHERE nomLP = ?");
			ps.setString(1, laissezPasser.getNomLP());

			// Execution de la requete
			returnValue = ps.executeUpdate();
		}
		catch (Exception e) 
			{
			if (e.getMessage().contains("ORA-02292"))	// si le LP n'existe pas deja dans la bdd
			{
				System.out.println("Ce laissez-passer n'a pas pu être supprimé !");
			}
			else
				e.printStackTrace();
		} 
		finally 
		{
			// fermeture du preparedStatement et de la connexion
			try 
			{
				if (ps != null) 
				{
					ps.close();
				}
			} 
			catch (Exception ignore)
			{
			}
			try 
			{
				if (con != null) 
				{
					con.close();
				}
			} 
			catch (Exception ignore) 
			{
			}
		}
		return returnValue;
	}
	public int getId(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idinscription FROM inscription WHERE adressemail = ?");
			ps.setString(1, email);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = rs.getInt("idinscription");
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	
	/**
	 * Permet de recuperer tous les fournisseurs stockes dans la table fournisseur
	 * 
	 * @return une ArrayList de fournisseur
	 */
	public static ArrayList<Inscription> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Inscription> returnValue = new ArrayList<Inscription>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM inscription ORDER BY IDINSCRIPTION");
			//ps.setString(1, null);			//selectionne uniquement les inscriptions non validées
			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Inscription(rs.getInt("IDINSCRIPTION"), new Participant(rs.getInt("IDINSCRIPTION"), rs.getString("ACTIVITEINSCRIPTION"), new PersonneMorale(rs.getInt("IDINSCRIPTION"), rs.getString("NOMINSCRIPTION"), rs.getString("PRENOMINSCRIPTION"),null,null,rs.getString("ADRESSEMAIL")))));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
}

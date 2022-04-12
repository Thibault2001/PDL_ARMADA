package DAO;

import Lot1.*;

import java.util.*;
import java.sql.*;

public class ZoneDAO extends ConnexionDAO {
	Scanner lectureClavier = new Scanner(System.in);
	public ZoneDAO() {
		super();
	}
	
	public int addZone(Zone zone) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO zone (idZone, placeParking, plageHoraire, typeZone, nbrPlaceReserve, nomZone) VALUES (IDZONE_SEQ.nextVal, ? , ? ,? , ?,?)");
			ps.setInt(1, zone.getPlaceParking());
			ps.setString(2, zone.getPlageHoraire());
			ps.setString(3, zone.getTypeZone());
			ps.setInt(4, zone.getNbrPlaceReserve());
			ps.setString(5, zone.getNomZone());

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

	public int delete(Zone Zone) 
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
			ps = con.prepareStatement("DELETE FROM Zone WHERE nomZone = ?");
			ps.setString(1, Zone.getNomZone());

			// Execution de la requete
			returnValue = ps.executeUpdate();
		}
		catch (Exception e) 
			{
			if (e.getMessage().contains("ORA-02292"))	// si l'Zone n'existe deja dans la bdd
			{
				System.out.println("Cet Zone n'a pas pu être supprimé !");
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
	
	public Zone get(int nomZone) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Zone returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Zone WHERE nomZone = ?");
			ps.setInt(1, nomZone);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Zone(rs.getString("nomZone"),
									       rs.getInt("placeParking"),
									       rs.getString("plageHoraire"),
									       rs.getString("typeZone"),
									       rs.getInt("nbrPlaceReserve"));
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
	public ArrayList<Zone> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Zone> returnValue = new ArrayList<Zone>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Zone ORDER BY idZone");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Zone(rs.getString("nomZone"),
					       rs.getInt("placeParking"),
					       rs.getString("plageHoraire"),
					       rs.getString("typeZone"),
					       rs.getInt("nbrPlaceReserve")));
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

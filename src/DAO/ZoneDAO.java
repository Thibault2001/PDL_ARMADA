package DAO;

import Lot1.*;
import java.util.Scanner;
import java.sql.*;

public class ZoneDAO extends ConnexionDAO {
	Scanner lectureClavier = new Scanner(System.in);
	public ZoneDAO() {
		super();
	}
	
	public int addZone(Zone zone ) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO zone (idZone, placeParking, plageHoraire, typeZone, nbrPlaceReserve) VALUES (?, ? , ? ,?, ?)");
			ps.setString(1, zone.getIdZone());
			ps.setInt(2, zone.getPlaceParking());
			ps.setString(3, zone.getPlageHoraire());
			ps.setString(4, zone.getTypeZone());
			ps.setInt(5, zone.getNbrPlaceReserve());

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

	public int deleteZone(Zone Zone) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du fournisseur
			System.out.println("id zone a supprimer :");
			String idDelete= lectureClavier.nextLine();
			ps = con.prepareStatement("DELETE FROM Zone WHERE idZone = ?");
			ps.setString(1, idDelete);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Ce fournisseur possede des articles, suppression impossible !"
						         + " Supprimer d'abord ses articles ou utiiser la méthode de suppression avec articles.");
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
	
	
}

package DAO;

import Lot1.*;
import java.sql.*;

public class ZoneDAO extends ConnexionDAO {
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
			ps = con.prepareStatement("INSERT INTO zone (idZone, placeParking, plageHoraire, typeZone) VALUES (1, 230, matin, locataire)");
			ps.setInt(1, zone.getIdZone());
			ps.setString(2, zone.getPlageHoraire());
			ps.setInt(3, zone.getPlaceParking());
			ps.setString(4, zone.getTypeZone());

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
}

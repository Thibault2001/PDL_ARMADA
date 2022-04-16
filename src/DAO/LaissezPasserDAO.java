package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import Lot1.*;

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
}

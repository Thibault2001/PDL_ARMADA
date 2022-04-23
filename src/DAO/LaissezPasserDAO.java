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
}

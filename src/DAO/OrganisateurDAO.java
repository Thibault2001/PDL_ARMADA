package DAO;

import java.sql.*;
import java.util.ArrayList;
import Tronc_commun.*;

/**
 * Classe d'acces aux donnees contenues dans la table participant
 * 
 * @author SERAFINI Thibault & TEGUE Elisée
 * */
public class OrganisateurDAO extends ConnexionDAO {
	/**
	 * Constructor
	 * 
	 */
	public OrganisateurDAO() {
		super();
	}

	/**
	 * Permet l'ajout d'un organisateur dans la table organisateur
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param organisateur l'organisateur a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Organisateur organisateur) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO organisateur (idorganisateur, prenomorganisateur, nomorganisateur, emailorganisateur) VALUES (IDORGANISATEUR_SEQ.nextVal, ?, ?, ?)");
			ps.setString(1, organisateur.getPrenomOrganisateur());
			ps.setString(2, organisateur.getNomOrganisateur());
			ps.setString(3, organisateur.getEmailOrganisateur());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet organisateur existe déjà. Ajout impossible !");
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

	/**
	 * Permet de connecter un organisateur
	 * 
	 * @param id l'adresse mail de l' organisateur
	 * @param mdp le mot de passe de l'organisateur qui est son nom
	 * @return l' organisateur qui a ete connecte
	 */
	public Organisateur login(String id, String mdp)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Organisateur returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idorganisateur, prenomorganisateur, nomorganisateur, emailorganisateur FROM organisateur WHERE emailorganisateur = ? AND nomorganisateur = ?");
			ps.setString(1, id);
			ps.setString(2, mdp);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Organisateur(rs.getString("EMAILORGANISATEUR"),rs.getString("PRENOMORGANISATEUR"),rs.getString("NOMORGANISATEUR"), rs.getInt("IDORGANISATEUR"));				       
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
	 * Permet de recuperer un organisateur a partir de son email 
	 * @param  email l'adresse mail de l'organisateur
	 * @return l'organisateur a recuperer 
	 * 			null si aucun organisateur ne correspond 
	 */
	public Organisateur get(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Organisateur returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idorganisateur, prenomorganisateur, nomorganisateur, emailorganisateur FROM organisateur WHERE emailorganisateur = ?");
			ps.setString(1, email);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Organisateur(rs.getString("EMAILORGANISATEUR"),rs.getString("PRENOMORGANISATEUR"),rs.getString("NOMORGANISATEUR"), rs.getInt("IDORGANISATEUR"));
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

	

	// main permettant de tester la classe (pour des test unitaires)
	public static void main(String[] args) throws SQLException {
		int returnValue;
		OrganisateurDAO organisateurDAO = new OrganisateurDAO();
		// test du constructeur

		/*Organisateur o1 = new Organisateur("iam@orga.com", "Jules", "Pipo",0);
		
		// test de la methode add
		returnValue = organisateurDAO.add(o1);
		System.out.println(returnValue + " organisateur ajoute");
		
		
		// test de la methode get
		Organisateur o2 = organisateurDAO.get("iam@orga.com");
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(o2);
		System.out.println();*/
		
		// test de la methode login
		Organisateur orga = organisateurDAO.login("iam@orga.com", "Pipo");
		System.out.println(orga);
		//System.out.println();
		
		/*// test de la methode getList
		ArrayList<Participant> list = ParticipantDAO.getList();
		for (Participant p : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(p.toString());
		}
		System.out.println();*/
		//test de la methode delete
		/*returnValue = 0;
		if (list.size() > 0)
			returnValue = supplierDAO.delete(list.get(0));
		System.out.println(returnValue + " fournisseur supprime");
		
		System.out.println();*/
	}
}
package DAO;

import java.sql.*;
import java.util.ArrayList;
import Tronc_commun.*;

/**
 * Classe d'acces aux donnees contenues dans la table participant
 * 
 * @author SERAFINI Thibault & TEGUE Elisée
 * */
public class ParticipantDAO extends ConnexionDAO {
	/**
	 * Constructor
	 * 
	 */
	public ParticipantDAO() {
		super();
	}

	/**
	 * Permet l'ajout d'un participant dans la table participant.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param participant le participant a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Participant participant) {
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
			ps = con.prepareStatement("INSERT INTO participant (idparticipant, profil, idpersonnemorale) VALUES (IDPARTICIPANT_SEQ.nextVal, ?, ?)");
			ps.setString(1, participant.getProfile());
			ps.setLong(2, participant.getPersonneMorale().getIdPM());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Ce participant existe déjà. Ajout impossible !");
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
	 * Permet de modifier un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param supplier le fournisseur a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	/*public int login(String id, String mdp) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE supplier set adresseMail = ?, nomInscription = ?, email = ? WHERE id = ?");
			ps.setString(1, supplier.getName());
			ps.setString(2, supplier.getAddress());
			ps.setString(3, supplier.getEmail());
			ps.setInt(4, supplier.getId());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
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
	 * Permet de supprimer un fournisseur dans la table supplier.
	 * Si ce dernier possede des articles, la suppression n'a pas lieu.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param supplier le fournisseur a supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	/*public int delete(Supplier supplier) {
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
			ps = con.prepareStatement("DELETE FROM supplier WHERE id = ?");
			ps.setInt(1, supplier.getId());

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
	}//


	/**
	 * Permet de recuperer un fournisseur a partir de sa reference
	 * 
	 * @param reference la reference du fournisseur a recuperer
	 * @return le fournisseur trouve;
	 * 			null si aucun fournisseur ne correspond a cette reference
	 */
	/*public Supplier get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Supplier returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM supplier WHERE id = ?");
			ps.setInt(1, id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Supplier(rs.getInt("id"),
									       rs.getString("name"),
									       rs.getString("address"),
									       rs.getString("email"));
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
	}*/

	/**
	 * Permet de recuperer tous les fournisseurs stockes dans la table fournisseur
	 * 
	 * @return une ArrayList de fournisseur
	 */
	public static ArrayList<Participant> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Participant> returnValue = new ArrayList<Participant>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM participant ORDER BY IDPARTICIPANT");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Participant(rs.getInt("IDPARTICIPANT"), rs.getString("PROFIL"),null));
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

	// main permettant de tester la classe (pour des test unitaires)
	public static void main(String[] args) throws SQLException {
		/*int returnValue;
		ParticipantDAO participantDAO = new ParticipantDAO();
		// test du constructeur

		Participant p1 = new Participant(0, "bateau", null);
		Participant p2 = new Participant(0, "Famille d'acceuil", null);
		Participant p3 = new Participant(0, "Entreprise", null);
		
		// test de la methode add
		returnValue = participantDAO.add(p1);
		System.out.println(returnValue + " participant ajoutee");
		returnValue = participantDAO.add(p2);
		System.out.println(returnValue + " participant ajoutee");
		returnValue = participantDAO.add(p3);
		System.out.println(returnValue + " participant ajoutee");
		System.out.println();*/
		
		/*// test de la methode get
		Supplier sg = supplierDAO.get(1);
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(sg);
		System.out.println();*/
		
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
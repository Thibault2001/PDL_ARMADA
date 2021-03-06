package DAO;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Tronc_commun.*;

/**
 * Classe d'acces aux donnees contenues dans la table incription
 * 
 * @author SERAFINI Thibault & TEGUE Elis?e
 * */
public class InscriptionDAO extends ConnexionDAO {
	/**
	 * Constructor
	 * 
	 */
	public InscriptionDAO() {
		super();
	}

	/**
	 * Permet l'ajout d'une demande d'inscription dans la table Inscription.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param inscription l'inscription a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Inscription inscription) {
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
			ps = con.prepareStatement("INSERT INTO inscription (idInscription, adresseMail, nomInscription, prenomInscription, activiteInscription) VALUES (IDINSCRIPTION_SEQ.nextVal, ?, ?, ?, ?)");
			ps.setString(1, inscription.getParticipant().getPersonneMorale().getEmail());
			ps.setString(2, inscription.getParticipant().getPersonneMorale().getName());
			ps.setString(3, inscription.getParticipant().getPersonneMorale().getFirstName());
			ps.setString(4, inscription.getParticipant().getProfile());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				{
				JFrame frame = new JFrame();	
				JOptionPane.showMessageDialog(frame, "Cette inscription existe d?j?. Ajout impossible !", "Erreur", JOptionPane.WARNING_MESSAGE);
				}
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
	 * Permet de modifier une demande d'inscription dans la table inscription
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param inscription l'inscription a modifier
	 * @param estValidee decision de l'organisateur
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Inscription inscription) {
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
			ps = con.prepareStatement("UPDATE inscription set adresseMail=?, nomInscription=?, prenomInscription=?, activiteInscription=? WHERE idInscription = ?");
			ps.setString(1, inscription.getParticipant().getPersonneMorale().getEmail());
			ps.setString(2, inscription.getParticipant().getPersonneMorale().getName());
			ps.setString(3, inscription.getParticipant().getPersonneMorale().getFirstName());
			ps.setString(4, inscription.getParticipant().getProfile());
			ps.setLong(5, inscription.getIdInsc());
			

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
	 * Permet de supprimer une demande d'inscription dans la table inscription.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param inscription la demande d'inscription a supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(Inscription inscription) {
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
			ps = con.prepareStatement("DELETE FROM inscription WHERE adressemail = ?");
			ps.setString(1, inscription.getParticipant().getPersonneMorale().getEmail());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
			{
				JFrame frame = new JFrame();	
				JOptionPane.showMessageDialog(frame, "Suppression impossible !", "Erreur", JOptionPane.WARNING_MESSAGE);
			}
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
	 * Permet de recuperer la reference d'une demande d'inscription a partir de l'interface graphique
	 * @param  email l'adresse mail de la personne morale rattachee a l'inscription
	 * @return reference la reference de l'inscription a recuperer 
	 * 			null si aucune inscription ne correspond a cet email
	 */
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
			//ps.setString(1, null);			//selectionne uniquement les inscriptions non valid?es
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

	// main permettant de tester la classe (pour des test unitaires)
	public static void main(String[] args) throws SQLException {
		int returnValue;
		InscriptionDAO inscriptionDAO = new InscriptionDAO();
		/*// test du constructeur
		PersonneMorale pers1 = new PersonneMorale(0, "Duc", "Evarice", "M","15/02/1960","evarduc@gmail.com");
		//PersonneMorale pers2 = new PersonneMorale(3, "Dupuit", "Evris", "M","15/02/1960", "evrisdup@gmail.com");
		//PersonneMorale pers3 = new PersonneMorale(4, "Dupont", "Eved", "M", "15/02/1960","eveddup@gmail.com");
		Participant p1 = new Participant(0, "bateau", pers1);
		//Participant p2 = new Participant(5, "Famille d'acceuil", pers2);
		//Participant p3 = new Participant(6, "Entreprise", pers3);
		Inscription i1 = new Inscription(0, p1);
		//Inscription i2 = new Inscription(5, p2);
		//Inscription i3 = new Inscription(6, p3);
		// test de la methode add
		returnValue = inscriptionDAO.add(i1);
		System.out.println(returnValue + " inscription ajoutee");
		//returnValue = inscriptionDAO.add(i2);
		//System.out.println(returnValue + " inscription ajoutee");
		//returnValue = inscriptionDAO.add(i3);
		//System.out.println(returnValue + " inscription ajoutee");
		System.out.println();*/
		
		//test de la methode update
		/*PersonneMorale pers1 = new PersonneMorale(0, "BOB", "Christine", "F","15/02/1960","ctn.bob@gmail.com");
		Participant p1 = new Participant(0, "Famille d'accueil", pers1);
		Inscription i1 = new Inscription(2, p1);
		returnValue = inscriptionDAO.update(i1);
		System.out.println(returnValue);*/
		// test de la methode get		
		/*int id = inscriptionDAO.getId("marcelh@gmail.com");
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(id);
		//System.out.println();
	
		// test de la methode getList
		/*ArrayList<Inscription> list = inscriptionDAO.getList();
		for (Inscription i : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(i.toString());
		}
		System.out.println();
		//test de la methode delete
		returnValue = 0;
		if (list.size() > 0)
			returnValue = inscriptionDAO.delete(list.get(1));
		System.out.println(returnValue + " demande d'inscription supprime");*/
		
		//System.out.println();
	}//
}
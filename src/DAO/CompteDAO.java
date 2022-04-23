package DAO;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Tronc_commun.*;

/**
 * Classe d'acces aux donnees contenues dans la table personne morale
 * 
 * @author SERAFINI Thibault & TEGUE Elisée
 * */
public class CompteDAO extends ConnexionDAO {
	/**
	 * Constructor
	 * 
	 */
	public CompteDAO() {
		super();
	}

	/**
	 * Permet l'ajout d'une personne morale dans la table personne morale
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param participant le participant dont la personne morale est à ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Compte compte) {
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
			ps = con.prepareStatement("INSERT INTO compte (idcompte, motdepasse, mailcompte) VALUES (IDCOMPTE_SEQ.nextVal, ?, ?)");
			ps.setString(1, compte.getIdentifiant());
			ps.setString(2, compte.getMdp());
			
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
			{
				JFrame frame = new JFrame();	
				JOptionPane.showMessageDialog(frame, "Ce compte existe déjà. Ajout impossible !", "Erreur", JOptionPane.WARNING_MESSAGE);
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
	 * Permet de modifier un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param supplier le fournisseur a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	/*public int update(Participant participant) {
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
	}*/

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
	public Compte get(String identifiant) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Compte returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE mailcompte = ?");
			ps.setString(1, identifiant);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Compte(rs.getString("mailcompte"),
									       rs.getString("motdepasse"));					       
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
	 * Permet de connecter un compte
	 * 
	 * @param id l'adresse mail du compte
	 * @param mdp le mot de passe du compte
	 * @return le compte qui a ete connecte
	 */
	public Compte login(String id, String mdp)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Compte returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE mailcompte = ? AND motdepasse = ?");
			ps.setString(1, id);
			ps.setString(2, mdp);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Compte(rs.getString("mailcompte"),
									       rs.getString("motdepasse"));					       
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
	public static ArrayList<PersonneMorale> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<PersonneMorale> returnValue = new ArrayList<PersonneMorale>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM personneMorale ORDER BY IDPM");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new PersonneMorale(rs.getInt("IDPM"), rs.getString("NOMPM"),rs.getString("PRENOMPM"), rs.getString("SEXEPM"), rs.getString("DATEDENAISSANCEPM"),rs.getString("EMAILPM")));
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
		CompteDAO compteDAO = new CompteDAO();
		/*// test du constructeur
		Compte c1 = new Compte("15-09-1995", "ninon.car@gmail.com");
		Compte c2 = new Compte("14-09-1995", "pat.jul@gmail.com");
		
		//PersonneMorale pm2 = new PersonneMorale(0, "Dupont", "Pauline", "F","20/02/1992", "dutp@test.cm");
		//PersonneMorale pm3 = new PersonneMorale(0, "Dupuis", "Pau", "M", "05/02/2005","dupp@test.cm");
		
		//Participant p1 = new Participant(1, "bateau", pm1);
		//Participant p2 = new Participant(2, "Famille d'acceuil", pm2);
		//Participant p3 = new Participant(3, "Entreprise", pm3);
		
		// test de la methode add
		returnValue = compteDAO.add(c1);
		System.out.println(returnValue + " compte ajoute");
		returnValue = compteDAO.add(c2);
		System.out.println(returnValue + " compte ajoute");
		//returnValue = personneMoraleDAO.add(p2);
		//System.out.println(returnValue + " personne morale ajoutee");
		//returnValue = personneMoraleDAO.add(p3);
		//System.out.println(returnValue + " personne morale ajoutee");
		System.out.println();*/
		
		/*// test de la methode get
		Supplier sg = supplierDAO.get(1);
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(sg);
		System.out.println();*/
		
		/*// test de la methode get
		CompteDAO compteDAO = new CompteDAO();
		Compte compte = compteDAO.get("ninon.car@gmail.com");
		System.out.println(compte);
		//System.out.println();*/
		
		// test de la methode login
		Compte compte = compteDAO.login("nono@gmail.com", "1995-10-18");
		System.out.println(compte);
		//System.out.println();
		
		// test de la methode getList
		/*ArrayList<PersonneMorale> list =PersonneMoraleDAO.getList();
		for (PersonneMorale pm : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(pm.toString());
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
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
public class PersonneMoraleDAO extends ConnexionDAO {
	/**
	 * Constructor
	 * 
	 */
	public PersonneMoraleDAO() {
		super();
	}

	/**
	 * Permet l'ajout d'une personne morale dans la table personne morale
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param participant le participant dont la personne morale est à ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(PersonneMorale personneMorale) {
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
			ps = con.prepareStatement("INSERT INTO personnemorale (idpm, nompm, prenompm, datedenaissancepm, sexepm, emailpm) VALUES (PERSONNEMORALE_SQL.nextVal, ?, ?, ?, ?,?)");
			ps.setString(1, personneMorale.getName());
			ps.setString(2, personneMorale.getFirstName());
			ps.setString(3, personneMorale.getDateNaiss());
			ps.setString(4, personneMorale.getSexe());
			ps.setString(5, personneMorale.getEmail());
			

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
			{
				JFrame frame = new JFrame();	
				JOptionPane.showMessageDialog(frame, "Cette personne morale existe déjà. Ajout impossible !", "Erreur", JOptionPane.WARNING_MESSAGE);
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
	 * Permet de recuperer une personne morale a partir de son email 
	 * @param  email l'adresse mail de la personne morale
	 * @return la personne morale a recuperer 
	 * 			null si aucune personne morale ne correspond 
	 */
	public PersonneMorale get(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PersonneMorale returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idpm, nompm, prenompm, sexepm, datedenaissancepm, emailpm FROM personnemorale WHERE emailPM = ?");
			ps.setString(1, email);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new PersonneMorale(rs.getInt("IDPM"), rs.getString("NOMPM"),rs.getString("PRENOMPM"), rs.getString("SEXEPM"), rs.getString("DATEDENAISSANCEPM"),rs.getString("EMAILPM"));
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
	 * Permet de recuperer l'identifiant et l'adresse mail d'une personne morale a partir de son email via l'interface graphique
	 * 
	 * @param  email l'adresse mail de la personne morale
	 * @return reference la reference de la personne morale a recuperer ainsi que sa date de naissance(qui est utilisée comme mdp pour lui créer un compte);
	 * 			null si aucune personne morale ne correspond a cet email
	 */
	public String[] getInfosPM(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] returnValue = new String[2];

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idpm, datedenaissancepm FROM personnemorale WHERE emailPM = ?");
			ps.setString(1, email);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				int returnId = rs.getInt("idpm");
				returnValue[0] = String.valueOf(returnId);
				returnValue[1] = rs.getString("datedenaissancepm").substring(0, 10);
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
	 * Permet de recuperer tous les personnes morales stockes dans la table personne morale
	 * 
	 * @return une ArrayList de personnes morales
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
		PersonneMoraleDAO personneMoraleDAO = new PersonneMoraleDAO();
		// test du constructeur
		
		/*PersonneMorale pm1 = new PersonneMorale(0, "BOB", "Christine", "F", "16/10/2020","c.bob@gmail.com");
		PersonneMorale pm2 = new PersonneMorale(0, "Duc", "Evarice", "M", "18/10/1905","evarduc@gmail.com");
		PersonneMorale pm3 = new PersonneMorale(0, "Dupond", "Evrad", "M", "14/01/1990","evraddup@gmail.com");
		PersonneMorale pm4 = new PersonneMorale(0, "Dupuit", "Evris", "M", "18/10/1995","evrisdup@gmail.com");
		PersonneMorale pm5 = new PersonneMorale(0, "Dupont", "Eved", "F", "18/10/1995","eveddup@gmail.com");
		PersonneMorale pm6 = new PersonneMorale(0, "NORMAND", "Noa", "M", "18/10/1995","nono@gmail.com");
		PersonneMorale pm7 = new PersonneMorale(0, "BEAU", "Bob", "F", "18/10/1995","nono@gmail.com");
		PersonneMorale pm8 = new PersonneMorale(0, "PAUL", "Henri", "M", "18/10/1995","hepa@gmail.com");
		PersonneMorale pm9 = new PersonneMorale(0, "Houloue", "Marcel", "M", "18/10/1995","marcelh@gmail.com");
		
		//PersonneMorale pm2 = new PersonneMorale(0, "Dupont", "Pauline", "F","20/02/1992", "dutp@test.cm");
		//PersonneMorale pm3 = new PersonneMorale(0, "Dupuis", "Pau", "M", "05/02/2005","dupp@test.cm");
		
		//Participant p1 = new Participant(1, "bateau", pm1);
		//Participant p2 = new Participant(2, "Famille d'acceuil", pm2);
		//Participant p3 = new Participant(3, "Entreprise", pm3);
		
		// test de la methode add
		returnValue = personneMoraleDAO.add(pm1);
		System.out.println(returnValue + " personne morale ajoutee");
		returnValue = personneMoraleDAO.add(pm2);
		System.out.println(returnValue + " personne morale ajoutee");
		returnValue = personneMoraleDAO.add(pm3);
		System.out.println(returnValue + " personne morale ajoutee");
		returnValue = personneMoraleDAO.add(pm4);
		System.out.println(returnValue + " personne morale ajoutee");
		returnValue = personneMoraleDAO.add(pm5);
		System.out.println(returnValue + " personne morale ajoutee");
		returnValue = personneMoraleDAO.add(pm6);
		System.out.println(returnValue + " personne morale ajoutee");
		returnValue = personneMoraleDAO.add(pm7);
		System.out.println(returnValue + " personne morale ajoutee");
		returnValue = personneMoraleDAO.add(pm8);
		System.out.println(returnValue + " personne morale ajoutee");
		returnValue = personneMoraleDAO.add(pm9);
		System.out.println(returnValue + " personne morale ajoutee");
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
		
		// test de la methode get
		/*PersonneMoraleDAO persMorDAO = new PersonneMoraleDAO();
		String[] Infos = persMorDAO.getInfosPM("marcelh@gmail.com");
		System.out.println(Integer.valueOf(Infos[0]));
		System.out.println(Infos[1]);*/
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
package DAO;

import java.sql.*;
import java.util.ArrayList;
import Tronc_commun.*;

/**
 * Classe d'acces aux donnees contenues dans la table incription
 * 
 * @author SERAFINI Thibault & TEGUE Elisée- TIC Department
 * @version 1.0
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
	 * Permet l'ajout d'un participant dans la table Inscription.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param supplier le participant a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Supplier supplier) {
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
			ps = con.prepareStatement("INSERT INTO supplier (id, name, address, email) VALUES (?, ?, ?, ?)");
			ps.setInt(1, supplier.getId());
			ps.setString(2, supplier.getName());
			ps.setString(3, supplier.getAddress());
			ps.setString(4, supplier.getEmail());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de fournisseur existe déjà. Ajout impossible !");
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
	public int update(Supplier supplier) {
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
			ps = con.prepareStatement("UPDATE supplier set name = ?, address = ?, email = ? WHERE id = ?");
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
	public int delete(Supplier supplier) {
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
	}


	/**
	 * Permet de recuperer un fournisseur a partir de sa reference
	 * 
	 * @param reference la reference du fournisseur a recuperer
	 * @return le fournisseur trouve;
	 * 			null si aucun fournisseur ne correspond a cette reference
	 */
	public Supplier get(int id) {
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
	}

	/**
	 * Permet de recuperer tous les fournisseurs stockes dans la table fournisseur
	 * 
	 * @return une ArrayList de fournisseur
	 */
	public ArrayList<Supplier> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Supplier> returnValue = new ArrayList<Supplier>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM supplier ORDER BY id");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Supplier(rs.getInt("id"),
						                     rs.getString("name"),
						                     rs.getString("address"),
						                     rs.getString("email")));
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
		SupplierDAO supplierDAO = new SupplierDAO();
		// test du constructeur
		Supplier s1 = new Supplier(1, "Mon fournisseur principal", "Rouen", "monfournisseurprincipal@mail.com");
		Supplier s2 = new Supplier(2, "Mon fournisseur secondaire", "Le Havre", "monfournisseursecondaire@mail.com");
		Supplier s3 = new Supplier(3, "Mon fournisseur de secours", "Paris", "monfournisseursecours@mail.com");
		// test de la methode add
		returnValue = supplierDAO.add(s1);
		System.out.println(returnValue + " fournisseur ajoute");
		returnValue = supplierDAO.add(s2);
		System.out.println(returnValue + " fournisseur ajoute");
		returnValue = supplierDAO.add(s3);
		System.out.println(returnValue + " fournisseur ajoute");
		System.out.println();
		
		// test de la methode get
		Supplier sg = supplierDAO.get(1);
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(sg);
		System.out.println();
		
		// test de la methode getList
		ArrayList<Supplier> list = supplierDAO.getList();
		for (Supplier s : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(s.toString());
		}
		System.out.println();
		//test de la methode delete
		returnValue = 0;
		if (list.size() > 0)
			returnValue = supplierDAO.delete(list.get(0));
		System.out.println(returnValue + " fournisseur supprime");
		
		System.out.println();
	}
}
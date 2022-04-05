package DAO;
import java.sql.*;

public class ConnexionDAO {
	final static String URL   = "jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl";
	final static String LOGIN = "C##_G2_G4_APP";
	final static String PASS  = "APP_2_4";
	
	public ConnexionDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}
}

package jeudes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sql.ConnexionJDBC;

public class PartieDAOUtils {

	private final static String QUERY_SAVE_JOUEUR = "INSERT INTO `joueur` (`nom`, `d1`, `d2`, `scorePartie`) VALUES (?,?,?,?)";

	public static void sauvegarderJoueur(JoueurBean joueurBean) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// Pour travailler avec Tomcat
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD); // La
																												// connexion
			stmt = con.prepareStatement(QUERY_SAVE_JOUEUR, Statement.RETURN_GENERATED_KEYS);
			// Remplir la requête
			stmt.setString(1, joueurBean.getNom());
			stmt.setInt(2, joueurBean.getGobelet().getD1().getValue());
			stmt.setInt(3, joueurBean.getGobelet().getD2().getValue());
			stmt.setInt(4, joueurBean.getScorePartie());
			// Lancer la requête
			stmt.executeUpdate();
			// Retourne la clé primaire
			ResultSet key = stmt.getGeneratedKeys();
			// positionne sur le 1er
			key.next();
			joueurBean.setId(key.getLong(1));

		} finally {
			// On ferme la connexion
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private final static String QUERY_SAVE_PARTIE = "INSERT INTO `partie` ( `tour`, `j1`, `j2`, `jc`) VALUES (?,?,?,?);";

	public static void sauvegarderPartie(PartieBean partieBean) throws Exception {

		sauvegarderJoueur(partieBean.getJ1());
		sauvegarderJoueur(partieBean.getJ2());

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// Pour travailler avec Tomcat
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD); // La
																												// connexion
			stmt = con.prepareStatement(QUERY_SAVE_PARTIE);
			// Remplir la requête
			stmt.setInt(1, partieBean.getTour());
			stmt.setLong(2, partieBean.getJ1().getId());
			stmt.setLong(3, partieBean.getJ2().getId());
			stmt.setLong(4, partieBean.getJoueurCourant().getId());
			// Lancer la requête
			stmt.executeUpdate();

		} finally {
			// On ferme la connexion
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private final static String QUERY_LOAD = "SELECT P.tour,p.jc, p.j1 as idJ1, J1.nom AS nomJ1, J1.d1 as d1J1, J1.d2 as d2J1, J1.scorePartie as scorePartieJ1, J2.* FROM partie P INNER JOIN joueur J1 on P.j1 = J1.id INNER JOIN joueur J2 on P.j2 = J2.id ORDER BY P.id DESC LIMIT 1";

	public static PartieBean chargerPartie() throws Exception {
		Connection con = null;
		Statement stmt = null;
		try {
			// Pour travailler avec Tomcat et wamp Rajouter :
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD); // La
			stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(QUERY_LOAD);
			if (!rset.next()) {
				throw new Exception("Aucune partie chargée");
			}

			PartieBean partieBean = new PartieBean(rset.getString("nomJ1"), rset.getString("nom"));
			partieBean.setTour(rset.getInt("tour"));
			// joueur 1
			partieBean.getJ1().setId(rset.getLong("idJ1"));
			partieBean.getJ1().getGobelet().getD1().setValue(rset.getInt("d1j1"));
			partieBean.getJ1().getGobelet().getD2().setValue(rset.getInt("d2j1"));
			partieBean.getJ1().setScorePartie(rset.getInt("scorePartieJ1"));

			// joueur 2
			partieBean.getJ2().setId(rset.getLong("id"));
			partieBean.getJ2().getGobelet().getD1().setValue(rset.getInt("d1"));
			partieBean.getJ2().getGobelet().getD2().setValue(rset.getInt("d2"));
			partieBean.getJ2().setScorePartie(rset.getInt("scorePartie"));

			// Joueur courant
			long idJoueurCourant = rset.getLong("jc");
			if (idJoueurCourant == partieBean.getJ1().getId()) {
				partieBean.setJoueurCourant(partieBean.getJ1());
			} else {
				partieBean.setJoueurCourant(partieBean.getJ2());
			}

			return partieBean;
		} finally {
			if (con != null) {// On ferme la connexion
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

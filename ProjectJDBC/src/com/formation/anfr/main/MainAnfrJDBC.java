package com.formation.anfr.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class MainAnfrJDBC {
	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost/";

	public String user = "root";
	public String pass = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainAnfrJDBC m = new MainAnfrJDBC();
		// m.init();
		// m.creTable();
		//m.insertTable();
		// m.updateTable();
		// m.removeFromTable();
		// m.selectTable();
		//m.superselect();
		m.keyTables();
		 m.selectTable();
	}

	private void keyTables(){
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "marchandanfr";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			String sql = "insert into marchandANFR ";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void superselect() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "marchandanfr";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM marchandANFR INNERJOIN produit ON (marchand.ANFR.ID = produit.IDMARCHAND);";
			ResultSet resultat = stat.executeQuery(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
	}

	private void updateTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "marchandanfr";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			String sql = "UPDATE marchandANFR set PRENOM='GOGO' where prenom = 'Vlac';";
			int resultat = stat.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private void removeFromTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "marchandanfr";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			String sql = "delete from marchandANFR where nom = 'Vincent';";
			int resultat = stat.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private void selectTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "marchandanfr";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM marchandANFR;";
			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				String sNom = resultat.getString("nom");
				String sPrenom = resultat.getString("prenom");
				String sAge = resultat.getString("age");
				System.out.println(sNom + sPrenom + sAge);
			}

			sql = "SELECT * FROM marchandANFR where nom='Vlac';";
			resultat = stat.executeQuery(sql);
			ResultSetMetaData meta = resultat.getMetaData();
			int nb = meta.getColumnCount();
			for (int i = 0; i < nb; i++) {
				System.out.println(meta.getColumnName(i + 1));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private void insertTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "marchandanfr";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String[] tab = { "Pomme", "Poire", "Saucisson", "Caramel", "Lune", "Jeux", "Cartes", "Chaton", "Peigne",
					"Disque", "Lumiere", "Etoile" };
			int[] tab2 = { 1, 2, 3, 4, 5, 7, 8, 9, 11 };
			for (int i = 0; i < tab2.length; i++) {
				for (int k = 0; k < tab.length; k++) {

					String sql = "INSERT INTO produit (idmarchand,nomProduit,qteProduit)" + //
							"values ('" + tab2[i] + "','" + tab[k] + "','10');";

					int resultat = stat.executeUpdate(sql);
					if (resultat > 0) {
						System.out.println(sql);
					}
				}
			}

			System.out.println("FIN");
		} catch (ClassNotFoundException |

				SQLException e) {
			e.printStackTrace();
		}
	}

	private void create() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "CREATE DATABASE MARCHANDANFR";

			stat.executeUpdate(sql);
			System.out.println("FIN");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void creTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "marchandanfr";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "CREATE TABLE marchandANFR.produit (" + //
					"IDPRODUIT INTEGER(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," + //
					"IDMARCHAND BIGINT," + //
					"nomProduit VARCHAR(255), " + //
					"qteProduit INT);";

			stat.executeUpdate(sql);
			System.out.println("FIN");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Enumeration<Driver> e = DriverManager.getDrivers();
		while (e.hasMoreElements()) {
			Driver driver = (Driver) e.nextElement();
			int majorVersion = driver.getMajorVersion();
			int minorVersion = driver.getMinorVersion();
			System.out.println(
					"Pilote = " + driver.getClass() + " version " + minorVersion + " majorVersion " + majorVersion);
			DriverPropertyInfo[] props;
			try {
				props = driver.getPropertyInfo("url JDBC", null);
				for (int i = 0; i < props.length; i++) {
					DriverPropertyInfo prop = props[i];
					System.out.println("Prop : " + prop.name);
					String[] choix = prop.choices;
					if (choix != null) {
						for (int j = 0; j < choix.length; j++) {
							System.out.println("\tprop choix " + j + " " + choix[j]);
						}
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

package com.formation.jeci.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

//import com.mysql.jdbc.Driver;

public class MainJDBCjeci {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/erreur";
	private String user = "root";
	public String pass = "";

	public static void main(String[] args) {
		MainJDBCjeci m = new MainJDBCjeci();
		// m.init();
		// m.create();
		// m.createTable();
		// m.insertTable();
		m.selectTable();

	}

	private void metaData() {
		Connection conne = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conne = DriverManager.getConnection(DB_URL, user, pass);
			stat = conne.createStatement();
			String sql = "SELECT * FROM etga WHERE NOM='toto';";
			ResultSet resultat = stat.executeQuery(sql);
			ResultSetMetaData meta = resultat.getMetaData();
			int nb = meta.getColumnCount();
			for (int i = 0; i < nb; i++) {
				meta.getColumnLabel(i);
			}

			while (resultat.next()) {
				String sNom = resultat.getString("NOM");
				String sAge = resultat.getString("age");
				System.out.println(sAge + " " + sNom);
			}
			;

			System.out.println("fin");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	private void selectTable() {
		Connection conne = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conne = DriverManager.getConnection(DB_URL, user, pass);
			stat = conne.createStatement();
			String sql = "SELECT * FROM etga;";
			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				String sNom = resultat.getString("NOM");
				String sAge = resultat.getString("age");
				System.out.println(sAge + " " + sNom);
			}
			;

			System.out.println("fin");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	private void insertTable() {
		Connection conne = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conne = DriverManager.getConnection(DB_URL, user, pass);
			stat = conne.createStatement();
			String sql = "INSERT INTO etga (age,NOM) VALUES('20','toto');";
			stat.executeUpdate(sql);
			System.out.println("fin");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	private void createTable() {
		Connection conne = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conne = DriverManager.getConnection(DB_URL, user, pass);
			stat = conne.createStatement();
			String sql = "Create table Erreur.ETGA ( Id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, NOM varchar(30) not null, age varchar(10) not null);";
			stat.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	private void create() {

		Connection conne = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conne = DriverManager.getConnection(DB_URL, user, pass);
			stat = conne.createStatement();
			String sql = "Create database Erreur";
			stat.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	private void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		Enumeration<Driver> e = DriverManager.getDrivers();
		while (e.hasMoreElements()) {
			Driver driver = (Driver) e.nextElement();
			int majorVersion = driver.getMajorVersion();
			int minorversion = driver.getMinorVersion();
			System.out.println("pilote= " + driver.getClass() + " version " + minorversion + " " + majorVersion);
			DriverPropertyInfo[] props;
			try {
				props = driver.getPropertyInfo("url JDBC", null);
				int cpt = 0;
				for (int i = 0; i < props.length; i++) {
					DriverPropertyInfo prop = props[i];
					System.out.println("Prop : " + prop.name);
					String[] choix = prop.choices;
					if (choix != null) {

						cpt++;
						System.out.print(cpt);
						for (int j = 0; j < choix.length; j++) {
							cpt++;
							System.out.print(cpt);
							System.out.println("\t prop Choix" + j + " " + choix[j]);

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

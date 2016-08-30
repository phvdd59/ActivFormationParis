package com.formation.joca.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class MainJDBC {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost/test";

	public String user = "root";
	public String pass = "";

	public static void main(String[] args) {
		MainJDBC m = new MainJDBC();
		// m.init();
		// m.create();
		// m.createTable();
		// m.insertTable();
		// m.selectTable();
		m.remplirProduit();
	}

	private void remplirProduit() {
		Connection conn = null;
		Statement stat = null;
		Statement stat2 = null;
		Statement stat3 = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			stat2 = conn.createStatement();
			stat3 = conn.createStatement();

			String deleteProduit = "delete from marchandjoca.produit;";
			stat3.executeUpdate(deleteProduit);

			String[] nomProduit = { "vis", "ecrou", "planche", "armature", "rondelle", "outil", "roulette",
					"Patrick Sebastien" };

			String sql = "SELECT * from marchandjoca.meuble";
			ResultSet resultat = stat.executeQuery(sql);

			while (resultat.next()) {
				String id = resultat.getString("id");
				for (int i = 0; i < nomProduit.length; i++) {
					int qte = (int) (Math.random() * 10);
					String sQte = Integer.toString(qte);
					String sql2 = "insert into marchandjoca.produit (idMeuble,nomProduit,qteProduit) VALUES('" + id
							+ "','" + nomProduit[i] + "','" + sQte + "');";
					stat2.executeUpdate(sql2);
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void selectTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * from marchandjoca.meuble WHERE marchandjoca.meuble.prix BETWEEN '100.00' and '200.00'";
			ResultSet resultat = stat.executeQuery(sql);

			System.out.println("WELP");
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String prix = resultat.getString("prix");
				String id = resultat.getString("id");
				System.out.println(nom + " " + prix + " " + id);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "insert into marchandjoca.meuble (nom,largeur,hauteur,longueur, prix) VALUES('CANAPE',13,19,30, 599.99);";
			String sql2 = "insert into marchandjoca.meuble (nom,largeur,hauteur,longueur, prix) VALUES('ECHELLE',1,80,5, 125.50);";
			String sql3 = "insert into marchandjoca.meuble (nom,largeur,hauteur,longueur, prix) VALUES('TABLE',15,15,25, 158.75);";
			String sql4 = "insert into marchandjoca.meuble (nom,largeur,hauteur,longueur, prix) VALUES('CHAISE',8,20,8, 115.00);";
			String sql5 = "insert into marchandjoca.meuble (nom,largeur,hauteur,longueur, prix) VALUES('ARMOIRE',10,30,25, 250.45);";
			System.out.println("FUCK YOU");
			stat.executeUpdate(sql);
			stat.executeUpdate(sql2);
			stat.executeUpdate(sql3);
			stat.executeUpdate(sql4);
			stat.executeUpdate(sql5);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String dropMeuble = "DROP TABLE marchandjoca.meuble";
			stat.executeUpdate(dropMeuble);
			String sql = "CREATE TABLE MarchandJOCA.meuble(nom VARCHAR(255) not null, prix DECIMAL(5,2) not null, hauteur DECIMAL(6,2) not null, largeur DECIMAL(6,2) not null, longueur DECIMAL(6,2) not null, id BIGINT not null PRIMARY KEY AUTO_INCREMENT);";
			stat.executeUpdate(sql);
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

			String sql = "CREATE DATABASE MarchandJOCA";
			stat.executeUpdate(sql);

			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			int minorVersion = driver.getMinorVersion();
			System.out.println("Pilote = " + driver.getClass() + " version " + minorVersion + " " + majorVersion);
			DriverPropertyInfo[] props;
			try {
				props = driver.getPropertyInfo("url JDBC", null);
				for (int i = 0; i < props.length; i++) {
					DriverPropertyInfo prop = props[i];
					System.out.println("Prop :" + prop.name);
					String[] choix = prop.choices;
					if (choix != null) {
						for (int j = 0; j < choix.length; j++) {
							System.out.println("\tprop Choix " + j + " " + choix[j]);
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

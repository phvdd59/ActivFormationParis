package com.formation.beba.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class MainJDBCref {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost/marchandphva";

	public String user = "root";
	public String pass = "";

	public static void main(String[] args) {
		MainJDBCref m = new MainJDBCref();
		//m.init();
		//m.create();
		//m.creTable();
		//m.selectTable();
		//m.insertTable();
		//m.selectMetaData();
		m.updateTable();
		m.selectTable();
	}

	public void create3() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "CREATE DATABASE marchandphva";

			stat.executeUpdate(sql);
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void create() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "CREATE TABLE marchand ( "//
					+ "ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, "//
					+ "NOM VARCHAR(30) NOT NULL"//
					+ ", PRENOM VARCHAR(30) NOT NULL"//
					+ ", AGE VARCHAR(10) NOT NULL);";

			stat.executeUpdate(sql);
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String[] tabEtudiant = { "ambr", "anfr", "beba", "emma", "etga", "issa", "jeci", "made", "soka", "thcr", "thde" };

			for (int i = 0; i < tabEtudiant.length; i++) {
				String sql = "INSERT INTO marchand " //
						+ "(nom, prenom, age)" + "VALUES ('Active','" + tabEtudiant[i] + "','" + i + "');";

				int resultat = stat.executeUpdate(sql);
				if (resultat >= 0) {
					System.out.println("OK");
				} else {
					System.out.println("NOK");
				}
			}
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String[] tabEtudiant = { "ambr", "anfr", "beba", "emma", "etga", "issa", "jeci", "made", "soka", "thcr", "thde" };
				String sql = "UPDATE marchand " //
						+ "set prenom = 'ambr1' "
						+ "where prenom = 'ambr';";

				int resultat = stat.executeUpdate(sql);
				if (resultat >= 0) {
					System.out.println("OK");
				} else {
					System.out.println("NOK");
				}
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM marchand; ";
			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				String sNom = resultat.getString("nom");
				String sPrenom = resultat.getString("prenom");
				String sAge = resultat.getString("age");
				System.out.println(sNom + " " + sPrenom + " " + sAge);
			}

			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectMetaData() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM marchand where prenom='ambr'; ";
			ResultSet resultat = stat.executeQuery(sql);
			ResultSetMetaData meta = resultat.getMetaData();
			int nb = meta.getColumnCount();
			for (int i = 0; i < nb; i++) {
				System.out.println(meta.getColumnName(i+1)+" "+
						meta.getColumnTypeName(i+1));
			}

			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
					System.out.println("Prop : " + prop.name);
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

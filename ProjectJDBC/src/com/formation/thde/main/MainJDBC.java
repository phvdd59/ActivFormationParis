package com.formation.thde.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import com.mysql.jdbc.ResultSetMetaData;

public class MainJDBC {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost";

	public String user = "root";
	public String pass = "";

	public static void main(String[] args) {
		MainJDBC main = new MainJDBC();
		//main.init();
		//main.create();
		//main.createTable();
		//main.insertTable();
		main.selectTrucTable();
	}

	public void create() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "CREATE DATABASE marchandTHDE;";
			stat.executeUpdate(sql);
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "CREATE TABLE marchandTHDE.marchand("// 
					+ "ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT"//
					+ ", NOM VARCHAR(30) NOT NULL"//
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

			String[] tabEtudiant = { "ambr", "anfr", "beba", "emma" };
			for (int i = 0; i < tabEtudiant.length; i++) {

				String sql = "INSERT INTO marchandTHDE.marchand "// 
						+ "(nom, age)"//
						+ "VALUES ('" + tabEtudiant[i] + "','" + i + "');";
				stat.executeUpdate(sql);
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

			String sql = "SELECT * FROM marchandTHDE.marchand; ";// 
			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				String sNom = resultat.getString("nom");
				String sAge = resultat.getString("age");
				System.out.println(sNom + " " + sAge);
			}
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectTrucTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM marchandTHDE.marchand where nom='ambr'; ";// 
					ResultSet resultat = stat.executeQuery(sql);
					//metadatas
					ResultSetMetaData meta = resultat.getMetaData();
					int nb = meta.getColumnCount();
					for (int i = 0; i < nb; i++) {
						System.out.println(meta.getColumnLabel(nb));
					}
					while (resultat.next()){
						String sNom = resultat.getString("nom");
						String sAge = resultat.getString("age");
						System.out.println(sNom+" "+sAge);
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
			Class.forName("com.mysql.jdbc.Driver");
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
							System.out.println("prop Choix " + j + " " + choix[j]);
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

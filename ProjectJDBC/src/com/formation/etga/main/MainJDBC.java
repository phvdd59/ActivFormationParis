package com.formation.etga.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class MainJDBC {
	
	public final static String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	public final static String DB_URL= "jdbc:mysql://localhost/dbetga";
	
	public String user = "root";
	public String pass = "";
	
	public static void main(String[] args) {
		MainJDBC m = new MainJDBC();
//		m.init();
//		m.create();
//		m.createTable();
//		m.insertTable();
//		m.selectTable();
		m.selectMetadata();
	}
	
	public void selectMetadata() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "SELECT * FROM tetga where prenom='etga';";
			ResultSet resultat = stat.executeQuery(sql);
			ResultSetMetaData meta = resultat.getMetaData();
			int nb = meta.getColumnCount();
			for (int i = 0; i < nb; i++) {
				System.out.println(meta.getColumnName(i+1));
			}
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
			String sql = "SELECT * FROM tetga;";
			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				String sNom = resultat.getString("nom");
				String sPrenom = resultat.getString("prenom");
				String sAge = resultat.getString("age");
				System.out.println(sNom+" "+sPrenom+" "+sAge);
			}
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
			
			String [] tabEtudiant = {"ambr", "anfr", "beba", "emma", "etga", "issa", "jeci", "joca","made", "soka", "thcr", "thde"};
			for (int i = 0; i < tabEtudiant.length; i++) {
				String sql = "INSERT INTO tetga "
						+" (nom, prenom, age) "
						+ "VALUES ( 'ACTIV','"+tabEtudiant[i]+"','"+i+"');";
				stat.executeUpdate(sql);
			}
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
			String sql = "CREATE TABLE TETGA ("
					+"ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, " 
					+"NOM VARCHAR (30) NOT NULL, " 
					+"PRENOM VARCHAR (30) NOT NULL, "
					+"AGE VARCHAR (10) NOT NULL);";
			stat.executeUpdate(sql);
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
			String sql = "CREATE DATABASE DBETGA";
			stat.executeUpdate(sql);
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
			e.printStackTrace();
		}
		Enumeration<Driver> e =DriverManager.getDrivers();
		while (e.hasMoreElements()) {
			Driver driver = (Driver) e.nextElement();
			int majorVersion = driver.getMajorVersion();
			int minorVersion = driver.getMinorVersion();
			System.out.println("Pilote = "+driver.getClass()+" version "+minorVersion+" à "+majorVersion);
			DriverPropertyInfo[] props;
			try {
				props = driver.getPropertyInfo("url JDBC", null);
				for (int i = 0; i < props.length; i++) {
					DriverPropertyInfo prop = props[i];
					System.out.println("Prop : "+prop.name);
					String [] choix = prop.choices;
					if (choix != null) {
						for (int j = 0; j < choix.length; j++) {
							System.out.println("\t prop Choix "+j+" "+choix[j]);
						}
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

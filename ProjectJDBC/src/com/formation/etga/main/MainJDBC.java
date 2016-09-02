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
	public final static String DB_URL= "jdbc:mysql://www.psyeval.fr/ajee";
	
	public String user = "ajee";
	public String pass = "erreuretga";
	
	public static void main(String[] args) {
		MainJDBC m = new MainJDBC();
//		m.init();
//		m.create();
		m.createTable();
//		m.insertTable();
//		m.selectTable();
//		m.selectMetadata();
//		m.updateTable();
//		m.deleteTable();
		
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
			System.out.println("FIN");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private int idDoc;
	private String nomDocUtil;
	private String type;
	private String nomDocFile;
	private long time;
	private String commentaire;
	
	public void createTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "CREATE TABLE DocPerso ("
					+"idDoc BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, " 
					+"nomDocUtil VARCHAR (50), "
					+"type VARCHAR (10), " 
					+"nomDocFile VARCHAR (50), "
					+"time BIGINT (50), "
					+"commentaire VARCHAR (100));";
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
			String sql = "CREATE DATABASE AJEE";
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
			String [] tabEtudiant = {"ambr", "anfr", "beba", "emma", "etga", "issa", "jeci", "joca","made", "soka", "thcr", "thde"};
			for (int i = 0; i < tabEtudiant.length; i++) {
				String sql = "INSERT INTO tetga "
						+" (nom, prenom, age) "
						+ "VALUES ( 'ACTIV','"+tabEtudiant[i]+"','"+i+"');";
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
			String sql = "SELECT * FROM tetga;";
			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				String sNom = resultat.getString("nom");
				String sPrenom = resultat.getString("prenom");
				String sAge = resultat.getString("age");
				System.out.println(sNom+" "+sPrenom+" "+sAge);
			}
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
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
				meta.getColumnLabel(i);
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
			String[] tabEtudiant = { "ambr", "anfr", "beba", "emma", "etga", "issa", "jeci", "joca", "made", "soka", "thcr", "thde" };
			String sql = "UPDATE tetga "+ "set prenom = 'ambr' " + "where prenom = 'ambr1';";
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
	
	public void deleteTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "DELETE from test.meuble "+ "where nom = 'SALUTCESTCOOL';";
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
		
}

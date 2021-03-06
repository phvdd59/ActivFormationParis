package com.formation.beba.main;

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
//		 m.create2();
//		m.update();
//		m.create();
//		m.creTable();
		m.insertTable();
		
	}
	
	public void insertTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String[] tabMarchand = { "ambr", "anfr", "beba", "emma", "etga", "issa", "jeci", "made", "soka", "thcr", "thde" };
			String[] tabfruit ={"kiwi","orange","pomme","citron","noisette"};
			for (int i = 0; i < tabMarchand.length; i++) {
				String noM=new String();
				if (i==2) {
					noM="NiceGuy";
				}else {
					noM="Connard";
				}
				String sql = "INSERT INTO marchand " //
						+ "(nom, prenom, age)" + "VALUES ('Connard','" + tabMarchand[i] + "','" + i + "');";			
				int resultat = stat.executeUpdate(sql);
				
				String sql3 = "SELECT ID FROM marchand where prenom='"+tabMarchand[i]+"'; ";
				ResultSet resultat2 = stat.executeQuery(sql3);
				resultat2.first();
				String idM=resultat2.getString("ID");
				for (int j = 0; j < tabfruit.length; j++) {
					String sql2 = "INSERT INTO produit " + "(IDMARCHAND, NOMPRODUIT, qteproduit)" + "VALUES ('" +idM + "','" + tabfruit[j] + "',"+Math.random()*250+");";
					stat.executeUpdate(sql2);
				}
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
	
	
	
	
	
	public void create() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "CREATE TABLE produit ( "//
					+ "IDPRODUIT INTEGER(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, "//
					+ "IDMARCHAND BIGINT"//
					+ ", NOMPRODUIT VARCHAR(255) "//
					+ ", qteproduit INT);";

			stat.executeUpdate(sql);
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
//	public void create() {
//		Connection conn = null;
//		Statement stat = null;
//		try {
//			Class.forName(JDBC_DRIVER);
//			conn = DriverManager.getConnection(DB_URL, user, pass);
//			stat = conn.createStatement();
//
//			String sql = "CREATE DATABASE marchandphva";
//
//			stat.executeUpdate(sql);
//			System.out.println("FIN");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public void creTable() {
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
	
	
	

	public void create2() {
		Statement stat = null;
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "CREATE DATABASE Activprov";
			stat.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			System.out.println("pilote = " + driver.getClass() + " version = " + minorVersion + "  " + majorVersion);
			DriverPropertyInfo[] props;
			try {
				props = driver.getPropertyInfo("url JDBC", null);

				for (int i = 0; i < props.length; i++) {
					DriverPropertyInfo prop = props[i];
					System.out.println("prop = " + prop.name);
					String[] choix = prop.choices;
					if (choix != null) {
						for (int j = 0; j < choix.length; j++) {
							System.out.println("prop choix = " + j + " " + choix[j]);
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

package com.formation.soka.main;

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
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost/MarchandSoka";

	public String user = "root";
	public String pass = "";

	public static void main(String[] args) {
		MainJDBC m = new MainJDBC();
		//m.init();
		//m.create();
		//m.createTable();
		//m.insertTable(); 
		m.selectTable();
		//m.selectTableMetaData();
		//m.updateTable();
		//m.deleteTable();
		m.prodMarchand();
	}

	public void prodMarchand() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String[] tabEtudiant = { "made", "soka", "thcr", "thde" };
			String insertTable = null; 
			for (int i = 0; i < tabEtudiant.length; i++) {
				for (int j = 0; j < 5; j++) {
					insertTable = "INSERT INTO marchandsoka.produit "//
							+ "(idMarchand, nomProduit, qteProduit)"//
							+ "VALUES (" + i + ", 'titi" + j + "', 2);";
					stat.executeUpdate(insertTable);
				}
				
//				int resultat = stat.executeUpdate(sql);
//				if (resultat >= 0) {
//					System.out.println("OK");
//				} else {
//					System.out.println("NOK");
//				}
			}
			System.out.println("fin");
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
			String sql = "DELETE from marchandsoka.produit where idProduit>=1081 ; ";
			int resultat = stat.executeUpdate(sql);
			if (resultat >= 0) {
				System.out.println("ok");
			} else {
				System.out.println("non ok");
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
			String sql = "UPDATE marchandsoka.marchand set nom='soka11' where nom='Kadri' ; ";
			int resultat = stat.executeUpdate(sql);
			if (resultat >= 0) {
				System.out.println("ok");
			} else {
				System.out.println("non ok");
			}
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectTableMetaData() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String selectTable = "SELECT * FROM marchand where nom='KADRI'; ";
			ResultSet result = stat.executeQuery(selectTable);
			ResultSetMetaData meta = result.getMetaData();
			int nb = meta.getColumnCount();
			//System.out.println(meta.getColumnLabel(0));
			for (int i = 0; i < nb; i++) {
				System.out.println(meta.getColumnName(i + 1));
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
			String selectTable = "SELECT * FROM marchand; ";
			ResultSet result = stat.executeQuery(selectTable);
			while (result.next()) {
				String sNom = result.getString("nom");
				String sPrenom = result.getString("prenom");
				String sAge = result.getString("age");
				System.out.println(sNom + " " + sPrenom + " " + sAge);
			}
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
			String insertTable = "INSERT INTO marchand "//
					+ "(nom, prenom, age)"//
					+ "VALUES ('KADRI', 'Souad', '24');";
			String insertTable2 = "INSERT INTO marchand "//
					+ "(nom, prenom, age)"//
					+ "VALUES ('CRESSON', 'Thomas', '4');";
			stat.executeUpdate(insertTable);
			stat.executeUpdate(insertTable2);
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
			String table = "CREATE TABLE marchand (ID bigint not null primary key auto_increment, "//
					+ "NOM varchar(30) not null, "//
					+ "PRENOM varchar(30) not null, "//
					+ "AGE varchar(10) not null) ;";
			stat.executeUpdate(table);
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
			String sql = "CREATE DATABASE MarchandSoka";
			stat.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		try {
			Class.forName("JDBC_DRIVER");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Enumeration<Driver> e = DriverManager.getDrivers();
		// Pour savoir avec quelles version le Driver va fonctionner: entre minor et major version
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
							System.out.println("prop choix " + j + " " + choix[j]);
						}
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

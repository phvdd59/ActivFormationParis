package com.formation.emma.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class MainJDBC {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost/marchand";

	public String user = "root";
	public String pass = "";

	public static void main(String[] args) {
		MainJDBC m = new MainJDBC();
		// m.init();
		//m.create();
		//m.creTable();
		//m.insertTable();
		m.modifMarchand();
		
	}

	private void modifMarchand() {
		Connection conn = null;
		Statement stat = null;
		
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, user, pass);
				stat = conn.createStatement();
				
					String sql= "delete from marchandemma where id=1;" ;
					
					stat.executeUpdate(sql);
				
			
				System.out.println("fin");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
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
				
				String[] marchand = {"Dupuis", "Yannick","45","Prost","Yves","58","Leberger","Corinne","64"};
				for (int i = 0; i < marchand.length; i++) {
					String sql= "insert into marchandemma (nom,prenom,age) values ('"+marchand[i]+"','"+marchand[i+1]+"','"+marchand[i+2]+"');";
					i=i+2;
					stat.executeUpdate(sql);
				}
			
				System.out.println("fin");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	private void creTable() {
		Connection conn = null;
		Statement stat = null;
		
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, user, pass);
				stat = conn.createStatement();
				
				String sql="create table marchandEmma (ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, NOM varchar(30) NOT NULL, PRENOM varchar(30) NOT NULL, AGE varchar(10) NOT NULL);";
				
				stat.executeUpdate(sql);
				System.out.println("fin");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
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
				String sql="CREATE DATABASE Marchand";
				
				stat.executeUpdate(sql);
				System.out.println("fin");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
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
			System.out.println("Pilote =" + driver.getClass() + " version " + minorVersion + " " + majorVersion);

			DriverPropertyInfo[] props;
			try {
				props = driver.getPropertyInfo("url JDBC", null);
				for (int i = 0; i < props.length; i++) {
					DriverPropertyInfo prop = props[i];
					System.out.println("prop : " + prop.name);
					String[] choix = prop.choices;
					if (choix != null) {
						for (int j = 0; j < choix.length; j++) {
							System.out.println("/tprop choix " + j + " " + choix[j]);
						}

					}
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

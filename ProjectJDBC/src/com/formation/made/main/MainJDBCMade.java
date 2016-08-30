package com.formation.made.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class MainJDBCMade {
	public final static String JDBC_DRIVER="com.mysql.jdbc.Driver"; 
	public final static String DB_URL="jdbc:mysql://localhost/marchandmade"; 

		public String user="root";
		public String pass="";
	public static void main(String[] args) {
		MainJDBCMade m=new MainJDBCMade();
		//m.init();
		//m.create();
		//m.createTab();
		m.insertTable();
		//m.selectTable();
	}

	private void selectTable() {
		Connection conn=null;
		Statement stat=null;
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection( DB_URL,user,pass);
			stat=conn.createStatement();
			
			String sql="SELECT *FROM personne";
			ResultSet resultat=stat.executeQuery(sql);
			while (resultat.next()) {
				String sNom=resultat.getString("nom");
				String sPrenom=resultat.getString("Prenom");
				String sAge=resultat.getString("age");
				System.out.println("nom "+sNom +" prenom "+sPrenom+" age "+sAge );
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
		Connection conn=null;
		Statement stat=null;
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection( DB_URL,user,pass);
			stat=conn.createStatement();

			String sqlDelete="delete from personne ; ";
			String sql0="INSERT INTO personne (nom,prenom,age) VALUES ('nom1','prenom1', '27');";
			String sql="INSERT INTO personne (nom,prenom,age) VALUES ('denis','marc', '27');";
			String sql2="INSERT INTO personne (nom,prenom,age) VALUES ('bon','jean', '33');";
			String sql3="INSERT INTO personne (nom,prenom,age) VALUES ('nom3','prenom3', '40');";
			String sql4="INSERT INTO personne (nom,prenom,age) VALUES ('nom4','prenom4', '15');";
			stat.executeUpdate(sqlDelete);
			stat.executeUpdate(sql0);
			stat.executeUpdate(sql);
			stat.executeUpdate(sql2);
			stat.executeUpdate(sql3);
			stat.executeUpdate(sql4);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createTab() {
		Connection conn=null;
		Statement stat=null;
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection( DB_URL,user,pass);
			stat=conn.createStatement();
			String sqlDrop="drop table marchandmade.banane;";
			stat.executeUpdate(sqlDrop);
			String sql="CREATE TABLE Marchandmade.personne(ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,NOM VARCHAR(30) NOT NULL,PRENOM VARCHAR(30) NOT NULL,AGE VARCHAR(10) NOT NULL);";		
			stat.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void create() {
		Connection conn=null;
		Statement stat=null;
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection( DB_URL,user,pass);
			stat=conn.createStatement();
			String sql="CREATE DATABASE MarchandMade";
			stat.executeUpdate(sql);
			
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
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Enumeration<Driver> e=DriverManager.getDrivers();
		while(e.hasMoreElements()){
			Driver driver=(Driver) e.nextElement();
			int majorVersion=driver.getMajorVersion();
			int minorVersion=driver.getMinorVersion();
			System.out.println("Pilote= "+driver.getClass()+" version "+minorVersion +" "+majorVersion);
			DriverPropertyInfo[] props;
			try {
				props=driver.getPropertyInfo("url JDBC", null);
				for (int i = 0; i < props.length; i++) {
					DriverPropertyInfo prop=props[i];
					System.out.println("Prop : " +prop.name); 
					String[] choix = prop.choices;
					if(choix != null){
						for (int j = 0; j < choix.length; j++) {
							System.out.println("\t prop Choix "+j+" "+choix[j]);
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

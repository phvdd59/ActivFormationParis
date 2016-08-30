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

public class MainExoEtga {
	
	public final static String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	public final static String DB_URL= "jdbc:mysql://localhost/dbetga";
	
	public String user = "root";
	public String pass = "";
	
	public static void main(String[] args) {
		MainExoEtga m = new MainExoEtga();
		m.insertTable();
	}
	
	public void insertTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String [] tabEtudiant = {"ambr", "anfr", "beba", "emma", "etga", "issa", "jeci", "joca","made", "soka", "thcr", "thde"};
			String [] tabProduit = {"patate", "navet", "carotte", "poireau", "choux", "salade", "peche", "melon","mangue", "poire"};
			for (int i = 0; i < tabEtudiant.length; i++) {
				for (int j = 0; j < tabProduit.length; j++) {
					String sql = "INSERT INTO produit "
							+" (idTetga, nomProduit, qteProduit) "
							+ "VALUES ( '"+(i+12)+"','"+tabProduit[j]+"','"+(int)(Math.random()*15)+"');";
					stat.executeUpdate(sql);
				}
			}
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}

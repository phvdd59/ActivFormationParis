package com.formation.ajee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.formation.ajee.metier.DocPerso;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class DaoDocument {
	public final static String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	public final static String DB_URL= "jdbc:mysql://localhost/ajee";
	
	public String user = "root";
	public String pass = "";
	
	public void insertTable() {
		Connection connexion = null;
		Statement statement = null;
		ArrayList<DocPerso> listeDoc = new ArrayList<DocPerso>();
		DocPerso docPerso = new DocPerso();
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();
			for (int i = 0; i < listeDoc.size(); i++) {
				String sql = "INSERT INTO AJEE "
						+" (nomDocUtil, type, nomDocFile, time, commentaire) "
						+ "VALUES (" +docPerso.getNomDocUtil()+"," +docPerso.getType()+"," 
						+docPerso.getNomDocFile()+"," +docPerso.getTime()+"," +docPerso.getCommentaire()+" );";
				statement.executeUpdate(sql);
			}
			System.out.println("Insert terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void deleteTable() {
		Connection conn = null;
		Statement stat = null;
		ArrayList<DocPerso> listeDoc = new ArrayList<DocPerso>();
		DocPerso docPerso = new DocPerso();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "DELETE from AJEE.docPerso "+ "where idDoc = "+docPerso.getIdDoc()+";";
				int resultat = stat.executeUpdate(sql);
				if (resultat >= 0) {
					System.out.println("OK");
				} else {
					System.out.println("NOK");
				}
			System.out.println("Delete terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

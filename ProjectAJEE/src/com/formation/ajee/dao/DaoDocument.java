package com.formation.ajee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.formation.ajee.metier.DocPerso;

public class DaoDocument {
	public final static String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	public final static String DB_URL= "jdbc:mysql://www.psyeval.com/ajee";
	
	public String user = "ajee";
	public String pass = "erreuretga";
	public ArrayList<DocPerso> listeDoc;
	public DocPerso docPerso;
	
	
	public void insertTable(DocPerso docPerso) {
		Connection connexion = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();
			String sql = "INSERT INTO ajee.DocPerso "
					+" (nomDocUtil, type, nomDocFile, time, commentaire) "
					+ "VALUES ('" +docPerso.getNomDocUtil()+"','" +docPerso.getType()+"','" 
					+docPerso.getNomDocFile()+"','" +docPerso.getTime()+"','" +docPerso.getCommentaire()+"' );";
			statement.executeUpdate(sql);
			System.out.println("Insert terminé");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void deleteTable(DocPerso docPerso) {
		Connection connexion = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();
			String sql = "DELETE from ajee.DocPerso "+ "where idDoc = "+docPerso.getIdDoc()+";";
			statement.executeUpdate(sql);
			System.out.println("Delete terminé");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

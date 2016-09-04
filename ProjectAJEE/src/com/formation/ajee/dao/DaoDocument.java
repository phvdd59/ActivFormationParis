package com.formation.ajee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.formation.ajee.metier.DocPerso;

public class DaoDocument {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://www.psyeval.com/ajee";

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
			String sql = "INSERT INTO ajee.DocPerso " + " (idPersone, nomDocUtil, type, nomDocFile, time, commentaire) " + "VALUES ('" + docPerso.getIdPersonne() + "','" + docPerso.getNomDocUtil() + "','" + docPerso.getType() + "','" + docPerso.getNomDocFile() + "','" + docPerso.getTime() + "','" + docPerso.getCommentaire() + "' );";
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
			String sql = "DELETE from ajee.DocPerso " + "where idDoc = " + docPerso.getIdDoc() + ";";
			statement.executeUpdate(sql);
			System.out.println("Delete terminé");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DocPerso> lectureTable(int idPersonne) {
		Connection connexion = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();
			String sql = "SELECT * FROM DocPerso where DocPerso.idPersonne = "+idPersonne+" ;";
			ResultSet resultat = statement.executeQuery(sql);
			while (resultat.next()) {
				String sNomDocUtil = resultat.getString("nomDocUtil");
				String sCommentaire = resultat.getString("commentaire");
				DocPerso docPerso = new DocPerso(sNomDocUtil, sCommentaire);
				System.out.println(sNomDocUtil + " " + sCommentaire);
				listeDoc.add(docPerso);
			}
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeDoc;
	}
	
	
	
	
}

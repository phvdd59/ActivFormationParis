package com.formation.thcr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.formation.thcr.metier.Personne;

public class DAOPersonne {

	public final static String	JDBC_DRIVER	= "com.mysql.jdbc.Driver";
	public final static String	DB_URL		= "jdbc:mysql://localhost/listpersonne";

	public String				user		= "root";
	public String				pass		= "";

	public void create(Personne personne) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER); //nom du driver
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			String sql = "INSERT INTO listpersonne.personne"//
					+ "(LOGIN,PASS,NOM,PRENOM,MAIL,NATIONALITE,ADMIN,ADRESSE)"//
					+ "VALUES('" + personne.getIdentifiant() + "','" + personne.getMdp() + "','" + personne.getNom() + "',"//
					+ "'" + personne.getPrenom() + "','" + personne.getEmail() + "','" + personne.getNationalite() + "',"//
					+ "'" + personne.isAdmin() + "','" + personne.getAdresse() + "');";//
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("OK : " + result);
			} else {
				System.out.println("Erreur");
			}
			statement.close();
			System.out.println("fin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Personne read(Personne personne) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER); //nom du driver
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			String sql = "SELECT * FROM listpersonne.personne";
			ResultSet result = statement.executeQuery(sql);
			boolean check = false;
			//TRAITER LES METADATA pour contrôler les erreurs
			while (result.next()) {
				if (personne.getIdentifiant().equals(result.getString("LOGIN"))) {
					personne.setIdentifiant(result.getString("LOGIN"));
					personne.setAdmin(Boolean.valueOf(result.getString("ADMIN")).booleanValue());
					personne.setAdresse(result.getString("ADRESSE"));
					personne.setNom(result.getString("NOM"));
					personne.setPrenom(result.getString("PRENOM"));
					personne.setEmail(result.getString("MAIL"));
					personne.setNationalite(result.getString("NATIONALITE"));
					check = true;
				}
			}
			statement.close();
			if (check) {
				System.out.println("OK");
			} else {
				System.out.println("erreur");
			}
			System.out.println("fin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personne;
	}

}

package com.formation.thde.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonneTest {
	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost/";
	public String user = "root";
	public String pass = "";

	//	String mail;
	//	String nom;
	//	String prenom;
	//
	//	public PersonneTest() {
	//		this.mail = "";
	//		this.nom = "";
	//		this.prenom = "";
	//	}
	//	
	//	public PersonneTest(String mail, String nom, String prenom) {
	//		this.mail = mail;
	//		this.nom = nom;
	//		this.prenom = prenom;
	//	}

	public Personne getPersonne(String Id) {
		Personne personne = null;
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "listeUserActiv";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			String sql = "SELECT * FROM listeUser WHERE IDPersonne ='" + Id + "';";
			ResultSet resultat = stat.executeQuery(sql);
			resultat.first();
			personne = new Personne(resultat.getString("email"), resultat.getString("nom"), resultat.getString("prenom"));
		} catch (Exception e) {
			e.printStackTrace();
		}
//		personne = new Personne ("testemail", "testnom","testprenom");
		return personne;
	}
}
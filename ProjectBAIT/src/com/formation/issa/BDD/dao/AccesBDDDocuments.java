package com.formation.issa.BDD.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.formation.bait.metier.DocPerso;
import com.formation.bait.metier.ListeDoc;

public class AccesBDDDocuments {

	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost/";

	public String user = "root";
	public String pass = "";

	public int saveAllDocs(ListeDoc lstdoc){
		int result = 1;
		for (DocPerso docPerso : lstdoc) {
			int res = saveDoc(docPerso);
			if (res == 0){
				result =0;
				break;
			}
		}
		return result;
	}
	
	public int saveDoc(DocPerso doc) {
		Connection conn = null;
		Statement stat = null;
		int result = 0;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "listeUserActiv";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "UPDATE listeDocument set nomDocUtil='" + doc.getNomDocUtil() + "', type='" + //
					doc.getType() + "', nomDocFile='" + doc.getNomDocFile() + "', time='" + doc.getTime() + //
					"', commentaire='" + doc.getCommentaire() + ", WHERE IDDocument=" + doc.getIDDocument() + ";";
			System.out.println(sql);
			stat.executeUpdate(sql);
			result = 1;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ListeDoc findAllUserDocs(int IDPersonne) {
		ListeDoc listDocs = new ListeDoc();
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "listeUserActiv";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM listeDocument WHERE IDPersonne=" + IDPersonne + ";";

			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				DocPerso sDoc = new DocPerso();
				sDoc.setIDDocument(resultat.getInt("IDDocument"));
				sDoc.setIDPersonne(resultat.getInt("IDPersonne"));
				sDoc.setNomDocUtil(resultat.getString("nomDocUtil"));
				sDoc.setNomDocFile(resultat.getString("nomDocFile"));
				sDoc.setType(resultat.getString("type"));
				sDoc.setTime(resultat.getString("time"));
				sDoc.setCommentaire(resultat.getString("commentaire"));
				listDocs.add(sDoc);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listDocs;
	}

	public int creNewDoc(DocPerso doc, int IDPersonne) {
		Connection conn = null;
		Statement stat = null;
		int result = 0;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "listeUserActiv";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "insert into listeDocs (IDPersonne,nomDocUtil,nomDocFile,type,time,commentaire" //
					+ ") values ('" + IDPersonne + "','" + doc.getNomDocUtil() + "','" + doc.getNomDocFile() //
					+ "','" + doc.getType() + "','" + doc.getTime() + "','" + doc.getCommentaire() + "');";
			stat.executeUpdate(sql);
			result= 1;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}

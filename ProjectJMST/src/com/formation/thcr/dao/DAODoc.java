package com.formation.thcr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jcp.xml.dsig.internal.dom.DOMSignatureProperties;

import com.formation.thcr.metier.DocPerso;

public class DAODoc {

	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost/listpersonne";

	public String user = "root";
	public String pass = "";

	public void create(DocPerso docPerso) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			String sql = "INSERT INTO listpersonne.docPerso"//
					+ "(nomDocUtil, type, nomDocFile, time, commentaire)"//
					+ "VALUES('" + docPerso.getNomDocUtil() + "','" + docPerso.getNomDocUtil().substring(docPerso.getNomDocUtil().lastIndexOf(".")) + "','" + docPerso.getNomDocFile() + "',"//
					+ docPerso.getTime() + ",'" + docPerso.getCommentaire() + "');";//
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("OK : " + result);
			} else {
				System.out.println("Erreur");
			}
			statement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void read(DocPerso docPerso) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			String sql = "SELECT * FROM listpersonne.docPerso;";
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				docPerso.setIdDoc(Integer.valueOf(result.getString("idDoc")).intValue());
				docPerso.setNomDocUtil(result.getString("nomDocUtil"));
				docPerso.setType(result.getString("type"));
				docPerso.setNomDocFile(result.getString("nomDocFile"));
				docPerso.setTime(Long.valueOf(result.getString("time")).longValue());
				docPerso.setCommentaire(result.getString("commentaire"));
			}
			statement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(DocPerso docPerso) {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "UPDATE listpersonne.docPerso SET nomDocUtile='" + docPerso.getNomDocUtil() //
					+ "', type='" + docPerso.getNomDocUtil().substring(docPerso.getNomDocUtil().lastIndexOf("."))//
					+ "', nomDocFile='" + docPerso.getNomDocFile()//
					+ "', time=" + docPerso.getTime()//
					+ ", commentaire='" + docPerso.getCommentaire()//
					+ "WHERE idDoc=" + docPerso.getIdDoc() + ";";//
			int resultat = stat.executeUpdate(sql);
			if (resultat >= 0) {
				System.out.println("ok");
			} else {
				System.out.println("non ok");
			}
			stat.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(DocPerso docPerso) {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "DELETE from listpersonne.docPerso where idDoc=" + docPerso.getIdDoc() + " ; ";
			int resultat = stat.executeUpdate(sql);
			if (resultat >= 0) {
				System.out.println("ok");
			} else {
				System.out.println("non ok");
			}
			stat.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

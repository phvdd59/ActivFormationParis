package com.formation.thcr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
			Class.forName(JDBC_DRIVER); //nom du driver
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			String sql = "INSERT INTO listpersonne.docPerso"//
					+ "(nomDocUtil, typeDoc, nomDocFile, time, commentaire)"//
					+ "VALUES('" + docPerso.getNomDocUtil() + "','" + docPerso.getType() + "','" + docPerso.getNomDocFile() + "',"//
					+ "'" + docPerso.getTime() + "','" + docPerso.getCommentaire() + "');";//
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
}

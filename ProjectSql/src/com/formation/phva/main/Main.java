package com.formation.phva.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Main implements Runnable {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost/marchandphva";
	public final static String user = "root";
	public final static String pass = "";

	public Date dateEncours;
	public Date datePromo;

	public static void main(String[] args) throws IOException, InterruptedException {
		Main m = new Main();
		m.init();
	}

	public void init() throws IOException, InterruptedException {
		//selectTable();
		monPerso();
	}

	public void monPerso() throws InterruptedException {
		Perso1 p = null;
		dateEncours = new Date();
		datePromo = new Date(new Date().getTime() - 10l * 24l * 60l * 60l * 1000l);
		Thread t = new Thread(this);
		t.start();
		try {
			p = new Perso1("VDD", dateEncours, datePromo);
			Thread.sleep(200);
			System.out.println(p.toString());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectTable() throws IOException {
		BufferedReader bIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Donnez votre pseudo !");
		String s = bIn.readLine();
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM marchand where nomMarchand = \"" + s + "\"; ";
			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				String sNom = resultat.getString("nomMarchand");
				String sPrenom = resultat.getString("idMarchand");
				String sAge = resultat.getString("ageMarchand");
				System.out.println(sNom + " " + sPrenom + " " + sAge);
			}

			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selectTable1() throws IOException {
		BufferedReader bIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Donnez votre pseudo !");
		String s = bIn.readLine();
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM marchand where nomMarchand = \"" + s + "\"; ";
			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				String sNom = resultat.getString("nomMarchand");
				String sPrenom = resultat.getString("idMarchand");
				String sAge = resultat.getString("ageMarchand");
				System.out.println(sNom + " " + sPrenom + " " + sAge);
			}

			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		datePromo.setTime(new Date().getTime() + 10l * 24l * 60l * 60l * 1000l);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		datePromo.setTime(new Date().getTime() - 10l * 24l * 60l * 60l * 1000l);
	}

}

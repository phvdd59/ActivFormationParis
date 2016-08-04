package com.formation.phva.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux m = new MainFlux();
		m.initLecture();
		m.initImage();
	}

	public void initImage() {

	}

	public void initLecture() {
		File file = new File("./src/com/formation/phva/data/texte.txt");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bIn = new BufferedReader(inputStreamReader);
			String line = bIn.readLine();
			while (line != null) {
				System.out.println(line);
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void initEcriture() {
		File file = new File("./src/com/formation/phva/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour tout le monde.");
			out.println("ceci doit apparaitre dans le fichier");
			out.flush();
			out.print("Suite de la phrase");
			out.print("Autre Suite de la phrase");
			out.println("32Autre Suite de la phrase");
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			out.close();
		}

	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			File fileTest = new File("c:/DevFormation");
			System.out.println(fileTest.exists());
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);
				File f = new File(ligne);
				if (f.exists()) {
					if (f.isDirectory()) {
						File[] fn = null;
						fn = f.listFiles();
						for (int i = 0; i < fn.length; i++) {
							String nomDuFile = null;
							nomDuFile = fn[i].getName();
							System.out.println(nomDuFile);

						}
					}
				}
				System.out.println("existe : " + f.exists() + " repertoire " + ((f.isDirectory()) ? "OUI" : "NON") + " path " + f.getCanonicalPath());
				ligne = stdIn.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				stdIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

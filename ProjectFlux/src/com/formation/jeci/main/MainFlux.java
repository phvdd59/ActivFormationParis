package com.formation.jeci.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainFlux {

	public static void main(String[] args) throws Exception {
		MainFlux m = new MainFlux();
		// m.init();
		// m.initEcriture();
		m.initLecture();

	}

	private void initLecture() {
		File file = new File("./src/com/formation/joca/data/texte.txt");

		BufferedReader bIn = null;
		try {
			bIn = new BufferedReader(new FileReader(file));
			String ligne = bIn.readLine();
			while (ligne != null) {
				System.out.println(ligne);
				ligne = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void initEcriture() throws Exception {
		File file = new File("./src/com/formation/etga/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("bonjour tout monde.");
			out.println("♥ceci doit apparaitre dans le fichier♥");
			out.flush();
			out.println("Suite de la phrase: thomas est un tocard");
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			out.close();
		}

	}

	private void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);

				File file = new File(ligne);
				if (file.exists()) {
					String typeMime = null;

					String[] nomFichier = file.getParentFile().list();

					for (int i = 0; i < nomFichier.length; i++) {

						if (nomFichier[i].contains(".")) {
							System.out.println(nomFichier[i].substring(nomFichier[i].lastIndexOf(".") + 1));
						}
					}
					for (String string : nomFichier) {
						System.out.println(string);
					}
					System.out.println("le fichier existe" + file.isDirectory() + "  " + file.getAbsolutePath());
				} else {
					System.out.println("le fichier n'existe pas");
				}
				ligne = stdIn.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stdIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

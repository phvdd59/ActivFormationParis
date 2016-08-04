package com.formation.made.main;

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
		MainFlux.initEcriture();
	}

	public void iniLecture() {
		File file = new File("./src/com/formation/issa/data/texte.txt");
		BufferedReader bIn = null;
		try {
			bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();
			while (line != null) { // on repert la fin du fichier si line est nul
				System.out.println(line);
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("je ne vois le fichier de Isma");
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

	private static void initEcriture() throws Exception {

		File file = new File("./src/com/formation/made/data/texte.txt"); // l'endroit ou on veut mettre le fichier plus el nom du ficher ici texte
		PrintWriter out = null; // la déclaration du flux TOUJOURS !!!
		try { // on la met en try catch parce qu'elle peut tomber en exception
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour tout le monde. ");
			out.println("Ceci doit apparaitre dans le fichier. ");
			out.flush(); // sert à transmission du flux sur le périph correspondant
			out.println("Suite de la phrase");
			out.println("Salut Isma :)");

		} catch (IOException e) {
			System.out.println("recommencez le traitement");
		} finally {
			out.close(); // on ferme TOUJOURS le FICHIER
		}

	}

	private static void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader((new InputStreamReader(System.in))); // le inputstreamreader transforme le flux binaire en caractère
		try {
			File filetest = new File("c:/DevFormation");
			System.out.println(filetest.exists());
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				// System.out.println(ligne);
				ligne = stdIn.readLine();
				File file = new File(ligne);
				if (file.exists()) {
					if (file.isDirectory()) {
						File[] tabFile = null;// la déclation pour le compilateur
						tabFile = file.listFiles();// instanciation
						for (File file2 : tabFile) {
							if (file2.isFile()) {
								String nom = file2.getName();
								if (nom.contains(".")) {
									int indicePoint = nom.lastIndexOf(".");
									String exte = nom.substring(indicePoint + 1);
									System.out.println(exte);
								}

							}

							// System.out.println(file2.getName());
						}
					}
					System.out.println("existe " + file.exists() + " répertoire" + ((file.isDirectory()) ? " OUI " : " NON ") + " path " + file.getCanonicalPath()); // getCanonicalPath pour pour remonter avec "../
				}
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
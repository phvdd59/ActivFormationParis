package com.formation.beba.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class MainFlux {

	public static void main(String[] args) throws Exception {
		MainFlux mainFlux = new MainFlux();
		mainFlux.initLecture();
	}

	public void initLecture() throws Exception {
		File file = new File("./src/com/formation/anfr/data/texte.txt");
		BufferedReader bIn = null;

		try {
			System.out.println(file.getCanonicalPath());
			bIn = new BufferedReader(new FileReader(file));
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

	public void initEcriture() throws Exception {
		File file = new File("./src/com/formation/beba/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour tout le monde ");
			out.println("ceci doit apparaitre dans le fichiers!");
			out.flush();
			out.print("Suite de la phrase");
		} catch (IOException e) {
			System.out.println("recomencer le traitement");
		} finally {
			out.close();
		}

	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {

			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				// System.out.println(ligne);

				File file = new File(ligne);
				System.out.println("Existe: " + file.exists() + " est un repertoire: " + file.isDirectory() + " path: " + file.getCanonicalPath());
				System.out.println("liste de fichier:");
				if (file.isDirectory()) {
					System.out.println(Arrays.toString(file.listFiles()));
					File[] fileAll = file.listFiles();
					System.out.println("liste des ext");
					for (int i = 0; i < fileAll.length; i++) {
						if (!fileAll[i].isDirectory()) {
							if (fileAll[i].getName().contains(".")) {

								System.out.print(fileAll[i].getName().substring(fileAll[i].getName().lastIndexOf('.') + 1) + ", ");
							}
						}
					}

				}
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

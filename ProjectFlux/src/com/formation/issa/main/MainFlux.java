package com.formation.issa.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainFlux {

	public static void main(String[] args) throws IOException {
		MainFlux m = new MainFlux();
		m.initEcriture();

	}

	public void initLecture() {
		File file = new File("./src/com/formation/issa/data/texte.txt");
		BufferedReader bIn = null;
		try {
			bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();
			while (line != null) {
				System.out.println(line);
				line = bIn.readLine();
			}

		} catch (

		FileNotFoundException e) {
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

	public void initEcriture() throws IOException {
		File file = new File("./src/com/formation/issa/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour tout le monde.");
			out.println("ceci doit apparaitre dans le fichier");
			out.flush();// transmission du flux sur le périphérique
						// correspondant
			out.print("Suite de la phrase");
			out.print(" Et un de plus.");
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
						// déclaration de fn
						fn = f.listFiles();
						for (int i = 0; i < fn.length; i++) {
							String nomDuFile = null;
							nomDuFile = fn[i].getName();
							System.out.println(nomDuFile);
							if (fn[i].isFile()) {
								if (nomDuFile.contains(".")) {
									System.out.println(nomDuFile.substring(nomDuFile.lastIndexOf(".") + 1));
								}
							}

						}
						File[] f2 = null;
						f2 = f.listFiles();

					}
				}

				System.out.println("existe : " + f.exists() + "repertoire " + ((f.isDirectory()) ? "OUI" : "NON") + "path" + f.getCanonicalPath());
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

package com.formation.made.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux m = new MainFlux();
		MainFlux.init();
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
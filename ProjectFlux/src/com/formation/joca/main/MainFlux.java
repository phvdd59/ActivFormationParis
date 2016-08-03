package com.formation.joca.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux m = new MainFlux();
		m.init();
	}

	private void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);
				File fichier = new File(ligne);
				if (fichier.exists()) {
					System.out.println("ca existe");
					if (fichier.isDirectory()) {
						System.out.println("c'est un dossier");
						fichier = fichier.getParentFile();

						for (File s : fichier.listFiles()) {
							if (s.isFile()) {
								if (s.getName().lastIndexOf('.') != -1) {
									System.out.println(s.getName().substring(s.getName().lastIndexOf('.') + 1));
								} else {
									System.out.println("fichier sans extension");
								}
							}
						}
					} else if (fichier.isFile()) {
						System.out.println("c'est un fichier");
					}

				} else {
					System.out.println("ca n'existe pas");
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

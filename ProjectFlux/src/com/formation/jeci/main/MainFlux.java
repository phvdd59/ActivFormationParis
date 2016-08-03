package com.formation.jeci.main;

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

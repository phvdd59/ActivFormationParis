package com.formation.beba.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux mainFlux = new MainFlux();
		mainFlux.init();
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

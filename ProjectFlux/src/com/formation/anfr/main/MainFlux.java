package com.formation.anfr.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainFlux {

	public static void main(String[] args) throws IOException {
		MainFlux mainFlux = new MainFlux();
	//	mainFlux.initEcriture();
		mainFlux.initLecture();

	}

	private void initLecture() throws IOException {
		File file = new File("./src/com/formation/beba/data/texte.txt");
		BufferedReader bIn = null;
		try {
			bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();
			while(line !=null) {
				System.out.println(line);
				 line = bIn.readLine();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			bIn.close();
		}
	}

	private void initEcriture() throws IOException {
		File file = new File("./src/com/formation/anfr/data/texte.txt");
		PrintWriter out = new PrintWriter(file);
		try {
			System.out.println(file.getCanonicalPath());
			out.println("MITHRA!!!");
			out.println("Au nom du père des pères,");
			out.flush();
			out.println("Que ta lumière soit faite!");
			out.print("Ps : Ibis Dieu de merde!");
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			out.close();
		}

	}

	private void init2() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);
				File file = new File(ligne);
				if (file.exists()) {
					System.out.println("Le répertoire existe.");
					System.out.println(file.getCanonicalPath());
					System.out.println("Fichiers dans le répertoire :");
					if (file.isDirectory()) {
						File[] listFile = file.listFiles();
						for (File file2 : listFile) {
							System.out.print(file2.getCanonicalPath());
							if (file2.isFile()) {

								String nomDuFichier = file2.getName();
								if (nomDuFichier.contains(".")) {
									int posPoint = nomDuFichier.lastIndexOf(".");
									String suffixe = nomDuFichier.substring(posPoint);
									System.out.println(" " + suffixe);
								} else {
									System.out.println("");
								}
							} else {
								System.out.println("");
							}

						}
					}
					System.out.println("Autre Méthode");
					if (file.isDirectory()) {
						System.out.println(Arrays.toString(file.listFiles()));
					}

				} else {
					System.out.println("Le répertoire n'existe pas.");
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

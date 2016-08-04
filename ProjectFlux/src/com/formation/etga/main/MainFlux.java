package com.formation.etga.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux m = new MainFlux();
		//		m.init();
		//		m.initEcriture();
		m. initLecture();
	}

	public void initLecture() {
		File file = new File("./src/com/formation/thde/data/texte.txt");
		BufferedReader bIn = null; 
		try {
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
	
	public void initEcriture() {
		File file = new File("./src/com/formation/etga/data/texte.txt");
		PrintWriter out = null; //on declare les variables en dehors du try et on les instancies.
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour tout le monde.");
			out.println("Ceci doit apparaitre dans le fichier");
			out.flush(); // transmission du flux sur le périph correspondant pour ne pas bloquer le programme
			out.print("Suite de la phrase");
		} catch (IOException e) {
			System.out.println("Recommencer le traitement");
		} finally {
			out.close();
		}
	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			// File fileTest = new File("c:/DevFormation");
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);
				File f = new File(ligne);
				System.out.println("existe t-il? : " + f.exists() + " /==> repertoire ou non? " + ((f.isDirectory()) ? "OUI / ==> " : "NON / ==>") + "path :" + f.getCanonicalPath());
				ligne = stdIn.readLine();
				if (f.exists()) {
					if (f.isDirectory()) {
						String[] tabRepertoire = f.list(); // tableau de String
						for (int i = 0; i < tabRepertoire.length; i++) {
							System.out.println(tabRepertoire[i]);
						}
						System.out.println("");

						File[] fn = f.listFiles(); // tableau de File
						for (int i = 0; i < fn.length; i++) {
							String nomDuFile = null;
							nomDuFile = fn[i].getName();
							//							System.out.println(nomDuFile);
							if (nomDuFile.contains(".")) {
								int indexPt = nomDuFile.indexOf(".");
								System.out.println(nomDuFile.substring(indexPt, nomDuFile.length()));
							} else {
								System.out.println(" ");
							}
						}
					}
				}
			}
		} catch (IOException e) { //quand il y a un probleme de lecture ou d'ecriture
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

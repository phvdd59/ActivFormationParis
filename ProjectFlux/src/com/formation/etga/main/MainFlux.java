package com.formation.etga.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux m = new MainFlux();
		m.init();
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

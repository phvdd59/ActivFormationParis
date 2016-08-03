package com.formation.emma.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux mainflux = new MainFlux();
		mainflux.init();
	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in)); //system.in envoie données du clavier qui sont chiffrées donc fait inputstreamreader pour transformer binaire en charactere
		try {
			String ligne = stdIn.readLine();
			File file = new File("c:/DevFormation");
			while (!ligne.equals("")) {
		//		System.out.println(ligne);
				File f = new File(ligne);
			//	System.out.println("existe :" + f.exists() + " repertoire " + (f.isDirectory() ? "oui" : "non") + " path " + f.getCanonicalPath());

				if (file.exists()) {
					// 1er methode
					//					String[] fichiers = null;
					//					fichiers = f.list();
					//					for (int i = 0; i < fichiers.length; i++) {
					//						System.out.println(fichiers[i]);
					//					}

					//2ie methode
					File[] fichiers2 = null;
					fichiers2 = f.listFiles();
					for (int i = 0; i < fichiers2.length; i++) {
						String nomDuFichier = null;
						File monFichier2 = fichiers2[i];
						if (monFichier2.isFile()) {
							nomDuFichier = monFichier2.getName();
						//	System.out.println(nomDuFichier);

							String suffixe = "";
							if (nomDuFichier.contains(".")) {
								suffixe = nomDuFichier.substring(nomDuFichier.lastIndexOf(".")+1);
								System.out.println(suffixe);
							} else {
								System.out.println("");
							}
						} else {
							System.out.println("");
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

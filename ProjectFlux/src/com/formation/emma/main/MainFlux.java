package com.formation.emma.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.BufferUnderflowException;

public class MainFlux {

	public static void main(String[] args) throws Exception { //throws exception arrete le programme alors que try catch sort l'exception avec try et la met dans catch, permet de continuer le programme
		MainFlux mainflux = new MainFlux();
		mainflux.initLecture();
	}

	public void initLecture() {
		File file = new File("./src/com/formation/emma/data/texte.txt");
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

	public void initEcriture() throws Exception {
		File file = new File("./src/com/formation/emma/data/texte.txt");
		PrintWriter out = null; // on declare les flux � l'exterieur pas dans le try
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("bonjour tout le monde");
			out.println("ceci doit apparaitre dans le fichier");
			out.flush(); //sauvegarde sur le disque les donn�es entr�es avant. Peut permettre aux autres de lire le d�but du fichiers si travaille dessus
			out.println("suite de la phrase");
		} catch (IOException e) {
			System.out.println("recommencer traitement");
		} finally {
			out.close();
		}
		// quand run le main clik droit sur dossier refresh et voit le fichier texte apparaitre
	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in)); //system.in envoie donn�es du clavier qui sont chiffr�es donc fait inputstreamreader pour transformer binaire en charactere
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
								suffixe = nomDuFichier.substring(nomDuFichier.lastIndexOf(".") + 1);
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

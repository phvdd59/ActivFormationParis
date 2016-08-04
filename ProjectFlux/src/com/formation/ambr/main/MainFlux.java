package com.formation.ambr.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainFlux {

	public static void main(String[] args) throws IOException {
		MainFlux mainFlux = new MainFlux();
		mainFlux.initEcriture();

	}

	public void initLecture() {
		File file = new File("./src/com/formation/ambr/data/texte.txt");
		BufferedReader bIn = null; // déclaration
		try {
			bIn = new BufferedReader(new FileReader(file)); // instanciation
			String line = bIn.readLine();
			while (line != null) {
				System.out.println(line);
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bIn.close(); // on l'a surround par un try-catch, au cas où ça planterait
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void initEcriture() throws IOException { // indique que cette exception est suffisamment grave pour faire planter le programme
		File file = new File("./src/com/formation/ambr/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("bonjour tout le monde.");
			out.println("ceci doit apparaitre dans le fichier.");
			out.flush(); // flush permet de sauvegarder sur le périphérique spécifié (chemin de fichier spécifié dans File) avec garantie de cette sauvegarde. Ici c'est sur C:
			out.print("suite de la phrase");
			out.print("autre suite de la phrase");
			out.print("autre suite de la phrase 2");
			out.print("autre suite de la phrase 3");
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			out.close();
		}
	}

	public void init() {

		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in)); // system.in envoie données du clavier qui sont chiffrées donc fait InputStreamReader pour transformer binaire en character
		try {
			File fileTest = new File("c:/DevFormation");
			System.out.println(fileTest.exists());

			String ligne = stdIn.readLine();

			while (!ligne.equals("")) { // tant que la ligne n'est pas vide, on la lit
				System.out.println(ligne);
				File f = new File(ligne);
				System.out.println("existe : " + f.exists() + " ; repertoire : " + (f.isDirectory() ? " oui" : "non") + " ; path " + f.getCanonicalPath());
				if (f.exists()) {
					if (f.isDirectory()) {
						File[] fn = null; // ça c'est de la déclaration. Là il n'existe pas. Il n'y aa que le compilateur qui sait que fn existe
						fn = f.listFiles(); // ça c'est l'instanciation. Là il existe. Si on fait pas ça, il ne met rien en mémoire
						for (int i = 0; i < fn.length; i++) {
							String nomDuFile = null;
							nomDuFile = fn[i].getName();
							System.out.println(nomDuFile);
							if (nomDuFile.equals("lmhosts.sam")) {
								System.out.println(fn[i].isFile());
							}
							if (fn[i].isFile() && nomDuFile.contains(".")) {
								int a = nomDuFile.lastIndexOf(".");
								String nomExtens = null;
								nomExtens = nomDuFile.substring(a + 1); // automatiquement il va de a jusqu'à la fin du mot, donc pas besoin d'écrire "nomDuFile.length()"
								System.out.println(nomExtens);
							}

							//C:\Windows\System32\drivers\etc
							//C:\Windows\System32\drivers

						}
					}
				}
				ligne = stdIn.readLine();
			}

		} catch (

		IOException e) {
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

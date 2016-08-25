package com.formation.soka.main;

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
		m.init();
		//m.initEcriture();
		//m.initLecture();
	}

	private void initLecture() {
		File file = new File("./src/com/formation/soka/data/texte.txt");
		BufferedReader bIn = null;
		try {
			
			bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine(); 
			while(line!=null){
				line= bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Pas de fichier trouvé pour effectuer la lecture");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOOException");
			e.printStackTrace();
		}finally{
			try {
				bIn.close();
			} catch (IOException e) {
				System.out.println("Pas fermé");
				e.printStackTrace();
			}
		}

	}

	private void initEcriture() {
		File file = new File("./src/com/formation/soka/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Coucou");
			out.println("Salut le fichier");
			out.flush();
			out.print("Suite de la phrase suite au flush ok");
		} catch (IOException e) {
			System.out.println("Try again! ");
		} finally {
			out.close();
		}
	}

	private void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			File fileTest = new File("c:/DevFormation");
			System.out.println(fileTest.exists());
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				// en gros quand on fait Entrée il s'arrete prsq ""
				System.out.println(ligne);
				File f = new File(ligne);
				System.out.println("existe: " + f.exists() + " repertoire : " + ((f.isDirectory()) ? "OUI" : "NON") + " path " + f.getCanonicalPath());

				if (f.exists()) {
					System.out.println(fileTest.exists() + " Je suis un File");
					if (f.isDirectory()) {
						System.out.println(f.isDirectory() + " Je suis un Repertoire");
						//System.out.println(f.getAbsolutePath());
						File[] fn = null;
						fn = f.listFiles();
						for (File file : fn) {
							//System.out.println(file.getName());
							if (file.isFile() && file.getName().contains(".")) {
								System.out.println(file.getName().substring(file.getName().lastIndexOf(".") + 1) + " totooo");

							} else {
								System.out.println("totooo");
							}

						}
						//						for (int i = 0; i < fn.length; i++) {
						//							String file = null; 
						//							file = fn[i].getName(); 
						//							System.out.println(file);
						//						}
					}
				} else {
					System.out.println("Nein! Je ne suis pas un File");
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

package com.formation.soka.main;

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

							}else{
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

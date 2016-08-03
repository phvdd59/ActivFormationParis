package com.formation.issa.main;

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
			File fileTest = new File("c:/DevFormation");
			System.out.println(fileTest.exists());
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);
				File f = new File(ligne);
				if (f.exists()) {
					if (f.isDirectory()) {
						File[] fn = null;
						// déclaration de fn
						fn = f.listFiles();
						for (int i = 0; i < fn.length; i++) {
							String nomDuFile = null;
							nomDuFile = fn[i].getName();
							System.out.println(nomDuFile);
							if (fn[i].isFile()) {
								if (nomDuFile.contains(".")) {
									System.out.println(nomDuFile.substring(nomDuFile.lastIndexOf(".")+1));
								}
							}

						}
						File[] f2 = null;
						f2 = f.listFiles();

					}
				}

				System.out.println("existe : " + f.exists() + "repertoire " + ((f.isDirectory()) ? "OUI" : "NON") + "path" + f.getCanonicalPath());
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

package com.formation.phva.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

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
						fn = f.listFiles();
						for (int i = 0; i < fn.length; i++) {
							String nomDuFile=null;
							nomDuFile=fn[i].getName();
							System.out.println(nomDuFile);
							
						}
					}
				}
				// f exists ?
				// f repertoire
				// si c'est le cas >>>>>>>

				System.out.println("existe : " + f.exists() + " repertoire " + ((f.isDirectory()) ? "OUI" : "NON") + " path " + f.getCanonicalPath());
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

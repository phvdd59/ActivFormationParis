package com.formation.thcr.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux main = new MainFlux();
		main.init();

	}

	private void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			String ligne = "yop";
			while (!ligne.equals("")) {
				ligne = stdIn.readLine();
				File f = new File(ligne);
				System.out.println("------------------------");
				System.out.println(f.getName());
				System.out.println(f.getPath());
				System.out.println(f.getCanonicalPath());

				if (f.exists()) {
					if (f.isDirectory()) {
						for (int i = 0; i < f.listFiles().length; i++) {
							if (f.listFiles()[i].isFile()
									&& f.listFiles()[i].getName().contains(".")) {
								System.out.println(f.listFiles()[i].getName().substring(
										f.listFiles()[i].getName().lastIndexOf(".") + 1));
							} else {
								System.out.println();
							}
						}
						System.out.println(Arrays.toString(f.list()));
					}
				} else {
					System.out.println("non, je n'existe pas");
				}
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

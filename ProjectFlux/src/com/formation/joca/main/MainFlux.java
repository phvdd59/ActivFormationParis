package com.formation.joca.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux m = new MainFlux();
		m.initImage();
	}

	private void initImage() {
		File fileIn = new File("./src/com/formation/phva/data/image.bmp");
		File fileOut = new File("./src/com/formation/joca/data/image.bmp");
		FileInputStream fluxIn = null;
		FileOutputStream fluxOut = null;
		int readUnByte = 0;

		try {
			fluxIn = new FileInputStream(fileIn);
			fluxOut = new FileOutputStream(fileOut);
			readUnByte = fluxIn.read();
			while (readUnByte != -1) {
				fluxOut.write(readUnByte);
				readUnByte = fluxIn.read();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				fluxIn.close();
				fluxOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void initLecture() {
		File file = new File("./src/com/formation/phva/data/texte.txt");
		BufferedReader bIn = null;
		try {
			InputStreamReader input = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bIn = new BufferedReader(input);
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

	private void initEcriture() {
		File file = new File("./src/com/formation/joca/data/texte.txt");
		PrintWriter out = null;

		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("bonjour tout le monde");
			out.println("ceci doit apparaitre dans le fichier");
			out.flush();
			out.print("suite de la phrase");
			out.print("Autre suite de la phrase");
			out.println("32Autre suite de la phrase");
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			out.close();
		}

	}

	private void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);
				File fichier = new File(ligne);
				if (fichier.exists()) {
					System.out.println("ca existe");
					if (fichier.isDirectory()) {
						System.out.println("c'est un dossier");
						fichier = fichier.getParentFile();

						for (File s : fichier.listFiles()) {
							if (s.isFile()) {
								if (s.getName().lastIndexOf('.') != -1) {
									System.out.println(s.getName().substring(s.getName().lastIndexOf('.') + 1));
								} else {
									System.out.println("fichier sans extension");
								}
							}
						}
					} else if (fichier.isFile()) {
						System.out.println("c'est un fichier");
					}

				} else {
					System.out.println("ca n'existe pas");
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

package com.formation.beba.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class MainFlux {

	public static void main(String[] args) throws Exception {
		MainFlux mainFlux = new MainFlux();
		// mainFlux.initLecture();
		// mainFlux.initEcriture();
		mainFlux.initImage();
	}

	public void initImage() throws Exception {
		FileInputStream fluxDentree = null;
		FileOutputStream fluxDeSortie = null;
		File fileIn = new File("./src/com/formation/beba/data/image2.bmp");
		File fileOut = new File("./src/com/formation/phva/data/image.bmp");
		int readUnByte;

		try {
			fluxDentree = new FileInputStream(fileIn);
			fluxDeSortie = new FileOutputStream(fileOut);
			readUnByte = fluxDentree.read();
			while (readUnByte != -1) {
				fluxDeSortie.write(readUnByte);
				readUnByte = fluxDentree.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fluxDentree.close();
			fluxDeSortie.close();
		}

		// File file = new File("./src/com/formation/beba/data/image2.bmp");
		// File file2 = new File("./src/com/formation/beba/data/image.bmp");
		// BufferedImage image = ImageIO.read(file);
		// System.out.println(file);
		// out = new (file2);

		// BufferedImage bIm=null;
		// Image image = toolkit.getImage(file);
		// bIm=new BufferedIma;

	}

	public void initLecture() throws Exception {
		File file = new File("./src/com/formation/phva/data/texte.txt");
		BufferedReader bIn = null;

		try {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			System.out.println(file.getCanonicalPath());
			bIn = new BufferedReader(inputStreamReader);
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
		File file = new File("./src/com/formation/beba/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour tout le monde ");
			out.println("ceci doit apparaitre dans le fichiers!♦");
			out.flush();
			out.print("Suite de la phrase");
		} catch (IOException e) {
			System.out.println("recomencer le traitement");
		} finally {
			out.close();
		}

	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {

			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				// System.out.println(ligne);

				File file = new File(ligne);
				System.out.println("Existe: " + file.exists() + " est un repertoire: " + file.isDirectory() + " path: " + file.getCanonicalPath());
				System.out.println("liste de fichier:");
				if (file.isDirectory()) {
					System.out.println(Arrays.toString(file.listFiles()));
					File[] fileAll = file.listFiles();
					System.out.println("liste des ext");
					for (int i = 0; i < fileAll.length; i++) {
						if (!fileAll[i].isDirectory()) {
							if (fileAll[i].getName().contains(".")) {

								System.out.print(fileAll[i].getName().substring(fileAll[i].getName().lastIndexOf('.') + 1) + ", ");
							}
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

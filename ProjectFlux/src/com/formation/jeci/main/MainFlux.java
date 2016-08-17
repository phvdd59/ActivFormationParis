package com.formation.jeci.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainFlux {

	public static void main(String[] args) throws Exception {
		MainFlux m = new MainFlux();
		// m.init();
		m.initEcriture();
m.initLecture();
		m.initImage();

	}

	private void initImage() {
		File file = new File("./src/com/formation/phva/data/image.bmp");
		File file2 = new File("./src/com/formation/jeci/data/image.bmp");
		FileInputStream iS = null;
		FileOutputStream oS = null;

		try {
			iS = new FileInputStream(file);
			oS = new FileOutputStream(file2);
			int lectur1byte = iS.read();
int nb=0;
			while (lectur1byte != -1) {
				if (nb>=1024) {
					if (nb%4==3) {
						lectur1byte=0xff;
					}
//					lectur1byte=(-1^lectur1byte)&0xff;
				}
				
				nb++;
				oS.write(lectur1byte);
				lectur1byte = iS.read();

			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				iS.close();
				oS.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void initLecture() {
		File file = new File("./src/com/formation/jeci/data/texte.txt");
		InputStreamReader inputStreamREader = null;
		BufferedReader bIn = null;
		try {
			inputStreamREader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bIn = new BufferedReader(new FileReader(file));
			String ligne = bIn.readLine();
			while (ligne != null) {
				System.out.println(ligne);
				ligne = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void initEcriture() throws Exception {
		File file = new File("./src/com/formation/jeci/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("bonjour tout monde.");
			out.println("♥ceci doit apparaitre dans le fichier♥");
			out.flush();
			out.println("Suite de la phrase: thomas est un tocard");
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

				File file = new File(ligne);
				if (file.exists()) {
					String typeMime = null;

					String[] nomFichier = file.getParentFile().list();

					for (int i = 0; i < nomFichier.length; i++) {

						if (nomFichier[i].contains(".")) {
							System.out.println(nomFichier[i].substring(nomFichier[i].lastIndexOf(".") + 1));
						}
					}
					for (String string : nomFichier) {
						System.out.println(string);
					}
					System.out.println("le fichier existe" + file.isDirectory() + "  " + file.getAbsolutePath());
				} else {
					System.out.println("le fichier n'existe pas");
				}
				ligne = stdIn.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stdIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

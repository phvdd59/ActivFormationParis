package com.formation.etga.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import com.formation.etga.metier.Terme;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux m = new MainFlux();
		//		m.init();
		//		m.initEcriture();
		//		m.initLecture();
		//		m.initImage();
		m.initEcritureObject();
		m.initLectureObject();
	}

	private void initLectureObject() {
		Terme terme = new Terme("WAGON", new Point(2, 9), Terme.HORIZONTAL);
		File file = new File("./src/com/formation/etga/data/terme1.ser");
		ObjectInputStream iStream = null;

		try {
			iStream = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Object o = iStream.readObject();
				if (o instanceof String) {
					String s = (String) o;
					System.out.println(s);
				} else if (o instanceof Terme) {
					Terme t = (Terme) o;
					System.out.println(t);
				}
			}
			// Ancienne manière de faire
			//			Object obj1 = iStream.readObject();
			//			if (obj1 instanceof String) {
			//				String s = (String) obj1;
			//				System.out.println(s);
			//			}
			//			Object obj2 = iStream.readObject();
			//			if (obj2 instanceof Terme) {
			//				Terme t = (Terme) obj2;
			//				System.out.println(t);
			//			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				iStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void initEcritureObject() {
		Terme terme = new Terme("WAGON", new Point(2, 9), Terme.HORIZONTAL);
		File file = new File("./src/com/formation/etga/data/terme1.ser");
		ObjectOutputStream oStream = null;
		try {
			oStream = new ObjectOutputStream(new FileOutputStream(file));
			oStream.writeObject("Etienne");
			oStream.writeObject(terme);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void initImage() {
		File fileIn = new File("./src/com/formation/phva/data/image2.bmp");
		File fileOut = new File("./src/com/formation/etga/data/image2.bmp");
		FileInputStream fluxDentree = null; // lecture d'un file
		FileOutputStream fluxDeSortie = null;
		int readUnByte;
		//		int nb= 0;
		try {
			fluxDentree = new FileInputStream(fileIn);
			fluxDeSortie = new FileOutputStream(fileOut);

			readUnByte = fluxDentree.read(); // on regarde si ca existe voir si on rentre dans la boucle
			while (readUnByte != -1) {
				readUnByte = readUnByte;
				//				if (nb >=1024) {
				//				readUnByte = (-1^readUnByte) & 0xFF; // on change la couleur et tout
				//				}
				//				nb++;
				fluxDeSortie.write(readUnByte);
				readUnByte = fluxDentree.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fluxDentree.close();
				fluxDeSortie.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void initLecture() {
		File file = new File("./src/com/formation/phva/data/texte.txt");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
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

	public void initEcriture() {
		File file = new File("./src/com/formation/etga/data/texte.txt");
		PrintWriter out = null; //on declare les variables en dehors du try et on les instancies.
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour thomas.");
			out.println("Ceci doit apparaitre dans le fichier");
			out.flush(); // transmission du flux sur le périph correspondant pour ne pas bloquer le programme
			out.print("Suite de la phrase");
		} catch (IOException e) {
			System.out.println("Recommencer le traitement");
		} finally {
			out.close();
		}
	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			// File fileTest = new File("c:/DevFormation");
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);
				File f = new File(ligne);
				System.out.println("existe t-il? : " + f.exists() + " /==> repertoire ou non? " + ((f.isDirectory()) ? "OUI / ==> " : "NON / ==>") + "path :" + f.getCanonicalPath());
				ligne = stdIn.readLine();
				if (f.exists()) {
					if (f.isDirectory()) {
						String[] tabRepertoire = f.list(); // tableau de String
						for (int i = 0; i < tabRepertoire.length; i++) {
							System.out.println(tabRepertoire[i]);
						}
						System.out.println("");

						File[] fn = f.listFiles(); // tableau de File
						for (int i = 0; i < fn.length; i++) {
							String nomDuFile = null;
							nomDuFile = fn[i].getName();
							//							System.out.println(nomDuFile);
							if (nomDuFile.contains(".")) {
								int indexPt = nomDuFile.indexOf(".");
								System.out.println(nomDuFile.substring(indexPt, nomDuFile.length()));
							} else {
								System.out.println(" ");
							}
						}
					}
				}
			}
		} catch (IOException e) { //quand il y a un probleme de lecture ou d'ecriture
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

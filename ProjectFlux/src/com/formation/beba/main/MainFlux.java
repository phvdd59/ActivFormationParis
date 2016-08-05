package com.formation.beba.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import com.formation.beba.Metier.Terme;

public class MainFlux {

	public static void main(String[] args) throws Exception {
		MainFlux mainFlux = new MainFlux();
		// mainFlux.init();
		// mainFlux.initLecture();
		// mainFlux.initEcriture();
		// mainFlux.initImage();
		mainFlux.initObjet();
		mainFlux.initLireObjet();
	}

	public void initLireObjet() throws Exception {

		File file = new File("./src/com/formation/beba/data/terme1.ser");
		ObjectInputStream IStream = null;

		try {
			IStream = new ObjectInputStream(new FileInputStream(file));
			// Object a = IStream.readObject();
			while (true) {
				Object a = IStream.readObject();
				if (a instanceof String) {
					String s = (String) a;
					System.out.println(s);
				} else if (a instanceof Terme) {
					Terme s = (Terme) a;

					System.out.println(s);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			IStream.close();

		}

	}

	public void initObjet() throws Exception {
		Terme terme = new Terme("wagon", new Point(2, 9), Terme.HORIZONTAL);
		File file = new File("./src/com/formation/beba/data/terme1.ser");
		ObjectOutputStream oStream = null;

		try {
			oStream = new ObjectOutputStream(new FileOutputStream(file));
			oStream.writeObject("Gros Sac");
			oStream.writeObject(terme);
			oStream.writeObject("test");
			oStream.writeObject("rien");
			oStream.writeObject(terme);
			oStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}

		}

	}

	public void initImage() throws Exception {
		FileInputStream fluxDentree = null;
		FileOutputStream fluxDeSortie = null;
		File fileIn = new File("./src/com/formation/phva/data/image2.bmp");
		File fileOut = new File("./src/com/formation/beba/data/image.bmp");
		int readUnByte;
		int nb = 0;
		try {
			fluxDentree = new FileInputStream(fileIn);
			fluxDeSortie = new FileOutputStream(fileOut);
			readUnByte = fluxDentree.read();
			while (readUnByte != -1) {
				if (nb >= 256) {
					readUnByte = (-1 ^ readUnByte) & 0xFF;
				}
				nb++;
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

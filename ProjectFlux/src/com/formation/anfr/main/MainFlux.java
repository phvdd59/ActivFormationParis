package com.formation.anfr.main;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import com.formation.anfr.metier.Terme;

public class MainFlux {

	public static void main(String[] args) throws IOException {
		MainFlux mainFlux = new MainFlux();
		// mainFlux.initEcriture();
		// mainFlux.initLecture();
		// mainFlux.initImage();
		 mainFlux.initObjet();
		mainFlux.initLireObjet();
	}

	private void initLireObjet() {
		File file = new File("./src/com/formation/anfr/data/terme1.ser");
		ObjectInputStream iStream = null;

		try {
			iStream = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Object o = iStream.readObject();
				if (o instanceof String) {
					String s = (String) o;
					System.out.println(s);
				} else if (o instanceof Terme) {
					Terme s = (Terme) o;
					System.out.println(s);

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				iStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	private void initObjet() {
		Terme terme = new Terme("Wagon", new Point(4, 5), Terme.VERTICAL);
		File file = new File("./src/com/formation/anfr/data/terme1.ser");
		ObjectOutputStream oStream = null;

		try {
			oStream = new ObjectOutputStream(new FileOutputStream(file));
			oStream.writeObject("emilie");
			oStream.writeObject("thomas");
			oStream.writeObject(terme);
			oStream.flush();
			terme.setNom("souad");
			oStream.writeObject(terme);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	private void initImage() {
		File fileIn = new File("./src/com/formation/phva/data/image.bmp");
		File fileOut = new File("./src/com/formation/anfr/data/image2.bmp");
		FileInputStream fluxEntree = null;
		FileOutputStream fluxSortie = null;
		int readUnbyte = 0;
		try {
			fluxEntree = new FileInputStream(fileIn);
			fluxSortie = new FileOutputStream(fileOut);
			readUnbyte = fluxEntree.read();
			int nb = 0;
			while (readUnbyte != -1) {
				if (nb >= 1024) {
					// readUnbyte = (-1^readUnbyte)&0xFFFFFF;
					if (nb % 4 == 1) {
						readUnbyte = 0xFF;
					}
				}
				nb++;
				fluxSortie.write(readUnbyte);
				readUnbyte = fluxEntree.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				fluxEntree.close();
				fluxEntree.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private void initLecture() throws IOException {
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
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			bIn.close();
		}
	}

	private void initEcriture() throws IOException {
		File file = new File("./src/com/formation/anfr/data/texte.txt");
		PrintWriter out = new PrintWriter(file);
		try {
			System.out.println(file.getCanonicalPath());
			out.println("MITHRA!!!");
			out.println("Au nom du père des pères,∟");
			out.flush();
			out.println("Que ta lumière soit faite!");
			out.print("Ps : Ibis Dieu de merde!");
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			out.close();
		}

	}

	private void init2() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);
				File file = new File(ligne);
				if (file.exists()) {
					System.out.println("Le répertoire existe.");
					System.out.println(file.getCanonicalPath());
					System.out.println("Fichiers dans le répertoire :");
					if (file.isDirectory()) {
						File[] listFile = file.listFiles();
						for (File file2 : listFile) {
							System.out.print(file2.getCanonicalPath());
							if (file2.isFile()) {

								String nomDuFichier = file2.getName();
								if (nomDuFichier.contains(".")) {
									int posPoint = nomDuFichier.lastIndexOf(".");
									String suffixe = nomDuFichier.substring(posPoint);
									System.out.println(" " + suffixe);
								} else {
									System.out.println("");
								}
							} else {
								System.out.println("");
							}

						}
					}
					System.out.println("Autre Méthode");
					if (file.isDirectory()) {
						System.out.println(Arrays.toString(file.listFiles()));
					}

				} else {
					System.out.println("Le répertoire n'existe pas.");
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

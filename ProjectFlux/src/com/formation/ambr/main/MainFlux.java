package com.formation.ambr.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import com.formation.ambr.metier.Terme;

public class MainFlux {

	public static void main(String[] args) throws IOException {
		MainFlux mainFlux = new MainFlux();
		mainFlux.initEcritureObject();
		mainFlux.initLectureObject();

	}

	//salut

	private void initLectureObject() {
		File file = new File("./src/com/formation/ambr/data/terme1.ser");
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
				Object a = iStream.readObject();
				if (a instanceof String) { // instanceof c'est pour v�rifier le type
					String s = (String) a;
					System.out.println(s);
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				iStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void initEcritureObject() {
		Terme terme = new Terme("wagon", new Point(2, 9), Terme.HORIZONTAL);
		File file = new File("./src/com/formation/ambr/data/terme1.ser"); // ser comme serializer
		ObjectOutputStream oStream = null;
		try {
			oStream = new ObjectOutputStream(new FileOutputStream(file));
			oStream.writeObject("amaury");
			oStream.writeObject(terme);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void initImage() {
		File fileIn = new File("./src/com/formation/phva/data/image2.bmp"); // image: c'est en binaire. Donc du input/output stream
		File fileOut = new File("./src/com/formation/ambr/data/image2.bmp");
		FileInputStream fluxDentree = null;
		FileOutputStream fluxDeSortie = null;
		int readUnByte;

		try {
			fluxDentree = new FileInputStream(fileIn);
			fluxDeSortie = new FileOutputStream(fileOut);
			readUnByte = fluxDentree.read();
			while (readUnByte != -1) {
				//readUnByte = (-1 ^ readUnByte) & 0xFF; // 0xFF c'est un int. readUnByte c'est un octet de notre image
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
		BufferedReader bIn = null; // déclaration
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); // InputStreamReader lit en binaire
			bIn = new BufferedReader(new FileReader(file)); // instanciation. On buffer pour pouvoir ligne par ligne
			String line = bIn.readLine();
			while (line != null) {
				System.out.println(line);
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bIn.close(); // on l'a surround par un try-catch, au cas où ça planterait
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void initEcriture() throws IOException { // indique que cette exception est suffisamment grave pour faire planter le programme
		File file = new File("./src/com/formation/ambr/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("bonjour tout le monde.");
			out.println("ceci doit apparaitre dans le fichier.");
			out.flush(); // flush permet de sauvegarder sur le périphérique spécifié (chemin de fichier spécifié dans File) avec garantie de cette sauvegarde. Ici c'est sur C:
			out.print("suite de la phrase");
			out.print("autre suite de la phrase");
			out.print("autre suite de la phrase 2");
			out.print("autre suite de la phrase 3♥");
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			out.close();
		}
	}

	public void init() {

		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in)); // system.in envoie données du clavier qui sont chiffrées donc fait InputStreamReader pour transformer binaire en character
		try {
			File fileTest = new File("c:/DevFormation");
			System.out.println(fileTest.exists());

			String ligne = stdIn.readLine();

			while (!ligne.equals("")) { // tant que la ligne n'est pas vide, on la lit
				System.out.println(ligne);
				File f = new File(ligne);
				System.out.println("existe : " + f.exists() + " ; repertoire : " + (f.isDirectory() ? " oui" : "non") + " ; path " + f.getCanonicalPath());
				if (f.exists()) {
					if (f.isDirectory()) {
						File[] fn = null; // ça c'est de la déclaration. Là il n'existe pas. Il n'y aa que le compilateur qui sait que fn existe
						fn = f.listFiles(); // ça c'est l'instanciation. Là il existe. Si on fait pas ça, il ne met rien en mémoire
						for (int i = 0; i < fn.length; i++) {
							String nomDuFile = null;
							nomDuFile = fn[i].getName();
							System.out.println(nomDuFile);
							if (nomDuFile.equals("lmhosts.sam")) {
								System.out.println(fn[i].isFile());
							}
							if (fn[i].isFile() && nomDuFile.contains(".")) {
								int a = nomDuFile.lastIndexOf(".");
								String nomExtens = null;
								nomExtens = nomDuFile.substring(a + 1); // automatiquement il va de a jusqu'à la fin du mot, donc pas besoin d'écrire "nomDuFile.length()"
								System.out.println(nomExtens);
							}

							//C:\Windows\System32\drivers\etc
							//C:\Windows\System32\drivers

						}
					}
				}
				ligne = stdIn.readLine();
			}

		} catch (

		IOException e) {
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

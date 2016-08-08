package com.formation.made.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.EOFException;
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
import java.util.ArrayList;

import com.formation.made.metier.Terme;

public class MainFlux {

	public static void main(String[] args) throws Exception {
		MainFlux m = new MainFlux();
		// m.init();
		//m.initLecture();
		//m.initEcriture();
		// m.initImage();
		// m.initObject();
		// m.initLectureObject();
		 m.initLectureXml();
	}

	private void initLectureXml() {

		File ffff = new File("../"); // pour savoir ou on est dans un fichier on fait File("") et du coup on peut mettre des points pour remonter de proche en proche qu'on recupere avec le canonical path
		File file = new File("../ProjectXml/src/com/formation/made/xml/ListTerme.xml");
		ArrayList<String> lstStringBalise = new ArrayList<String>();

		BufferedReader bR = null;
		InputStreamReader inputStreamReader = null;// flux d'entree que je declare
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file)); // flux d'entree que j'instancie comme un nouveau contenant le file inputStream de mon fichier
			bR = new BufferedReader(new FileReader(file));
			String maLigne = bR.readLine();
			System.out.println(maLigne);
			while (maLigne != null) {
				maLigne = bR.readLine();
				if (maLigne.contains("<Terme ")) {
					// System.out.println("je suis une ligne terme");
					if (maLigne.endsWith("</Terme>")) {
						// lstStringBalise.add(maLigne);//la il faudrait encore verifier que la liste ne contienne qu'une balise
					} else {
						String ligneConcat = "";
						while (!maLigne.contains("</Terme>")) {
							ligneConcat = ligneConcat + maLigne;
							maLigne = bR.readLine();
							// System.out.println(ligneConcat);
						}
						ligneConcat = ligneConcat + maLigne;
						 System.out.println(ligneConcat);
						//lstStringBalise.add(ligneConcat);

					}
				}
			}
			System.out.println(lstStringBalise);
			for (String string : lstStringBalise) {
				
			}
			Terme terme = new Terme();
			int Indicex = maLigne.indexOf("x=");
			int Indicecarac = 0;
			int Indicey = maLigne.indexOf("y=");
			char[] tabCharMaLigne = maLigne.toCharArray();
			for (int i = 0; i < tabCharMaLigne.length; i++) {

			}

			// String stringpointx=maLigne.substring(Indicex);
			Point pointTerme = new Point(Indicex, Indicey);
			terme.setPos(pointTerme);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// on peut sauvegarder sur le disque des objects permanents et on peut les recuperer. ces objects sont de types String. on peut collectioner les objects comme �a
	private void initLectureObject() {
		File file = new File("./src/com/formation/made/data/terme1.ser");
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(file));
			Object o = objectInputStream.readObject();
			while (true) {
				if (o instanceof String) {
					String s = (String) o;
					System.out.println(s + "je suis un string");
					o = objectInputStream.readObject();
				}
				if (o instanceof Terme) {
					Terme s = (Terme) o;
					System.out.println(s + "je suis un objet");
					o = objectInputStream.readObject();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void initObject() {
		Terme terme = new Terme("bonobo", new Point(1, 2), Terme.HORIZONTAL);
		File file = new File("./src/com/formation/made/data/terme1.ser");
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			objectOutputStream.writeObject("marc");
			objectOutputStream.writeObject("jean guillaume");
			objectOutputStream.writeObject(terme); // quand on le fait au d�but il sort une notserializable exception
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void initImage() {
		File filein = new File("./src/com/formation/phva/data/image.bmp");
		File fileout = new File("./src/com/formation/made/data/image.bmp");
		FileInputStream fluxdentree = null;// on declare la variable input file qui est de type input stream
		FileOutputStream fluxDeSortie = null;//
		int readUnByte = 0;

		try {
			fluxdentree = new FileInputStream(filein);// ouverture des flux en tant qu'objet je peux l'utiliser a partir de la.
			fluxDeSortie = new FileOutputStream(fileout);
			readUnByte = fluxdentree.read();// �a correspond a demander si le byte existe
			while (readUnByte != -1) {
				// readUnByte=(-1^readUnByte)&0xFF;
				fluxDeSortie.write(readUnByte);
				readUnByte = fluxdentree.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fluxdentree.close();
				fluxDeSortie.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void initLecture() { // pour fichier caractere
		// TODO Auto-generated method stub
		File file = new File("./src/com/formation/phva/data/texte.txt");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); // file est lu dans un flux binaire. transformé en flux de caractère avec la specificité utf8 via inputstreamreader
			bIn = new BufferedReader(new FileReader(file)); // seulement apres on utilise le buffer. ce ferait caractere par caractere sans le buffer. il lit octet par octet
			String line = bIn.readLine();
			while (line != null) { // on repert la fin du fichier si line est nul
				System.out.println(line);
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("je ne vois le fichier file not found exception");
		} catch (NullPointerException e) {
			// e.printStackTrace();
			System.out.println("le fichier n'existe pas de Isma null pointer exception");
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

	private static void initEcriture() throws Exception { // pour fichier caractère

		File file = new File("./src/com/formation/made/data/texte.txt"); // l'endroit ou on veut mettre le fichier plus el nom du ficher ici texte
		PrintWriter out = null; // la déclaration du flux TOUJOURS !!!
		try { // on la met en try catch parce qu'elle peut tomber en exception
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour tout le monde.♥ ");
			out.println("Ceci doit apparaitre dans le fichier. ");
			out.flush(); // sert à transmission du flux sur le périph correspondant
			out.println("Suite de la phrase");
			out.println("Salut Isma :)");

		} catch (IOException e) {
			System.out.println("recommencez le traitement");
		} finally {
			out.close(); // on ferme TOUJOURS le FICHIER
		}

	}

	private static void init() {

		BufferedReader stdIn = null;
		stdIn = new BufferedReader((new InputStreamReader(System.in))); // le inputstreamreader transforme le flux binaire en caractère
		try {
			File filetest = new File("c:/DevFormation");
			System.out.println(filetest.exists());
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				// System.out.println(ligne);
				ligne = stdIn.readLine();
				File file = new File(ligne);
				if (file.exists()) {
					if (file.isDirectory()) {
						File[] tabFile = null;// la déclation pour le compilateur
						tabFile = file.listFiles();// instanciation
						for (File file2 : tabFile) {
							if (file2.isFile()) {
								String nom = file2.getName();
								if (nom.contains(".")) {
									int indicePoint = nom.lastIndexOf(".");
									String exte = nom.substring(indicePoint + 1);
									System.out.println(exte);
								}
							}

							// System.out.println(file2.getName());
						}
					}
					System.out.println("existe " + file.exists() + " répertoire" + ((file.isDirectory()) ? " OUI " : " NON ") + " path " + file.getCanonicalPath()); // getCanonicalPath pour pour remonter avec "../
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
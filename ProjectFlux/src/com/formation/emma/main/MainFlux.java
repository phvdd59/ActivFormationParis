package com.formation.emma.main;

import java.awt.Point;
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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.BufferUnderflowException;

import com.formation.emma.metier.Terme;

public class MainFlux {

	public static void main(String[] args) throws Exception { //throws exception arrete le programme alors que try catch sort l'exception avec try et la met dans catch, permet de continuer le programme
		MainFlux mainflux = new MainFlux();
		mainflux.initEcritureObject();
		mainflux.initLectureObject();
	}

	private void initLectureObject() {
		File file = new File("./src/com/formation/emma/data/terme1.ser");
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

		} catch (ClassNotFoundException e) {

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
		Terme terme = new Terme("wagon", new Point(2, 9), Terme.HORIZONTAL);
		File file = new File("./src/com/formation/emma/data/terme1.ser");
		ObjectOutputStream oStream = null;

		try {
			oStream = new ObjectOutputStream(new FileOutputStream(file));
			oStream.writeObject("emilie");
			oStream.writeObject("thomas");
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
		File image = new File("./src/com/formation/phva/data/image.bmp");
		FileInputStream fluxDentree = null;
		File file = new File("./src/com/formation/emma/data/image.bmp");
		FileOutputStream fluxDeSortie = null;

		try {
			fluxDentree = new FileInputStream(image);
			fluxDeSortie = new FileOutputStream(file);

			int picture = fluxDentree.read();
			while (picture != -1) {

				fluxDeSortie.write(picture);
				picture = fluxDentree.read();
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
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); // pour corriger les caracteres speciaux d'un texte 
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
		File file = new File("./src/com/formation/emma/data/texte.txt");
		PrintWriter out = null; // on declare les flux à l'exterieur pas dans le try
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("bonjour tout le monde");
			out.println("ceci doit apparaitre♥ dans le fichier");
			out.flush(); //sauvegarde sur le disque les données entrées avant. Peut permettre aux autres de lire le début du fichiers si travaille dessus
			out.println("suite de la phrase");
		} catch (IOException e) {
			System.out.println("recommencer traitement");
		} finally {
			out.close();
		}
		// quand run le main clik droit sur dossier refresh et voit le fichier texte apparaitre
	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in)); //system.in envoie données du clavier qui sont chiffrées donc fait inputstreamreader pour transformer binaire en charactere
		try {
			String ligne = stdIn.readLine();
			File file = new File("c:/DevFormation");
			while (!ligne.equals("")) {
				//		System.out.println(ligne);
				File f = new File(ligne);
				//	System.out.println("existe :" + f.exists() + " repertoire " + (f.isDirectory() ? "oui" : "non") + " path " + f.getCanonicalPath());

				if (file.exists()) {
					// 1er methode
					//					String[] fichiers = null;
					//					fichiers = f.list();
					//					for (int i = 0; i < fichiers.length; i++) {
					//						System.out.println(fichiers[i]);
					//					}

					//2ie methode
					File[] fichiers2 = null;
					fichiers2 = f.listFiles();
					for (int i = 0; i < fichiers2.length; i++) {
						String nomDuFichier = null;
						File monFichier2 = fichiers2[i];
						if (monFichier2.isFile()) {
							nomDuFichier = monFichier2.getName();
							//	System.out.println(nomDuFichier);

							String suffixe = "";
							if (nomDuFichier.contains(".")) {
								suffixe = nomDuFichier.substring(nomDuFichier.lastIndexOf(".") + 1);
								System.out.println(suffixe);
							} else {
								System.out.println("");
							}
						} else {
							System.out.println("");
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

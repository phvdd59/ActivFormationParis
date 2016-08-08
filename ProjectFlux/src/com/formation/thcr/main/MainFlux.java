package com.formation.thcr.main;

import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import com.formation.thcr.metier.Terme;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux main = new MainFlux();
		main.initJSONWrite();
		main.initJSONRead();

	}

	private void initJSONRead() {
		File file = new File("./src/com/formation/thcr/data/saisie.json");
		FileReader fr = null;
		ArrayList<Terme> listTerme = new ArrayList<Terme>();
		try {
			fr = new FileReader(file);
			int character = fr.read();
			String s = "";
			while (character != -1) {
				s += (char) character;
				character = fr.read();
			}
			System.out.println(s);
			String sModif = s.replace("{", " ");
			sModif = sModif.replace("}", " ");
			sModif = sModif.replace("\"", " ");
			sModif = sModif.replace(":", " ");
			sModif = sModif.replace(",", " ");
			sModif = sModif.replace("  ", " ");
			sModif = sModif.replace("  ", " ");
			sModif = sModif.replace(" mot ", "");
			sModif = sModif.replace(" posX", "");
			sModif = sModif.replace(" posY", "");
			sModif = sModif.replace(" sens", "");
			sModif = sModif.replaceAll("\\p{Space}", " ");
			sModif = sModif.replace("  ", " ");
			String[] info = sModif.split(" ");
			for (String string : info) {
				System.out.println(string);
			}
			String nom = "";
			int posX = 0;
			int posY = 0;
			boolean sens = false;
			for (int i = 0; i < info.length; i++) {
				if (i % 4 == 0) {
					nom = info[i];
				} else if (i % 4 == 1) {
					posX = Integer.valueOf(info[i]);
				} else if (i % 4 == 2) {
					posY = Integer.valueOf(info[i]);
				} else {
					if (Boolean.valueOf(info[i]) == Terme.HORIZONTAL) {
						sens = Terme.HORIZONTAL;
					} else if (Boolean.valueOf(info[i]) == Terme.VERTICAL) {
						sens = Terme.VERTICAL;
					}
					listTerme.add(new Terme(nom, new Point(posX, posY), sens));
				}

			}
			for (Terme terme : listTerme) {
				System.out.println(terme);
			}
			//System.out.println(sModif);

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	private void initJSONWrite() {
		ArrayList<Terme> listTerme = new ArrayList<Terme>();
		listTerme.add(new Terme("Wagon", new Point(0, 0), Terme.HORIZONTAL));
		listTerme.add(new Terme("melon", new Point(2, 3), Terme.VERTICAL));
		listTerme.add(new Terme("gateau", new Point(8, 2), Terme.VERTICAL));
		File file = new File("./src/com/formation/thcr/data/saisie.json");
		PrintWriter bw = null;
		try {
			bw = new PrintWriter(new FileWriter(file));
			for (Terme terme : listTerme) {
				//{"mot":"pastille","posX":1,"posY":5,"sens":true}
				bw.write("{\"mot\":\"" + terme.getNom() + "\",\"posX\":" + terme.getPos().x + ",\"posY\":" + terme.getPos().y + ",\"sens\":"
						+ terme.isSens() + "}\n");
			}
		} catch (IOException e) {
		} finally {
			bw.close();
		}

	}

	private void initLectureObject() {
		File file = new File("./src/com/formation/thcr/data/terme1.ser");
		ObjectInputStream oInStr = null;

		try {
			oInStr = new ObjectInputStream(new FileInputStream(file));
			//			Object obj = oInStr.readObject();
			while (true) {
				Object o = oInStr.readObject();
				if (o instanceof String) {
					System.out.println(o);
				} else if (o instanceof Terme) {
					System.out.println(o);
				}
			}
			//			if (obj instanceof String) {
			//				obj = (String) obj;
			//				System.out.println(obj);
			//			}
			//			Object obj2 = oInStr.readObject();
			//			if (obj2 instanceof String) {
			//				obj2 = (String) obj2;
			//				System.out.println(obj2);
			//			}
			//			Object obj3 = oInStr.readObject();
			//			if (obj3 instanceof Terme) {
			//				obj3 = (Terme) obj3;
			//				System.out.println(obj3);
			//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			//	e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oInStr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void initObject() {
		Terme terme = new Terme("Wagon", new Point(0, 0), Terme.HORIZONTAL);
		File file = new File("./src/com/formation/thcr/data/terme1.ser");
		ObjectOutputStream oOutStr = null;
		try {
			oOutStr = new ObjectOutputStream(new FileOutputStream(file));
			oOutStr.writeObject("Thomas");
			oOutStr.writeObject("String");
			oOutStr.writeObject(terme);
			terme.setNom("Souad"); //FAIRE Attention, il sauvegarde ‡ l'instant o˘ l'on Ècrit 
									//Il ne modifie pas l'objet une fois sauvegardÈ
			oOutStr.writeObject(terme);
			;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oOutStr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void initImage() {
		File file = new File("./src/com/formation/phva/data/image.bmp");
		File fileCopied = new File("./src/com/formation/thcr/data/image.bmp");
		BufferedInputStream bInSt = null;
		BufferedOutputStream bOutSt = null;
		int cpt = 0;
		try {
			bInSt = new BufferedInputStream(new FileInputStream(file));
			bOutSt = new BufferedOutputStream(new FileOutputStream(fileCopied));
			int o = bInSt.read();
			byte i = -1;
			while (o != -1) {
				if (cpt > 80) {
					o = (i ^ o);
				}
				bOutSt.write(o);
				o = bInSt.read();
				cpt++;
			}
			int pixels = cpt / 3;
			System.out.println(cpt + "o");
			System.out.println(pixels + "p");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bInSt.close();
				bOutSt.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void initLecture() {
		File file = new File("./src/com/formation/phva/data/texte.txt");
		BufferedReader bin = null; // Initiallisation √† null des flux
		InputStreamReader input = null;
		try {
			input = new InputStreamReader(new FileInputStream(file), "UTF-8"); // Transforamtion fichier binaire en fichier texte
			//FileInputStream : lecture fichier binaire
			//InputStreamReader , UTF-8 : Lecture fichier binaire en fichier texte avec norme UTF-8
			bin = new BufferedReader(input);
			String line = bin.readLine();
			while (line != null) {
				System.out.println(line);
				line = bin.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void initEcriture() {
		//		String path = "D:\\DevFormation\\GITActivFormationParis\\ProjectFlux\\src\\com\\formation\\thcr\\data";
		File file = new File("./src/com/formation/thcr/data/texte.txt"); //Utiliser "./" pour voir sur quelle chemin o√π 'on se situe
		PrintWriter out = null; // toujours initialiser les flux en dehors des try
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour Tous le monde");
			out.println("Ceci doit appara√Ætre dans le fichier");
			out.flush(); //Garantie la sauvegarde
			out.print("Suite de la phrase");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close(); //Toujours fermer les flux
		}
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
							if (f.listFiles()[i].isFile() && f.listFiles()[i].getName().contains(".")) {
								System.out.println(f.listFiles()[i].getName().substring(f.listFiles()[i].getName().lastIndexOf(".") + 1));
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

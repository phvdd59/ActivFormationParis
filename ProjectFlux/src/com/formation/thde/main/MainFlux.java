package com.formation.thde.main;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

import com.formation.thde.metier.Terme;

public class MainFlux {

	public static void main(String[] args) throws Exception {
		MainFlux mainFlux = new MainFlux();
		mainFlux.init();
//		mainFlux.initEcriture();
//		mainFlux.initLecture();
//		mainFlux.initImage();
//		mainFlux.initEcritureObject();
//		mainFlux.initLectureObject();
	}

	public void initLectureObject() {
		File file = new File("./src/com/formation/thde/data/terme1.ser");
		ObjectInputStream iStream = null;

		try {
			iStream = new ObjectInputStream(new FileInputStream(file));
			//			while (true) {
			//				Object o = iStream.readObject();
			//				if (o instanceof String) {
			//					String s = (String) o;
			//					System.out.println(s);
			//				} else if (o instanceof Terme) {
			//					Terme s = (Terme) o;
			//					System.out.println(s);
			//				}
			//			}
			Object a = iStream.readObject();
			if (a instanceof String) {
				String s = (String) a;
				System.out.println(s);
			}
			Object b = iStream.readObject();
			if (b instanceof Terme) {
				System.out.println(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				iStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void initEcritureObject() {
		Terme terme = new Terme("wagon", new Point(2, 9), Terme.HORIZONTAL);
		File file = new File("./src/com/formation/thde/data/terme1.ser");
		ObjectOutputStream oStream = null;

		try {
			oStream = new ObjectOutputStream(new FileOutputStream(file));
			oStream.writeObject("Emilie");
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
		File fileIn = new File("./src/com/formation/phva/data/image.bmp");
		File fileOut = new File("./src/com/formation/thde/data/image.bmp");
		FileInputStream fluxDentree = null;
		FileOutputStream fluxDeSortie = null;
		int readUnByte;
		int nb = 0;
		try {
			fluxDentree = new FileInputStream(fileIn);
			fluxDeSortie = new FileOutputStream(fileOut);
			readUnByte = fluxDentree.read();
			while (readUnByte != -1) {
				if (nb >= 1024) {
					readUnByte = (-1 ^ readUnByte) & 0xFF;
					//					if (nb % 4== 1) {
					//						readUnByte = 0xFF;
					//					}
				}
				nb++;
				fluxDeSortie.write(readUnByte);
				readUnByte = fluxDentree.read();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
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
			bIn = new BufferedReader(new FileReader(file));
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
		File file = new File("./src/com/formation/thde/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour tout le monde");
			out.println("ceci doit apparaitre dans le fichier");
			out.flush();
			out.print("Test Test");
		} catch (IOException e) {
			System.out.println("recommencer le traitement");
		} finally {
			out.close();
		}
	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		File test = new File("c:/DevFormation");
		try {
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				System.out.println(ligne);
				File f = new File(ligne);
				System.out.println(f.exists() + "   " + f.isDirectory() + "   " + f.getCanonicalPath());
				if (f.exists() && f.isDirectory()) {
					File[] tabFiles = f.listFiles();
					for (int i = 0; i < tabFiles.length; i++) {
						//System.out.println(tabFiles[i].getName());
						if (tabFiles[i].isFile() && tabFiles[i].getName().contains(".")) {
							System.out.println(tabFiles[i].getName().substring(tabFiles[i].getName().lastIndexOf(".") + 1));
						} else {
							System.out.println(" - ");
						}

					}
				}
				ligne = stdIn.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				wipeConsole();
				stdIn.close();
			} catch (IOException | AWTException e) {
				e.printStackTrace();
			}
		}
	}

	public void wipeConsole() throws AWTException {
		Robot robbie = new Robot();
		robbie.keyPress(KeyEvent.VK_ALT);
		robbie.keyPress(KeyEvent.VK_SHIFT);
		robbie.keyPress(KeyEvent.VK_Q);
		robbie.keyRelease(KeyEvent.VK_ALT);
		robbie.keyPress(KeyEvent.VK_SHIFT);
		robbie.keyPress(KeyEvent.VK_Q);
		robbie.keyPress(KeyEvent.VK_C);
		robbie.keyRelease(KeyEvent.VK_C);

		robbie.keyPress(KeyEvent.VK_SHIFT);
		robbie.keyPress(KeyEvent.VK_F10);
		robbie.keyRelease(KeyEvent.VK_SHIFT);
		robbie.keyRelease(KeyEvent.VK_F10);
		robbie.keyPress(KeyEvent.VK_R);
		robbie.keyRelease(KeyEvent.VK_R);
	}

}

package com.formation.thde.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainFlux {

	public static void main(String[] args) throws Exception {
		MainFlux mainFlux = new MainFlux();
		//mainFlux.init();
		mainFlux.initEcriture();
		mainFlux.initLecture();
	}

	public void initLecture() {
		File file = new File("./src/com/formation/etga/data/texte.txt");
		BufferedReader bIn = null;
		try {
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
		File file = new File("./src/com/formation/jeci/data/texte.txt");
		PrintWriter out = null;
		try {
			System.out.println(file.getCanonicalPath());
			out = new PrintWriter(file);
			out.println("Bonjour tout le monde.");
			out.println("ceci doit apparaitre dans le fichier");
			out.flush();
			out.print("(ノಠ益ಠ)ノ彡┻━┻");
			out.print("Autre suite de la phrase");
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

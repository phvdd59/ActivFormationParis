package com.formation.thde.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainFlux {

	public static void main(String[] args) {
		MainFlux mainFlux = new MainFlux();
		mainFlux.init();
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

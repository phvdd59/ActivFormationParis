package com.formation.joca.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		main.lectureXml();
	}

	public void lectureXml() {
		File fichier = new File("C:/DevFormation/ActivFormationParis/ProjectXml.src/com/formation/joca/xml/toto.txt");
		BufferedReader bIn = null;
		
		try {
			InputStreamReader input = new InputStreamReader(new FileInputStream(fichier));
			bIn = new BufferedReader(input);
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

}

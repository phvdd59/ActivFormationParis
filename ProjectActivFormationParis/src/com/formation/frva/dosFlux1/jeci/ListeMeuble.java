package com.formation.phva.dosFlux1.jeci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ListeMeuble extends ArrayList<Meuble> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static TRI tri;

	public void chargeListeMeuble(File fRep) {
	}

	public void chargeXml(File file) {
		
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

	@Override
	public String toString() {
		String s = "[";
		for (int i = 0; i < size(); i++) {
			Meuble m = get(i);
			s += m.toString();
			if (i < size() - 1) {
				s += ",";
			}
		}
		s += "]";
		return s;
	}
}

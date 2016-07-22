package com.formation.phva.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DossierEtudiant {

	String[] tabNom = new String[] { "ambr", "anfr", "beba", "emma", "etga", "issa", "jeci", "joca", "made", "phva", "soka", "thcr", "thde", "phva" };

	public static void main(String[] args) throws IOException {
		DossierEtudiant d = new DossierEtudiant();
		d.init();
	}

	public void init() throws IOException {
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
		File fRep = null;
		File fIn = null;
		File fOut = null;
		PrintWriter out = null;
		BufferedReader in = null;
		for (int i = 0; i < tabNom.length; i++) {
			fRep = new File("src/com/formation/phva/doss/" + tabNom[i]);
			if (!fRep.exists()) {
				fRep.mkdirs();
			}
			fIn = new File("src/com/formation/" + tabNom[i] + "/exoResExoTableau1.txt");
			fOut = new File("src/com/formation/phva/doss/" + tabNom[i] + "/exoResExoTableau1_" + fd.format(new Date()) + ".txt");
			in = new BufferedReader(new FileReader(fIn));
			out = new PrintWriter(fOut);
			String s = in.readLine();
			while (s != null) {
				out.println(s);
				s = in.readLine();
			}
			in.close();
			out.close();
		}
		System.out.println("FIN");
	}
}

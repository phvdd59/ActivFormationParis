package com.formation.ambr.save;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ListeMeuble extends ArrayList<Meuble> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static TRI tri;

	public void chargeListeMeuble(File fRep) {
	}

	public void chargeXml(File file) {
		File file1 = new File("./src/com/formation/ambr/ctr/ExempleXml.xml");
		// flux caractère input -> reader
		BufferedReader br = null;
		try {
			ArrayList<Meuble> lst = new ArrayList<Meuble>();
			br = new BufferedReader(new FileReader(file1));
			String line = br.readLine();
			while (line != null) {
				if (repereBaliseMeuble(line) == true) {
					if (repereNom(line) == true && repereRef(line) == true && repereUnite(line) == true && repereLng(line) == true && repereLar(line) == true && repereHau(line) == true) {
						String a = line.trim();
						a = a.replaceAll("\\s+","");
						int i = a.indexOf("nom"); // i = 7
						int j = a.indexOf("ref"); // j = 25
						int k = a.indexOf("unite");
						int l = a.indexOf("lng");
						int m = a.indexOf("lar");
						int n = a.indexOf("hau");
						int o = a.indexOf(">");
						
						String nomCommercial = a.substring(i, j-1); // rajouter i+x
						String refAbrege = a.substring(j, k-1);
						String unite = a.substring(k, l-1);
						float lng = Float.valueOf(a.substring(l, m-1));
						float lar = Float.valueOf(a.substring(m, n-1));
						float hau = Float.valueOf(a.substring(n, o-1));
						
						Meuble meuble = new Meuble(nomCommercial, refAbrege, unite, lng, lar, hau); // faire nouveau constructeur dans meuble avec nom, ref, unite, lng, lar, hau
						lst.add(meuble);

					}
					
					
				}
				System.out.println(line);
				line = br.readLine();
			}
			System.out.println(lst);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public boolean repereBaliseMeuble(String line) {
		boolean baliseMeublePresente = false;
		if (line.contains("<Meuble")) {
			baliseMeublePresente = true;
		} else {
			baliseMeublePresente = false;
		}
		return baliseMeublePresente;
	}

	public boolean repereNom(String line) {
		boolean nomPresent = false;
		if (line.contains("nom")) {
			nomPresent = true;
		} else {
			nomPresent = true;
		}
		return nomPresent;
	}

	public boolean repereRef(String line) {
		boolean refPresent = false;
		if (line.contains("ref")) {
			refPresent = true;
		} else {
			refPresent = true;
		}
		return refPresent;
	}

	public boolean repereUnite(String line) {
		boolean unitePresent = false;
		if (line.contains("unite")) {
			unitePresent = true;
		} else {
			unitePresent = true;
		}
		return unitePresent;
	}
	
	public boolean repereLng(String line) {
		boolean lngPresent = false;
		if (line.contains("lng")) {
			lngPresent = true;
		} else {
			lngPresent = true;
		}
		return lngPresent;
	}
	
	public boolean repereLar(String line) {
		boolean larPresent = false;
		if (line.contains("lar")) {
			larPresent = true;
		} else {
			larPresent = true;
		}
		return larPresent;
	}
	
	public boolean repereHau(String line) {
		boolean hauPresent = false;
		if (line.contains("hau")) {
			hauPresent = true;
		} else {
			hauPresent = true;
		}
		return hauPresent;
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

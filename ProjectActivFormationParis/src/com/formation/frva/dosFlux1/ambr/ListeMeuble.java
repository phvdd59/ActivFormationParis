package com.formation.phva.dosFlux1.ambr;

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
					if (repereX(line) == true && repereY(line) == true && repereSens(line) == true && line.contains("VERTICAL")) {
						String a = line.trim();
						String nextline = br.readLine();
						String b = nextline.trim();
						String nom = new String(b);

						boolean sens = true; // true : VERTICAL

						char[] tabChar = a.toCharArray();
						int i = a.indexOf("x");
						int x = Character.getNumericValue(tabChar[i + 3]);
						int j = a.indexOf("y");
						int y = Character.getNumericValue(tabChar[j + 3]);
						Point pos = new Point(x, y);

						Meuble meuble = new Meuble();
						lst.add(meuble);

					}
					if (repereX(line) == true && repereY(line) == true && repereSens(line) == true && line.contains("HORIZONTAL")) {
						String a = line.trim();
						String nextline = br.readLine();
						String b = nextline.trim();
						String nom = new String(b);

						boolean sens = false; // false : HORIZONTAL

						char[] tabChar = a.toCharArray();
						int i = a.indexOf("x");
						int x = Character.getNumericValue(tabChar[i + 3]);
						int j = a.indexOf("y");
						int y = Character.getNumericValue(tabChar[j + 3]);
						Point pos = new Point(x, y);

						Meuble meuble = new Meuble();
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
		boolean baliseTermePresente = false;
		if (line.contains("<Terme")) {
			baliseTermePresente = true;
		} else {
			baliseTermePresente = false;
		}
		return baliseTermePresente;
	}

	public boolean repereX(String line) {
		boolean xPresent = false;
		if (line.contains("x")) {
			xPresent = true;
		} else {
			xPresent = true;
		}
		return xPresent;
	}

	public boolean repereY(String line) {
		boolean yPresent = false;
		if (line.contains("y")) {
			yPresent = true;
		} else {
			yPresent = true;
		}
		return yPresent;
	}

	public boolean repereSens(String line) {
		boolean sensPresent = false;
		if (line.contains("sens")) {
			sensPresent = true;
		} else {
			sensPresent = true;
		}
		return sensPresent;
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

package com.formation.phva.dosFlux1.issa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
		//ecriture
		//File file=new File(".src/com/formation/issa/ctr/fFile.xml");
		
		
	}

	public void chargeXml(File file) {
		//Lecture
		File file1=new File(".src/com/formation/issa/ctr/fFile.xml");
		BufferedReader oS=null;
		InputStreamReader input=null;
		Elmt element=new Elmt(5, "boisRose", 3, 45, 55, 60);
		int numero=5;
		try{
			input=new InputStreamReader(new FileInputStream(file1));
			oS=new BufferedReader(input);
			try {
				String elementEntier=element.toString();
				elementEntier=oS.readLine();
				while((elementEntier=oS.readLine())!=null){
					String listElement[]=elementEntier.split(",");
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
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

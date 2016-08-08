package com.formation.phva.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.formation.phva.exception.CruciException;
import com.formation.phva.metier.ListTerme;
import com.formation.phva.metier.Terme;

public class MainXml {

	public static void main(String[] args) throws IOException, CruciException {
		MainXml main = new MainXml();
		//main.ecriture();
		main.lectureDom();
	}

	public void ecriture() throws IOException {
		ArrayList<Terme> lst = new ArrayList<Terme>();
		BufferedReader bIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bonjour. pour commencer appuyez sur la touche ENTRER");
		String sDebut = bIn.readLine();
		while (sDebut.length() == 0) {
			System.out.println("Saisir le MOT :");
			String sMot = bIn.readLine();
			String sRes = epuration(sMot);
			while (sMot.length() == 0 || !sRes.equals(sMot)) {
				System.err.println("erreur sur la saisie du mot.");
				System.out.println("Saisir le MOT :");
				sMot = bIn.readLine();
				sRes = epuration(sMot);
			}
			System.out.println("Saisir la position x :");
			String sX = bIn.readLine();
			while (!sX.matches("\\d+")) {
				System.err.println("erreur sur la saisie de la coordonnée x.");
				System.out.println("Saisir la position x :");
				sX = bIn.readLine();
			}
			System.out.println("Saisir la position y :");
			String sY = bIn.readLine();
			while (!sY.matches("\\d+")) {
				System.err.println("erreur sur la saisie de la coordonnée y.");
				System.out.println("Saisir la position y :");
				sY = bIn.readLine();
			}
			System.out.println("Saisir le sens (H/V) :");
			String sSens = bIn.readLine();
			while (!sSens.matches("([HV]{1})")) {
				System.err.println("erreur sur la saisie du sens.");
				System.out.println("Saisir le sens (H/V) :");
				sSens = bIn.readLine();
			}
			Terme terme = new Terme(sRes, new Point(Integer.valueOf(sX).intValue(), Integer.valueOf(sY).intValue()), ((sSens.equals("H") ? Terme.HORIZONTAL : Terme.VERTICAL)));
			lst.add(terme);
			System.out.println("pour poursuivre appuyez sur la touche ENTRER sinon ecrire FIN");
			sDebut = bIn.readLine();
			while (sDebut.length() > 0 && !sDebut.equals("FIN")) {
				System.out.println("pour poursuivre appuyez sur la touche ENTRER sinon ecrire FIN");
				sDebut = bIn.readLine();
			}
		}
		ecritureDom(lst);
	}

	//	<ListTerme>
	//		<Terme y='1' x='2'    sens='VERTICAL'>
	//			BONJOUR
	//		</Terme>
	//	</ListTerme>	
	public void ecritureDom(ArrayList<Terme> lst) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.newDocument();
			final Element eListTerme = document.createElement("ListTerme");
			document.appendChild(eListTerme);
			for (Terme terme : lst) {
				final Element eTerme = document.createElement("Terme");
				eListTerme.appendChild(eTerme);
				eTerme.setAttribute("x", Integer.toString(terme.getPos().x));
				eTerme.setAttribute("y", Integer.toString(terme.getPos().y));
				eTerme.setAttribute("sens", ((terme.isSens() == Terme.HORIZONTAL) ? "HORIZONTAL" : "VERTICAL"));
				eTerme.appendChild(document.createTextNode(terme.getNom()));
			}

			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			final DOMSource source = new DOMSource(document);

			final StreamResult sortie = new StreamResult(new File("src/com/formation/phva/xml/LstTerme.xml"));
			//final StreamResult sortie = new StreamResult(System.out);
			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, sortie);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public void lectureDom() throws IOException, CruciException {
		ListTerme lst = new ListTerme();
		File file = new File("src/com/formation/phva/xml/ListTerme.xml");
		System.out.println(file.getCanonicalPath());
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(file);
			System.out.println(document.getXmlVersion());
			System.out.println(document.getXmlEncoding());
			System.out.println(document.getXmlStandalone());

			final Element eListTerme = document.getDocumentElement();
			System.out.println(eListTerme.getNodeName());
			final NodeList listTermeNoeuds = eListTerme.getChildNodes();
			final int nbListTermeNoeuds = listTermeNoeuds.getLength();
			for (int i = 0; i < nbListTermeNoeuds; i++) {
				Node ee = listTermeNoeuds.item(i);
				System.err.println("[" + ee.getNodeName() + "," + NODE_TYPE.values()[ee.getNodeType()] + ","+ee.getTextContent()+"," + ee.getNodeValue() + "]");
				if (listTermeNoeuds.item(i) != null && listTermeNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					if (listTermeNoeuds.item(i).getNodeName().equals("Terme")) {
						final Element eTerme = (Element) listTermeNoeuds.item(i);
						try {
							int x = Integer.valueOf(eTerme.getAttribute("x")).intValue();

							int y = Integer.valueOf(eTerme.getAttribute("y")).intValue();
							boolean sens = Boolean.valueOf(eTerme.getAttribute("sens")).booleanValue();
							String nom = eTerme.getTextContent();
							lst.add(new Terme(nom, new Point(x, y), sens));
						} catch (Exception e) {
						}
					}
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Cruci cruci = new Cruci(lst);
		cruci.afficher();
	}

	public String epuration(String txt) {
		String sRet = "";
		if (txt != null) {
			char[] tab = txt.trim().toLowerCase().toCharArray();
			for (int i = 0; i < tab.length; i++) {
				int v = tab[i];
				if (v >= 'à' && v <= 'å') {
					sRet += "a";
				} else if (v >= 'ç' && v <= 'ç') {
					sRet += "c";
				} else if (v >= 'è' && v <= 'ë') {
					sRet += "e";
				} else if (v >= 'ì' && v <= 'ï') {
					sRet += "i";
				} else if (v >= 'ò' && v <= 'ö') {
					sRet += "o";
				} else if (v >= 'ù' && v <= 'ü') {
					sRet += "u";
				} else if (v >= 'ý' && v <= 'ý') {
					sRet += "y";
				} else if (v >= 'a' && v <= 'z') {
					sRet += (char) v;
				} else {
					if (i != 0 && sRet.length() > 00 && !sRet.substring(sRet.length() - 1).equals(" ")) {
						sRet += " ";
					}
				}
			}
		}
		return sRet.trim().toUpperCase();
	}

}

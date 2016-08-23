//package com.formation.jeci.ctr;
//
//import java.awt.Point;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import com.formation.made.exo.NegatifException;
//import com.formation.soka.exo.SensException;
//
//public class ListeMeuble extends ArrayList<Meuble> {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	public static TRI tri;
//
//	public void chargeListeMeuble(File fRep) {
//
//	}
//
//	public void chargeXml(File file) {
//
//		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		// File file = new File("./src/com/formation/etga/xml/ListTerme.xml");
//		try {
//			final DocumentBuilder builder = factory.newDocumentBuilder();
//			final Document document = builder.parse(file);
//			System.out.println(document.getXmlEncoding());
//			System.out.println(document.getXmlVersion());
//
//			final Element eListMeuble = document.getDocumentElement();
//			final NodeList nListMeuble = eListMeuble.getChildNodes();
//			System.out.println(eListMeuble.getNodeName());
//			if (eListMeuble.getNodeName().equals("ListTerme")) {
//				// lstMeuble = new ArrayList<Meuble>();
//				for (int i = 0; i < nListMeuble.getLength(); i++) {
//					final Node nMeuble = nListMeuble.item(i);
//					System.out.println(nListMeuble.item(i).getNodeName());
//					if (nMeuble.getNodeType() == Node.ELEMENT_NODE) {
//						final Element eMeuble = (Element) nMeuble;
//						System.out.println(eMeuble.getNodeName());
//						if (eMeuble.getNodeName().equals("Meuble")) {
//							String sNom = eMeuble.getAttribute("nom");
//							String sRef = eMeuble.getAttribute("ref");
//							String sUnite = eMeuble.getAttribute("unite");
//							String sLng = eMeuble.getAttribute("lng");
//							String sLar = eMeuble.getAttribute("lar");
//							String sHau = eMeuble.getAttribute("hau");
//								final NodeList nListElement=eMeuble.getChildNodes();
//								for (int j = 0; i < nListMeuble.getLength(); j++) {
//									final Node nMeubleElement = nListElement.item(j);
//									System.out.println(eMeuble.getNodeName());
//									if (nMeubleElement.getNodeType() == Node.ELEMENT_NODE) {
//										final Element eMeubleElement = (Element) nMeubleElement;
//									if (eMeuble.getNodeName().equals("Elmt")) {
//										String sNom1 = eMeuble.getAttribute("nom");
//										String sRef1 = eMeuble.getAttribute("num");
//										String sUnite1 = eMeuble.getAttribute("unite");
//										String sLng1 = eMeuble.getAttribute("lng");
//										String sLar1 = eMeuble.getAttribute("lar");
//										String sHau1 = eMeuble.getAttribute("hau");
//											final Element eMeubleElementMateriau = (Element) nMeubleElement.getFirstChild();
//												if (eMeubleElementMateriau.getNodeName().equals("Materiaux")) {
//													String type=eMeubleElementMateriau.getAttribute("type");
//													String pc=eMeubleElementMateriau.getAttribute("pc");
//												try {		
//													MATERIAUX type1 = MATERIAUX.valueOf(type);
//													int lar1 = Integer.parseInt(sLar1);
//													int hau1 = Integer.parseInt(sHau1);
//													} }catch (Exception e) {
//													}
//												
//										try {		
//										int lng1 = Integer.parseInt(sLng1);
//										int lar1 = Integer.parseInt(sLar1);
//										int hau1 = Integer.parseInt(sHau1);
//										} catch (Exception e) {
//										}
//									}
//
//							try {
//
//								int lng = Integer.parseInt(sLng);
//								int lar = Integer.parseInt(sLar);
//								int hau = Integer.parseInt(sHau);
//								
//								
//
////								
////								meuble terme = new meuble(sNom, new Point(x, y), sens);
////								this.add(meuble);
//							}}}}}}}} catch (Exception e) {
//							
//							}
//	}
//
//	@Override
//	public String toString() {
//		String s = "[";
//		for (int i = 0; i < size(); i++) {
//			Meuble m = get(i);
//			s += m.toString();
//			if (i < size() - 1) {
//				s += ",";
//			}
//		}
//		s += "]";
//		return s;
//	}
//}

package com.formation.beans;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.formation.ajee.dao.DaoBDD;

public class Mainssa {

	public static void main(String[] args) throws MalformedURLException {
		Mainssa m = new Mainssa();
		m.init();
	}

	private void init() throws MalformedURLException {
//		DaoBDD dao1 = new DaoBDD();
//		ArrayList<Perso> lst = dao1.lectureTableBackUpPerso();
//		for (int i = 0; i < lst.size(); i++) {
//			System.out.println(lst.get(i).getNom());
//		}

		URL wsdlURL = new URL("http://192.168.33.145:8888/ws/jax?wsdl");
		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
		Service service = Service.create(wsdlURL, qname);
		InterPersoService ps = service.getPort(InterPersoService.class);
		Perso[] p = ps.getPersos();
		System.out.println(p.length);

	}

}

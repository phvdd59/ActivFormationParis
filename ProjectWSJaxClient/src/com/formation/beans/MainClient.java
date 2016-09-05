package com.formation.beans;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class MainClient {

	public static void main(String[] args) throws MalformedURLException {
		MainClient p=new MainClient();
		p.init();
	}
	public void init() throws MalformedURLException {
		URL wsdlURL = new URL("http://192.168.33.143:8888/ws/jax?wsdl");
		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
		Service service = Service.create(wsdlURL, qname);
		InterPersoService ps = service.getPort(InterPersoService.class);
		
//		Perso p1 = new Perso(21,"Vdd1","Francoise",25);
//		Perso p2 = new Perso(41,"Vdd1","Philippe",1);
//		
//		System.out.println("Add Fr : "+ps.addPerso(p1));
//		System.out.println("Add Ph : "+ps.addPerso(p2));
//		
//		System.out.println(Arrays.toString(ps.getAllPerso()));
	}
}

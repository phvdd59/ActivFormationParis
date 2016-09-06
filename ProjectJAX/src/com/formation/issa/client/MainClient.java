package com.formation.issa.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.formation.issa.beans.InterPersonJService;
import com.formation.issa.beans.PersonJ;

public class MainClient {

	public static void main(String[] args) throws MalformedURLException {
		MainClient mainClient = new MainClient();
		mainClient.init();

	}

	private void init() throws MalformedURLException {
		URL wsdlURL = new URL("http://localhost:8888/ws/personJ?wsdl");

		QName qname = new QName("http://beans.issa.formation.com/", "ServicePersonJService");

		Service service = Service.create(wsdlURL, qname);

		InterPersonJService ps = service.getPort(InterPersonJService.class);
		PersonJ p1 = new PersonJ(2, "Lucile", 18);
		PersonJ p2 = new PersonJ(4, "Henri", 35);

		System.out.println("Add personne1 : " + ps.addPersonJ(p1));
		System.out.println("Add personne2 : " + ps.addPersonJ(p2));
		System.out.println(Arrays.toString(ps.getAllPersonJs()));
	}

}

package com.formation.made.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.formation.made.inter.InterPersonneService;
import com.formation.made.metier.Personne;

public class MainClient {

	public static void main(String[] args) throws MalformedURLException {
		MainClient m=new MainClient();
		m.init();

	}

	private void init() throws MalformedURLException{
		URL wsdlURL=new URL("http://localhost:8888/dossier/personne?wsdl");
		QName qname=new QName("http://service.made.formation.com/","PersonneServiceService");
		Service service=Service.create(wsdlURL,qname);
		InterPersonneService ps=service.getPort(InterPersonneService.class);
		Personne p1=new Personne();
		Personne p2=new Personne();
		p1.setId(1);p1.setName("marc");p1.setAge(37);
		p2.setId(2);p2.setName("marc2");p2.setAge(28);
		ps.addPersonne(p1);
		System.out.println("add marc");
		System.out.println("add marc2"+ps.addPersonne(p2));
		System.out.println(Arrays.toString(ps.getAllPersonnes()));
	}

	
		
}

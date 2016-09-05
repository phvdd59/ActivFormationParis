package com.formation.made.service;

import javax.xml.ws.Endpoint;

public class MainServer {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/dossier/personne", new PersonneService());
		System.out.println("serveur lancé");
	}

}

package com.formation.phva.beans;

import javax.xml.ws.Endpoint;

public class MainServeur {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/ws/jaxPhva", new PersoService());
		System.out.println("Serveur du service en cours");
	}
}

package com.formation.phva.beans;

import javax.xml.ws.Endpoint;

public class MainServeur {

	public static void main(String[] args) {
		Endpoint.publish("http://192.168.33.143:8888/ws/jaxPhva", new PersoService());
		System.out.println("Serveur du service en cours");
	}
}

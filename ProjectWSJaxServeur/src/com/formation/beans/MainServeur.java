package com.formation.beans;

import javax.xml.ws.Endpoint;

public class MainServeur {

	public static void main(String[] args) {
		Endpoint.publish("http://192.168.33.143:8888/ws/jax", new PersoService());
		System.out.println("Serveur du service en cours");
	}
}

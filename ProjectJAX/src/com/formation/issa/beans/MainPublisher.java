package com.formation.issa.beans;

import javax.xml.ws.Endpoint;

public class MainPublisher {

	public static void main(String[] args) {
	Endpoint.publish("http://localhost:8888/ws/personJ", new ServicePersonJ());
	System.out.println("Serveur lancé!");

	}

}

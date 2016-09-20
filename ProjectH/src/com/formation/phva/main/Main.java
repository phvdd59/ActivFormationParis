package com.formation.phva.main;

import java.io.File;
import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.formation.phva.metier.Materiaux;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Materiaux mat = Materiaux.BOIS.getMateriaux(100);
		File file = new File("./hibernate.cfg.xml");
		// Configuration configuration = new Configuration().configure(file);
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(mat);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}

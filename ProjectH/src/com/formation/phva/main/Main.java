package com.formation.phva.main;

import java.io.File;
import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.formation.phva.metier.Elmt;
import com.formation.phva.metier.Materiaux;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.init();
	}

	public void init() {

		Elmt e = new Elmt(1, "planche", 1, 100, 100, 100);
		Materiaux mat = Materiaux.BOIS.getMateriaux(100);
		e.getListeMateriaux().add(mat);
		//mat.setElmt(e);
		File file = new File("hibernate.cfg.xml");
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

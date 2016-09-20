package com.formation.phva.main;

import java.io.File;
import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.formation.phva.metier.Elmt;
import com.formation.phva.metier.Materiaux;
import com.formation.phva.metier.Meuble;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.init();
	}

	public void init() {
		Meuble meuble=new Meuble(Meuble.TRI_REF,"Mon Meuble","123456789",100,100,100);
		Elmt e = new Elmt(1, "planche", 1, 100, 100, 100);
		Materiaux mat = Materiaux.BOIS.getMateriaux(100);
		e.getListeMateriaux().add(mat);
		mat.setElmt(e);
		meuble.getLstElmt().add(e);
		
		File file = new File("hibernate.cfg.xml");
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(mat);
		session.save(e);
		session.save(meuble);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}

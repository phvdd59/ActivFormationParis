package com.formation.phva.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.formation.phva.metier.Elmt;
import com.formation.phva.metier.ListeMeuble;
import com.formation.phva.metier.Materiaux;
import com.formation.phva.metier.Meuble;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		//m.init();
		//m.init1();
		m.init2();
	}

	public void init2() {
		boolean bCriteria = true;
		File file = new File("src/hibernate.cfg2.xml");
		Configuration configuration = new Configuration().configure(file);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// requete query
		if (!bCriteria) {
			Query query = session.createQuery("from Materiaux where id_materiaux = 3");
			List list = query.list();
			System.out.println(Arrays.toString(list.toArray()));
		}

		if (bCriteria) {
			Criteria criteria = session.createCriteria(Materiaux.class);
			criteria.add(Restrictions.eq("id_materiaux", 3l));
			//criteria.uniqueResult();
			List<Materiaux> lst = criteria.list();
			System.out.println("-------------------------------------------------------------");
			System.out.println(Arrays.toString(lst.toArray()));
			System.out.println("-------------------------------------------------------------");
		}
		if (bCriteria) {
			Criteria criteria = session.createCriteria(Materiaux.class);
			criteria.setMaxResults(4);
			List<Materiaux> lst = criteria.list();
			System.out.println("-------------------------------------------------------------");
			System.out.println(Arrays.toString(lst.toArray()));
			System.out.println("-------------------------------------------------------------");
		}
		
		if (bCriteria) {
			Criteria criteria = session.createCriteria(Materiaux.class);
			List lst=criteria.add(Restrictions.like("nom", "B%"))
				    .add(Restrictions.between("densite", 0.5f, 10f))
				    .list();
			System.out.println("-------------------------------------------------------------");
			System.out.println(Arrays.toString(lst.toArray()));
			System.out.println("-------------------------------------------------------------");
		}

		if (bCriteria) {
			Criteria criteria = session.createCriteria(Materiaux.class);
			List lst=criteria.add(Restrictions.like("nom", "B%"))
				    .add(Restrictions.between("densite", 0.5f, 10f))
				    .addOrder( Order.asc("id_materiaux") )
				    .list();
			System.out.println("-------------------------------------------------------------");
			System.out.println(Arrays.toString(lst.toArray()));
			System.out.println("-------------------------------------------------------------");
		}
		//
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}
	

	public void init1() {
		ListeMeuble lst = new ListeMeuble();
		lst.chargeListeMeuble(new File("C:/DevFormation/GITActivFormationParis/ProjectH/ikae/"));

		File file = new File("src/hibernate.cfg.xml");
		Configuration configuration = new Configuration().configure(file);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 0; i < lst.size(); i++) {
			Meuble meuble = lst.get(i);
			session.save(meuble);
		}

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

	public void init() {

		Meuble meuble = new Meuble(Meuble.TRI_REF, "Mon Meuble", "123456789", 100, 100, 100);
		Elmt e = new Elmt(1, "planche", 1, 100, 100, 100);
		Materiaux mat = Materiaux.BOIS.getMateriaux(100);
		e.getListeMateriaux().add(mat);
		mat.setElmt(e);
		meuble.getLstElmt().add(e);
		e.setMeuble(meuble);

		Elmt e1 = new Elmt(1, "planche2", 1, 100, 100, 100);
		Materiaux mat1 = Materiaux.FER.getMateriaux(100);
		e1.getListeMateriaux().add(mat1);
		mat1.setElmt(e1);

		meuble.getLstElmt().add(e1);
		e1.setMeuble(meuble);

		File file = new File("hibernate.cfg.xml");
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(meuble);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}

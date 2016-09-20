package com.formation.bean;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainHibernate {

	public static void main(String[] args) {
		MainHibernate m = new MainHibernate();
		m.init();
//		m.init2();
		Session session = HibernateUtils.getSession();
		session.getSessionFactory().close();
	}

	public void init2() {
		DaoHibernate dao = new DaoHibernate();
		Produit p = dao.read("JECI");
		System.out.println(p.toString());
	}

	public void init() {
//		Produit produit1 = new Produit("Papier Dessin");
		ProduitInfo info = new ProduitInfo("A4", "France");
//		ProduitInfo info2 = new ProduitInfo("ERREUR", "France");
//		produit1.setInfo(info1);
//		Produit produit2 = new Produit(2, "JECI", info2);
		Categorie cat = new Categorie("casserole", "123456");
		Produit produit = new Produit("TEST", info, cat);
//			Configuration conf = new Configuration().configure();
//			SessionFactory sessionFactory = conf.buildSessionFactory();
//			Session session = sessionFactory.openSession();
		Session session = HibernateUtils.getSession(); // On replace par cette ligne
		Transaction trans = session.beginTransaction();
		session.save(produit);
		trans.commit();
		session.close();
		System.out.println("fin");
		session.getSessionFactory().close();
	}

}

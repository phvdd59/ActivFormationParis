package com.formation.bean;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoHibernate {
	
	public void create(Produit produit) {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		session.save(produit);
		trans.commit();
		session.close();
	}
	
	public Produit read(String nomProd) {
		Produit result = new Produit(); 
		Session session = HibernateUtils.getSession();
		Query q = session.createQuery("from Produit where nom = :nom");
		q.setString("nom", nomProd);
		result = (Produit) q.uniqueResult();
		session.close();
		return result;
	}
	
	public Produit update(String nomProd) {
		Produit result = new Produit(); 
		Session session = HibernateUtils.getSession();
		Query q = session.createQuery("from Produit where nom = :nom");
		q.setString("nom", nomProd);
		Transaction trans = session.beginTransaction();
		result = (Produit) q.uniqueResult();
		session.update(result);
		trans.commit();
		session.close();
		return result;
	}
	
	public void delete(String nomProd) {
		Session session = HibernateUtils.getSession();
		Query q = session.createQuery("from Produit where nom = :nom");
		q.setString("nom", nomProd);
		
		session.close();
	}
}

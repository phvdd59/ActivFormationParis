package com.formation.phva.main;



import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.phva.beans.SocieteDevLogiciel;

public class MainSpring {
	public static void main(String[] args) {
		MainSpring m = new MainSpring();
		m.init();
	}

	public void init() {
		Logger logger = Logger.getLogger(this.getClass().getName());
		/* chargement du conteneur spring */
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("simple-beans.xml");
		SocieteDevLogiciel societe1 = (SocieteDevLogiciel) app.getBean("societeDevLogiciel");
		logger.info("Chef Developpeur1: " + societe1.getChefDeveloppeur().getNom());
		app.close();
		
		ApplicationContext appContext = (ApplicationContext) 
				new ClassPathXmlApplicationContext("simple-beans.xml");
		/* récupération d'un bean du conteneur */
		SocieteDevLogiciel societe = (SocieteDevLogiciel) 
				appContext.getBean("societeDevLogiciel");
		/* utilisation du bean avec injection de dépendence */
		logger.info("Chef Developpeur: " + societe.getChefDeveloppeur().getNom());
		logger.info("Developpeur     : " + societe.getDeveloppeur().getNom());
	}
}

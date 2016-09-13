package com.formation.emma.autreexo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emma.autreexo.SocieteDevLogiciel;

public class MainSpring {

	public static void main(String[] args) {
		MainSpring main = new MainSpring();
		main.init();

	}

	private void init() {
		Logger logger = Logger.getLogger(this.getClass().getName());
		/* chargement du conteneur spring */
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("simple-beans.xml");
		SocieteDevLogiciel societe1 = (SocieteDevLogiciel) app.getBean("societeDevLogiciel");
		logger.info("Chef Developpeur1 : " + societe1.getChefDeveloppeur().getNom());
		app.close();

		ApplicationContext appContext = new ClassPathXmlApplicationContext("simple-beans.xml");
		/* récupération d'un beans du conteneur */
		SocieteDevLogiciel societe = (SocieteDevLogiciel) appContext.getBean("societeDevLogiciel");
		/* utilisation du bean avec injection de dépendance */
		logger.info("Chef Developpeur : " + societe.getChefDeveloppeur().getNom() + " " + societe.getChefDeveloppeur().getAnneesExperience());
		logger.info("Developpeur : " + societe.getDeveloppeur().getNom() + " " + societe.getDeveloppeur().getAnneesExperience());
	}

}

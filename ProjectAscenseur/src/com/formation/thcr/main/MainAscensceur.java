package com.formation.thcr.main;

import com.formation.thcr.metier.ListAscenseur;
import com.formation.thcr.metier.ListPersonne;

public class MainAscensceur {

	public static void main(String[] args) {
		MainAscensceur main = new MainAscensceur();
		main.init();
	}

	private void init() {

		ListPersonne listPersonne = new ListPersonne();
		Thread listPersonneThread = new Thread(listPersonne, "LISTE DE PERSONNE");
		listPersonneThread.start();
		ListAscenseur listAscenseur = new ListAscenseur(listPersonne);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//		try {
		while (!listPersonne.isEmpty()) {
			//				//Trouver l'ascenseur le plus proche et wait (personne.getDepart compareto ascenseur.getetage && ascenseur (notify)
			//				//mettre sur état départ et ascenceur progression ??? (cb d'étage par unité de temps) && ascenseur busy
			//				//l'ascenseur vient chercher cette personne (ascenseur.setPersonnne)
			//				//l'ascenseur l'emmène à l'étage voulu (personne.getArrive == ascenseur.etage) 
			//				//vider la paersonne de la liste et mettre ascensceur ready pour la prochaine personne
			//				synchronized (listPersonneThread) {
			//					ascenseur1.wait();
			//					for (Personne personne : listPersonne) {
			//						if (personne.getEtat() == ETAT.ETAT_ATTENTE.ordinal()) {
			//							if (ascenseur1.getState() == Thread.State.WAITING && ascenseur1.getPersonne() == null) {
			//								personne.notify();
			//								personne.setEtat(ETAT.ETAT_DEPART.ordinal());
			//								int progression = 0;
			//								ascenseur1.setProgression(progression);
			//								while (!(ascenseur1.getEtage() == personne.getDepart())) {
			//								}
			//								ascenseur1.setPersonne(personne);
			//								personne.setEtat(ETAT.ETAT_MOVE.ordinal());
			//								while (!(ascenseur1.getEtage() == personne.getArrive())) {
			//								}
			//								ascenseur1.setPersonne(null);
			//								personne.setEtat(ETAT.ETAT_ARRIVE.ordinal());
			//								ascenseur1.wait();
			//							}
			//						} else if (personne.getEtat() == ETAT.ETAT_ARRIVE.ordinal()) {
			//							listPersonne.remove(personne);
			//						}
			//					}
			//				}
			//				Thread.sleep(200);
			//				synchronized (listPersonne) {
			//					listPersonne.wait();
			//					Personne p = null;
			//					int personneArrive = (int) (Math.random() * listPersonne.size());
			//					listPersonne.get(personneArrive).setEtat(ETAT.ETAT_ARRIVE.ordinal());
			//					for (Personne personne : listPersonne) {
			//						if (personne.getEtat() == ETAT.ETAT_ARRIVE.ordinal()) {
			//							p = personne;
			//						}
			//					}
			//System.out.println(listAscenseur);
			//System.out.println(listPersonne.remove(listPersonne.indexOf(p)));
			//					notify();
			//				}
			//				System.out.println(listPersonne.size());
			//				listPersonne.remove(listPersonne.size() - 1);
			//			}
			//		} catch (InterruptedException e) {
			//			e.printStackTrace();
			//		}
		}
		System.out.println("FIN main");
	}
}

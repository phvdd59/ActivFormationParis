package com.formation.emma.metier;

public class Ascenseur extends Thread {

	public static int CPT = 0;
	public static int TEMPS = 100;
	public static int HAUTEUR_ETAGE = 30;

	private int etage;
	private int progression;
	private boolean fin;
	private Personne personne;
	private ListePersonne listP;

	public Ascenseur(ListePersonne listP) {
		this.setName(Integer.toString(CPT));
		CPT++;
		etage = 0;
		personne = null;
		this.listP = listP;
	}

	@Override
	public void run() {
		progression = 0;
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
			}

			if (personne == null) {
				synchronized (listP) {
					if (listP.size() == 0 && listP.isSortie()) {
						fin = true;
					} else {
						personne = rechercherPersEnAttente();
						personne.setEtat(Etat.DEPART);
					}
				}

			} else {
				int deplacement1 = 0;
				int deplacement2 = 0;

				if (personne.getEtat() == Etat.DEPART) {
					deplacement1 = getEtage() - personne.getDepart();
					deplacerAscenseur(deplacement1);
					if (etage == personne.getDepart()) {
						personne.setEtat(Etat.MOVE);
					}
				} else if (personne.getEtat() == Etat.MOVE) {
					deplacement2 = personne.getDepart() - personne.getArrivee();
					deplacerAscenseur(deplacement2);
					if (etage == personne.getArrivee()) {
						personne.setEtat(Etat.ARRIVE);
					}
				} else if (personne.getEtat() == Etat.ARRIVE) {
					personne = null;
				}
			}
		}
	}

	private void deplacerAscenseur(int deplacement) {

		if (deplacement > 0) {
			progression++;
			if (progression % HAUTEUR_ETAGE == 0) {
				etage--;
			}
			// change d'etage grace boucle while dans le run 
		} else if (deplacement < 0) {
			progression++;
			if (progression % HAUTEUR_ETAGE == 0) {
				etage++;
			}

		}
	}

	private Personne rechercherPersEnAttente() { // peut mettre synchronized directement dans la methode mais si le fait les autres ascenseurs ne pourront pas utiliser la liste tant que la recherche ne sera pas terminée pour cet ascenseur 
		Personne persDispo = null;
		for (int i = 0; i < listP.size(); i++) {
			if (listP.get(i).getEtat() == Etat.ATTENTE) {
				persDispo = listP.remove(i);
				break;
			}
		}
		return persDispo;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getProgression() {
		return progression;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Ascenseur " + this.getName() + " [etage=" + etage + ", progression=" + progression + ", fin=" + fin + ", personne=" + personne + "]";
	}

}

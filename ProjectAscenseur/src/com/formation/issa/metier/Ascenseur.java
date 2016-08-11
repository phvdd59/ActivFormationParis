package com.formation.issa.metier;

public class Ascenseur extends Thread {
	public static int CPT = 0;
	public static int TEMPS = 10; // vitesste à laquelle l'ascenseur va bouger
	public static int HAUTEUR_ETAGE = 30;
	private int etage;
	private int progression;
	private Personne personne;
	private boolean fin;
	private ListPersonne listPersonne;

	public Ascenseur() {
		this.setHAUTEUR_ETAGE(HAUTEUR_ETAGE);
		this.setEtage(etage);

	}

	public Ascenseur(ListPersonne listPersonne) {
		this.listPersonne = listPersonne;
		etage = 0;
		progression = 0;
		fin = false;
		personne = null;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
				// recherche de personnes
				if (personne == null) {

					synchronized (listPersonne) {
						if (listPersonne.size() == 0 && listPersonne.issortie()) {
							fin = true;
						} else {
							personne = rechercherPersonneEnAttente();
							personne.setEtat(ETAT.ETAT_DEPART.ordinal());
						}
					}

				} else {
					if (personne.getEtat() == ETAT.ETAT_DEPART.ordinal()) {
						deplaceAscenseurversDepart();

					} else if (personne.getEtat() == ETAT.ETAT_MOVE.ordinal()) {
						deplaceAscenseurversArrivee();

					} else if (personne.getEtat() == ETAT.ETAT_ARRIVEE.ordinal()) {
						personne = null;

					}

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private Personne rechercherPersonneEnAttente() {
		Personne persDisponible = null;
		if (listPersonne != null) {
			int indice = 0;
			while (indice < listPersonne.size() && listPersonne.get(indice).getEtat() != ETAT.ETAT_ATTENTE.ordinal()) {
				indice++;
			}
			if (indice != listPersonne.size()) {
				persDisponible = listPersonne.remove(indice);
			}

		}
		return personne;
	}

	private void deplaceAscenseurversDepart() {
		if (this.etage > personne.getDepart()) {
			if (progression % 30 == 0) {
				for (int i = 30; i > 0; i--) {
					progression--;
				}
				etage--;
			}
		} else if (etage < personne.getDepart()) {
			if (progression % 30 == 0) {
				for (int i = 0; i < 30; i++) {
					progression++;
				}
				etage++;
			}

		} else {
			personne.setEtat(ETAT.ETAT_MOVE.ordinal());
		}
	}

	private void deplaceAscenseurversArrivee() {
		if (etage > personne.getArrivee()) {
			etage--;
		} else if (etage < personne.getArrivee()) {
			etage++;
		} else {
			personne.setEtat(ETAT.ETAT_ARRIVEE.ordinal());

		}

	}

	// public void MonteeAscenseur() {
	// int etageInitial = personne.getDepart();
	// int etageArrivee = personne.getArrivee();
	// while (etageInitial < etageArrivee) {
	// for (int i = etageInitial; i < etageArrivee; i++) {
	// etage++;
	// System.out.println("étage = " + etage);
	// }
	// }
	//
	// }
	//
	// public void DescenteAscenseur() {
	// int etageInitial = personne.getDepart();
	// int etageArrivee = personne.getArrivee();
	// while (etageArrivee > etageInitial) {
	// for (int i = etageArrivee; i > etageInitial; i--) {
	// etage--;
	// System.out.println("étage =" + etage);
	// }
	// }
	//
	// }

	private boolean isfin() {
		return fin;
	}

	public static int getTEMPS() {
		return TEMPS;
	}

	public static void setTEMPS(int tEMPS) {
		TEMPS = tEMPS;
	}

	public static int getHAUTEUR_ETAGE() {
		return HAUTEUR_ETAGE;
	}

	public static void setHAUTEUR_ETAGE(int hAUTEUR_ETAGE) {
		HAUTEUR_ETAGE = hAUTEUR_ETAGE;
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

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Ascenseur [etage=" + etage + ", progression=" + progression + ", personne=" + personne + "]";
	}

}

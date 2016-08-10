package com.formation.joca.metier;

public class Ascenseur extends Thread {

	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_ETAGE = 30;

	private int etage;
	private int progression;
	private boolean fin;
	private Personne personne;
	private ListePersonne listePersonne;

	public Ascenseur(ListePersonne lstPers) {
		this.etage = 0;
		this.progression = 0;
		this.fin = false;
		this.personne = null;
		this.listePersonne = lstPers;
		this.CPT++;
	}

	public ListePersonne getListePersonne() {
		return listePersonne;
	}

	public void setListePersonne(ListePersonne listePersonne) {
		this.listePersonne = listePersonne;
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

	public Personne trouverPersonne() {
		Personne personneTrouve = null;
		boolean trouve = false;
		int nb = 0;
		while (!trouve) {
			if (this.getListePersonne().get(nb).getEtat() == ETAT.ETAT_ATTENTE.ordinal()) {
				personneTrouve = this.getListePersonne().get(nb);
				personneTrouve.setEtat(ETAT.ETAT_DEPART.ordinal());
				trouve = true;
			}
			nb++;
		}
		return personneTrouve;
	}

	public void deplacer(int destination) {
		if (destination > this.getEtage()) {
			while (this.getEtage() != destination) {
				System.out.println("je monte !");
				this.etage++;
			}

		} else if (destination < this.getEtage()) {
			while (this.getEtage() != destination) {
				System.out.println("je descend !");
				this.etage--;
			}
		}
	}

	public void chargerPersonne(Personne perso) {
		int indexPerso = this.getListePersonne().indexOf(perso);
		this.getListePersonne().get(indexPerso).setEtat(ETAT.ETAT_MOVE.ordinal());
		this.setPersonne(this.getListePersonne().get(indexPerso));

	}

	public void dechargerPersonne(Personne perso) {
		int indexPerso = this.getListePersonne().indexOf(perso);
		this.getListePersonne().get(indexPerso).setEtat(ETAT.ETAT_ARRIVE.ordinal());
		this.setPersonne(this.getListePersonne().remove(indexPerso));
	}

	@Override
	public void run() {
		synchronized (listePersonne) {

			while (this.getListePersonne().size() != 0) {
				Personne personne = this.trouverPersonne();
				System.out.println("je suis l'ascenseur " + this.getName());
				System.out.println("j'ai trouvé une personne " + personne.toString());
				this.deplacer(personne.getDepart());
				System.out.println("je me suis deplacé vers depart, je suis à l'étage " + this.getEtage());
				this.chargerPersonne(personne);
				System.out.println("j'ai chargé la personne, etat= " + personne.getEtat());
				this.deplacer(personne.getArrive());
				System.out.println("je me suis deplacé vers arrivé, je suis à l'étage " + this.getEtage());
				this.dechargerPersonne(personne);
				System.out.println("je decharge la personne");
				System.out.println("");
				System.out.println(this.getListePersonne().toString());

			}
		}

	}

	@Override
	public String toString() {
		return "Ascenseur [etage=" + etage + ", progression=" + progression + ", fin=" + fin + ", personne=" + personne
				+ ", CPT=" + CPT + ", name=" + this.getName() + "]";
	}

}

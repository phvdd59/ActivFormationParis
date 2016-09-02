package com.formation.issa.BDD.main;

import com.formation.issa.BDD.dao.AccesBDDDocuments;
import com.formation.issa.BDD.metier.ListeDoc;

public class MainDocument {

	public static void main(String[] args) {
		MainDocument maindoc = new MainDocument();
		maindoc.init();

	}

	private void init() {
		AccesBDDDocuments acces = new AccesBDDDocuments();
		com.formation.bait.metier.DocPerso doc1 = new com.formation.bait.metier.DocPerso();
		doc1.setIDDocument(256);
		doc1.setIDPersonne(5);
		doc1.setNomDocFile("listeDesCandidats");
		doc1.setNomDocUtil("FicheDeSalaire");
		doc1.setTime("5h25min25s");
		doc1.setType("pdf");
		doc1.setCommentaire("fichier à sauvegarder");
		acces.saveDoc(doc1);
		com.formation.bait.metier.DocPerso doc2 = new com.formation.bait.metier.DocPerso();
		doc2.setIDDocument(315);
		doc2.setIDPersonne(6);
		doc2.setNomDocFile("Mutuelle");
		doc2.setNomDocUtil("Java.util");
		doc2.setTime("6h30min25s");
		doc2.setType("word");
		acces.saveDoc(doc2);
		com.formation.bait.metier.ListeDoc lstdoc=new com.formation.bait.metier.ListeDoc();
		lstdoc.add(doc1);
		lstdoc.add(doc2);
		acces.saveAllDocs(lstdoc);

	}

}

package controleur;

import java.sql.Timestamp;
import java.util.Date;

import com.formation.thcr.metier.ListeDoc;
import com.formation.thcr.metier.SEXE;

public interface InterCtrlPersonne {

	
	public boolean ctrlIdPersonne (int idPersonne);
	public boolean ctrlNom (String nom);
	public boolean ctrlPrenom(String prenom);
	public boolean ctrlSexe(SEXE sexe);
	public boolean ctrlIdentifiant(String identifiant);
	public boolean ctrlMdp(String mdp);
	public boolean ctrlEmail(String email);
	public boolean ctrlAdresse(String adresse);
	public boolean ctrlCp(String cp);
	public boolean ctrlVille(String ville);
	public boolean ctrlTelFixe(String telFixe);
	public boolean ctrlTelPort(String telPort);
	public boolean ctrlFax(String fax);
	public boolean ctrlDateNaissance(Date dateNaissance);
	public boolean ctrlLieuNaissance(String lieuNaissance);
	public boolean ctrlNumSecu(String numSecu);
	public boolean ctrlNationalite(String nationalite);
	public boolean ctrlSituation(String situation);
	public boolean ctrlFonction(String fonction);
	public boolean ctrlPosition(String position);
	public boolean ctrlCadre(boolean cadre);
	public boolean ctrlCoeff(String coeff);
	public boolean ctrlSalaire(String salaire);
	public boolean ctrlVisiteMedicale(Date visiteMedicale);
	public boolean ctrlMontantTransport(String montantTransport);
	public boolean ctrlVoiture(boolean voiture);
	public boolean ctrlNbCV(int nbCV);
	public boolean ctrlNbKm(String nbKm);
	public boolean ctrlMutuelle(boolean mutuelle);
	public boolean ctrlTicketResto(boolean ticketResto);
	public boolean ctrlAdmin(boolean admin);
	public boolean ctrlDateCreation(Date dateCreation);
	public boolean ctrlDateModification(Timestamp dateModification);
	public boolean ctrlBloque(boolean bloque);
	public boolean ctrlRaisonBlocage(String raisonBlocage);
	public boolean ctrlListeDoc(ListeDoc listeDoc);
	
}

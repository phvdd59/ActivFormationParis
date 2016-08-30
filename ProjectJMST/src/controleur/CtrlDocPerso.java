package controleur;

import com.formation.thcr.metier.DocPerso;

public class CtrlDocPerso implements InterCtrlDocPerso {
	
	private DocPerso doc;

	public CtrlDocPerso(DocPerso doc) {
		this.doc = doc;
	}

	public DocPerso getDoc() {
		return doc;
	}

	public void setDoc(DocPerso doc) {
		this.doc = doc;
	}

	@Override
	public boolean ctrlIdDoc(int idDoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlNomDocUtil(String nomDocUtil) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlNomDocFile(String nomDocFile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlTime(long time) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlCommentaire(String commentaire) {
		// TODO Auto-generated method stub
		return false;
	}
	

}

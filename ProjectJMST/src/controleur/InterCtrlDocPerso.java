package controleur;

public interface InterCtrlDocPerso {
	
	public boolean ctrlIdDoc(int idDoc);
	public boolean ctrlNomDocUtil(String nomDocUtil);
	public boolean ctrlType(String type);
	public boolean ctrlNomDocFile(String nomDocFile);
	public boolean ctrlTime(long time);
	public boolean ctrlCommentaire(String commentaire);

}

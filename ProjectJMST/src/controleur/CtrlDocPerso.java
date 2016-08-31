package controleur;

public class CtrlDocPerso implements InterCtrlDocPerso {

	@Override
	public boolean ctrlNomDocUtil(String nomDocUtil) {
		if (nomDocUtil == null) {
			return false;
		} else if (nomDocUtil.contains("?") || nomDocUtil.contains("*") || nomDocUtil.contains("<")
				|| nomDocUtil.contains(">") || nomDocUtil.contains(":") || nomDocUtil.contains("/")
				|| nomDocUtil.contains("\\") || nomDocUtil.contains("\"") || nomDocUtil.contains("|")) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean ctrlType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlCommentaire(String commentaire) {
		// TODO Auto-generated method stub
		return false;
	}

}

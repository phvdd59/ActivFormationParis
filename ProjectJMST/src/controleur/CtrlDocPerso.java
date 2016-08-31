package controleur;

import java.util.regex.Pattern;

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
		if (type == null) {
			return false;
		} else if (type.length()==0){
			return true;
		} else if (Pattern.matches("[a-zA-Z]+", type)) {
			return true;
		} else {
			return false;
		}
	}
	

	@Override
	public boolean ctrlCommentaire(String commentaire) {
		if (commentaire == null) {
			return false;
		} else {
			return true;
		}
	}

}

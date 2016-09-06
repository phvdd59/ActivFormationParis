<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.formation.joca.controleur.CtrlPersonne"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.formation.thcr.dao.DAOPersonne"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="com.formation.thcr.metier.*"%>
<%@ page import="com.formation.joca.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
	<%
		session.getAttribute("Personne");
		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");
		Object p = session.getAttribute("Personne");
		Personne personne = null;
		DAOPersonne dao = new DAOPersonne();
		CtrlPersonne ctrl = new CtrlPersonne();

		String ancienMdp = request.getParameter("ancienMdp");
		String mdp1 = request.getParameter("newMdp1");
		String mdp2 = request.getParameter("newMdp2");
		//ATTENTION IDENTIFIANT PEUT CHANGER, PLUS SUR DE RECUPERER DE 
		//LA BDD

		if (p instanceof Personne) {
			personne = (Personne) p;
		}

		//identifiant = personne.getIdentifiant();

		if (noSerie.equals(noSerieHtml) && dao.read(personne) && personne.getMdp().equals(ancienMdp) && mdp1.equals(mdp2)) {
			personne.setIdentifiant(personne.getIdentifiant());
			personne.setMdp(mdp1);
			Date dateModif = new Date();
			personne.setDateModification(new Timestamp(dateModif.getTime()));
			if (dao.update(personne)) {
	
			out.write("mise à jour réussie, cliquer sur retour login");
		%>
	</p>
	<br/><form action="http://localhost:8080/ProjectJMST/ServletJOCA1"
		method="post">
		<input type="submit" value="retour login">
	</form>
	<%
		} else {
				out.write("échec mise à jour, cliquer sur retour login");
	%>
	</p>
	<br/><form action="http://localhost:8080/ProjectJMST/Servletmadecversmenu"
		method="post">
		<input type="submit" value="retour menu">
	</form>
	<%
		}

		} else {
			out.write("erreur mot de passe ou  session expiré");
	%>
	<form action="http://localhost:8080/ProjectJMST/ServletJOCA1"
		method="post">
		<input type="submit" value="retour menu">
	</form>
	<%
		}
	%>




</body>
</html>
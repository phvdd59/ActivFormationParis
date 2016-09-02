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
	<%
		session.getAttribute("Personne");
		String noSerieHtml = request.getParameter("noSerie");
		String noSerie = (String) session.getAttribute("noSerie");
		Object p = session.getAttribute("Personne");
		Personne personne = null;
		DAOPersonne dao = new DAOPersonne();
		CtrlPersonne ctrl = new CtrlPersonne();

		String ancienMdp = request.getParameter("ancien mdp");
		String mdp1 = request.getParameter("new mdp 1");
		String mdp2 = request.getParameter("new mdp 2");
		String identifiant = request.getParameter("identifiant");
		//ATTENTION IDENTIFIANT PEUT CHANGER, PLUS SUR DE RECUPERER DE 
		//LA BDD

		if (p instanceof Personne) {
			personne = (Personne) p;
		}

		//identifiant = personne.getIdentifiant();
		
		if (noSerie.equals(noSerieHtml)) {
			personne.setIdentifiant(identifiant);
			if (dao.read(personne)) {
				if (personne.getMdp().equals(ancienMdp) && mdp1.equals(mdp2)) {
					personne.setMdp(mdp1);
					dao.update(personne);
				}
			}
		}
		
	%>
	<jsp:forward page="deco.jsp"/>
</body>
</html>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.formation.thcr.metier.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="main">
		<div id="liste">
			<table>
				<tr>
					<th>Login</th>
					<th>Prenom</th>
					<th>Nom</th>
					<th>Mail</th>
					<th>Link</th>
				</tr>
				<%
					ListPersonne listPersonne = null;
					Object o = session.getAttribute("listPersonne");

					if (o instanceof ListPersonne) {
						listPersonne = (ListPersonne) o;
					}
					for (Personne personne : listPersonne) {
				%>

				<tr>
					<form action="http://localhost:8080/ProjectJMST/ServletThcr1"
						method="post">
						<td><input type="hidden" name="login"
							value="<%=personne.getIdentifiant()%>"><%=personne.getIdentifiant()%></td>
						<td><%=personne.getPrenom()%></td>
						<td><%=personne.getNom()%></td>
						<td><%=personne.getEmail()%></td>
						<td><input type="submit" name="afficher" value="afficher"></td>
					</form>
				</tr>

				<%
					}
				%>
			</table>
			<div id="retour">
				<form action=http://localhost:8080/ProjectJMST/RetourMenu
					method="post">
					<input type="submit" value="retour"> <input type="hidden"
						name="noSerie" value="%%noSerie%%">
				</form>
			</div>
			<div id="deco">
				<form action=http://localhost:8080/ProjectJMST/ServletDeco
					method="post">
					<input type="submit" value="deconnexion"> <input
						type="hidden" name="noSerie" value="%%noSerie%%">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
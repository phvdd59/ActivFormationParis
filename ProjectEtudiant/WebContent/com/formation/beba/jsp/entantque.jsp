


<h2>Candidat</h2>


<div ID=formu28>

	<label>Connect� en tant que :</label>

<%= session.getAttribute("identifiant") %>

</div>

<div>

	<div ID="formu41">Modifier vos informations:</div>
	<div ID="formu42">
		<form method="post" action="http://localhost:8080/ProjectBAIT/EtatCivil2">
			<input type="submit" name="etatCivil" value="Etat civil">
		</form>

		<form method="post" action="http://localhost:8080/ProjectBAIT/ServletCoordonnees2">
			<input type="submit" name="coordonnees" value="coordonnees">
		</form>

		<form method="post" action="http://localhost:8080/ProjectBAIT/ServletSituation2">
			<input type="submit" name="situation" value="Situation actuelle">
		</form>

		<form method="post" action="http://localhost:8080/ProjectBAIT/ServletRemuneration2">
			<input type="submit" name="remuneration" value="Remuneration souhaite">
		</form>


	</div>
	<div>
		<input type="submit" name="modify" value="Acceder">
	</div>

</div>

<div ID=formu30>
	<input type="submit" name="document" value="Document">
</div>
<div>
	<input type="submit" name="modify" value="Modifier votre mot de passe">
</div>

<div ID=formu29>
	<input type="submit" name="disconnect" value="Deconnexion">
</div>






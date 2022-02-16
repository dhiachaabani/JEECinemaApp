<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>

<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 70%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 10px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

.button {
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

table.center {
	margin-left: auto;
	margin-right: auto;
}

.button1 {
	background-color: #4CAF50;
} /* Green */
.button2 {
	background-color: #008CBA;
} /* Blue */
.button3 {
	background-color: #008CBA;
} /* Blue */
</style>
</head>


<body style="background-color: #FBF6B6;">

	<button class="button button3 " name="button" value="OK" type="button"
		onclick="document.location.href='film';">Go To Films et
		Salles</button>
	<button class="button button3 " name="button" value="OK" type="button"
		onclick="document.location.href='Reservation';">Go To
		Reservation</button>
	<button class="button button3 " name="button" value="OK" type="button"
		onclick="document.location.href='Compte';">Go To Comptes</button>

	<h1 style="font-size: 160%; color: #17118A;">Liste des Programmes</h1>
	<table border="1" cellpadding="0" cellspacing="0"
		style="border-collapse: collapse" bordercolor="#ABF952" width="62%"
		id="AutoNumber1">
		<tr bgcolor="#E3B4F8">
			<td>Id Programme du salle</td>
			<td>Id film</td>
			<td>Id Salle</td>


		</tr>
		<c:forEach var="c" items="${ListeSalleProg}">
			<tr>
				<td><c:out value="${c.id}" /></td>
				<td><c:out value="${c.film.getNom()}" /></td>
				<td><c:out value="${c.salle.getAdress()}" /></td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<button name="button" value="OK" type="button"
		onclick="document.location.href='film';">Go To Films</button>
	</a>
	</form>
	<h1 style="font-size: 160%; color: #17118A;">Ajout des programmes
		des salles</h1>
	<form method="POST" action="Salleprog">

		Id film: &nbsp;&nbsp; <input type="number" name="idfilm" size="20"
			required="required" /> <br> <br> Id salle :&nbsp; <input
			type="number" name="idsalle" size="20" required="required" /> <br>
		<br>
		<input type="submit" value="ajouter" name="action"
			class="button button1" /> <input type="reset" value="Reset"
			name="reset" class="button button2" />
	</form>

	<br>
	<br>
	<h1 style="font-size: 160%; color: #17118A;">Liste des Seances</h1>
	<table border="1" cellpadding="0" cellspacing="0"
		style="border-collapse: collapse" bordercolor="#ABF952" width="62%"
		id="AutoNumber1">
		<tr bgcolor="#E3B4F8">
			<td>Id seance</td>
			<td>Nom film</td>
			<td>Adresse Salle</td>
			<td>Horaire</td>
			<td>Nombre Places reserves</td>
			<td>Tarif</td>




		</tr>
		<c:forEach var="c" items="${ListeSeance}">
			<tr>
				<td><c:out value="${c.id}" /></td>

				<td><c:out value="${c.salleProg.getFilm().getNom()}" /></td>
				<td><c:out value="${c.salleProg.getSalle().getAdress()}" /></td>
				<td><c:out value="${c.horaire}" /></td>


				<td><c:out value="${c.places}" /></td>

				<td><c:out value="${c.tarif}" /></td>

			</tr>
		</c:forEach>
	</table>

	<br>
	<br>

	</a>
	</form>
	<h1 style="font-size: 160%; color: #17118A;">Ajout des Seances</h1>
	<form method="POST" action="Seance">

		<br> Id salleProg : <input type="number" name="idsalle" size="20"
			required="required" /> <br> <br> Horaire Film: <input
			id="date" type="date" name="horaire" value="2017-06-01"
			required="required"><br>
		<br> Tarif film: &nbsp; <input type="number" name="tarif"
			size="20" required="required" /><br>
		<br> <input type="submit" value="ajouter" name="action"
			class="button button1" /> <input type="reset" value="Reset"
			name="reset" class="button button2" />
	</form>
</body>
</html>


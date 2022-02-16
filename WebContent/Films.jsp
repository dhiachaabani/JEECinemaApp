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
		onclick="document.location.href='Salleprog';">Go To
		Programmes et seances</button>
	<button class="button button3 " name="button" value="OK" type="button"
		onclick="document.location.href='Reservation';">Go To
		Reservation</button>
	<button class="button button3 " name="button" value="OK" type="button"
		onclick="document.location.href='Compte';">Go To Comptes</button>



	<h1 h1
		style="font-size: 160%; color: #17118A; font-family: 'Courier New'">Liste
		des Films</h1>
	<table style="width: 30%" border="1" cellpadding="0" cellspacing="0"
		style="border-collapse: collapse" bordercolor="#111111" width="62%"
		id="AutoNumber1">
		<tr bgcolor="#E3B4F8">
			<td>Id Film</td>
			<td>Nom Film</td>

		</tr>
		<c:forEach var="c" items="${listeFilms}">
			<tr>
				<td><c:out value="${c.id}" /></td>
				<td><c:out value="${c.nom}" /></td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<h1 h1
		style="font-size: 160%; color: #17118A; font-family: 'Courier New'">Ajout
		de Films</h1>
	<form method="POST" action="film">
		Nom Film: <input type="text" name="nom" size="20" required="required" />
		<br> <br> <br> <input type="submit" value="ajouter"
			name="action" class="button button1" /> <input type="reset"
			value="Reset" name="reset" class="button button2" />
	</form>

	<h1 h1
		style="font-size: 160%; color: #17118A; font-family: 'Courier New'">Liste
		des Sslles</h1>
	<table border="1" cellpadding="0" cellspacing="0"
		style="border-collapse: collapse" bordercolor="#111111" width="62%"
		id="AutoNumber1">
		<tr bgcolor="#E3B4F8">
			<td>Id Salle</td>
			<td>Nom FilSallem</td>
			<td>Capacite</td>
			<td>Adressse</td>

		</tr>
		<c:forEach var="c" items="${listeSalle}">
			<tr>
				<td><c:out value="${c.id}" /></td>
				<td><c:out value="${c.nom}" /></td>
				<td><c:out value="${c.capacite}" /></td>
				<td><c:out value="${c.adress}" /></td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<h1 h1
		style="font-size: 160%; color: #17118A; font-family: 'Courier New'">Ajouter
		des Salles</h1>
	<form method="POST" action="salle">

		Nom salle: <input type="text" name="nom" size="20" required="required" />
		<br> <br> Capacite : &nbsp;&nbsp; <input type="number"
			name="capacite" size="20" required="required" /> <br> <br>
		adresse: <input type="text" name="adress" size="20"
			required="required" /> <br> <br> <input type="submit"
			value="ajouter" name="action" class="button button1" /> <input
			type="reset" value="Reset" name="reset" class="button button2" />
	</form>
</body>
</html>


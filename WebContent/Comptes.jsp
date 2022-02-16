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
		onclick="document.location.href='Salleprog';">Go To
		Programmes et Seances</button>
	<h1 style="font-size: 160%; color: #17118A; font-family: 'Courier New'">Liste
		des comptes</h1>

	<table border="1" cellpadding="0" cellspacing="0"
		style="border-collapse: collapse" bordercolor="#111111" width="62%"
		id="AutoNumber1">
		<tr bgcolor="#E3B4F8">
			<td>Id Compte</td>
			<td>Nom</td>
			<td>Password</td>
			<td>solde</td>



		</tr>
		<c:forEach var="c" items="${ListeCompte}">
			<tr>
				<td><c:out value="${c.id}" /></td>
				<td><c:out value="${c.name}" /></td>
				<td><c:out value="${c.password}" /></td>

				<td><c:out value="${c.solde}" /></td>
			</tr>
		</c:forEach>
	</table>

	<br>


	</a>
	</form>
	<h1 style="font-size: 160%; color: #17118A; font-family: 'Courier New'">Ajout
		des comptes</h1>
	<form method="POST" action="Compte">
		<br> Username: &nbsp;&nbsp; <input type=text name="nom" size="20"
			required="required" /> <br>
		<br>Password : &nbsp;&nbsp; <input type="password"
			name="password" size="20" required="required" /><br> <br>Solde
		initial : &nbsp;&nbsp; <input type="number" name="solde" size="20"
			required="required" /> <br> <br> <input type="submit"
			value="ajouter" name="action" class="button button1" /> <input
			type="reset" value="Reset" name="reset" class="button button2" />
</body>
</html>


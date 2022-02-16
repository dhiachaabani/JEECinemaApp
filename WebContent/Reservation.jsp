<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>
<style>
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
		onclick="document.location.href='Compte';">Go To Comptes</button>

	<button class="button button3 " name="button" value="OK" type="button"
		onclick="document.location.href='Salleprog';">Go To
		Programmes et Seances</button>



	<h1 style="font-size: 160%; color: #17118A;">Ajouter une nouvelle
		résérvation</h1>
	<form method="POST" action="Reservation">
		<br> UserName: &nbsp;&nbsp; <input class="" type=text name="nom"
			size="20" required="required" /> <br> <br>Password :
		&nbsp;&nbsp; <input type="password" name="password" size="20"
			required="required" /> <br> <br>Id Seance : &nbsp; <input
			type="number" name="idseance" size="20" required="required" /> <br>
		<br> <input type="submit" value="ajouter" name="action"
			class="button button1" /> <input type="reset" value="Reset"
			name="reset" class="button button2" />
	</form>


</body>
</html>


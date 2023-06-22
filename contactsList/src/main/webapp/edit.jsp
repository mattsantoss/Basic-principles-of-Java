<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts List</title>
<link rel="icon" href="images/phone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Edit Contact</h1>
	<form name="frmContact" action="update">
		<table>
			<tr>
				<td><input id="caixa3" type="text" name="idcon" readonly value="<%out.print(request.getAttribute("idcon")); %>"></td>
			</tr>
			<tr>
				<td><input class="Box1" type="text" name="name" value="<%out.print(request.getAttribute("name")); %>"></td>
			</tr>
			<tr>
				<td><input class="Box2" type="text" name="phone" value="<%out.print(request.getAttribute("phone")); %>"></td>
			</tr>
			<tr>
				<td><input class="Box1" type="text" name="email" value="<%out.print(request.getAttribute("email")); %>"></td>
			</tr>
		</table>
		<input class="Botao1" type="button" value="Salvar"
			onclick="validator()">
	</form>
	<script src="scripts/validator.js"></script>
</body>
</html>
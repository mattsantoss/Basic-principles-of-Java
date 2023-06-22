<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contacts");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts List</title>
<link rel="icon" href="images/phone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Contacts List</h1>
	<a href="new.html" class="Botao1">Novo Contato</a>
	<table id="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>phone</th>
				<th>E-mail</th>
				<th>Opcoes</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>"
					class="Botao1">Edit</a> <a
					href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)" class="Botao1">Excluir</a>

				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>
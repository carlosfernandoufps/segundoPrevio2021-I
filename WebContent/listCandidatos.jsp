<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Votaciones UFPS 2021</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Brand/logo -->
			<a class="navbar-brand" href="#">Votaciones UFPS 2021</a>

			<!-- Links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/list">Candidatos</a></li>

			</ul>
		</nav>

	</header>
	<br>
	<div class="container">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Listado de Candidatos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar
					Nuevo Canndidato</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Documento</th>
						<th>Eleccion</th>
						<th>Numero</th>
						<th>Acciones</th>

					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="candidato" items="${listCandidatos}">

						<tr>
							<td><c:out value="${candidato.id}" /></td>
							<td><c:out value="${candidato.nombre}" /></td>
							<td><c:out value="${candidato.apellido}" /></td>
							<td><c:out value="${candidato.documento}" /></td>
							<td><c:out value="${candidato.eleccion}" /></td>
							<td><c:out value="${candidato.numero}" /></td>

							<td><a href="edit?id=<c:out value='${candidato.id}' />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${candidato.id}' />">Eliminar</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
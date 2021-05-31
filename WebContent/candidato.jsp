<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<li class="nav-item"><a class="nav-link" href="">Candidato</a>
				</li>

			</ul>
		</nav>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-md-9 col-lg-8 mx-auto">
				<h3 class="login-heading mb-4">Registro de Candidato</h3>
				<form action="#" method="post">
					<div class="form-label-group">
						<input type="text" id="inputNombre" name="nombre"
							class="form-control" placeholder="Nombre" required autofocus>
						<label for="inputNombre">Nombre</label>
					</div>
					<div class="form-label-group">
						<input type="text" id="inputApellido" name="apellido"
							class="form-control" placeholder="Apellido" required autofocus>
						<label for="inputNombre">Apellido</label>
					</div>
					<div class="form-label-group">
						<input type="text" id="inputDocumento" name="documento"
							class="form-control" placeholder="Documento" required autofocus>
						<label for="inputDocumento">Documento</label>
					</div>
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">Elecciones</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#">Rectoria UFPS 2021-2025</a>
						</div>
					</div>

					<div class="form-label-group">
						<input type="text" id="inputNumero" name="numero"
							class="form-control" placeholder="Numero Candidato" required>
						<label for="inputNumero">Numero</label>
					</div>


					<input name="accion" value="Registrar"
						class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
						type="submit" />

				</form>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

</body>
</html>
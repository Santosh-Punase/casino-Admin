<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register new Customer</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
		class="navbar-brand"><img alt="casino"
		src="resources/images/logo.jpeg" style="width: inherit; height: 50px"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/home">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="/user/register">Register</a></li>
			<li class="nav-item"><a class="nav-link" href="/users">User
					List</a></li>
		</ul>
		<span class="navbar-text"> Welcome to Casino Admin App! </span>
	</div>
	</nav>
	
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration successfull!</div>
	</c:if>


	<div align="center" class="container">
		<br>
		<h1>Register Customer</h1>
		<hr style="width: 70%">
		<form:form action="/user/save" method="post" modelAttribute="customer">
			<div align="left" style="width: 50%">
				<form:hidden path="id" />
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Name</label>
					<div class="col-sm-10">
						<form:input type="text" class="form-control" path="name" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Date of Birth</label>
					<div class="col-sm-10">
						<form:input type="date" class="form-control" path="dob" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Contact</label>
					<div class="col-sm-10">
						<form:input type="number" class="form-control" path="contact" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Email ID</label>
					<div class="col-sm-10">
						<form:input type="text" class="form-control" path="email" />
					</div>
				</div>

					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Identity Proof</label>
						<div class="col-sm-10">
							<input type="file" class="form-control-file">
						</div>
					</div>
					
				<div align="center">
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</div>
		</form:form>

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
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



	<div align="center" class="container">
		<br>
		<form>
			<div class="m-4 p-4">
				<div class="form-group row">
					<label class="col-md-2 col-form-label">Name</label>
					<div class="col-md-4">
						<input type="text" class="form-control" path="name"
							placeholder="Search By Name" />
					</div>
					<label class="col-md-2 col-form-label">Contact</label>
					<div class="col-md-4">
						<input type="text" class="form-control" path="contact"
							placeholder="Search By Contact" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-md-2 col-form-label">Email</label>
					<div class="col-md-4">
						<input type="text" class="form-control" path="email"
							placeholder="Search By Email" />
					</div>
					<label class="col-md-2 col-form-label"></label>
					<button type="submit" class="btn btn-primary mx-auto">Search</button>
				</div>

			</div>
		</form>



		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Name</th>
					<th scope="col">DOB</th>
					<th scope="col">Contact</th>
					<th scope="col">Email</th>
					<th scope="col">Balance(in Rs.)</th>
					<th scope="col">Recharge</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${list}">
					<tr>
						<th scope="row">${customer.id}</th>
						<td>${customer.name}</td>
						<td>${customer.dob}</td>
						<td>${customer.contact}</td>
						<td>${customer.email}</td>
						<td>${customer.total_bal}</td>
						<td><button
									class="btn btn-outline-info p-2 open-modal" data-toggle="modal"
									data-id="${customer.id}" data-target="#rechargeModal">+</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="rechargeModal" tabindex="-1" role="dialog"
		aria-labelledby="rechargeModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="rechargeModalLabel">Add Money</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" action="/recharge">

						Ammount: <input type="text" name="ammount" id="id-amt" val="" />
						<input type="hidden" name="id" id="id" val="" />
						<div class="modal-footer">
							<input type="submit" class="btn btn-primary" value="Recharge" />
						</div>
					</form>
				</div>

			</div>
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
		<script type="text/javascript">
			$(document).on("click", ".open-modal", function() {
				var customerId = $(this).attr('data-id');
				$(".modal-body #id").val(customerId);

			});
		</script>
</body>
</html>
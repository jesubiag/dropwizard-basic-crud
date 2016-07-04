<#-- @ftlvariable name="" type="com.test.dropwizard.views.CarView" -->
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Autos</title>
	
	<#include "../parts/header.ftl">
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<a href="/cars/new" class="btn btn-primary pull-right" role="button">Crear Auto</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h1>Lista de Autos</h1>
				<table class="table table-striped table-condensed">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Kilómetros</th>
							<th>Color</th>
							<th>Pintura</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<#list cars as c>
							<tr>
								<td>${c.id?html}</td>
								<td>${c.name?html}</td>
								<td>${c.kilometers?html}</td>
								<td>
									<span>
										<div class="color-box" style="background-color: ${c.appearance.color};">
											<b>${c.appearance.color?html}</b>
										</div>
									</span>
								</td>
								<td>${c.appearance.painting?html}</td>
								<td>
									<button type="button" class="btn btn-danger" value="${c.id}">Eliminar</button>
								</td>
							</tr>
						</#list>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>

<script>
	$(document).ready(function() {
		var deleteButton = $('.btn-danger');
		deleteButton.click(function() {
			$.ajax({
				url: '/cars/' + deleteButton.val(),
				type: 'DELETE',
				success: function(data, textStatus, jqXHR) {
					console.log("Delete successfull");
					location.reload();
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log("Delete error");
				}
			})
		});
	});
</script>

</html>
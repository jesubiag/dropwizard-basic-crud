<#-- @ftlvariable name="" type="com.test.dropwizard.views.CarView" -->
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>This is a Cars list</title>
	
	<#include "../parts/header.ftl">
</head>

<body>

	<div class="container">
		<div class="row centered">
			<div class="col-md-12">
				<h1>Cars List</h1>
				<table class="table table-striped table-condensed">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
						</tr>
					</thead>
					<tbody>
						<#list cars as c>
							<tr>
								<td>${c.id?html}</td>
								<td>${c.name?html}</td>
							</tr>
						</#list>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>

</html>
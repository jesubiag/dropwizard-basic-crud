<#-- @ftlvariable name="" type="com.test.dropwizard.views.CarView" -->
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Car Creation</title>
	
	<#include "../parts/header.ftl">
</head>

<body>
	
	<div class="container">
		<div class="row centered">
			<div class="col-md-12">
				<h1>Create Car</h1>
				<form role="form" action="/cars" method="post">
					<label for="name">Name</label>
					<input type="text" name="name" id="carName" class="form-control">
					
					<label for="kilometers">Kilometers</label>
					<input type="number" name="kilometers" id="carKilometers" class="form-control">
					
					<label for="appearance.color">Color</label>
					<input type="color" name="appearance.color" id="carColor" class="form-control">
					
					<label for="appearance.painting">Painting</label>
					<input type="text" name="appearance.painting" id="carPainting" class="form-control">
					
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>

</body>

</html>
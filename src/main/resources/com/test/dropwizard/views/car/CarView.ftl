<#-- @ftlvariable name="" type="com.test.dropwizard.views.CarView" -->
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>This is a Car view</title>
	
	<#include "../parts/header.ftl">
</head>

<body>
	<div>
		<p>Esto es un div</p>
		Nombre del auto: ${car.name?html}
		Color de la pintura: ${car.appearance.color?html}
	</div>
</body>

</html>
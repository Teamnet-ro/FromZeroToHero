<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="includes/admin-head.jsp" />
<body>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/admin/"/>">Zero To Hero</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="/admin/list/"/>">Vizualizare</a></li>
					<li><a href="<c:url value="/j_spring_security_logout"/>">Iesire</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">
		<div class="starter-template">
			<h1>Bine ai venit, Admin!</h1>
			<p class="lead">
				Foloseste link-urile de sus pentru a naviga in aplicatie<br>

			</p>
		</div>
	</div>
	<!-- /.container -->

	<jsp:include page="includes/admin-scripts.jsp" />

</body>
</html>

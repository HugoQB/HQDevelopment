<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Principal</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">

</head>
<body>

<div class="card">
	<div class="card-header"><h1 class="card-title">Tabla de peliculas</h1></div>
	<div class="card-body">
		<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Duración</th>
				<th>Clasificación</th>
				<th>Genero</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${peliculas}" var="pelicula">
					<tr>
						<td>${ pelicula.id }</td>
						<td>${ pelicula.titulo }</td>
						<td>${ pelicula.duracion }</td>
						<td>${ pelicula.clasificacion }</td>
						<td>${ pelicula.genero }</td>
						<td><img width="100" height="150" src="${ urlPublic }/imgs/${ pelicula.imagen }"/></td>
						<td><fmt:formatDate value="${ pelicula.fechaEstreno }" pattern="dd-MM-yyyy" /></td>
						<td>
						<c:choose>
							<c:when test="${ pelicula.estatus=='Activa' }">
								<span class="btn btn-success">ACTIVA</span>
							</c:when>
							<c:otherwise>
								<span class="btn btn-danger">INACTIVA</span>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>	
	
	
	
</body>
</html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Peliculas</title>
    <spring:url value="/resources/" var="urlPublic"></spring:url>
    <spring:url value="/peliculas/edit" var="urlEdit"></spring:url>
    <spring:url value="/peliculas/delete" var="urlDel"></spring:url>
    <link href="${ urlPublic }bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ urlPublic }bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Peliculas</h3>
      
      <c:if test="${ successSave != null }">
      	<div class="alert alert-success" role="alert">${ successSave }</div>
      </c:if>
      
      <c:if test="${ delMsg != null }">
      	<div class="alert alert-success" role="alert">${ delMsg }</div>
      </c:if>
      
      <a href="create" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
       		<tr>
                <th>Titulo</th>
                <th>Genero</th>
                <th>Clasificacion</th>
                <th>Duracion</th>
                <th>Fecha Estreno</th>
                <th>Estatus</th>
                <th>Opciones</th>
            </tr>
            
        	<c:forEach items="${ peliculas }" var="p">
        		<fmt:formatDate value="${p.fechaEstreno}" pattern="MM-dd-yyyy" var="date"/>
	        	<tr>
	                <td>${ p.titulo }</td>
	                <td>${ p.genero }</td>
	                <td>${ p.clasificacion }</td>
	                <td>${ p.duracion }</td>
	                <td>${ date }</td>
	                <c:choose>
	                	<c:when test="${ p.estatus eq 'Activa'}">
	                		<td><span class="label label-success">${ p.estatus }</span></td>
	                	</c:when>
	                	<c:otherwise>
	                		<td><span class="label label-danger">${ p.estatus }</span></td>
	                	</c:otherwise>
	                </c:choose>
	                <td>
	                    <a href="${ urlEdit }/${ p.id }" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
	                    <a href="${ urlDel }/${ p.id }" onclick= 'return confirm("esta seguro que desea eliminar el registro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
	                </td>
            	</tr>
        	</c:forEach>
           
        </table>
      </div>
          
      <hr class="featurette-divider">

      <!-- FOOTER -->
     <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Creacion de Peliculas</title>
	<spring:url value="/resources/" var="urlPublic"></spring:url>
	<spring:url value="/banners/save" var="urlForm"></spring:url>
    <link href="${ urlPublic }bootstrap/css/bootstrap.min.css" rel="stylesheet">    
    <link href="${ urlPublic }bootstrap/css/theme.css" rel="stylesheet">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <div class="page-header">
	<h3 class="blog-title"><span class="label label-success">Datos de la Pelicula</span></h3>
      </div>

		<spring:hasBindErrors name="banner">
		  	<div class="alert alert-danger" role="alert">
		  		Por favor corrija los siguientes errores:
		  		<ul>
		  			<c:forEach var="error" items="${ errors.allErrors }">
		  			<li> <spring:message message="${ error }"></spring:message> </li>
		  			</c:forEach>
		  			
		  		</ul>
		  	</div>
	  	</spring:hasBindErrors>

      <form action="${ urlForm }" method="post" enctype="multipart/form-data" >
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="titulo">Título</label>
              <input type="text" class="form-control" name="titulo" id="titulo" required="required" />
            </div>  
          </div>    
        </div>

		<div class="col-sm-3">
            <div class="form-group">
              <label for="fecha">Fecha</label>             
              <input type="text" class="form-control" name="fecha" id="fecha" required="required" />
            </div>  
         </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="estatus" class="control-label">Estatus</label>              
              <select id="status" name="status" class="form-control">
                <option value="Activa">Activa</option>
                <option value="Inactiva">Inactiva</option>               
              </select>             
            </div> 
          </div>     

          <div class="col-sm-3">
            <div class="form-group">
              <label for="Imagen">Imagen</label>
              <input type="file" id="archivoImagen" name="archivoImagen" />
              <p class="help-block">Imagen de la pelicula</p>
            </div> 
          </div>
        </div>
        
        <button type="submit" class="btn btn-danger" >Guardar</button>
      </form> 

      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }bootstrap/js/bootstrap.min.js"></script> 
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
      $(function () {
          $("#fecha").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
  </body>
</html>
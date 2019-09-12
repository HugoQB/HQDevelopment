<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix = "f" uri = "http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Creacion de Peliculas</title>
	<spring:url value="/resources" var="urlPublic"></spring:url>
	<spring:url value="/peliculas/save" var="urlForm"></spring:url>
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
    <link href="${ urlPublic }/bootstrap/css/theme.css" rel="stylesheet">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  </head>

  <body>

    <!-- Fixed navbar -->
   <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <div class="page-header">
	<h3 class="blog-title"><span class="label label-success">Datos de la Pelicula</span></h3>
      </div>
	  
	  <spring:hasBindErrors name="pelicula">
	  	<div class="alert alert-danger" role="alert">
	  		Por favor corrija los siguientes errores:
	  		<ul>
	  			<c:forEach var="error" items="${ errors.allErrors }">
	  			<li> <spring:message message="${ error }"></spring:message> </li>
	  			</c:forEach>
	  			
	  		</ul>
	  	</div>
	  </spring:hasBindErrors>
	  
      <f:form action="${ urlForm }" method="post" enctype="multipart/form-data" modelAttribute="pelicula">
        <div class="row" >
        	<div class="col-sm-3">
        		<div class="form-group">
        			<img src="${ urlPublic }/images/${ pelicula.imagen }" title="Imagen actual de la pelicula" width="150" height="200" >
        		</div>
        	</div>
        </div>
        <div class="row" >
          <div class="col-sm-3">
            <div class="form-group">
              <label for="titulo">Título</label>
              <f:hidden path="id"/>
              <f:hidden path="detalle.id"/>
              <f:input type="text" class="form-control" path="titulo" id="titulo" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="duracion">Duracion</label>
              <f:input type="text" class="form-control" path="duracion" id="duracion" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="clasificacion" class="control-label">Clasificacion</label>              
              <f:select id="clasificacion" path="clasificacion" class="form-control">
                <f:option value="A">Clasificacion A</f:option>
                <f:option value="B">Clasificacion B</f:option>
                <f:option value="C">Clasificacion C</f:option>                  
              </f:select>             
            </div> 
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="genero" class="control-label">Genero</label>              
             <f:select id="genero" path="genero" class="form-control" items="${ generos }"> </f:select>  
<%--                 <f:option value="Accion">Accion</f:option> --%>
<%--                 <f:option value="Aventura">Aventura </f:option> --%>
<%--                 <f:option value="Clasicas">Clasicas</f:option>                   --%>
<%--                 <f:option value="Comedia Romantica">Comedia Romantica</f:option>                   --%>
<%--                 <f:option value="Drama">Drama</f:option>                   --%>
<%--                 <f:option value="Terror">Terror</f:option>                   --%>
<%--                 <f:option value="Infantil">Infantil</f:option>                   --%>
<%--                 <f:option value="Accion y Aventura">Accion y Aventura</f:option>                   --%>
<%--                 <f:option value="Romantica">Romantica</f:option>                   --%>
                        
            </div> 
          </div>         
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="estatus" class="control-label">Estatus</label>              
              <f:select id="genero" path="estatus" class="form-control">
                <f:option value="Activa">Activa</f:option>
                <f:option value="Inactiva">Inactiva</f:option>               
              </f:select>             
            </div> 
          </div>     
          <div class="col-sm-3">
            <div class="form-group">
              <label for="fechaEstreno">Fecha Estreno</label>             
              <f:input type="text" class="form-control" path="fechaEstreno" id="fechaEstreno" required="required" />
            </div>  
          </div>

          <div class="col-sm-3">
            <div class="form-group">
              <label for="imagen">Imagen</label>
               <f:hidden path="${ imagen }"/>
              <input type="file" id="archivoImagen" name="archivoImagen"/>
              <p class="help-block">Imagen de la pelicula</p>
            </div> 
          </div>
        </div>

        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Detalles</span></h3>
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="director">Director</label>
              <f:input type="text" class="form-control" path="detalle.directores" id="director" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="actores">Actores</label>
              <f:input type="text" class="form-control" path="detalle.actores" id="actores" required="required" />
            </div>  
          </div>

          <div class="col-sm-6">
            <div class="form-group">
              <label for="trailer">URL del Trailer (Youtube)</label>
              <f:input type="text" class="form-control" path="detalle.trailer" id="trailer" placeholder="URL completa del video de YOUTUBE"  />
            </div>  
          </div> 
        </div> 

        <div class="row">
          <div class="col-sm-6">
            <div class="form-group">
              <label for="sinopsis">Sinopsis</label>
              <f:textarea class="form-control" rows="5" path="detalle.sinopsis" id="sinopsis"></f:textarea>
            </div> 
          </div> 
        </div>
        
        <button type="submit" class="btn btn-danger" >Guardar</button>
      </f:form> 

      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
      $(function () {
          $("#fechaEstreno").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
  </body>
</html>

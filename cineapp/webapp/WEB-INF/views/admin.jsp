<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix = "s" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cinesite Administraci�n</title>    
	<spring:url value="/resources" var="urlPublic"></spring:url>
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">   
    <link href="${ urlPublic }/bootstrap/css/theme.css" rel="stylesheet">

  </head>

  <body>

   <!-- Fixed navbar -->
		<jsp:include page="includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <div class="jumbotron">        
        <h3>Administraci�n del Sistema</h3>
        <p>Bienvenido(a) <s:authentication property="principal.username"/> </p>
      </div>

      <!-- FOOTER -->
     		<jsp:include page="includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 
    <script>
      function goBack() {
         window.history.back();
      }
    </script>
  </body>
</html>

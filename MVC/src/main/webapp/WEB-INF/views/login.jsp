<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./styles.css">
    <title>Login Page</title>
    <script src="./validation.js" type="text/javascript"></script>
  </head>
  <body>
      <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
        <div class="container-fluid align-center">
          <span class="navbar-brand mb-0 h1 mx-auto">Login</span>
        </div>
      </nav>
          <font color="red">${errorMessage}</font>
          <form:form action="welcome" method = "post" modelAttribute="user" class="position-absolute top-50 start-50 translate-middle needs-validation">
             <form:label  path = "userId" >User Name</form:label>
             <form:input path = "userId" placeholder="Enter username" />

               <br><br>
             <form:label path = "password">Password</form:label>
             &nbsp;&nbsp;
             <form:password path = "password" placeholder="Enter password"/>

               <br><br>
             <center><input type = "submit" value = "Submit"/></center>

          </form:form>
    </body>
</html>


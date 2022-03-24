<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" %>
 <%@ page isELIgnored="false"%>
 <%@ page import="pageNumber.*, java.util.*, java.io.*" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html" charset=UTF-"8">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

 <title>Add New Book</title>
 </head>
 <body>


    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
            <div class="container-fluid">
              <span class="navbar-brand mb-0 h1 position-absolute top-50 start-50 translate-middle">Add New Book</span>
            </div>
    <span class="px-2">Hi ${username}</span>
     <form action="logout">
       <button type="submit" class="btn btn-danger mx-2 ">Logout</button>
     </form>
    </nav>
    <div class="col-sm-10 col-md-12 col-lg-12">
     <div class="row px-3 py-3"><b>Please enter book details</b></div>
     <form action="add" method="post" object="${book}">
           <div>
                 <div class="mb-3 row ">
                     <label for="bookName" class="col-sm-2 col-form-label px-5 py-3">Book name</label>
                     <div class="col-sm-3">
                       <input type="text" class="form-control mx-3 my-3" id="bookName" name="bookName" field="*{bookName}" required>
                       <span class="valid" id="username-validation"></span>
                     </div>
                 </div>
                 <div class="mb-3 row">
                     <label for="author" class="col-sm-2 col-form-label px-5 py-3 " for="inputGroupSelect01">Author</label></b>
                     <select style="width: 300px" class="form-select col-sm-2 ms-4" id="author" name="author">
                          <option selected>Choose...</option>
                        <c:forEach var="author" items="${author}">
                       <option value="${author.getName()}">${author.getName()}</option>
                     </c:forEach>
                     </select>
                 </div>
                 <div class="mb-3 row">
                     <label for="date" class="col-sm-2 col-form-label px-5 py-3">Added On</label>
                      <div class="col-sm-3">
                        <input type="text" readonly class="form-control mx-3 my-3" id="date" name="date" field="*{date}" value="${date}">
                      </div>
                 </div>

                 <div class="mb-3 ps-5 pb-3">
                   <button type="submit" class="btn btn-primary m-2">Save</button>
                   <button type="button" onClick="cancelForm()" class="btn btn-danger m-2">Cancel</button>
                 </div>
                 <script type="text/javascript">
                 function cancelForm(){
                    window.location = "/welcome";
                 }
                 </script>
               </form>
                </body>
                </html>
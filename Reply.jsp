<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

<div class="container">
<h1><a href='DispT?fId=${param.fId}&name=${param.fname}'>Back</a> > ${param.subject}</h1>
<table class="table table-hover">
<thead>
	<tr>
		<th >Author</th>
		<th >Content</th>
		<th >Posted On</th>
	</tr>
</thead>
<tbody>
  <tr>
    <td>${param.name}</td>
    <td>${param.content}</td>
    <td>${param.date}</td>
  </tr>
 
<c:forEach items="${replies}" var="reply">
    <tr>
      <td>${reply.getName()}</td>
      <td>${reply.getContent()}</td>
      <td>${reply.getDate()}</td>
    </tr>
  </c:forEach>
</tbody>
</table>
<input type="hidden" name="id" value="${param.id}">
 <br>
 
<form class="form-horizontal" action="Reply?id=${param.id}" method="post">
	<div class="form-group row">
		<label class="col-sm-1 col-form-label" for="name">Name:</label>
		<div class="col-sm-6">
    		<input class="form-control" type="text" name="name">
    	</div>
  	</div>
  	<div class="form-group row">
  		<label class="col-sm-1 col-form-label" for="subject">Subject:</label>
  		<div class="col-sm-6">
    		<input class="form-control" type="text" name="subject">
    	</div>
  	</div>
  	<div class="form-group row">
  		<label class="col-sm-1 col-form-label" for="content">Content:</label>
  		<div class="col-sm-6">
    		<textarea class="form-control" name="content" rows="6" cols= "6"></textarea>
    	</div>
  	</div>
  	<input type="submit" value="Submit">
  	</form>

</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
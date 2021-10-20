<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Topic1</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<div style='margin-left:40px; margin-right:40px'>
<h1><a href='DispT?fId='${param.fId}>${param.name}</a> > Create Topic</h1>

<div>
<form class="form-horizontal" action="CrT" method="post">
	<div class="form-group row">
		<label class="col-sm col-form-label" for="name">Name:</label>
		<div class="col-sm-11">
    		<input class="form-control" type="text" name="name">
    	</div>
  	</div>
  	<div class="form-group row">
  		<label class="col-sm col-form-label" for="subject">Subject:</label>
  		<div class="col-sm-11">
    		<input class="form-control" type="text" name="subject">
    	</div>
  	</div>
  	<div class="form-group row">
  		<label class="col-sm col-form-label" for="content">Content:</label>
  		<div class="col-sm-11">
    		<textarea class="form-control" name="content" rows="6" cols = "12"></textarea>
    	</div>
  	</div>
  	<input type="hidden" name="fId" value="${param.fId}">
  	
  	<input type="submit" value="Submit">
  	
	
</form>
</div>

</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
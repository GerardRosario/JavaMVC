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
<table class="table table-hover">
<thead>
	<tr>
		<th scope="col">Forum</th>
		<th scope="col">Topics</th>
	</tr>
</thead>
<tbody>
<tr>
	
		<td scope="row"><a href='DispT?fId=1&name=General Discussion'>General Discussion</a></td><td>${counter1.size()}</td>
	</tr>
	<tr>
	
		<td scope="row"><a href='DispT?fId=2&name=CS3220 Web Programming'>CS3220 Web Programming</a></td><td>${counter2.size()}</td>
	</tr>
<c:forEach items="${forums}" var="forum">
	<tr>
	
		<td scope="row"><a href='DispT?fId=${forum.id}&name=${forum.name}'>${forum.name}</a></td><td>${counter3.size()}</td>
	</tr>
</c:forEach>
</tbody>
</table>
<a href='CrF'>Create Forum</a>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
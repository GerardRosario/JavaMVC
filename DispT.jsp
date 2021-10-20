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
<h1><a href='DispForum'>${param.name}</a></h1>
<table class="table table-hover">
<thead>
	<tr>
		<th >Topic</th>
		<th >Author</th>
		<th >Replies</th>
		<th >Last Post</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${topics}" var="topic">
<c:if test="${param.fId == topic.fId}">
    <tr>
    	<td><a href='Reply?tId=${topic.id}&fId=${param.fId}&fname=${param.name} '>${topic.subject}</a></td>
    	<td>${topic.name}</td>
    	<td>${replies.size()}</td>
    	<td>${topic.date}</td>
    	
    </tr>
    <input type="hidden" name="fId" value="${topic.fId}">
    <input type="hidden" name="Id" value="${topic.id}">
    </c:if>
  </c:forEach>
</tbody>
</table><br><a href='CrT?fId=${param.fId}&name=${param.name}'>Create Topic</a></div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>설문조사 리스트</h1></div>
	<div>
		<c:forEach var="list" items="${lists }">
			${list.id }; ${list.title }<br/>
		</c:forEach>
	</div>
</div>
</body>
</html>
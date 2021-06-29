<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<form:form action="/memberRegister.do" modelAttribute="memberVO" method="post">
		<p>
			<label>이메일 : <br>
			<form:input path="email" />
			</label>
		</p>
		<p>
			<label>이름 : <br>
			<form:input path="name"/>
			</label>
		</p>
		<p>
			<label>비밀번호 : <br>
			<form:password path="password"/>
			</label>
		</p>
		<p>
			<label>비밀번호 확인 : <br>
			<input type="password" id="confirmPassword" name="confirmPassword">
			</label>
		</p>
		<c:if test="${!empty memberVO.email }">
			${memberVO.name }님 ${message }
		</c:if>
		<c:if test="${empty memberVO.email }">
			<input type="submit" value="가입하기">
		</c:if>
	</form:form>
</body>
</html>
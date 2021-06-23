<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>검색 결과</h1>
		</div>
		<div>
			<h3>${vo.id };
			${vo.title };
			${vo.writer };
			${vo.sdate };
			${vo.edate };
			${vo.gubun };
			${vo.course };
			${vo.rnumber }</h3><br/>
		</div>
	</div>
	<div>
		<button type="button" onclick="location.href='researchAppend.do?id=${vo.id}'">설문조사참여</button>
	</div>
</body>
</html>
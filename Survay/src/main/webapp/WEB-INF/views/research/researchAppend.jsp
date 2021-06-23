<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사지</title>
</head>
<body>
<div align="center">
	<div>
		<h1>설문조사</h1>
	</div>
	<div>
		<form id="frm" name="frm" action="researchAppendwrite.do" method="post">
			<div>
				<table border="1">
					<tr>
						<td colspan="2" width="700" height="200" align="center">
							<h1>${researchTitle.title }</h1>
							<h4>종료일자 : ${researchTitle.edate }</h4>
						</td>
					</tr>
					<c:forEach items="${qlists }" var="q">
						<input type="hidden" id="id" name="id" value="${q.qId }">
						<input type="hidden" id="qOrder" name="qOrder" value="${q.qOrder }">
						<tr>
							<th width="50">문항 ${q.qOrder }</th>
							<td>${q.qTitle }</td>
						</tr>
						<c:set var="qstr" value="${fn:split(q.qSubtitle, ',') }" />
						<tr>
							<td colspan="2" width="700">
								<c:choose>
									<c:when test="${q.qType eq 'S' }">
										<c:forEach var="str" items="${qstr }">
											<input type="checkbox" name="qResult[${q.qOrder }]" value="${str }">${str }
										</c:forEach>
									</c:when>
									<c:when test="${q.qType eq 'R' }">
										<c:forEach var="str" items="${qstr }">
											<input type="radio" name="qResult[${q.qOrder }]" value="${str }">${str }
										</c:forEach>
									</c:when>
									<c:when test="${q.qType eq 'C' }">
										<c:forEach var="str" items="${qstr }">
											<input type="text" name="qResult[${q.qOrder }]">
										</c:forEach>
									</c:when>
									<c:when test="${q.qType eq 'SC' }">
										<c:forEach var="str" items="${qstr }">
											<input type="checkbox" name="qResult[${q.qOrder }]" value="${str }">${str }
											<c:if test="${str eq '기타' }">
												<input type="text" name="qResult[${q.qOrder }]">
											</c:if>
										</c:forEach>
									</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br/>
			<div align="center">
				<input type="submit" value="결과제출"">&nbsp;&nbsp;
				<input type="reset" value="취소">
			</div>
		</form>
	</div>
</div>
</body>
</html>
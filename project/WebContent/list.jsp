<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	function check() {
		var bo = confirm("이전 작성한 신청서가 있을 경우 데이터가 사라집니다.\n진행하시겠습니까?");

		if (bo) {
			location.href = "apply.do";
		}
	}
</script>
<title>신청목록보기</title>
</head>
<body>
	<h1>신청 목록 보기</h1>
	
	${matchinginfo}
	
	<!-- <script>
		alert("1");
		alert("${list[0].college}");
		alert("2");
		var c="${matchinginfo}";
		<c:if test="${not empty matchinginfo}">
		alert(c);
		
		</c:if>
		alert(c);
	</script> -->
	<%-- <c:if test="${check eq 'true'}">
		<script>alert("${matchinginfo}")</script>
	</c:if> --%>
	<c:if test="${not empty matchinginfo}">
		<script>alert("${matchinginfo}");</script>
		<c:if test="${check eq  'true'}">
			<%-- <% response.sendRedirect("loginform.do"); %> --%>
		</c:if>
	</c:if>
<%-- <c:if test="${not empty matchinginfo}">
	<script>
		
		
		alert("${matchinginfo}");
		/* 
		document.write("<table border='1'>");
		<c:forEach items="${list}" var="dto">
		alert("${dto.userid}");
		document.write("<tr>");
 */
		/* document.write("	<td>${list[0].userid}</td>"); */
		/* document.write("<td>${dto.gender}</td>");
		document.write("<td>${dto.college}</td>");
		document.write("<td>${dto.hometown}</td>");
		document.write("<td>${dto.age}</td>");
		document.write("<td>${dto.height}</td>");
		document.write("<td>${dto.interesting}</td>");
		document.write("<td>${dto.character}</td>"); 
		document.write("<td>${dto.time}</td>"); */
		/* document.write("</tr>"); */
/* 
		</c:forEach>
		document.write("</table>"); */
		
	</script>
	</c:if> --%>
	
	<table border="1">
		<tr>
			<td>ID</td>
			<td>성별</td>
			<td>선호 단과대</td>
			<td>선호 고향</td>
			<td>선호 나이</td>
			<td>최소 키</td>
			<td>최대 키</td>
			<td>선호 취미</td>
			<td>선호 성격</td>
			<td>신청 날짜</td>
		</tr>

		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.userid}</td>
				<td>${dto.gender}</td>
				<td>${dto.college}</td>
				<td>${dto.hometown}</td>
				<td>${dto.age}</td>
				<td>${dto.minheight}</td>
				<td>${dto.maxheight}</td>
				<td>${dto.interesting}</td>
				<td>${dto.character}</td>
				<td>${dto.time}</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="check()">신청하기</button>
	<a href="application.do"><button>신청내용보기</button></a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신청내용보기</title>
<script>
	function check(){
		var bo=confirm("정말로 삭제하시겠습니까?");
		if(bo){
			location.href="delete.do";
		}
	}
</script>
</head>
<body>
	<h1>미팅 신청내용</h1>
	<hr>
	<p>원하는 상대방의 정보</p>

	<table border="1">
		<tr>
			<td>단과 대학</td>
			<td>${dto.college}</td>
		</tr>
		<tr>
			<td>고향</td>
			<td>${dto.hometown}</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${dto.age}</td>
		</tr>
		<tr>
			<td>키</td>
			<td>${dto.height}</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>${dto.interesting}</td>
		</tr>
		<tr>
			<td>성격</td>
			<td>${dto.character}</td>
		</tr>
	</table>
	<a href="list.do"><button>신청목록보기</button></a><button onclick="check()">신청내역삭제</button>
</body>
</html>
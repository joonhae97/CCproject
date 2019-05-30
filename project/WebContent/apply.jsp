<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>미팅 신청 페이지</title>
</head>
<body>
	<h1>미팅 신청하기</h1>
	<hr>
	<p>원하는 상대방의 정보를 선택하세요</p>
	<form action="BoardApplyAction.do" name="applyform" method="post">
		<table border="1">
			<tr>
				<td>단과 대학</td>
				<td><input type="checkbox" name="college" value="인문대학">인문대학&nbsp;&nbsp;
					<input type="checkbox" name="college" value="사회과학대학">사회과학대학&nbsp;&nbsp;
					<input type="checkbox" name="college" value="자연과학대학">자연과학대학&nbsp;&nbsp;
					<input type="checkbox" name="college" value="경영대학">경영대학&nbsp;&nbsp;<br />
					<input type="checkbox" name="college" value="공과대학">공과대학&nbsp;&nbsp;
					<input type="checkbox" name="college" value="전자정보대학">전자정보대학&nbsp;&nbsp;
					<input type="checkbox" name="college" value="사범대학">사범대학&nbsp;&nbsp;
					<input type="checkbox" name="college" value="생활과학대학">생활과학대학&nbsp;&nbsp;<br />
					<input type="checkbox" name="college" value="수의과대학">수의과대학&nbsp;&nbsp;
					<input type="checkbox" name="college" value="약학대학">약학대학&nbsp;&nbsp;
					<input type="checkbox" name="college" value="의과대학">의과대학&nbsp;&nbsp;
					<input type="checkbox" name="college" value="자율전공학부">자율전공학부&nbsp;&nbsp; <br /> 
					<input type="checkbox" name="college" value="융합학과군">융합학과군
					<input type="checkbox" name="college" value="농업생명환경대학">농업생명환경대학&nbsp;&nbsp;
					</td>
			</tr>
			<tr>
				<td>고향</td>
				<td><input type="checkbox" name="hometown" value="서울특별시">서울특별시&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="경기도">경기도&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="인천광역시">인천광역시&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="대전광역시">대전광역시&nbsp;&nbsp;<br />
					<input type="checkbox" name="hometown" value="광주광역시">광주광역시&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="울산광역시">울산광역시&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="부산광역시">부산광역시&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="전라북도">전라북도&nbsp;&nbsp;<br />
					<input type="checkbox" name="hometown" value="전라남도">전라남도&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="경상북도">경상북도&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="경상남도">경상남도&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="충청북도">충청북도&nbsp;&nbsp;<br />
					<input type="checkbox" name="hometown" value="충청남도">충청남도&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="강원도">강원도&nbsp;&nbsp;
					<input type="checkbox" name="hometown" value="제주특별자치도">제주특별자치도
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="checkbox" name="age" value="20">20&nbsp;&nbsp;
					<input type="checkbox" name="age" value="21">21&nbsp;&nbsp;
					<input type="checkbox" name="age" value="22">22&nbsp;&nbsp;
					<input type="checkbox" name="age" value="23">23&nbsp;&nbsp;
					<input type="checkbox" name="age" value="24">24&nbsp;&nbsp;
					<input type="checkbox" name="age" value="25">25</td>
			</tr>
			<tr>
				<td>키</td>
				<td>
					<input type="checkbox" name="height" value="140">~140&nbsp;&nbsp;
					<input type="checkbox" name="height" value="145">145~150&nbsp;&nbsp;
					<input type="checkbox" name="height" value="150">150~155&nbsp;&nbsp;
					<input type="checkbox" name="height" value="155">155~160&nbsp;&nbsp;
					<input type="checkbox" name="height" value="160">160~165&nbsp;&nbsp;<br />
					<input type="checkbox" name="height" value="165">165~170&nbsp;&nbsp;
					<input type="checkbox" name="height" value="170">170~175&nbsp;&nbsp;
					<input type="checkbox" name="height" value="175">175~180&nbsp;&nbsp;
					<input type="checkbox" name="height" value="180">180~185&nbsp;&nbsp;
					<input type="checkbox" name="height" value="185">185~&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input type="checkbox" name="interesting" value="운동하기">운동하기&nbsp;&nbsp;
					<input type="checkbox" name="interesting" value="영화보기">영화보기&nbsp;&nbsp;
					<input type="checkbox" name="interesting" value="노래듣기">노래듣기&nbsp;&nbsp;
					<input type="checkbox" name="interesting" value="쇼핑하기">쇼핑하기&nbsp;&nbsp;
					<input type="checkbox" name="interesting" value="여행가기">여행가기&nbsp;&nbsp;<br />
					<input type="checkbox" name="interesting" value="코딩하기">코딩하기&nbsp;&nbsp;
					<input type="checkbox" name="interesting" value="맛집탐방">맛집탐방&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td>성격</td>
				<td><input type="checkbox" name="character" value="외향적인">외향적인&nbsp;&nbsp;
					<input type="checkbox" name="character" value="내향적인">내향적인&nbsp;&nbsp;
					<input type="checkbox" name="character" value="자유로운">자유로운&nbsp;&nbsp;
					<input type="checkbox" name="character" value="호기심많은">호기심많은&nbsp;&nbsp;<br />
					<input type="checkbox" name="character" value="과묵한">과묵한&nbsp;&nbsp;
					<input type="checkbox" name="character" value="친절한">친절한&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		<input type="submit" value="신청하기"><a href="list.do"><button type="button">되돌아가기</button></a>
	</form>
</body>
</html>
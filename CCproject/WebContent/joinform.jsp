<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>회원가입</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/scrolling-nav.css" rel="stylesheet">

<!-- css 파일 분리 -->
<link href='css/join_style.css' rel='stylesheet' style='text/css' />
<style>
.applyForm {
	margin-left: auto;
	margin-right: auto;
}

.sen {
	text-align: center;
}
</style>
</head>
<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="#page-top">CBNU
			Campus Couple Project</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="BoardList.bo">홈으로</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="BoardListAction.bo">후기 게시판</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="application.ro">내 정보</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="LoginForm.do">로그인</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<header class="bg-primary text-white"
		style="background-color:#fd67a5 !important;">
	<div class="container text-center">
		<h1>오직 충북대 학생만을 위한 CC 프로젝트</h1>
		<p class="lead">CBNU Campus Couple Project</p>
	</div>
	</header>
	<section class="applyForm">
	<div class="sen">
		<h1>회원가입</h1>
		<hr>
		<p>당신의 정보를 입력하세요.</p>
	</div>
	<center>
		<div style="width: 800px;">
			<form action="MemberJoinAction.do" method="post">
				<table class="table table-striped table-bordered table-hover"
					style="text-align: center">
					<tr>
						<th>ID</th>
						<th><input type="text" name="id"></th>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<th><input type="text" name="password"></th>
					</tr>
					<tr>
						<th>NAME</th>
						<th><input type="text" name="name"></th>
					</tr>
					<tr>
						<th>EMAIL</th>
						<th><input type="text" name="email"></th>
					</tr>
					<tr>
						<th>GENDER</th>
						<th><div class="btn-group" data-toggle="buttons">

								<label class="btn btn-primary active"> <input
									type="radio" name="gender" autocomplete="off" value="남자"
									checked>남자

								</label> <label class="btn btn-primary"> <input type="radio"
									name="gender" autocomplete="off" value="여자">여자

								</label>

							</div></th>
					</tr>
					<tr>
						<th>COLLEGE</th>
						<td style="padding-left: 10%"><input type="radio"
							name="college" value="인문대학" class="cb">인문대학&nbsp;&nbsp; <input
							type="radio" name="college" value="사회과학대학" class="cb">사회과학대학&nbsp;&nbsp;
							<input type="radio" name="college" value="자연과학대학" class="cb">자연과학대학&nbsp;&nbsp;
							<input type="radio" name="college" value="경영대학" class="cb">경영대학&nbsp;&nbsp;
							<input type="radio" name="college" value="공과대학" class="cb">공과대학&nbsp;&nbsp;
							<input type="radio" name="college" value="전자정보대학" class="cb">전자정보대학&nbsp;&nbsp;
							<input type="radio" name="college" value="사범대학" class="cb">사범대학&nbsp;&nbsp;
							<input type="radio" name="college" value="생활과학대학" class="cb">생활과학대학&nbsp;&nbsp;
							<input type="radio" name="college" value="수의과대학" class="cb">수의과대학&nbsp;&nbsp;
							<input type="radio" name="college" value="약학대학" class="cb">약학대학&nbsp;&nbsp;
							<input type="radio" name="college" value="의과대학" class="cb">의과대학&nbsp;&nbsp;
							<input type="radio" name="college" value="자율전공학부" class="cb">자율전공학부&nbsp;&nbsp;
							<input type="radio" name="college" value="융합학과군" class="cb">융합학과군
							<input type="radio" name="college" value="농업생명환경대학" class="cb">농업생명환경대학&nbsp;&nbsp;
						</td>

					</tr>
					<tr>
						<th>HOMETOWM</th>
						<td style="padding-left: 10%"><input type="radio"
							name="hometown" value="서울특별시" class="cb">서울특별시&nbsp;&nbsp;
							<input type="radio" name="hometown" value="경기도" class="cb">경기도&nbsp;&nbsp;
							<input type="radio" name="hometown" value="인천광역시" class="cb">인천광역시&nbsp;&nbsp;
							<input type="radio" name="hometown" value="대전광역시" class="cb">대전광역시&nbsp;&nbsp;
							<input type="radio" name="hometown" value="광주광역시" class="cb">광주광역시&nbsp;&nbsp;
							<input type="radio" name="hometown" value="울산광역시" class="cb">울산광역시&nbsp;&nbsp;
							<input type="radio" name="hometown" value="부산광역시" class="cb">부산광역시&nbsp;&nbsp;
							<input type="radio" name="hometown" value="전라북도" class="cb">전라북도&nbsp;&nbsp;
							<input type="radio" name="hometown" value="전라남도" class="cb">전라남도&nbsp;&nbsp;
							<input type="radio" name="hometown" value="경상북도" class="cb">경상북도&nbsp;&nbsp;
							<input type="radio" name="hometown" value="경상남도" class="cb">경상남도&nbsp;&nbsp;
							<input type="radio" name="hometown" value="충청북도" class="cb">충청북도&nbsp;&nbsp;
							<input type="radio" name="hometown" value="충청남도" class="cb">충청남도&nbsp;&nbsp;
							<input type="radio" name="hometown" value="강원도" class="cb">강원도&nbsp;&nbsp;
							<input type="radio" name="hometown" value="제주특별자치도" class="cb">제주특별자치도
						</td>
					</tr>
					<tr>
						<th>AGE</th>
						<td style="padding-left: 10%"><input type="radio" name="age"
							value="20" class="cb">20&nbsp;&nbsp; <input type="radio"
							name="age" value="21" class="cb">21&nbsp;&nbsp; <input
							type="radio" name="age" value="22" class="cb">22&nbsp;&nbsp;
							<input type="radio" name="age" value="23" class="cb">23&nbsp;&nbsp;
							<input type="radio" name="age" value="24" class="cb">24&nbsp;&nbsp;
							<input type="radio" name="age" value="25" class="cb">25</td>

					</tr>
					<tr>
						<th>HEIGHT</th>

						<td style="padding-left: 10%">
							<!--숫자만 입력할 수 있게  --> <input required type="text" name="height"
							oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />cm
						</td>

					</tr>
					<tr>
						<th>INTERESTING</th>
						<td style="padding-left: 10%"><input type="radio"
							name="interesting" value="운동하기" class="cb">운동하기&nbsp;&nbsp;
							<input type="radio" name="interesting" value="영화보기" class="cb">영화보기&nbsp;&nbsp;
							<input type="radio" name="interesting" value="쇼핑하기" class="cb">쇼핑하기&nbsp;&nbsp;
							<input type="radio" name="interesting" value="여행가기" class="cb">여행가기&nbsp;&nbsp;
							<input type="radio" name="interesting" value="코딩하기" class="cb">코딩하기&nbsp;&nbsp;
							<input type="radio" name="interesting" value="맛집탐방" class="cb">맛집탐방&nbsp;&nbsp;
						</td>

					</tr>
					<tr>
						<th>CHARACTER</th>
						<td style="padding-left: 10%"><input type="radio"
							name="character" value="외향적인" class="cb">외향적인&nbsp;&nbsp;
							<input type="radio" name="character" value="내향적인" class="cb">내향적인&nbsp;&nbsp;
							<input type="radio" name="character" value="자유로운" class="cb">자유로운&nbsp;&nbsp;
							<input type="radio" name="character" value="호기심많은" class="cb">호기심많은&nbsp;&nbsp;
							<input type="radio" name="character" value="과묵한" class="cb">과묵한&nbsp;&nbsp;
							<input type="radio" name="character" value="친절한" class="cb">친절한&nbsp;&nbsp;
						</td>

					</tr>
					<tr>
						<th colspan="2" style="text-align: center"><input type=submit
							class="btn btn-success" value="등록"
							Onclick="javascript:writeCheck();"> <input type=button
							class="btn btn-secondary" value="취소"
							OnClick="window.location='login.jsp'"></th>
					</tr>
				</table>

			</form>
		</div>
	</center>
	</section>

	<!-- Footer -->
	<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Team 4 2019</p>
	</div>
	<!-- /.container --> </footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom JavaScript for this theme -->
	<script src="js/scrolling-nav.js"></script>
</body>
</html>
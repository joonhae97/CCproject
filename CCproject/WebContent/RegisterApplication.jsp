<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>내 정보 보기</title>
	<script>
	function check(){
		var bo=confirm("정말로 삭제하시겠습니까?");
		if(bo){
			location.href="delete.ro";
		}
	}
</script>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/scrolling-nav.css" rel="stylesheet">
    <style>
        td{
            border: solid 3px #FBB7DE;
        }

        .btn{
            background-color: #FD67A5;
            color: white;
            font-weight: bold;
            font-size: 18px;
            padding: 10px 15px;
            border: none;
            border-radius: 10px;
        }
        table{
            font-size: 22px;
            width: 700px;
        }
        td{
            padding: 10px 5px;
        }
        .apply{
            width: 40%;
            margin-left: 32%;
            margin-right: 30%;

        }

    </style>
</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">CBNU Campus Couple Project</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="BoardList.bo">홈으로</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="apply.jsp">신청하기</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="BoardListAction.bo">후기 게시판</a>
                </li>
                <li class="nav-item">
                     <a class="nav-link js-scroll-trigger" href="MemberLogoutAction.do">로그아웃</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header class="bg-primary text-white" style="background-color:#fd67a5 !important;">
    <div class="container text-center">
        <h1>오직 충북대 학생만을 위한 CC 프로젝트</h1>
        <p class="lead">CBNU Campus Couple Project</p>
    </div>
</header>

<section style="text-align: center;">
<h3>신청 정보</h3>
<hr>
<p>당신이 선택한 상대방 프로필 입니다!</p>
<div class="apply" style="display:table;margin:10px auto;">
<table class="bd">
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
        <td>${dto.minheight}~${dto.maxheight}</td>
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
</div>
    <br/><br/><br/>
<a href="RegisterList.ro"><button class="btn">신청목록보기</button></a>
<button onclick="check()" class="btn">신청내역삭제</button>
</section>

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Team 4 2019</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom JavaScript for this theme -->
<script src="js/scrolling-nav.js"></script>

</body>

</html>

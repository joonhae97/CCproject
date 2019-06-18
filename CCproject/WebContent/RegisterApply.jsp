<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Scrolling Nav - Start Bootstrap Template</title>

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
            font-size: 18px;
            width: 750px;
        }
        td{
            padding: 15px 10px;
        }
        .applyForm{
            margin-left: 30%;
            margin-right: 30%;

        }

       .sen{
            text-align: center;
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
                    <a class="nav-link js-scroll-trigger" href="BoardListAction.bo">후기 게시판</a>
                </li>
                 <li class="nav-item">
                     <a class="nav-link js-scroll-trigger" href="application.ro">내 정보</a>
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
<section class="applyForm">
    <div class="sen">
<h1>미팅 신청하기</h1>
<hr>
<p>원하는 상대방의 정보를 선택하세요</p>
    </div>
<form action="BoardApplyAction.ro" name="applyform" method="post">
    <table border="1">
        <tr>
            <td style="text-align: center">단과 대학</td>
            <td style="padding-left: 10%"><input type="checkbox" name="college" value="인문대학"class="cb">인문대학&nbsp;&nbsp;
                <input type="checkbox" name="college" value="사회과학대학"class="cb">사회과학대학&nbsp;&nbsp;
                <input type="checkbox" name="college" value="자연과학대학"class="cb">자연과학대학&nbsp;&nbsp;
                <input type="checkbox" name="college" value="경영대학"class="cb">경영대학&nbsp;&nbsp;<br />
                <input type="checkbox" name="college" value="공과대학"class="cb">공과대학&nbsp;&nbsp;
                <input type="checkbox" name="college" value="전자정보대학"class="cb">전자정보대학&nbsp;&nbsp;
                <input type="checkbox" name="college" value="사범대학"class="cb">사범대학&nbsp;&nbsp;
                <input type="checkbox" name="college" value="생활과학대학"class="cb">생활과학대학&nbsp;&nbsp;<br />
                <input type="checkbox" name="college" value="수의과대학"class="cb">수의과대학&nbsp;&nbsp;
                <input type="checkbox" name="college" value="약학대학"class="cb">약학대학&nbsp;&nbsp;
                <input type="checkbox" name="college" value="의과대학"class="cb">의과대학&nbsp;&nbsp;
                <input type="checkbox" name="college" value="자율전공학부"class="cb">자율전공학부&nbsp;&nbsp; <br />
                <input type="checkbox" name="college" value="융합학과군"class="cb">융합학과군
                <input type="checkbox" name="college" value="농업생명환경대학"class="cb">농업생명환경대학&nbsp;&nbsp;
            </td>
        </tr>

        <tr>
            <td style="text-align: center">고향</td>
            <td style="padding-left: 10%"><input type="checkbox" name="hometown" value="서울특별시"class="cb">서울특별시&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="경기도"class="cb">경기도&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="인천광역시"class="cb">인천광역시&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="대전광역시"class="cb">대전광역시&nbsp;&nbsp;<br />
                <input type="checkbox" name="hometown" value="광주광역시"class="cb">광주광역시&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="울산광역시"class="cb">울산광역시&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="부산광역시"class="cb">부산광역시&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="전라북도"class="cb">전라북도&nbsp;&nbsp;<br />
                <input type="checkbox" name="hometown" value="전라남도"class="cb">전라남도&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="경상북도"class="cb">경상북도&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="경상남도"class="cb">경상남도&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="충청북도"class="cb">충청북도&nbsp;&nbsp;<br />
                <input type="checkbox" name="hometown" value="충청남도"class="cb">충청남도&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="강원도"class="cb">강원도&nbsp;&nbsp;
                <input type="checkbox" name="hometown" value="제주특별자치도"class="cb">제주특별자치도
            </td>
        </tr>
        <tr>
            <td style="text-align: center">나이</td>
            <td style="padding-left: 10%"><input type="checkbox" name="age" value="20"class="cb">20&nbsp;&nbsp;
                <input type="checkbox" name="age" value="21"class="cb">21&nbsp;&nbsp;
                <input type="checkbox" name="age" value="22"class="cb">22&nbsp;&nbsp;
                <input type="checkbox" name="age" value="23"class="cb">23&nbsp;&nbsp;
                <input type="checkbox" name="age" value="24"class="cb">24&nbsp;&nbsp;
                <input type="checkbox" name="age" value="25"class="cb">25</td>
        </tr>
        <tr>
            <td style="text-align: center">키</td>
            <td style="padding-left: 10%">
                <!-- 최소<input type="text" name="minheight">
                ~ 최대<input type="text" name="maxheight"> -->

                <!--숫자만 입력할 수 있게  -->
                <input required type="text" name="minheight" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
                <input required type="text" name="maxheight" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
            </td>
        </tr>
        <tr>
            <td style="text-align: center">취미</td>
            <td style="padding-left: 10%"><input type="checkbox" name="interesting" value="운동하기" class="cb">운동하기&nbsp;&nbsp;
                <input type="checkbox" name="interesting" value="영화보기"class="cb">영화보기&nbsp;&nbsp;
                <input type="checkbox" name="interesting" value="노래듣기"class="cb">노래듣기&nbsp;&nbsp;
                <input type="checkbox" name="interesting" value="쇼핑하기"class="cb">쇼핑하기&nbsp;&nbsp;
                <input type="checkbox" name="interesting" value="여행가기"class="cb">여행가기&nbsp;&nbsp;<br />
                <input type="checkbox" name="interesting" value="코딩하기"class="cb">코딩하기&nbsp;&nbsp;
                <input type="checkbox" name="interesting" value="맛집탐방"class="cb">맛집탐방&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td style="text-align: center">성격</td>
            <td style="padding-left: 10%"><input type="checkbox" name="character" value="외향적인"class="cb">외향적인&nbsp;&nbsp;
                <input type="checkbox" name="character" value="내향적인"class="cb">내향적인&nbsp;&nbsp;
                <input type="checkbox" name="character" value="자유로운"class="cb">자유로운&nbsp;&nbsp;
                <input type="checkbox" name="character" value="호기심많은"class="cb">호기심많은&nbsp;&nbsp;<br />
                <input type="checkbox" name="character" value="과묵한"class="cb">과묵한&nbsp;&nbsp;
                <input type="checkbox" name="character" value="친절한"class="cb">친절한&nbsp;&nbsp;
            </td>
        </tr>
    </table>
    <br/><br/>
    <div class="sen">
    <input type="submit" value="신청하기" class="btn"><a href="RegisterList">
    <button type="button" class="btn">되돌아가기</button></a>
    </div>
</form>
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

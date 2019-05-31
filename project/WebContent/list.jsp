<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>신청목록보기</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/scrolling-nav.css" rel="stylesheet">
    <script>
        function check() {
            var bo = confirm("이전 작성한 신청서가 있을 경우 데이터가 사라집니다.\n진행하시겠습니까?");

            if (bo) {
                location.href = "apply.do";
            }
        }
    </script>


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
        .applyList{
            margin-left: 15%;
            margin-right: 15%;

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
                    <a class="nav-link js-scroll-trigger" href="main.jsp">홈으로</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="apply.jsp">신청하기</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#">후기 게시판</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#">로그아웃</a>
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
<div class="sen">
    <br/><br/><br/>
<h1>신청 목록 보기</h1>
<hr style="width:80%">
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
</div>
<div class="applyList">
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
</div>
<br/><br/>
<div class="sen">
<button onclick="check()" class="btn">신청하기</button>
<a href="application.do"><button class="btn">신청내용보기</button></a>
</div>
<br/><br/><br/><br/><br/><br/>
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
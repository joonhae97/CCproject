<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>글 수정</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/scrolling-nav.css" rel="stylesheet">
    
    <style type="text/css">
        #title{
            height : 16;
            font-family :'돋움';
            font-size : 12;
            text-align :center;
        }
    </style>
    
    <script type="text/javascript">
        function changeView()
        {
            location.href='BoardListAction.bo?page=${pageNum}';
        }
    </script>
    
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
                    <a class="nav-link js-scroll-trigger" href="LoginForm.do">로그인</a>
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
    <h1>글 수정</h1>
    <hr>
<br/>
</div>
    
    <form method="post" action="BoardUpdateAction.bo?page=${pageNum}" name="boardForm" 
            enctype="multipart/form-data">
 
    <input type="hidden" name="board_num" value="${board.board_num}"/>
    <input type="hidden" name="existing_file" value="${board.board_file}"/>
 
    <table width="700" border="3" bordercolor="lightgray" align="center">
        <tr>
            <td id="title">작성자</td>
            <td>${board.board_id}</td>
        </tr>
            <tr>
            <td id="title">
                제 목
            </td>
            <td>
                <input name="board_subject" type="text" size="70" maxlength="100" 
                    value="${board.board_subject}"/>
            </td>        
        </tr>
        <tr>
            <td id="title">
                내 용
            </td>
            <td>
                <textarea name="board_content" cols="72" rows="20">
                    ${board.board_content}
                </textarea>            
            </td>        
        </tr>

        
        <tr align="center" valign="middle">
            <td colspan="5">
                <input type="reset" value="작성취소" >
                <input type="submit" value="수정" >
                <input type="button" value="목록" onclick="changeView()" >            
            </td>
        </tr>
    </table>    
    </form>
    
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

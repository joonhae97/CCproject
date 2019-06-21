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

    <title>��ü �Խù�</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/scrolling-nav.css" rel="stylesheet">
     
    <style type="text/css">
        #wrap {
            width: 800px;
            margin: 0 auto 0 auto;
        }
        #topForm{
            text-align :right;
        }
        #board, #pageForm, #searchForm{
            text-align :center;
        }
        
        #bList{
            text-align :center;
        }
    </style>
    
    <script type="text/javascript">
        function writeForm(){
            location.href="BoardWriteForm.bo";
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
                    <a class="nav-link js-scroll-trigger" href="BoardList.bo">Ȩ����</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="BoardListAction.bo">�ı� �Խ���</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="application.ro">�� ����</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="LoginForm.do">�α���</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header class="bg-primary text-white" style="background-color:#fd67a5 !important;">
    <div class="container text-center">
        <h1>���� ��ϴ� �л����� ���� CC ������Ʈ</h1>
        <p class="lead">CBNU Campus Couple Project</p>
    </div>
</header>
    <div>
    <center><h1>��ü �Խù�</h1></center>
    <hr>
    </div>
<br/>
<div id="wrap">
 
    <!-- �۸�� �� �κ�-->
    <br>
    <div id="topForm">
        <c:if test="${sessionScope.sessionID!=null}">
            <input type="button" value="�۾���" onclick="writeForm()">
        </c:if>    
    </div>
    
    <!-- �Խñ� ��� �κ� -->
    <br>
    <div id="board">
        <table id="bList" width="800" border="3" bordercolor="lightgray">
            <tr heigh="30">
                <td>�۹�ȣ</td>
                <td>����</td>
                <td>�ۼ���</td>
                <td>�ۼ���</td>
                <td>��ȸ��</td>
            </tr>
        <c:forEach var="board" items="${requestScope.list}">
            <tr>
                <td>${board.board_num}</td>
                <td>
                    <a href="BoardDetailAction.bo?num=${board.board_num}&pageNum=${spage}">
                    ${board.board_subject}
                    </a>
                </td>
                <td>
                    <a href="#">
                    ${board.board_id}
                    </a>
                </td>
                <td>${board.board_date}</td>
                <td>${board.board_count}</td>
            </tr>
        </c:forEach>
        </table>
    </div>
    
    <!-- ������ �ѹ� �κ� -->
    <br>
    <div id="pageForm">
        <c:if test="${startPage != 1}">
            <a href='BoardListAction.bo?page=${startPage-1}'>[ ���� ]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href='BoardListAction.bo?page=${pageNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a href='BoardListAction.bo?page=${endPage+1 }'>[����]</a>
        </c:if>
    </div>
    
    <!--  �˻� �κ� -->
    <br>
    <div id="searchForm">
        <form>
            <select name="opt">
                <option value="0">����</option>
                <option value="1">����</option>
                <option value="2">����+����</option>
                <option value="3">�۾���</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="�˻�"/>
        </form>    
    </div>
</div>  
  
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


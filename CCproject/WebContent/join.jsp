<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
    
<%-- �ڹٺ� Ŭ���� import --%>      
<%@ page import="com.login.beans.MemberBean" %>  
<%-- DAO import --%>   
<%@ page import="com.login.dao.MemberDAO" %> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ȸ������</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/scrolling-nav.css" rel="stylesheet">
    
    <!-- css ���� �и� -->
    <link href='css/join_style.css' rel='stylesheet' style='text/css'/>
    <style>
         .applyForm{
            margin-left: auto;
            margin-right: auto;

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

    <%-- JoinForm.jsp���� �Է��� ������ �Ѱ� �޾� ó���Ѵ�. --%>
    <% 
        // �ѱ� ������ �����ϱ� ���� ���ڵ� ó��
        request.setCharacterEncoding("euc-kr"); 
    %>
    
    <%-- �ڹٺ� ���� �׼��±� ��� --%>
    <jsp:useBean id="memberBean" class="com.login.beans.MemberBean" />
    <jsp:setProperty property="*" name="memberBean"/>    
    <%--
    <%
        MemberDAO dao = MemberDAO.getInstance();
    
        // ȸ�������� ����ִ� memberBean�� dao�� insertMember() �޼���� �ѱ��.
        // insertMember()�� ȸ�� ������ JSP_MEMBER ���̺� �����Ѵ�.
        dao.joinMember(memberBean);
    %>
    --%>
    
    <div id="wrap">
        <br><br>
        <b><font size="5" color="gray">ȸ������ ������ Ȯ���ϼ���.</font></b>
        <br><br>
        <font color="blue"><%=memberBean.getName() %></font>�� ������ ���ϵ帳�ϴ�.
        <br><br>
        
        <%-- �ڹٺ󿡼� �Էµ� ���� �����Ѵ�. --%>
        <table>
            <tr>
                <td id="title">���̵�</td>
                <td><%=memberBean.getId() %></td>
            </tr>
                        
            <tr>
                <td id="title">��й�ȣ</td>
                <td><%=memberBean.getPw() %></td>
            </tr>
                    
            <tr>
                <td id="title">�̸�</td>
                <td><%=memberBean.getName() %></td>
            </tr>
                    
            <tr>
                <td id="title">����</td>
                <td><%=memberBean.getGender()%></td>
            </tr>
                    
            <tr>
                <td id="title">�̸���</td>
                <td>
                    <%=memberBean.getEmail() %>@<%=memberBean.getEmail() %>
                </td>
            </tr>
                    
        </table>
        
        <br>
        <input type="button" value="Ȯ��">
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

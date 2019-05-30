<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- 뷰포트 -->
    <meta name="viewport" content="width=device-width" initial-scale="1">
    <!-- 스타일시트 참조  -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>Login</title>
</head>
<body>
<!-- 로긴폼 -->
<div class="container">
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
        <!-- 점보트론 -->
        <div class="jumbotron" style="padding-top: 20px;">
            <!-- 로그인 정보를 숨기면서 전송post -->
            <form method="post" action="MemberLoginAction.do">
                <h3 style="text-align: center;"> 로그인화면 </h3>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="아이디" name="id" maxlength="20">
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" placeholder="비밀번호" name="password" maxlength="20">
                </div>
                <input type="submit" class="btn btn-primary form-control" value="로그인">

            </form>
        </div>
    </div>
</div>





<!-- 애니매이션 담당 JQUERY -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<!-- 부트스트랩 JS  -->
<script src="js/bootstrap.js"></script>

</body>
</html>
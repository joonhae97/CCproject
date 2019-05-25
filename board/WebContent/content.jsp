<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 
<html>
<head>
    <title>글 상세보기</title>
    
    <style type="text/css">
        #wrap {
            width: 800px;
            margin: 0 auto 0 auto;    
        }
    
        #detailBoard{
            text-align :center;
        }
        
        #title{
            height : 16;
            font-family :'돋움';
            font-size : 12;
            text-align :center;
            background-color: #F7F7F7;
        }
        
        #btn{
            font-family :'돋움';
            font-size : 14;
            text-align :center;
        }
 	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </style>
    
    <script type="text/javascript">
        function changeView(value)
        {
            if(value == 0)    
                location.href='BoardListAction.bo?page=${pageNum}';
            else if(value == 1)
                location.href='BoardReplyFormAction.bo?num=${board.board_num}&page=${pageNum}';
        }
        

 
        var httpRequest = null;
        
        // httpRequest 객체 생성
        function getXMLHttpRequest(){
            var httpRequest = null;
        
            if(window.ActiveXObject){
                try{
                    httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
                } catch(e) {
                    try{
                        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e2) { httpRequest = null; }
                }
            }
            else if(window.XMLHttpRequest){
                httpRequest = new window.XMLHttpRequest();
            }
            return httpRequest;    
        }
        
        // 댓글 등록
        function writeCmt()
        {
            var form = document.getElementById("writeCommentForm");
            
            var board = form.comment_board.value
            var id = form.comment_id.value
            var content = form.comment_content.value;
            
            if(!content)
            {
                alert("내용을 입력하세요.");
                return false;
            }
            else
            {    
                var param="comment_board="+board+"&comment_id="+id+"&comment_content="+content;
                httpRequest = getXMLHttpRequest();
                httpRequest.onreadystatechange = checkFunc;
                httpRequest.open("POST", "CommentWrite.do", true);    
                httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=EUC-KR'); 
                httpRequest.send(param);
            }
        }
        
        function checkFunc(){
            if(httpRequest.readyState == 4){
                // 결과값을 가져온다.
                var resultText = httpRequest.responseText;
                if(resultText == 1){ 
                    document.location.reload(); // 상세보기 창 새로고침
                }
            }
        }
    
    </script>
</head>
<body>
 
<div id="wrap">
    <br><br>
    <div style="text-align:right">
	사용자ID : ${id} <input type=button class="btn btn-info" value="로그아웃" OnClick="window.location='logout.do'">
	</div>
	
	<c:forEach items="${articleList}" var="article">
	<table class="table table-striped table-bordered table-hover" style="text-align:center">
		<caption style="text-align:center">게시판 내용</caption>
		<tr>
			<td>제목</td>
			<td style="text-align:left">${article.subject}</td>			
		</tr>
		<tr>
			<td>작성자</td>
			<td style="text-align:left">${article.id}</td>						
		</tr>
		<tr>
			<td>작성일자</td>
			<td style="text-align:left">${article.boarddate}</td>						
		</tr>
		<tr>
			<td>조회수</td>
			<td style="text-align:left">${article.score}</td>						
		</tr>
		<tr>
			<td>email</td>
			<td style="text-align:left">${article.email}</td>						
		</tr>		
		<tr>
			<td>내용</td>
			<td style="text-align:left">${article.content}</td>						
		</tr>
	</table>
	<div style="text-align:right">
		<input type=button class="btn btn-danger" value="답글달기" OnClick="window.location='replyform.do?num=${article.num}'">
		<input type=button class="btn btn-danger" value="삭제하기" OnClick="window.location='delete.do?num=${article.num}'">
		<input type=button class="btn btn-warning" value="수정하기" OnClick="window.location='modifyform.do?num=${article.num}'">			
		<input type=button class="btn btn-secondary" value="돌아가기" OnClick="window.location='list.do'">
	</div>
	
	
    <!-- 댓글 부분 -->
    <div id="comment">
        <table border="1" bordercolor="lightgray">
    <!-- 댓글 목록 -->    
        <c:forEach var="comment" items="${commentList}">
            <tr>
                <!-- 아이디, 작성날짜 -->
                <td width="150">
                    <div>
                        ${comment.comment_id}<br>
                        <font size="2" color="lightgray">${comment.comment_date}</font>
                    </div>
                </td>
                <!-- 본문내용 -->
                <td width="550">
                    <div class="text_wrapper">
                        ${comment.comment_content}
                    </div>
                </td>
                <!-- 버튼 -->
                <td width="100">
                    <div id="btn" style="text-align:center;">
                        <a href="#">[답변]</a><br>
                    <!-- 댓글 작성자만 수정, 삭제 가능하도록 -->    
                    <c:if test="${comment.comment_id == sessionScope.id}">
                        <a href="#">[수정]</a><br>    
                        <a href="#">[삭제]</a>
                    </c:if>        
                    </div>
                </td>
            </tr>
            
        </c:forEach>
            <!-- 로그인 했을 경우만 댓글 작성가능 -->
            <c:if test="${sessionScope.id !=null}">
            <tr bgcolor="#F5F5F5">
            <form id="writeCommentForm">
                <input type="hidden" name="comment_board" value="${article.num}">
                <input type="hidden" name="comment_id" value="${sessionScope.id}">
                <!-- 아이디-->
                <td width="150">
                    <div>
                        ${sessionScope.id}
                    </div>
                </td>
                <!-- 본문 작성-->
                <td width="550">
                    <div>
                        <textarea name="comment_content" rows="4" cols="70" ></textarea>
                    </div>
                </td>
                <!-- 댓글 등록 버튼 -->
                <td width="100">
                    <div id="btn" style="text-align:center;">
                        <p><a href="#" onclick="writeCmt()">[댓글등록]</a></p>    
                    </div>
                </td>
            </form>
            </tr>
            </c:if>
    
        </table>
    </div>
    </c:forEach>
    
</div>    
</body>
</html>


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
        }
    </style>
    <script>
    	function doAction(value){
    		if(value==0) alert("수정버튼 클릭");
    		else if(value ==1)
    			location.href = "BoardDeleteAction.bo?num=${board.board_num}";
    	}
    </script>
</head>
<body>
 
<div id="wrap">
    <br><br>
    <div id="board">
        <table id="detailBoard" width="800" border="3" bordercolor="lightgray">
        
            <tr>
                <td id="title">작성일</td>
                <td>${board.board_date}</td>
            </tr>
            <tr>
                <td id="title">작성자</td>
                <td>${board.board_id}</td>
            </tr>
            <tr>
                <td id="title">
                    제 목
                </td>
                <td>
                    ${board.board_subject}
                </td>        
            </tr>
            <tr>
                <td id="title">
                    내 용
                </td>
                <td>
                    ${board.board_content}
                </td>        
            </tr>
            <tr>
                <td id="title">
                    첨부파일
                </td>
                <td>
                    <a href='FileDownloadAction.bo?file_name=${board.board_file}'>${board.board_file}</a>
                </td>    
            </tr>
    
            <tr align="center" valign="middle">
                <td colspan="5">
                	<c:if test = "${sessionScope.sessionID!=null}">
                		<c:if test = "${sessionScope.sessionID == board.board_id}">
		                    <input type="button" value="수정" onclick ="doAction(0)">
		                    <input type="button" value="삭제" onclick ="doAction(1)">
		                </c:if>
		            </c:if>
                    <input type="button" value="목록" 
                        onclick="javascript:location.href='BoardListAction.bo?page=${pageNum}'">            
                </td>
            </tr>
        </table>
    </div>
</div>    
 
</body>
</html>



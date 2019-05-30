<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

  Connection conn=null;

 

  try{

     

        String jdbcUrl= "jdbc:mysql://127.0.0.1/jspdb" ;

        String dbId="scott";

        String dbPass= "1234";


        Class.forName( "com.mysql.jdbc.Driver");

        conn=DriverManager.getConnection(jdbcUrl,dbId ,dbPass );

        out.println( "제대로 연결되었습니다." );

  }catch(Exception e){

           e.printStackTrace();
          

  }

%>
</body>
</html>
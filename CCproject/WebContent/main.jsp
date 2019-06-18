<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
    
<!DOCTYPE html>
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>CBNU CC Project</title>
  <!-- Custom styles for this template -->
  <link href="css/agency.css" rel="stylesheet">
  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>



</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">CBNU Campus Couple Project</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="about.html">소개</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="RegisterList.ro">신청하기</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="BoardListAction.bo">후기보기</a>
          </li>
          <c:if test="${sessionScope.sessionID==null}">
		      <li class="nav-item">
		      	<a class="nav-link js-scroll-trigger" href="JoinForm.do">회원가입</a>
	          </li>
          </c:if>
          <c:if test="${sessionScope.sessionID==null}">
	          <li class="nav-item">
	            <a class="nav-link js-scroll-trigger" href="LoginForm.do">로그인</a>
	          </li>
          </c:if>
          <c:if test="${sessionScope.sessionID!=null}">
	          <li class="nav-item">
	            <a class="nav-link js-scroll-trigger" href="MemberLogoutAction.do">로그아웃</a>
	          </li>
          </c:if>
          
          
        </ul>
      </div>
    </div>
  </nav>

  <!-- Header -->
  <header class="masthead">
    <div class="container">
      <div class="intro-text">
        <div class="intro-lead-in">누구에게나 인연은 있다.</div>
        <div class="intro-heading text-uppercase">당신의 인연을 찾아보세요!</div>
        <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="RegisterList.ro">신청하러 가기</a>
      </div>
    </div>
  </header>

  <!-- Services -->
  <section class="page-section" id="services">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">소개팅 신청 현황</h2>
          <h3 class="section-subheading text-muted">누구에게나 인연은 있다.</h3>
        </div>
      </div>
        <div id="board" style="display:table;margin:10px auto;">
        <table id="bList" width="800" border="3" bordercolor="lightgray">
            <tr heigh="30">
                <td>글번호</td>
                <td>제목</td>
                <td>작성자</td>
                <td>작성일</td>
                <td>조회수</td>
            </tr>
            <c:forEach begin="1" end="5" items="${list}" var="board">
		        <tr>
		            <td>${board.board_num}</td>
		            <td>${board.board_subject}</td>
		            <td>${board.board_id}</td>
		            <td>${board.board_date}</td>
		            <td>${board.board_count}</td>
		        </tr>
	        </c:forEach>
    
        </table>
    </div>
    </div>
  </section>

  <!-- About -->
  <section class="page-section" id="about">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">어떻게 인연이 만들어 질까요?</h2>
          <h3 class="section-subheading text-muted">누구에게나 인연은 있다.</h3>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <ul class="timeline">
            <li>
              <div class="timeline-image">
       
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>첫 번째,</h4>
                  <h4 class="subheading">신청서 작성</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">당신의 프로필을 작성하고 신청서를 작성합니다. 신청서에서 원하는 상대방의 여러가지 조건을 선택하고 신청하기를 누르면 간단하게 신청 완료! 당신의 이상형을 찾아보세요~</p>
                </div>
              </div>
            </li>
            <li class="timeline-inverted">
              <div class="timeline-image">
        
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>두 번째,</h4>
                  <h4 class="subheading">매칭 기다리기 </h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">당신의 이상형에 가장 적합한 사람을 찾는 중입니다. 소개팅을 함께할 상대가 매칭되면 알려드리니 조금만 기다려주세요!</p>
                </div>
              </div>
            </li>
            <li>
              <div class="timeline-image">
             
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>세 번째,</h4>
                  <h4 class="subheading">소개팅 주선</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">매칭된 상대와 즐거운 시간을 보내세요. 어쩌면 당신의 인연을 찾게될지도 몰라요!</p>
                </div>
              </div>
            </li>
            <li class="timeline-inverted">
              <div class="timeline-image">
          
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>마지막,</h4>
                  <h4 class="subheading">후기 작성하기</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">즐거운 시간을 보내셨나요? 그렇다면 후기를 작성해 더 많은 사람들에게 알려주세요. 그렇지 않았다면 더 나은 서비스를 위해 후기를 작성해주세요!</p>
                </div>
              </div>
          </ul>
        </div>
      </div>
    </div>
  </section>

  <!-- Team -->
  <section class="bg-light page-section" id="team">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Our Amazing Team</h2>
          <h3 class="section-subheading text-muted">오픈소스 전문 프로젝트</h3>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-3">
          <div class="team-member">

            <h4>송유헌</h4>
            <p class="text-muted">팀장</p>
            <ul class="list-inline social-buttons">
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-facebook-f"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-linkedin-in"></i>
                </a>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="team-member">
       
            <h4>박상혁</h4>
            <p class="text-muted">팀원</p>
            <ul class="list-inline social-buttons">
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-facebook-f"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-linkedin-in"></i>
                </a>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="team-member">

            <h4>천아현</h4>
            <p class="text-muted">팀원</p>
            <ul class="list-inline social-buttons">
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-facebook-f"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-linkedin-in"></i>
                </a>
              </li>
            </ul>
          </div>
        </div>
          <div class="col-sm-3">
            <div class="team-member">
   
              <h4>황준해</h4>
              <p class="text-muted">팀원</p>
              <ul class="list-inline social-buttons">
                <li class="list-inline-item">
                  <a href="#">
                    <i class="fab fa-twitter"></i>
                  </a>
                </li>
                <li class="list-inline-item">
                  <a href="#">
                    <i class="fab fa-facebook-f"></i>
                  </a>
                </li>
                <li class="list-inline-item">
                  <a href="#">
                    <i class="fab fa-linkedin-in"></i>
                  </a>
                </li>
              </ul>
            </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-8 mx-auto text-center">
          <p class="large text-muted">가나다라마바사가나다라마바사</p>
        </div>
      </div>
    </div>
  </section>

  <!-- Contact -->
  <section class="page-section" id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Contact Us</h2>
          <h3 class="section-subheading text-muted">궁금한 점, 불편한 점이 있으신가요? 저희에게 알려주세요.</h3>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <form id="contactForm" name="sentMessage" novalidate="novalidate">
            <div class="row">
              <div class="col-md-6">
                <div class="form-group">
                  <input class="form-control" id="name" type="text" placeholder="Your Name *" required="required" data-validation-required-message="Please enter your name.">
                  <p class="help-block text-danger"></p>
                </div>
                <div class="form-group">
                  <input class="form-control" id="email" type="email" placeholder="Your Email *" required="required" data-validation-required-message="Please enter your email address.">
                  <p class="help-block text-danger"></p>
                </div>
                <div class="form-group">
                  <input class="form-control" id="phone" type="tel" placeholder="Your Phone *" required="required" data-validation-required-message="Please enter your phone number.">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <textarea class="form-control" id="message" placeholder="Your Message *" required="required" data-validation-required-message="Please enter a message."></textarea>
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="clearfix"></div>
              <div class="col-lg-12 text-center">
                <div id="success"></div>
                <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">Send Message</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
  
  <script>
     var isOn = false;
     function chatButtonClick(){
        var chat=document.getElementsByClassName("chat_frame")[0]
        if(isOn){
           document.getElementsByClassName("chat_frame")[0].style.display='none';
           isOn=false;
        }
        else{
           document.getElementsByClassName("chat_frame")[0].style.display='block';
           document.getElementById("chat_img").src='image/talk.png';
           isOn=true;
        }
   }
  </script>
  
  <!-- Fixed chat frame -->
  <div class="chat_frame">
     <iframe src="http://172.30.3.171:18080/ch16-Websocket/web/chat.do" width="400" height="510"></iframe>
  </div>
  <div class="chat_button">
     <img id="chat_img" src="image/talk.png" onclick="chatButtonClick()">
  </div>
  
  <!-- Footer -->
  <footer class="footer">
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <span class="copyright">Copyright &copy; Your Website 2019</span>
        </div>

        <div class="col-md-4">
          <ul class="list-inline quicklinks">
            <li class="list-inline-item">
              <a href="#">Privacy Policy</a>
            </li>
            <li class="list-inline-item">
              <a href="#">Terms of Use</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Contact form JavaScript -->
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/agency.min.js"></script>

</body>

</html>

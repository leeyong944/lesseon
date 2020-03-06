<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Wines &mdash; Website Template by Colorlib</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  
  <link href="https://fonts.googleapis.com/css?family=Cinzel:400,700|Montserrat:400,700|Roboto&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="./Resource/fonts/icomoon/style.css">

  <link rel="stylesheet" href="./Resource/css/bootstrap.min.css">
  <link rel="stylesheet" href="./Resource/css/jquery-ui.css">
  <link rel="stylesheet" href="./Resource/css/owl.carousel.min.css">
  <link rel="stylesheet" href="./Resource/css/owl.theme.default.min.css">
  <link rel="stylesheet" href="./Resource/css/owl.theme.default.min.css">

  <link rel="stylesheet" href="./Resource/css/jquery.fancybox.min.css">

  <link rel="stylesheet" href="./Resource/css/bootstrap-datepicker.css">

  <link rel="stylesheet" href="./Resource/fonts/flaticon/font/flaticon.css">

  <link rel="stylesheet" href="./Resource/css/aos.css">
  <link href="./Resource/css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">

  <link rel="stylesheet" href="./Resource/css/style.css">
  <link rel="stylesheet" href="./Resource/css/popup.css">
  <script>
  	function loginCheck(){
  		<%if(session.getAttribute("login") == null ){%>
  			alert("로그인을 해주세요");
  		<%} else{%>
  			location.href="BoardWrite.jsp";
  		<%}%>
  	}
  </script>



</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

  <div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>


    
    <div class="header-top">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-12 text-center">
            <a href="index.html" class="site-logo">
              <img src="images/logo.png" alt="Image" class="img-fluid">
            </a>
          </div>
          <a href="#" class="mx-auto d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black"><span
                class="icon-menu h3"></span></a>
        </div>
      </div>
      


      
      <div class="site-navbar py-2 js-sticky-header site-navbar-target d-none pl-0 d-lg-block" role="banner">

      <div class="container">
        <div class="d-flex align-items-center">
          
          <div class="mx-auto">
            <nav class="site-navigation position-relative text-left" role="navigation">
              <ul class="site-menu main-menu js-clone-nav mx-auto d-none pl-0 d-lg-block border-none">
                <li class="active"><a href="MainPage.jsp" class="nav-link text-left">Home</a></li>
                <li><a href="About.jsp" class="nav-link text-left">About</a></li>
                <li><a href="productList" class="nav-link text-left">Shop</a></li>
                <li><a href="productQnA" class="nav-link text-left">QnA</a></li>
                 <li class="nav-link text-left">&nbsp;</li>
                 <li class="nav-link text-left">&nbsp;</li>
                 <li class="nav-link text-left">&nbsp;</li>
                 <%if(session.getAttribute("login") == null ){%>
                 <li id="popup_open"><a href="#layer2" class="btn-example">Login</a></li>
                <li><a href="JoinForm.jsp" class="nav-link text-left">Sign Up</a></li>
                <%} else{ %>
                <li>${sessionScope.login}님</li>
                <li><a href="#" class="nav-link text-left">My Page</a></li>
                <li><a href="memberLogout" class="nav-link text-left">Logout</a></li>
                <c:if test="${sessionScope.login eq 'admin'}">
					<li><a href="AdminPage.jsp" class="nav-link text-left">AdminPage</a></li>
				</c:if>
                <%} %> 
              </ul>                                                                                                                                                                                                                                                                                         
            </nav>

          </div>
         
        </div>
      </div>

    </div>
    
    </div>

    <div class="dim-layer">
    <div class="dimBg"></div>
    <div id="layer2" class="pop-layer">
        <div class="pop-container">
            <div class="pop-conts">
     <div class="container">
      	<div class="row">
        	<div class="col-md-3">
          		<div class="login-box well">
        			<form role="form" method="post" action="memberLogin">
            			<legend>로그인</legend>
            			<div class="form-group">
                			<label for="username-email">아이디</label>
                			<input name="m_id" id="username-email" placeholder="ID" type="text" class="form-control" style="width:400px" />
            			</div>
            			<div class="form-group">
                			<label for="password">비밀번호</label>
                			<input name="m_pw" id="password" placeholder="Password" type="password" class="form-control" style="width:400px" />
            			</div>
            			<div class="form-group">
                			<input type="submit" class="btn btn-default btn-login-submit btn-block m-t-md" value="Login" />
            			</div>
        			</form>
          		</div>
        	</div>
      	</div>
    </div>
            <div class="btn-r">
            		<a href="JoinForm.jsp" class="btn-layerClose"> 회원가입</a>
                    <a href="#" class="btn-layerClose">Close</a>
                </div>
                <!--// content-->
            </div>
        </div>
    </div>
</div>
    

    <div class="hero-2" style="background-image: url('images/hero_2.jpg');">
     <div class="container">
        <div class="row justify-content-center text-center align-items-center">
          <div class="col-md-8">
            <span class="sub-title"></span>
            <h2>QnA</h2>
          </div>
        </div>
      </div>
    </div>


    <div class="site-section bg-light">
      <div class="container">
        <div class="row">

          <div class="col-lg-12">
            <div class="section-title mb-5">
              <h2>QnA</h2><br>
            </div>
                  <div class="row">
                      <table class="table">
                      	<tr>
                      		<td>글번호</td>
                      		<td>제목</td>
                      		<td>작성자</td>
                      		<td>작성일자</td>
                      	</tr>
                      	<c:forEach var="boardList" items="${boardList}">
                      		<tr>
                      			<td>${boardList.b_number}</td>
                      			<td><a href="boardView?b_number=${boardList.b_number}">(${boardList.b_categori})상품문의 드립니다.</a></td>
                      			<td>${boardList.id}</td>
                      			<td>${boardList.b_date}</td>
                      		</tr>
                      	</c:forEach>
                      
                      </table>
                  </div>
                  <a href="#" onclick="loginCheck()" class="btn btn-default">상품문의하기</a>
    <div class="row mb-5">
          <div class="col-12 section-title text-center mb-5">              
    		<c:if test="${paging.page<=1}">
			[이전]&nbsp;
			</c:if>
			<c:if test="${paging.page>1}">
				<a href="boardListPaging?page=${paging.page-1}">[이전]</a>&nbsp;
			</c:if>
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
				<c:choose>
					<c:when test="${i eq paging.page}">
						${i}
					</c:when>
					<c:otherwise>
						<a href="boardListPaging?page=${i}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		
			<c:if test="${paging.page>=paging.maxPage}">
				[다음]
			</c:if>
			<c:if test="${paging.page<paging.maxPage}">
				<a href="boardListPaging?page=${paging.page+1}">[다음]</a>
			</c:if>
		</div>
	</div>
              
           
          </div>
          
        </div>

        
      </div>
    </div>

  

    
    
    <div class="footer">
      <div class="container">
        
        <div class="row">
          <div class="col-12 text-center">
            <div class="social-icons">
              <a href="#"><span class="icon-facebook"></span></a>
              <a href="#"><span class="icon-twitter"></span></a>
              <a href="#"><span class="icon-youtube"></span></a>
              <a href="#"><span class="icon-instagram"></span></a>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <div class="copyright">
                <p>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>



            </div>
          </div>
        </div>
      </div>
    </div>
    

  </div>
  <!-- .site-wrap -->


  <!-- loader -->
  <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#ff5e15"/></svg></div>

  <script src="./Resource/js/jquery-3.3.1.min.js"></script>
  <script src="./Resource/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="./Resource/js/jquery-ui.js"></script>
  <script src="./Resource/js/popper.min.js"></script>
  <script src="./Resource/js/bootstrap.min.js"></script>
  <script src="./Resource/js/owl.carousel.min.js"></script>
  <script src="./Resource/js/jquery.stellar.min.js"></script>
  <script src="./Resource/js/jquery.countdown.min.js"></script>
  <script src="./Resource/js/bootstrap-datepicker.min.js"></script>
  <script src="./Resource/js/jquery.easing.1.3.js"></script>
  <script src="./Resource/js/aos.js"></script>
  <script src="./Resource/js/jquery.fancybox.min.js"></script>
  <script src="./Resource/js/jquery.sticky.js"></script>
  <script src="./Resource/js/jquery.mb.YTPlayer.min.js"></script>




  <script src="./Resource/js/main.js"></script>
  <script src="./Resource/js/popup.js"></script>

</body>

</html>
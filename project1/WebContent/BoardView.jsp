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
  	function boardDelete(){
  		var passConfirm = prompt('비밀번호를 입력하세요');
		var password = '${boardView.b_password}';
		if(password == passConfirm){
			location.href='boardDelete?b_number=${boardView.b_number}';
		} else{
			alert('비밀번호가 틀립니다');
		}
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
              <h2>답변</h2>
            </div>
              
                  <div class="row">
                      <div class="col-md-6 form-group">
                          <label for="id">작성자</label>
                          <input type="text" class="form-control form-control-lg" value="${boardView.id}" readonly>
                      </div>
                      <div class="col-md-6 form-group">
                          <label for="b_password">작성시간</label>
                          <input type="text" value="${boardView.b_date}" class="form-control form-control-lg" readonly>
                      </div>
                  </div>
                  <div class="row">
                      <div class="col-md-6 form-group">
                          <label for="b_categori">문의상품</label>
                          <input type="text" class="form-control form-control-lg" value="${boardView.b_categori}" readonly>
                      </div>
                      <div class="col-md-6 form-group">
                      </div>
                  </div>
                  <div class="row">
                      <div class="col-md-12 form-group">
                          <label for="b_contents">내용</label>
                          <textarea cols="30" rows="10" class="form-control" readonly>${boardView.b_contents}</textarea>
                      </div>
                  </div>

                  <div class="row">
                      <div class="col-12">
                          <button onclick="location.href='productQnA'" class="btn btn-primary py-3 px-5">게시판으로</button>
                          <c:if test="${sessionScope.login eq boardView.id}">
                          <button onclick="location.href='boardModify?b_number=${boardView.b_number}'">수정하기</button>
                          <button onclick="boardDelete()">삭제하기</button>
                          </c:if>
                          <c:if test="${sessionScope.login eq 'admin'}">
                          <button onclick="location.href='boardDelete?b_number=${boardView.b_number}'">삭제하기</button>
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
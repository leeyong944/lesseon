<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String p_number = request.getParameter("p_number");
	String page1 = request.getParameter("page");
%>

	<div style="text-align: center">
	<div style="float:left">
		<img src="./Resource/images/19.jpg">
	</div>
	<div style="float:left">
		<h3><string>이 정보내용은 청소년 유해 매채물로서</string></h3>
		<h3><string>정보통신망 이용촉진법 및 정보보호 등에 관한</string></h3>
		<h3><string>법률 및 청소년 보호법 규정에 의하여</string></h3>
		<h3 style="color:red; display: inline-block" ><string>19세 미만의 청소년</string></h3>
		<h3 style="display: inline-block"><string>은 사용할 수 없습니다.</string></h3><br>
		<button onclick="location.href='productList'" style="width:200px; height:50px; font-size:15px;">19세 미만 나가기</button><br><br>
		<a  id="popup_open" href="#layer2" class="btn-example">성인인증하기</a>
	</div>
	</div>
	
	<div class="dim-layer">
    <div class="dimBg"></div>
    <div id="layer2" class="pop-layer">
        <div class="pop-container">
            <div class="pop-conts">
     <div class="container">
      	<div class="row">
        	
          		<div class="login-box well">
        			<form role="form" method="post" action="productView" id="viewForm" name="viewForm">
            			<legend>성인인증</legend>
            			<div class="form-group">
                			<label for="umun1">주민등록번호</label><br>
                			<input name="unum1" id="unum1" type="text" maxlength="6"/><span>&nbsp-</span>
                			<span><input name="unum2" id="unum2" type="password" maxlength="7"/></span>
            			</div>
            			<div class="form-group">
            				<input type="hidden" value="<%=p_number%>" name="p_number">
            				<input type="hidden" value="<%=page1%>" name="page">
                			<input type="button" class="btn btn-default btn-login-submit btn-block m-t-md" value="검사" onclick="validate()" />
            			</div>
        			</form>
          		</div>
        	
      	</div>
    </div>
            <div class="btn-r">
                    <a href="#" class="btn-layerClose">Close</a>
                </div>
                <!--// content-->
            </div>
        </div>
    </div>
</div>


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
  <script src="./Resource/js/popup.js"></script>
  <script src="./Resource/js/certification.js"></script>



  <script src="./Resource/js/main.js"></script>
</body>
</html>
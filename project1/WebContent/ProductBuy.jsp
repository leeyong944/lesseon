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
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="./Resource/js/join.js"></script>  



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
                <li class="dropdown"><a href="#" class="nav-link text-left dropdown-toggle" id="dropdown01" data-toggle="dropdown">My Page</a>
                	<div class="dropdown-menu" aria-labelledby="dropdown01">
                		<a class="dropdown-item" href="memberModify?id=${sessionScope.login}">회원정보 수정</a>
                		<a class="dropdown-item" href="productCartList?id=${sessionScope.login}">장바구니</a>
                		<a class="dropdown-item" href="#">주문 내역확인</a>
                		<a class="dropdown-item" href="memberLogout">로그아웃</a>
                	</div>
                </li>
                <li><a href="memberLogout" class="nav-link text-left">Logout</a></lis>
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

    
    
    
      
    
<form action="productOrder" method="post">
    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-12">
            <div class="bg-light rounded p-3">
              <p class="mb-0">Returning customer? <a href="#" class="d-inline-block">Click here</a> to login</p>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 mb-5 mb-md-0">
            <h2 class="h3 mb-3 text-black font-heading-serif">Billing Details</h2>
            <div class="p-3 p-lg-5 border">
              <div class="form-group row">
                <div class="col-md-12">
                  <label for="c_fname" class="text-black">이름 <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="m_name" name="m_name" value="${memberDTO.name}">
                </div>
              </div>
    
              <div class="form-group row">
                <div class="col-md-12">
                  <label for="m_tel" class="text-black">전화번호 </label>
                  <input type="text" class="form-control" id="m_tel" name="m_tel" value="${memberDTO.tel}">
                </div>
              </div>
    
              <div class="form-group row">
                <div class="col-md-12">
                  <label for="c_diff_address" class="text-black">배송지 <span class="text-danger">*</span></label>
                        <input name="m_address1" class="form-control" type="text" id="sample4_postcode" value="${memberDTO.address1}">
						<input name="m_address2" class="form-control" type="text" id="sample4_roadAddress" value="${memberDTO.address2}">
						<input name="m_address3" class="form-control" type="text" id="sample4_jibunAddress" value="${memberDTO.address3}">
						<span id="guide" style="color:#999;display:none"></span>
						<input name="m_address4" class="form-control" type="text" id="sample4_detailAddress" onkeyup="creatAddress()" value="${memberDTO.address4}">
						<input name="m_address5" class="form-control" type="text" id="sample4_extraAddress" value="${memberDTO.address5}">
						<input type="button" onclick="sample4_execDaumPostcode()" value="주소 변경">
						<input type="button" onclick="changeAddress()" value="배송예상시간">

                </div>
              </div>
    
              <div class="form-group">
                <label for="c_order_notes" class="text-black">배송 요청사항</label>
                <textarea name="c_order_notes" id="c_order_notes" cols="30" rows="10" class="form-control"
                  placeholder="요청사항을 적어주세요."></textarea>
              </div>
              
              <div class="form-group">
              	<p style="margin-top:-12px">
    			<em class="link">
        			<a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
            			혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
        			</a>
    			</em>
			</p>
			<div id="map" style="width:100%;height:350px;"></div>
			
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ccec25535cd8b557c726c143de2f006b&libraries=services"></script>
			<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    			mapOption = {
        			center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        			level: 8 // 지도의 확대 레벨
    			};  
			
			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 
			
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
			
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch('인천 미추홀구 매소홀로488번길 6-32', function(result, status) {
			
    			// 정상적으로 검색이 완료됐으면 
     			if (status === kakao.maps.services.Status.OK) {
			
        			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
        			// 결과값으로 받은 위치를 마커로 표시합니다
        			var marker = new kakao.maps.Marker({
            			map: map,
            			position: coords
        			});
			
        			// 인포윈도우로 장소에 대한 설명을 표시합니다
        			var infowindow = new kakao.maps.InfoWindow({
            			content: '<div style="width:150px;text-align:center;padding:6px 0;">배송출발지</div>'
        			});
        			infowindow.open(map, marker);
			
        			// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        			map.setCenter(coords);
    			} 
			});
			
			
			function changeAddress(){
			//주소값 좌표로
			var geocoder = new kakao.maps.services.Geocoder();
			var address = document.getElementById("sample4_roadAddress").value;
			var x,y = "";
			var distance;
			var callback = function(result, status) {
			    if (status === kakao.maps.services.Status.OK) {
			        console.log(result);
			        var coords1 = new daum.maps.LatLng(result[0].y,result[0].x);
					y = result[0].x;
					x = result[0].y;
					console.log(x);
					console.log(y);
					var linePath = [
					    new kakao.maps.LatLng(37.4388938204128, 126.675113024566),
					    new kakao.maps.LatLng(x, y)
					];
					var polyline = new kakao.maps.Polyline({
					    path: linePath, // 선을 구성하는 좌표배열 입니다
					    strokeWeight: 5, // 선의 두께 입니다
					    strokeColor: '#FFAE00', // 선의 색깔입니다
					    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
					    strokeStyle: 'solid' // 선의 스타일입니다
					});
					
					polyline.setMap(map);
					
					var marker1 = new kakao.maps.Marker({
            			map: map,
            			position: coords1
        			});
					
					var infowindow = new kakao.maps.InfoWindow({
            			content: '<div style="width:150px;text-align:center;padding:6px 0;">배송예상기간 2일</div>'
        			});
        			infowindow.open(map, marker1);
        			
        			
			    }
			};

			geocoder.addressSearch(address, callback);
			}
			</script>
              </div>
              
              
            </div>
          </div>
          
          
          <div class="col-md-6">
    
            <div class="row mb-5">
              <div class="col-md-12">
                <h2 class="h3 mb-3 text-black font-heading-serif">Coupon Code</h2>
                <div class="p-3 p-lg-5 border">
    
                  <label for="c_code" class="text-black mb-3">Enter your coupon code if you have one</label>
                  <div class="input-group w-75">
                    <input type="text" class="form-control" id="c_code" placeholder="Coupon Code" aria-label="Coupon Code"
                      aria-describedby="button-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary btn-sm rounded px-4" type="button" id="button-addon2">Apply</button>
                    </div>
                  </div>
    
                </div>
              </div>
            </div>
    
            <div class="row mb-5">
              <div class="col-md-12">
                <h2 class="h3 mb-3 text-black font-heading-serif">Your Order</h2>
                <div class="p-3 p-lg-5 border">
                  <table class="table site-block-order-table mb-5">
                    <thead>
                      <th>Product</th>
                      <th>Total</th>
                    </thead>
                   
                    <tbody>
                     <c:forEach var="cartList" items="${cartList}">
                      <tr>
                        <td>${cartList.p_name} <strong class="mx-2">x</strong> 1</td>
                        <td>${cartList.p_price}</td>
                      </tr>
                      </c:forEach>

                      <tr>
                        <td class="text-black font-weight-bold"><strong>Cart Subtotal</strong></td>
                        <td class="text-black">$350.00</td>
                      </tr>
                      <tr>
                        <td class="text-black font-weight-bold"><strong>Order Total</strong></td>
                        <td class="text-black font-weight-bold"><strong>$350.00</strong></td>
                      </tr>
                    </tbody>
                  </table>
    
                  <div class="border mb-3 p-3 rounded">
                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsebank" role="button"
                        aria-expanded="false" aria-controls="collapsebank">Direct Bank Transfer</a></h3>
    
                    <div class="collapse" id="collapsebank">
                      <div class="py-2 pl-0">
                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the
                          payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                      </div>
                    </div>
                  </div>
    
                  <div class="border mb-3 p-3 rounded">
                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsecheque" role="button"
                        aria-expanded="false" aria-controls="collapsecheque">Cheque Payment</a></h3>
    
                    <div class="collapse" id="collapsecheque">
                      <div class="py-2 pl-0">
                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the
                          payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                      </div>
                    </div>
                  </div>
    
                  <div class="border mb-5 p-3">
                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsepaypal" role="button"
                        aria-expanded="false" aria-controls="collapsepaypal">Paypal</a></h3>
    
                    <div class="collapse" id="collapsepaypal">
                      <div class="py-2 pl-0">
                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the
                          payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                      </div>
                    </div>
                  </div>
    
                  <div class="form-group">
                    <button class="btn btn-primary btn-lg btn-block" onclick="window.location='thankyou.html'">주문하기</button>
                  </div>
    
                </div>
              </div>
            </div>
    
          </div>
        </div>
        <!-- </form> -->
      </div>
    </div>
 </form>

    
    
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

</body>

</html>
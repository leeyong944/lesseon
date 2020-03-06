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
	<script>
		function add(){
			var p_price = document.getElementById("p_price").value;
			var c_quantity = document.getElementById("c_quantity").value;
			c_quantity = Number(c_quantity);
			console.log(p_price);
			console.log(c_quantity);
			document.getElementById("sum").value = p_price * (c_quantity+1);
		}
		function del(){
			var p_price = document.getElementById("p_price").value;
			var c_quantity = document.getElementById("c_quantity").value;
			c_quantity = Number(c_quantity);
			console.log(p_price);
			console.log(c_quantity);
			document.getElementById("sum").value = p_price * (c_quantity-1);
		}
		function buy(){
			buyForm.submit();
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
                <li class="dropdown"><a href="#" class="nav-link text-left dropdown-toggle" id="dropdown01" data-toggle="dropdown">My Page</a>
                	<div class="dropdown-menu" aria-labelledby="dropdown01">
                		<a class="dropdown-item" href="memberModify?id=${sessionScope.login}">회원정보 수정</a>
                		<a class="dropdown-item" href="#">장바구니</a>
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

    
    
    

      
    

    <div class="site-section  pb-0">
      <div class="container">
        <div class="row mb-5 justify-content-center">
          <div class="col-7 section-title text-center mb-5">
            <h2 class="d-block">Cart</h2>
          </div>
        </div>
        <div class="row mb-5">
          <form class="col-md-12" method="post" action="productBuy?id=${sessionScope.login}" id="buyForm">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th class="product-thumbnail">Image</th>
                    <th class="product-name">Product</th>
                    <th class="product-price">Price</th>
                    <th class="product-quantity">Quantity</th>
                    <th class="product-total">Total</th>
                    <th class="product-remove">Remove</th>
                  </tr>
                </thead>
                <c:forEach var="cartList" items="${cartList}" varStatus="status">
                <tbody onload="init()">
                  <tr>
                    <td class="product-thumbnail">
                      <img src="./Resource/images/${cartList.p_file}" alt="Image" class="img-fluid">
                    </td>
                    <td class="product-name">
                      <h2 class="h5 cart-product-title text-black">${cartList.p_name}</h2>
                    </td>
                    <td><input type="hidden" value="${cartList.p_price}" id="p_price">${cartList.p_price}</td>
                    <td>
                      <div class="input-group mb-3" style="max-width: 120px;">
                        <div class="input-group-prepend">
                          <button class="btn btn-outline-primary js-btn-minus" type="button" onclick="del()">&minus;</button>
                        </div>
                        <input type="text" class="form-control text-center border mr-0" value="1" placeholder=""
                          aria-label="Example text with button addon" aria-describedby="button-addon1" id="c_quantity" name="c_quantity"
                          >
                        <div class="input-group-append">
                          <button class="btn btn-outline-primary js-btn-plus" type="button" onclick="add()">&plus; </button>
                        </div>
                      </div>
    				
                    </td>
                    <td><input type="text" id="sum" value="${cartList.p_price}" readonly >원</td>
                    <td><a href="#" class="btn btn-primary height-auto btn-sm">X</a></td>
                  </tr>
                </tbody>
   				 </c:forEach>
   				 
                  
              </table>
            </div>
          </form>
        </div>
    
      </div>
    </div>

    <div class="site-section pt-5 bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <div class="row mb-5">
              <div class="col-md-6 mb-3 mb-md-0">
                <button class="btn btn-primary btn-md btn-block">Update Cart</button>
              </div>
              <div class="col-md-6">
                <button class="btn btn-outline-primary btn-md btn-block">Continue Shopping</button>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <label class="text-black h4" for="coupon">Coupon</label>
                <p>Enter your coupon code if you have one.</p>
              </div>
              <div class="col-md-8 mb-3 mb-md-0">
                <input type="text" class="form-control py-3" id="coupon" placeholder="Coupon Code">
              </div>
              <div class="col-md-4">
                <button class="btn btn-primary btn-md px-4">Apply Coupon</button>
              </div>
            </div>
          </div>
          <div class="col-md-6 pl-5">
            <div class="row justify-content-end">
              <div class="col-md-7">
                <div class="row">
                  <div class="col-md-12 text-right border-bottom mb-5">
                    <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                  </div>
                </div>
                <div class="row mb-3">
                  <div class="col-md-6">
                    <span class="text-black">Subtotal</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong class="text-black">$230.00</strong>
                  </div>
                </div>
                <div class="row mb-5">
                  <div class="col-md-6">
                    <span class="text-black">Total</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong class="text-black">$230.00</strong>
                  </div>
                </div>
    
                <div class="row">
                  <div class="col-md-12">
                    <button class="btn btn-primary btn-lg btn-block" onclick="buy()">구매하기</button>
                  </div>
                </div>
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

</body>

</html>
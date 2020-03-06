<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="./Resource/css/booStstrap.css"/>
	<link rel="stylesheet" href="./Resource/css/bootstrap.min.css">
    <link rel="stylesheet" href="./Resource/css/style.css">
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="./Resource/js/join.js"></script>    
    <script src="https://kit.fontawesome.com/b6a8e68f57.js" crossorigin="anonymous"></script>
    <script>
    	function main(){
    		location.href = "MainPage.jsp";
    	}
    	
    	function modify(){
    		var jf = document.joinForm;
    		var password1 = document.getElementById("inputPassword").value;
    		var password = '${memberView.pw}'
    		if(password != password1){
    			alert("비밀번호가 틀렸습니다")
    		}else if(jf.m_id.value==""||jf.m_pw.value==""||jf.m_pw1.value==""||jf.m_name.value==""||jf.m_address4.value==""||jf.m_tel.value==""||jf.m_email.value==""){
    			alert("필수 입력란이 비었습니다. 확인해 주세요.");
    		}else{
    			modifyForm.submit();
    		}
		}
    </script>
</head>
<body>
	<article class="container">
            <div class="page-header">
                <div class="col-md-5 col-md-offset-3">
                <h3>회원가입</h3>
                </div>
            </div>
            <div class="col-sm-5 col-md-offset-3">
                <form role="form" action="memberModifyProcess" method="post" id="modifyForm" name="joinForm">
                    <div class="form-group">
                        <label for="inputId">아이디</label>
                        <input name="m_id" type="text" class="form-control" id="inputId" onkeyup="creatId()" value="${memberView.id}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">이전비밀번호</label>
                        <input name="m_pw" type="password" class="form-control" id="inputPassword" onkeyup="creatPw()" placeholder="현재 비밀번호">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordCheck">변경비밀번호</label>
                        <input name="m_pw1" type="password" class="form-control" id="inputPasswordCheck" onkeyup="creatPw1()" placeholder="변경하실 비밀번호">
                    </div>
                    <div class="form-group">
                        <label for="inputName">이름</label>
                        <input name="m_name" type="text" class="form-control" id="inputName" onkeyup="creatName()" value="${memberView.name}">
                    </div>
                    <div class="form-group">
                    	<label for="sample4_postcode">주소</label><br>
                    	<input name="m_address1" type="text" id="sample4_postcode" value="${memberView.address1}" }>
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						<input name="m_address2" type="text" id="sample4_roadAddress" value="${memberView.address2}">
						<input name="m_address3" type="text" id="sample4_jibunAddress" value="${memberView.address3}">
						<span id="guide" style="color:#999;display:none"></span>
						<input name="m_address4" type="text" id="sample4_detailAddress" onkeyup="creatAddress()" value="${memberView.address4}">
						<input name="m_address5" type="text" id="sample4_extraAddress" value="${memberView.address5}">
                    </div>
                    <div class="form-group">
                        <label for="inputTel">휴대전화</label>
                        <input name="m_tel" type="tel" class="form-control" id="inputTel" onkeyup="creatTel()" value="${memberView.tel}">
                    </div>
                     <div class="form-group">
                        <label for="inputGender">성별</label><br>
                        <input name="m_gender" type="radio" name="gender" value="남자" checked>남자 
                        <input name="m_gender" type="radio" name="gender" value="여자">여자
                    </div>
                    <div class="form-group">
                        <label for="inputEmail">이메일</label>
                        <input name="m_email" type="text" class="form-control" id="inputEmail" onkeyup="creatEmail()" value="${memberView.email}">
                    </div>

				</form>
				<div class="form-group text-center">
                        <button onclick="modify()" class="btn btn-primary">
                            	수정완료
                        </button>
                        <button onclick="main()" class="btn btn-warning">
                            	수정취소
                        </button>
                    </div>
             </div>
              

        </article>
</body>
</body>
</html>
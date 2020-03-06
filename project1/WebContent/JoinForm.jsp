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
    	
    	function join(){
    		var jf = document.joinForm;
    		if(jf.m_id.value==""||jf.m_pw.value==""||jf.m_pw1.value==""||jf.m_name.value==""||jf.m_address4.value==""||jf.m_birth.value==""||jf.m_tel.value==""||jf.m_email.value==""){
    			alert("필수 입력란이 비었습니다. 확인해 주세요.");
    		}else{
    			joinForm.submit();
    		}
		}
    </script>
    <style>
    	#joinForm .help-block{
    	display: none;}
    	#joinForm .glyphicon{
    	display: none;}
    </style>
</head>
<body>
	<article class="container">
            <div class="page-header">
                <div class="col-md-5 col-md-offset-3">
                <h3>회원가입</h3>
                </div>
            </div>
            <div class="col-sm-5 col-md-offset-3">
                <form role="form" action="memberJoin" method="post" id="joinForm" name="joinForm">
                    <div class="form-group">
                        <label for="inputId">아이디</label>
                        <input name="m_id" type="text" class="form-control" id="inputId" minlength="6" maxlength="10" onkeyup="creatId()" placeholder="아이디을 입력해 주세요">
                        <span id="overlapErr" class="help-block">사용할 수 없는 아이디 입니다.</span>
            			<span class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">비밀번호</label>
                        <input name="m_pw" type="password" class="form-control" id="inputPassword" onkeyup="creatPw()" placeholder="비밀번호를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordCheck">비밀번호 확인</label>
                        <input name="m_pw1" type="password" class="form-control" id="inputPasswordCheck" onkeyup="creatPw1()" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputName">이름</label>
                        <input name="m_name" type="text" class="form-control" id="inputName" onkeyup="creatName()" placeholder="이름을 입력해주세요">
                    </div>
                    <div class="form-group">
                    	<label for="sample4_postcode">주소</label><br>
                    	<input name="m_address1" type="text" id="sample4_postcode" placeholder="우편번호">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						<input name="m_address2" type="text" id="sample4_roadAddress" placeholder="도로명주소">
						<input name="m_address3" type="text" id="sample4_jibunAddress" placeholder="지번주소">
						<span id="guide" style="color:#999;display:none"></span>
						<input name="m_address4" type="text" id="sample4_detailAddress" onkeyup="creatAddress()" placeholder="상세주소">
						<input name="m_address5" type="text" id="sample4_extraAddress" placeholder="참고항목">
                    </div>
                    <div class="form-group">
                        <label for="inputBirth">생일</label>
                        <input name="m_birth" type="date" class="form-control" id="inputBirth" onkeyup="creatBirth()" placeholder="생년월일을 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputTel">휴대전화</label>
                        <input name="m_tel" type="tel" class="form-control" id="inputTel" onkeyup="creatTel()" placeholder="핸드폰번호를 입력해 주세요">
                    </div>
                     <div class="form-group">
                        <label for="inputGender">성별</label><br>
                        <input name="m_gender" type="radio" name="gender" value="남자" checked>남자 
                        <input name="m_gender" type="radio" name="gender" value="여자">여자
                    </div>
                    <div class="form-group">
                        <label for="inputEmail">이메일</label>
                        <input name="m_email" type="text" class="form-control" id="inputEmail" onkeyup="creatEmail()" placeholder="이메일을 입력해 주세요">
                    </div>

                    <div class="form-group">
                    <label>약관 동의</label>
                    <div data-toggle="buttons">
                    <label class="btn btn-primary active">
                    <span class="fa fa-check"></span>
                    <input id="agree" type="checkbox" autocomplete="off" checked>
                    </label>
                    <a href="#">이용약관</a>에 동의합니다.
                    </div>
                    </div>
				</form>
				<div class="form-group text-center">
                        <button onclick="join()" class="btn btn-primary">
                            	회원가입
                        </button>
                        <button onclick="main()" class="btn btn-warning">
                            	가입취소
                        </button>
                    </div>
             </div>
              

        </article>
</body>
</body>
</html>
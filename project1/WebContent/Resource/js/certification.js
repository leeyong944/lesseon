function validate(){
	

        var num1 = document.getElementById("unum1");
        var num2 = document.getElementById("unum2");

        var arrNum1 = new Array(); // 주민번호 앞자리숫자 6개를 담을 배열
        var arrNum2 = new Array(); // 주민번호 뒷자리숫자 7개를 담을 배열

        // -------------- 주민번호 -------------

        for (var i=0; i<num1.value.length; i++) {
            arrNum1[i] = num1.value.charAt(i);
        } // 주민번호 앞자리를 배열에 순서대로 담는다.

        for (var i=0; i<num2.value.length; i++) {
            arrNum2[i] = num2.value.charAt(i);
        } // 주민번호 뒷자리를 배열에 순서대로 담는다.

        var tempSum=0;

        for (var i=0; i<num1.value.length; i++) {
            tempSum += arrNum1[i] * (2+i);
        } // 주민번호 검사방법을 적용하여 앞 번호를 모두 계산하여 더함

        for (var i=0; i<num2.value.length-1; i++) {
            if(i>=2) {
                tempSum += arrNum2[i] * i;
            }
            else {
                tempSum += arrNum2[i] * (8+i);
            }
        } // 같은방식으로 앞 번호 계산한것의 합에 뒷번호 계산한것을 모두 더함

        if((11-(tempSum%11))%10!=arrNum2[6]) {
            alert("올바른 주민번호가 아닙니다.");
            num1.value = "";
            num2.value = "";
            num1.focus();
            return false;
        }else{
        	viewForm.submit();
        }
    }

    function check(re, what, message) {
        if(re.test(what.value)) {
            return true;
        }
        alert(message);
        what.value = "";
        what.focus();
        //return false;
    }
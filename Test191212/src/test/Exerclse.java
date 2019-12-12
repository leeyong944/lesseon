package test;

public class Exerclse {

	public static void main(String[] args) {
		// 배열 new 연산자 이용하기
		int number = 1;
		int[] num = null; // 실질적인 배열이아님 이름만 선언했기때문에 배열로서 작동하려면 new 연산자 필요.
		num = new int[2]; //여기서 2라고선언을했지만 밑에 if문에서 다시 new연산자활용 3이라 선언하여 배열이초기화되서 새로운
		num[0] = 1;             //new 연산자활용 배열선언한게 출력됨
		if(number == 1) {       //null을 활용하여 같은이름의 여러개의 배열 선언 활용가능
			num = new int[3];
			System.out.println(num.length);
			System.out.println(num[0]);
		}else {
			System.out.println(num.length);
			System.out.println(num[0]);
		}

	}

}

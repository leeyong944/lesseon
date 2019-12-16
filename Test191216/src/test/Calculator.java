package test;

public class Calculator {

	// 메소드 선언
	// 덧셈, 뺄셈, 나눗셈, 곱셈 메소드 각각 선언
	
	int sum(int num1, int num2) { //리턴타입 , 메소드이름, 매개변수
		int result = num1 + num2;
		return result; //리턴타입&리턴문 타입이 같아야함 int면 int  double이면 double
	}
	
	//void == 리턴이없다 (비어있는)
	void sum1(int num1, int num2, int num3) {
		int result = num1 + num2 + num3;
		System.out.println("Calculator 클래스" + result);
	}



}

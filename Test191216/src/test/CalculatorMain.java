package test;

public class CalculatorMain {

	public static void main(String[] args) {
		//Calculator 클래스의 객체 생성
		Calculator ca = new Calculator();
		int sumResult = ca.sum(1,4);
		System.out.println(sumResult);
		System.out.println(ca.sum(1,3));
		
		//리턴이 없는 메소드 
		ca.sum1(1, 2, 3);

	}

}

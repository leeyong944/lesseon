package test191223;

public class Computer extends Calculator {
	//리턴타입이 int 인 calculation 메소드 정의
	// 매개변수는 정수2개, 정수2개의 평균값을 리턴
	
	//override : 메소드재정의
	
	@Override
	//Annotation(어노테이션, 애노테이션)
	int calculation(int x, int y) {
		//부모 클래스의 메소드 호출(재정의 되지 않은)
		System.out.println(super.calculation(x, y));
		
		System.out.println("Computer의 메소드 호출");
		return (x+y)/2;
	}
	
	

}

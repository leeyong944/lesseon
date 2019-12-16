package test;

public class CarMain {

	public static void main(String[] args) {
		//절차지향
		//  ↕
		//객체지향 프로그래밍(OOP=Object Oriented Programming)(부품화)
		//클래스를 객체화(new)해서 씀
		//ex) Scanner class 스캐너라는 클래스를 new scanner 해서 씀.
		
		// car 클래스를 객체로 선언
		Car car = new Car();
		// 객체 선언 문법
		// 클래스이름 객체이름 = new 클래스이름();
		//                     생성자이름(); (기본생성자)
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = null; //Car 클래스에 cr3 이라는 변수를 선언한다.
		car3 = new Car();
		// Car 클래스에 있는 필드 사용.
		car.color = "검정";
		System.out.println(car.color);
		System.out.println(car.speed);
		System.out.println(car1.color);
		System.out.println(car2.color);
		System.out.println(car3.color);
		
		car.company = "BMW";
		System.out.println(car.company);
		System.out.println(car1.company);
		System.out.println(car2.company);
		System.out.println(car3.company);
		
		car.speed = 100;
		int speedUp = car.speed + 50;
		System.out.println(speedUp);
		
		System.out.println(car.type);
		
		// 매개변수가 있는 생성자를 호출하여 객체 선언
		Car car4 = new Car("빨강", 150);
		// car4 객체가 가지고 있는 필드값 모두 출력
		System.out.println(car4.color);
		System.out.println(car4.speed);
		System.out.println(car4.type);
		System.out.println(car4.model);
		System.out.println(car4.company);
		
		//Car 클래스에 color와 company를 매개변수로 하는
		//생성자를 선언하고
		//main 클래스에서 이 생성자를 이용하여 객체를 선언후
		//전체 필드값 출력
		
		Car car5 = new Car("검정","페라리");
		
		System.out.println(car5.color);
		System.out.println(car5.speed);
		System.out.println(car5.type);
		System.out.println(car5.model);
		System.out.println(car5.company);
		
		System.out.println(car5.toString()); //toString 이라는 메소드를 호출했다.
		
		/* car 클래스의 모든 필드를 매개값으로 하는 생성자를 선언하고
		 * 이 생성자 호출로 객체를 선언하여 모든 필드값 출력
		 */
		System.out.println("------------------------------------");
		Car car6 = new Car("빨강",292,"하이브리드","4.0 v8","포르쉐");
		
		System.out.println(car6.toString());
	}

}

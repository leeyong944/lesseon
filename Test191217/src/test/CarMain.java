package test;

import java.util.Scanner;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car();
		Scanner scan = new Scanner(System.in);
		System.out.print("가스량을 입력해 주세요 : ");
		int gas = scan.nextInt();
		scan.close();
		car.setGas(gas);//입력된 가스량을 필드에 저장
		boolean gasState = car.isLeftGas();
		// 가스가 없으면 false로 출발안함 위에 필드에 가스값을 1이상으로 지정해놓으면
		// 가스가 있기때문에 true
		System.out.println(car.gas);//가스 잔량 표시
		if(gasState) { // gasState = true
			System.out.println("출발");
			car.run(); // gas != 0 아니기때문에 if 문실행
			           // car.run 메소드 와일문실행
			           // gas != 0 이 아니라는건 gas 값이 있다는거
			           // gas > 0 이기때문에 while 문에 if문 실행
			           // gas == 0 이 되면 else 메소드종료.
		}
		/*
		 * gas가 있습니다.
		 * 5
		 * 출발
		 * 달립니다. (gas 잔량:5)
		 * 달립니다. (gas 잔량:4)
		 * 달립니다. (gas 잔량:3)
		 * 달립니다. (gas 잔량:2)
		 * 달립니다. (gas 잔량:1)
		 * gas가 없습니다. 이게 들어갈까 안들아갈까? 안들어가넹 ㅎ;;
		 * car.run 메소드 와일문안에 없기때문에 안들어감.
		 * 멈춥니다. (gas 잔량:0)
		 */
		

	}

}

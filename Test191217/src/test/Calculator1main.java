package test;

import java.util.Scanner;

public class Calculator1main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculator1 cal = new Calculator1();
		int number = 0;
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------");
			System.out.println("1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택>");
			number = scan.nextInt();
			switch(number) {
			case 1:
				System.out.println("덧셈 결과는 : "+cal.sum(5, 5));
				break;
			case 2:
				System.out.println("뺄셈 결과는 : "+cal.subtract(5, 5));
				break;
			case 3:
				System.out.println("곱셈 결과는 : "+cal.multiply(5, 5));
				break;
			case 4:
				System.out.println("나눗셈 결과는 : "+cal.divide(5, 5));
				break;
			case 5:
				System.out.println("프로그램 종료.");
				run = false;
			}
		}

	}

}

package test;

import java.util.Scanner;

public class Calculator2Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculator2 cal = new Calculator2();
		boolean run = true;
		int number = 0;
		while(run) {
			System.out.println("-------------------------------------");
			System.out.println("1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택>");
			number = scan.nextInt();			
			if(number == 1) {
				System.out.print("두 숫자를 입력하세요>");
				int num1=scan.nextInt();
				int num2=scan.nextInt();
				cal.add(num1, num2);
			} else if(number == 2) {
				System.out.print("두 숫자를 입력하세요>");
				int num1=scan.nextInt();
				int num2=scan.nextInt();
				cal.subtract(num1, num2);
			} else if(number == 3) {
				System.out.print("두 숫자를 입력하세요>");
				int num1=scan.nextInt();
				int num2=scan.nextInt();
				cal.multiply(num1, num2);
			} else if(number == 4) {
				System.out.print("두 숫자를 입력하세요>");
				int num1=scan.nextInt();
				int num2=scan.nextInt();
				cal.divide(num1, num2);
			} else if(number == 5) {
				System.out.println("프로그램 종료.");
				break;
			}
			
			
		}
		
	}

}

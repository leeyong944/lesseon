package test;

import java.util.Scanner;

public class Calculator1Main {

	public static void main(String[] args) {
		int number = 0;
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		Calculator1 cal = new Calculator1(); 		
	    while(run) {
	    	System.out.println("-------------------------------------");
			System.out.println("1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택>");
			number = scan.nextInt();
			if(number==1) {
				cal.sum(5, 5);
			}else if(number==2) {
				cal.subtract(5, 5);
			}else if(number==3) {
				cal.multiply(5, 5);
			}else if(number==4) {
				cal.divide(5, 5);
			}else if(number==5) {
				System.out.println("프로그램 종료.");
				run=false;
			}
	    }
		scan.close();
	}

}

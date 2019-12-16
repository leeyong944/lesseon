package test;

import java.util.Scanner;

public class Calculator2 {
	Scanner scan = new Scanner(System.in);
	void add(int num1, int num2) {
		int result = num1 + num2;
		System.out.println("덧셈 결과 : "+result);
	}
	void subtract(int num1, int num2) {
		int result = num1 - num2;
		System.out.println("뺄셈결과 : "+result);
	}
	void multiply(int num1, int num2) {
		int result = num1 * num2;
		System.out.println("곱셈결과 : "+result);
	}
	void divide(int num1, int num2) {
		int result = num1 / num2;
		System.out.println("나눗셈결과 : "+result);
	}
	
	

}

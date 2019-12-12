package test;

import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {
		/*
		 * 크기가 3인 정수형 배열을 선언
		 * 스캐너를 이용하여 값을 3개 저장후
		 * 입력된 값이 총합, 평균 계산
		 */
		int sum=0;
		int[] num=null;
		num = new int[3];
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<num.length; i++) {
			System.out.print((i+1)+"번 째 숫자 입력 : ");
		    num[i]=scan.nextInt();
			sum += num[i];
		}System.out.println("총합 : "+sum);
		System.out.println("평균 : "+sum/num.length);
		
	}

}

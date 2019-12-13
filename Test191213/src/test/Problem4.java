package test;

import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		/*
		 * 금액입력 :2680
		 * 500원 동전:5개
		 * 100원 동전:1개
		 * 50원 동전 :1개
		 * 10원동전:3개
		 * 금액입력:5000
		 * 500원 동전:10개
		 * 100원 동전:0개
		 * 50원 동전:0개
		 * 10원 동전:0개
		 * 금액입력 :3120
		 * 500원 동전:6개
		 * 100원 동전:1개
		 * 50원 동전:0개
		 * 10원 동전:2개
		 * 금액입력 : 
		 */
//		int[] coin = {500, 100, 50, 10};
//		int money=0,num1=0;
//		Scanner scan = new Scanner(System.in);
//		while(true) {
//			System.out.print("금액 입력 : ");
//			money = scan.nextInt();
//		    for(int i=0;i<coin.length;i++) {
//		    	num1=money/coin[i];
//		    	money=money%coin[i];
//		    	System.out.println(coin[i]+"의 동전 :"+num1+"개");
//		    }
//		   
//		}
		Scanner scan=new Scanner(System.in);
		do {
			int[] coin = {500, 100, 50, 10};
			System.out.println("금액 입력 : ");
			int change = scan.nextInt();
			for(int i=0; i<coin.length; i++) {
				// 동전의 갯수 출력
				int coinCount = change/coin[i];
				System.out.println(coin[i]+"원 동전:"+coinCount+"개");
				//나머지 값을 사용하기 위한식
				change = change%coin[i];
			}
			}while(true);
		}
			
		
	}



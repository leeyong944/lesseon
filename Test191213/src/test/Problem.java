package test;

import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		//스캐너로 원하는 배열 크기 입력
		//그 크기를 갖는 배열 만들기
		int size=0;
		Scanner scan=new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		size=scan.nextInt();
		int[] num = new int[size];
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
		
		
//		Scanner scan = new Scanner(System.in);
//		int[] num = null;
//		System.out.println("지정할 배열 크기 입력 : ");
//		int size = scan.nextInt();
//		num = new int[size]
//		System.out.println("배열크기:"+num.length);

	}

}

package test;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		//배열에 정수 5개 입력받아서 가장 큰수 출력
		Scanner scan=new Scanner(System.in);
		int max=0;
		int[] num = new int[5];
		for(int i=0; i<num.length; i++) {
			System.out.print((i+1)+"번째 숫자를 입력하세요 : ");
			num[i]=scan.nextInt();
			if(max<=num[i]) {
				max=num[i];
			}
		}System.out.println(max);
	}

}

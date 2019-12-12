package test;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		//배열에 정수 5개를 입력.
		//오름차순으로 정렬시키기.
//		int asc=0;
//		int[] num = {5, 2, 3, 4, 1};
//		for(int i=0; i<num.length; i++) {
//			for(int j=i+1; j<num.length; j++) {
//				if(num[i]>num[j]) {
//				    asc = num[i];
//				    num[i] = num[j];
//				    num[j] = asc;
//				}
//			}System.out.println(num[i]);
//								
//		}
		int asc;
		int i;
		Scanner scan = new Scanner(System.in);
		int[] num = new int[5];
		for(i=0; i<num.length; i++) {
			System.out.print((i+1)+"번째 숫자를 입력하세요 : ");
			num[i]=scan.nextInt();
		}
		//오름차순 정렬
		//0,1 0,2 0,3 0,4
		//1,2 1,3 1,4
		//2,3 2,4
		//3,4
//		for(i=0; i<num.length; i++) {
//		    for(int j=i+1; j<num.length; j++) {
//		    	//순서바꾸기 (버블정렬)
//			    if(num[i]>num[j]) { //내림차순은 > 를 < 로바꾸면 됨
//			    asc = num[i];
//			    num[i] = num[j];
//			    num[j] = asc;
//			}
//		}System.out.println(num[i]);
//		
//
//	    }
//		Arrays.parallelSort(num);
		Arrays.sort(num); //이런식으로 메소드를 사용하여 오름차순을 쉽게 할수 있음 ^^! 내림차순은 불가능
		for(i=0;i<num.length;i++) {
	      System.out.println(num[i]);	
		}
		

	}
}

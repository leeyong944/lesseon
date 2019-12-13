package test;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		//학점계산하기
		/*
		 * 스캐너를 이용하여 4년간의 학기별 학점을 입력하고
		 * 총 폄점을 출력하세요.
		 */
		
		Scanner scan = new Scanner(System.in);
		double[][] number = new double[4][2];
		int sum=0,count=0;
	    System.out.println("학점을 입력하세요");
		for(int i=0;i<number.length;i++) {
		    for(int j=0;j<number[i].length;j++) {
		    	System.out.print((i+1)+"학년"+(j+1)+"학기 : ");
		        number[i][j]=scan.nextDouble();
			    sum = (int) (sum+number[i][j]);
			    count++;
			}
		}
		
		double avg = sum/(number.length*number[0].length);
		avg = (double)sum/count; //형변환
		double avg1 = sum/count;
		System.out.println("총점 :"+sum);
		System.out.println("평균 :"+avg);
		System.out.println(avg1);

	}

}

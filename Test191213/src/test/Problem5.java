package test;

import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
		/*
		 * ---------------------------------------
		 * 1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료
		 * ---------------------------------------
		 * 선택>1
		 * 학생수>3
		 * ---------------------------------------
		 * 1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료
		 * ---------------------------------------
         * 선택>2
         * 1번 째 학생점수 : 90
         * 2번 째 학생점수 : 80
         * 3번 째 학생점수 : 70
         * ---------------------------------------
		 * 1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료
		 * ---------------------------------------
         * 선택>3
         * 1번 째 학생점수 : 90
         * 2번 째 학생점수 : 80
         * 3번 째 학생점수 : 70
         * ---------------------------------------
		 * 1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료
		 * ---------------------------------------
         * 선택>4
         * 최고점수 : 90
         * 평균점수 : 80
         * 90
         * 80
         * 70
         * ---------------------------------------
		 * 1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료
		 * ---------------------------------------
         * 선택>5
         * 프로그램 종료
		 */
		
		int select = 0,student = 0, score = 0;
		int[] number = null;
		Scanner scan = new Scanner(System.in); 
		do {
			System.out.println("---------------------------------------");
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택>");
			select=scan.nextInt();
				if(select==1) {
					System.out.print("학생수>");
					student=scan.nextInt();
				}else if(select==2) {
					number = new int[student];
					for(int i=0; i<number.length; i++) {
						System.out.print((i+1)+"번 째 학생 점수 :");
						number[i]=scan.nextInt();
					}
				}else if(select==3) {
					for(int i=0; i<number.length; i++) {
						System.out.println((i+1)+"번 째 학생 점수 :"+number[i]);	
					}
					
				}else if(select==4) {
					int max=0;
					for(int k=0; k<number.length; k++) {
						if(max<=number[k]) {
							max=number[k];
						}						
					}
					System.out.println("최고점수 : "+max);
					int sum1=0;
					for(int l=0; l<number.length; l++) {
						sum1 += number[l];
					}
					System.out.println("평균점수 : " + sum1/number.length);
					for(int i=0; i<number.length; i++) {
						for(int j=i+1; j<number.length; j++) {
							if(number[i]<number[j]) {
								int sum = number[i];
								number[i] = number[j];
								number[j] = sum;
							}
						}
						System.out.println(number[i]);
					}
				}else if(select==5) {
					System.out.println("프로그램 종료");
					break;
				}
		}while(true);
		
		
		
	

	}
}

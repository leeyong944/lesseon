package test;

import java.util.Scanner;

public class Problem3 {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		// 2차원 배열을 활용한 단어게임
		/*
		 * 문제1. chair의 뜻은 무엇인가요? 의자
		 * 정답입니다
		 * 문제2. desk의 뜻은 무엇인가요? 책상
		 * 정답입니다.
		 * 문제3. water의 뜻은 무엇인가요? 물ㄹㄹㄹㄹㄹㄹ
		 * 틀렸습니다
		 * 정답은 물입니다.
		 * ~~~~~~
		 * ~~~~~~
		 * 총 몇개 정답입니다.
		 * 정답률은 60.0% 입니다.
		 */
		Scanner scan = new Scanner(System.in);
		String result=null;
		int count=0,avg;
		
		String[][] str = {{"chair","의자"},
				          {"desk","책상"},
				          {"water","물"},
				          {"pencil","연필"},
				          {"watch","시계"}
		                  };
				          
		for(int i=0; i<str.length; i++) {
				for(int j=0; j<str[i].length; j++) {
					System.out.print("문제"+(i+1)+". "+str[i][j]+"의 뜻은 무엇인가요?");
					result=scan.next();
				 if(result.equals(str[i][j+1])) {
					 System.out.println("정답입니다.");
					 count++;
				 }else {
					 System.out.println("틀렸습니다.");
					 System.out.println("정답은 "+str[i][j+1]+"입니다.");
				 }
				 j++;
				
			}
		}
		avg=count*100/str.length;
		System.out.println("정답은 "+count+"개 입니다.");
		System.out.println("정답률은"+avg+"% 입니다.");
		
		
		
		
//		for(int i=0;i<words.length;i++) {
//			System.out.println("문제"+(i+1)+". "+words[i][0]+"의 뜻은 무엇인가요 :");
//			String answer=scan.next();
//			
//			if(answer.contentEquals(words[i][0])) {
//				System.out.println("정답입니다.");
//				score++;
//			} else {
//				System.out.println("틀렸습니다.");
//				System.out.println("정답은"+words[i][1]+"입니다.");
//			}
//		}
//		System.out.println("총"+score+"개 정답입니다. ");
//		double precent=100*((double)score/words.length);
//		System.out.println("정답률은"+precent+"% 입니다.");
//		
		
	}



}

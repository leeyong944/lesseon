package test;

import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		// 값이 5개있는 String 배열을 선언하고 foreach를 이용하여
		// 배열에 담긴 모든 데이터 출력
		
//		String[] str = {"책상", "의자", "모니터", "키보드", "마우스"};
//		for(String a:str) {
//			System.out.println(a);
//		}
		
		// int num[] = {1, 2, 5, 3, 4, 7, 6, 9, 10, 8};
		// 이런식으로 있을때 숫자를 입력했을때 몇번째에 있는지 나오게..
        int number, index=0;
		Scanner scan = new Scanner(System.in);
		int num[] = {1, 2, 5, 3, 4, 7, 6, 9, 10, 8};
		System.out.print("숫자를 입력하세요 : ");
		number=scan.nextInt();
		for(int i=0; i<num.length;i++) {
			if(num[i]==number) {
			     index =i;
			}
				
		}
		System.out.println(number+"는"+(index+1)+"번째 있습니다.");	
		
	}

}

package test;

public class Exerclse1 {

	public static void main(String[] args) {
		//향상된 for문(advanced for)(foreach문)
		int[] num = {3, 4, 1, 2, 5};
		
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		} //지금까지 배워왔던 num배열안에숫자보기
		
		for(int a:num) {
			System.out.println(a);
		}//foreach문 사용해서 num 배열안에 숫자보기

	}

}

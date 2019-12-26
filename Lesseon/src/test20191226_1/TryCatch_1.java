package test20191226_1;

public class TryCatch_1 {

	public static void main(String[] args) {
		/*
		 * 나눗셈 계산에서 분모가 0일 때 발생하는
		 * 예외(Exception)확인 후 이 예외에 대한
		 * 예외처리를 할 수 있는 코드를 작성해보세요.
		 * 예외 발생시 "0으로 나눌 수 없습니다.!!" 출력
		 */
		

//		System.out.println(5/0);
		
		try {
			int result = 5 / 0 ;
			System.out.println(result);
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.!!");
			e.printStackTrace();
		}

	}

}

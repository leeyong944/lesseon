package test191223;

public class KoreaBank {
	
	/*
	 * 한국은행 기준 금리는 1.0입니다.
	 * 우리은행, 국민은행, 하나은행은 각 금리가 1.5, 1.6, 1.4 입니다.
	 * 각 은행에 대한 금리를 확인하는 메소드를 정의하여
	 * BankMain 클래스에서 각 은행의 금리를 확인해보세요.
	 */
	
	double interestRate(double x) {
		System.out.print("한국은행 금리 : ");
		return x * 1.0;
	}

}

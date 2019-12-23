package test191223;

public class OurBank extends KoreaBank {
	@Override
	double interestRate(double x) {
		System.out.println(super.interestRate(x));
		System.out.print("우리은행 금리 : ");
		return x * 1.5;
	}

}

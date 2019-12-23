package test191223;

public class KookminBank extends OurBank{
	
	@Override
	double interestRate(double x) {
		System.out.println(super.interestRate(x));
		System.out.print("국민은행 금리 : ");
		return x * 1.6;
	}

}

package test191223;

public class HanaBank extends KookminBank {
	@Override
	double interestRate(double x) {
		System.out.println(super.interestRate(x));
		System.out.print("하나은행 금리 : ");
		return x * 1.4;
	}

}

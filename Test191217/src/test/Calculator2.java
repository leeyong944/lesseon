package test;

public class Calculator2 {
//int x=7;
//int y=10;
//double result;
//	int add(int x, int y) {
//		x = this.x;
//		y = this.y;
//		int result = x + y;
//		this.result = result;
//		return (int) this.result;
//	}
//	
//	double avg(int x, int y) {
//		double result =(double) this.result/2;
//		this.result = result;
//		return this.result; 
//	}
//	
//	void execute() {
//		System.out.println("실행결과 : "+result);
//	}
	
	int add(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double avg(int x, int y) {
		double sum = add(x, y);
		double result = sum/2;
		return result;
	}
	
	void execute() {
		double result = avg(7, 10);
		System.out.println("실행결과 :" + result);
	}

	//리버스엔지니어링 결과물을보고 거꾸로 
	
	
	
}

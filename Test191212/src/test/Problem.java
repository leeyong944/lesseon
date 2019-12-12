package test;

public class Problem {

	public static void main(String[] args) {
		// 크기가 5인 double 타입의 배열 변수 선언
		// 각각 값을 저장해보고 for문을 이용하여 저장된 값 출력
		//double[] num = null;
		//num = new double[5];
		double[] num = new double[5];
		num[0] = 1.111;
		num[1] = 2.111;
		num[2] = 3.111;
		num[3] = 4.111;
		num[4] = 5.111;
		for(int i=0;i<num.length;i++) {
			System.out.println(num[i]);
		}

	}

}

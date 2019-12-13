package test;

public class Exerclse1 {

	public static void main(String[] args) {
		/*형변환
		 *특정 타입의 변수가 다른 타입의 변수로 변환되는 것.
		 * 1.자동형변환(promotion)
		 *   크기가 작은 타입이 큰 타입으로 변환.
		 * 2.강제형변환(casting)
		 *   크기가 큰 타입을 작은 타입으로 변환.
		 */
		byte byteValue = 10;
		int intValue = 10;
		double doubleValue = 1.0;
		//byte 타입의 변수를 int 타입의 변수에 저장
//		intValue = byteValue; 자동형변환
		byteValue = (byte) intValue; //인트타입의 변수가 더 크기때문에 강제형변환을 해야함.
		intValue = (int) doubleValue; 
		
		
		
		

	}

}

package test;

public class B {
	
	public static void main(String[] args) {
		A a = new A();
		// field 4개 호출하기
		a.field1 = 10;
		a.field2 = 10;
		a.field3 = 10;
//		a.field4 = 10;
		
		// add 4개 메소드 호출하기
		System.out.println(a.add1(5, 5));
		System.out.println(a.add2(5, 5));
		System.out.println(a.add3(5, 5));
//		System.out.println(a.add4(5, 5));
	}

}

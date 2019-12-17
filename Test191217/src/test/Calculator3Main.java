package test;

public class Calculator3Main {

	public static void main(String[] args) {
		
        Calculator3 cal = new Calculator3();
        //필드값 호출
        System.out.println(cal.pi1);
        System.out.println(cal.pi);
        System.out.println(Calculator3.pi);
        //static 으로 준것은 객체화 하지않아도 사용가능
        //되도록이면 쓰지않는게좋음 메모리상에 그냥 올라가있기때문에.
        
        //메소드 호출
        System.out.println(cal.add(5, 5));
        System.out.println(cal.subtract(5, 5));
        System.out.println(Calculator3.subtract(5, 5));
        
        //상수 호출
        System.out.println(Calculator3.EARTH_RADIUS);
        
	}

}

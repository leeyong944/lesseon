package test191223;

public class CellPhoneMain {

	public static void main(String[] args) {
		/*
		 * CellPhone 클래스 객체 선언해서
		 *  - 부모클래스 필드값 출력
		 *  - 부모클래스 메소드 호출
		 *  - 자식클래스 필드값 출력
		 *  - 자식클래스 메소드 호출
		 */
		
		CellPhone phone = new CellPhone("버튼","갤럭시","빨강");
		//부모클래스 필드값
		System.out.println(phone.model);
		System.out.println(phone.color);
		System.out.println("----------------------");
		//부모클래스 메소드
		phone.hangOn();
		phone.hangOff();
		phone.call("d");
		System.out.println("----------------------");
		//자식클래스 필드값
		System.out.println(phone.button);
		System.out.println(phone.message);
		System.out.println("----------------------");
		//자식클래스 메소드
		phone.sendMessage("안녕");
		phone.receiveMessage("그랭");
		phone.powerOn();
		phone.powerOff();
		
	}

}

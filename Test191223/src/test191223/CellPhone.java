package test191223;

/*
 * phone : 부모클래스
 * CellPhone : 자식클래스
 */
public class CellPhone extends Phone { //상속지정
	String button;
	String message;
	
	// 생성자
	// button, model , color 를 매개변수로 하는 생상저 선언
	public CellPhone(String button, String model, String color){
		this.button = button;
		this.model = model;
		this.color = color;
	}
	
	// 메소드
	void sendMessage(String message) {
		System.out.println("메세지 전송 : "+message);
	}
	
	void receiveMessage(String message) {
		System.out.println("메세지 수신 : "+message);
	}
	
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	@Override
	public String toString() {
		return "CellPhone [button=" + button + ", message=" + message + ", model=" + model + ", color=" + color + "]";
	}

	



	
	
	
	
	

}

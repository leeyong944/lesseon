package test20191226;

public class SmartPhone extends Pda implements MobilePhone, Mp3 {

	@Override
	public void hangOn() {
		System.out.println("전화를 겁니다.");
	}

	@Override
	public void hangOff() {
		System.out.println("전화를 받습니다.");
	}

	@Override
	public void sendMessage() {
		System.out.println("문자를 보냅니다.");
	}

	@Override
	public void receiveMessage() {
		System.out.println("문자를 받습니다.");
	}
	

}

package test20191224_3;

public class RemoteControlMain {

	public static void main(String[] args) {
		Television tv = new Television();
		
		tv.turnOn();
		tv.turnOff();
		tv.setVolume(100);
		tv.setMute(true);
		System.out.println("--------------------------");
		// Audio클래스를 RemoteControl의 구현클래스로 정의하여
		// 메소드 등을 정의하고
		// main 클래스에서 다형성을 적용하여
		// TV, Audio 객체를 만들어 메소드를 호출해보세요.
		RemoteControl rc = null;
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(7);
		rc.setMute(true);
		System.out.println("--------------------------");
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(9);
		rc.setMute(true);
		RemoteControl.changeBattery();
		System.out.println(RemoteControl.MAX_VOLUME);
		System.out.println("--------------------------");
		rc = new SmartTelevision();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(10);
		rc.setMute(true);
		InternetSearch is = null;
		is = new SmartTelevision();
		is.search("고양이");
		

	}

}

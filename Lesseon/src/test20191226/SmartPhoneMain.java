package test20191226;

public class SmartPhoneMain {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		sp.hangOn();
		sp.hangOff();
		sp.sendMessage();
		sp.receiveMessage();
		sp.setMusic(true);
		sp.setMusic(false);
		System.out.println(sp.add(5, 8));

	}

}

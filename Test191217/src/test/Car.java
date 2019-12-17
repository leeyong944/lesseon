package test;

public class Car {
	int gas;   // 가스 필드를 만듬
	void setGas(int gas) { //  setGas 메소드로 가스량을 정해서 가스 필드에 저장
		this.gas = gas;
	}
	boolean isLeftGas() {  //리턴타입이 boolean 
		if(gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		}else {
			System.out.println("gas가 있습니다.");
			return true;
		}
	}
	void run(){
		while(true) {
			if (gas > 0) {
				System.out.println("달립니다.(gas 잔량 :" + gas + ")");
				gas -=1;
			}else {
				System.out.println("멈춥니다.(gas 잔량 :" + gas + ")");
				return; //메소드종료
			}
		}
	}

}

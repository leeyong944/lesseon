package test20191224_2;

public class CarMain {

	public static void main(String[] args) {
		Car1 car1 = new Car1();
		Truck truck = new Truck();
		
		car1.wheel();
		truck.wheel();
		
		Car car = new Car1();
		car.wheel();
		car = new Truck();
		car.wheel();

	}

}

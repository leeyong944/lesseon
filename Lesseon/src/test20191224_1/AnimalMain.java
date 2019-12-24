package test20191224_1;

public class AnimalMain {

	public static void main(String[] args) {
//		Animal animal = new Animal();
		//추상클래스는 객체화 불가능~~~~~~~~
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		dog.breath();
		cat.sound();
		cat.breath();
		
		// 다형성(polymorphsim)
		Animal ani = new Dog();
		ani.sound();
		ani = new Cat();
		ani.sound();
		
//		cat = new Dog(); 안됨~~~~~~~~~~~

	}

}

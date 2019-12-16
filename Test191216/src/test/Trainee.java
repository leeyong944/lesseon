package test;

public class Trainee {
	//교육원에 다니는 훈련생에 대한 클래스를 만들고
	//메인 클래스에서 각자 같은 줄에 앉은 사람들에 대한 객체를 각각 선언해서 필드값 출력
	
	String name;
	int age;
	String gender;
	
	Trainee(String name, int age, String gender){
		this.name=name;
		this.age=age;
		this.gender=gender;
	}
	
	//매개변수가있는 생성자를 생성했을때 기본생성자를 사용하고싶으면 기본생성자를 선언해줘야함.

	@Override
	public String toString() {
		return "Trainee [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

}
package test191223;

public class Student extends People {
	
	int studentId;
	String major;
	
	Student(String name, String peopleNumber, int studentId, String major){
		super(name, peopleNumber); //super : 부모클래스의 생성자
		this.studentId = studentId;
		this.major = major;
	}



}

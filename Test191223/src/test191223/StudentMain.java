package test191223;

public class StudentMain {

	public static void main(String[] args) {
		Student student = new Student("이용","111111-1111111",1234,"컴퓨터");
		System.out.println(student.name);
		System.out.println(student.peopleNumber);
		System.out.println(student.studentId);
		System.out.println(student.major);

	}

}


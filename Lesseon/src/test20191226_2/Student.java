package test20191226_2;

public class Student {
	private int studentNo;
	private String name;
	private int age;
	private String address;
	private String gender;
	private String phone;
	
	Student(){
		
	}
	
	Student(int studentNo, String name, int age, String address, String gender, String phone){
		this.studentNo = studentNo;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
	}
	
	

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", gender=" + gender + ", phone=" + phone + "]";
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	

}

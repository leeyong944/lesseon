package test191220;

public class Student {
	
	private int studentNumber;
	private String name;
	private int birth;
	private String address;
	private int phoneNumber;
	private int javaScore;
	private int servletScore;
	private int springScore;
	
	public Student(){
		
	}
	
	public Student(int studentNumber, String name, int birth, String address, int phoneNumber) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.birth = birth;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}

	public int getServletScore() {
		return servletScore;
	}

	public void setServletScore(int servletScore) {
		this.servletScore = servletScore;
	}

	public int getSpringScore() {
		return springScore;
	}

	public void setSpringScore(int springScore) {
		this.springScore = springScore;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", name=" + name + ", birth=" + birth + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", javaScore=" + javaScore + ", servletScore="
				+ servletScore + ", springScore=" + springScore + "]";
	}
	

	

}

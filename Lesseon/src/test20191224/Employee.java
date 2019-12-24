package test20191224;

public class Employee {
	
	private String name;
	private int salary;
	
	Employee(String name, int salary){
		this.name = name;
		this.salary = salary;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	int impression() {
		salary = (int)(salary * 1.1);
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [이름=" + name + ", 급여=" + salary + "]";
	}
	
	

}

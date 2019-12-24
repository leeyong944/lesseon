package test20191224;

public class Manager extends Employee {
	int allowance;
	
	Manager(String name, int salary, int allowance){
		super(name,salary);
		this.allowance = allowance;
	}
	
	@Override
	public String toString() {
		return "Manager [이름=" + getName() + ", 급여=" + getSalary() + ", 수당=" + allowance + "]";
	}

	@Override
	int impression() {
		setSalary((int)(getSalary() * 1.2));
		return getSalary();
	}

	
}

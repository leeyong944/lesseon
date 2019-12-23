package test191223;

public class Manager extends Employee {
	
	int bonus;
	
	Manager(String name, String address, int salary, int bonus){
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Manager [bonus=" + bonus + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}
	
	

}

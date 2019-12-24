package test20191224;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee emp = new Employee("김현",2000000);
		Manager manager = new Manager("유연수",3000000,200000);
		Executive executive = new Executive("이용",4000000,300000,200000);
		
		emp.impression();
		manager.impression();
		executive.impression();
		
		System.out.println(emp.toString());
		System.out.println(manager.toString());
		System.out.println(executive.toString());
		

	}

}

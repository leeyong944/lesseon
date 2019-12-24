package test20191224;

public class Executive extends Manager {
	
	int bouns;
	
	Executive(String name, int salary, int allowance, int bouns){
		super(name, salary, allowance);
		this.bouns = bouns;
	}
	
	@Override
	int impression() {
		setSalary((int)(getSalary()*1.3));
		return getSalary();
	}

	@Override
	public String toString() {
		return "Executive [이름=" + getName() + ", 급여=" + getSalary() + ", 수당=" + allowance + ", 보너스=" + bouns + "]";
	}

	
	
	
	

}

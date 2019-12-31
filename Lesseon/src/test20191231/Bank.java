package test20191231;

public class Bank {
	private int customerNo;
	private String name;
	private String accountNo;
	private int balance;
	
	
	public Bank() {
		
	}
	
	
	public Bank(int customerNo, String name, String accountNo, int balance) {
		this.customerNo = customerNo;
		this.name = name;
		this.accountNo = accountNo;
		this.balance = balance;
	}


	public int getCustomerNo() {
		return customerNo;
	}


	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Bank [customerNo=" + customerNo + ", name=" + name + ", accountNo=" + accountNo + ", balance=" + balance
				+ "]";
	}
	
	
	
	

}

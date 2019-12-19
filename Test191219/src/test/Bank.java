package test;

public class Bank {
	private int count;
	private String name;
	private int account;
	private int balance;
	
	public Bank(int count, String name, int account, int balance) {
		super();
		this.count = count;
		this.name = name;
		this.account = account;
		this.balance = balance;
	}
	public Bank() {
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Bank [고객번호 =" + count + ", 이름 =" + name + ", 계좌번호 =" + account + ", 잔액 =" + balance + "]";
	}
	
	
	public void deposit(int x) {
			    balance += x ; 
				System.out.println(x+"원 입금되었습니다.");
				System.out.println("현재 잔액은 "+balance+"원 입니다.");
	}
	
	public void withdraw(int x) {
		if(balance>x) {
			balance -= x;
			System.out.println(x+"원 출금되었습니다.");
			System.out.println("현재잔액은 "+balance+"원 입니다.");
		}else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	public void check() {
		System.out.println("현재 잔액은 "+balance+"원 입니다.");
	}
	
	public void Information() {
		System.out.println("고객번호 : "+count+", 이름 :"+name+", 계좌번호 :"+account+", 잔액 : "+balance);
	}


	
	
	
	
	

}

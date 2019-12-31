package test20191231;

import java.util.*;
import java.sql.*;

public class BankMain {

	public static void main(String[] args) {
		DBsql sql = new DBsql();
		Scanner scan = new Scanner(System.in);
		Bank bank = null;
		List<Bank> bankList = new ArrayList<Bank>();
		boolean run = true;
		int count = 0;
		while(run) {
			System.out.println("0.DB접속, 1.계좌생성, 2.입금, 3.출금, 4.계좌확인, 5.송금, 6.종료");
			int selectNo = scan.nextInt();
			switch(selectNo) {
			case 0 :
				sql.dbConnection();
				break;
			case 1 :
				int customerNo = bankList.size()+1;
				bank =new Bank();
				bank.setCustomerNo(customerNo);
				System.out.print("이름을 입력해 주세요 : ");
				String name = scan.next();
				bank.setName(name);
				System.out.print("계좌번호를 입력해 주세요 : ");
				String accountNo = scan.next();
				bank.setAccountNo(accountNo);
				System.out.print("입금할 금액을 입력해 주세요 : ");
				int balance = scan.nextInt();
				bank.setBalance(balance);
				sql.createAccount(bank);
				bankList.add(bank);
				break;
			case 2 :
				System.out.print("이름을 입력해 주세요 : ");
				name = scan.next();
				System.out.print("계좌번호를 입력해 주세요 : ");
				accountNo = scan.next();
				boolean confirm = sql.confirm(name, accountNo);
				if(confirm) {
					System.out.print("입금할 금액을 입력해 주세요 : ");
					int deposit = scan.nextInt();
					sql.deposit(deposit, accountNo);
				}else {
					System.out.println("잘못된 정보입니다.");
				}
				break;
			case 3 :
				System.out.print("이름을 입력해 주세요 : ");
				name = scan.next();
				System.out.print("계좌번호를 입력해 주세요 : ");
				accountNo = scan.next();
				confirm = sql.confirm(name, accountNo);
				if(confirm) {
					System.out.print("출금할 금액을 입력해 주세요 : ");
					int withdraw = scan.nextInt();
					sql.withdraw(withdraw, accountNo);
				}else {
					System.out.println("잘못된 정보입니다.");
				}
				break;
			case 4 :
				System.out.print("이름을 입력해 주세요 : ");
				name = scan.next();
				System.out.print("계좌번호를 입력해 주세요 : ");
				accountNo = scan.next();
				confirm = sql.confirm(name, accountNo);
				if(confirm) {
					sql.account(accountNo);
				}else {
					System.out.println("잘못된 정보입니다.");
				}
				break;
			case 5:
				
			case 6 :
				run = false;
				break;
			}
		}
		

	}

}

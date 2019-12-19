package test;

import java.util.*;

public class BankMain {

	public static void main(String[] args) {
		/*
		 * 은행 프로그램
		 * 1. 고객 등록을 할 수 있다.
		 *  1.1 생성자를 이용한 방법
		 *  1.2 getter, setter 이용한방법
		 * 2. 예금 기능을 수행할 수 있다.
		 * 3. 출금 기능을 수행할 수 있다.
		 *  3.1 잔액이 0원 미만이면 출금 불가능 메세지를 출력한다.
		 * 4. 잔액 확인을 할 수 있다.
		 * 5. 고객 정보
		 *  - 고객번호, 이름, 계좌번호, 잔액
		 * 6. 고객 정보는 ArrayList에 저장한다.
		 */
		int count = 0;
		int money = 0;
		int select = 0;
		int number = 0;
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		List<Bank> memberList = new ArrayList<Bank>(); 
		Bank member = null;
		
		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.고객등록|2.입금|3.출금|4.잔액확인|5.고객리스트|6.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 >");
			select = scan.nextInt();
			switch(select) {
			case 1:
				count++;
				System.out.println("고객등록 메뉴 입니다.");
				System.out.print("이름을 입력해 주세요 : ");
				String name = scan.next();
				System.out.print("계좌번호를 입력해 주세요 : ");
				int account = scan.nextInt();
				System.out.print("입금 금액을 입력해주세요 : ");
				money = scan.nextInt();
				member = new Bank(count, name, account, money);
				memberList.add(member);
				break;
			case 2:
				System.out.print("계좌번호를 입력해 주세요 : ");
				number = scan.nextInt();
				System.out.print("입금할 금액을 입력해 주세요 : ");
				money = scan.nextInt();
				for(int i = 0; i < memberList.size(); i++) {
					if(memberList.get(i).getAccount() == number) {
						memberList.get(i).deposit(money);
					}
				}
				break;
			case 3:
				System.out.print("계좌번호를 입력해 주세요 : ");
				number = scan.nextInt();
				System.out.print("출금할 금액을 입력해 주세요 : ");
				money = scan.nextInt();
				for(int i = 0; i < memberList.size(); i++) {
					if(memberList.get(i).getAccount() == number) {
						memberList.get(i).withdraw(money);
					}
				}
				break;
			case 4:
				System.out.print("계좌번호를 입력해 주세요 : ");
				number = scan.nextInt();
				for(int i = 0; i < memberList.size(); i++) {
					if(memberList.get(i).getAccount() == number) {
						System.out.println(memberList.get(i).getBalance()+"원 입니다.");
					}
				}
				break;
			case 5:
				for(int i = 0; i < memberList.size(); i++) {
					System.out.println(memberList.get(i));
				}
				break;
			case 6:
				System.out.println("프로그램 종료.");
				run=false;
				
			}
			
		}
		scan.close();
	}

}

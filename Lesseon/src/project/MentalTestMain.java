package project;

import java.util.*;

public class MentalTestMain {

	public static void main(String[] args) {
		DBsql sql = new DBsql();
		Scanner scan = new Scanner(System.in);
		MentalTest mt = null;
		boolean run = true;
		while(true) {
			System.out.println("0.DB접속, 1.회원가입, 2.회원정보수정, 3.회원 탈퇴, 4.우울증 테스트, 5.");
			int selectNo = scan.nextInt();
			switch(selectNo) {
			case 0 :
				sql.dbConnection();
				break;
			case 1 :
				mt = new MentalTest();
				System.out.println("아이디 : ");
				String id = scan.next();
				mt.setId(id);
				System.out.println("비밀번호 : ");
				String password = scan.next();
				mt.setPassword(password);
				System.out.println("이름 : ");
				String name = scan.next();
				mt.setName(name);
				System.out.println("핸드폰 번호 : ");
				String tel = scan.next();
				mt.setTel(tel);
				System.out.println("충전 금액 :");
				int balance = scan.nextInt();
				mt.setBalance(balance);
				sql.signUp(mt);
			case 2 :
				System.out.println("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.println("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				boolean check = sql.check(id, password);
				if(check) {
					mt = new MentalTest();
					mt.setId(id);
					System.out.println("로그인 되었습니다.");
					System.out.println("수정할 비밀번호를 입력해 주세요 : ");
					password = scan.next();
					mt.setPassword(password);
					System.out.println("수정할 핸드폰 번호를 입력해 주세요 : ");
					tel = scan.next();
					mt.setTel(tel);
					System.out.println("수정할 충전 금액을 입력해 주세요 : ");
					balance = scan.nextInt();
					mt.setBalance(balance);
					sql.updateMember(mt);
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
				break;
			case 3 :
				System.out.println("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.println("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				check = sql.check(id, password);
				if(check) {
					sql.deleteMember(id);
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
			case 4 :
				
				
			case 5 :
				
			}
		}

	}

}

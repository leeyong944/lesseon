package project;

import java.util.*;

public class MentalTestMain {

	public static void main(String[] args) {
		DBsql sql = new DBsql();
		Scanner scan = new Scanner(System.in);
		MentalTest mt = null;
		boolean run = true;
		while(true) {
			System.out.println("0.DB접속, 1.회원가입, 2.회원정보수정, 3.회원 탈퇴, 4.우울증 테스트, 5.스트레스 테스트, "
					+ "6.알코올 중독 테스트, 7.인터넷 중독 테스트, 8.상담 예약, 99.관리자모드");
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
				break;
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
				break;
			case 4 :
				System.out.println("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.println("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				check = sql.check(id, password);
				if(check) {
					int score = sql.DTest(id);
					String result = null;
					if(score<=15) {
						result = "[15점이하] 정상음주입니다.";
						System.out.println("총점 : "+score+"점");
						System.out.println("결과 : "+result+"입니다");
						} else if(score<=25) {
							result = "[16~25점] “ 위험음주 수준으로 주의를 요합니다.”";
							System.out.println("총점 : "+score+"점");
							System.out.println("결과 : "+result+"입니다");
						} else if(score<=35) {
							result = "[26~35점] “ ㅇㅇ”";
							System.out.println("총점 : "+score+"점");
							System.out.println("결과 : "+result+"입니다");
						} else {
							result = "[36~40점] “ ㅇㅇ”";
							System.out.println("총점 : "+score+"점");
							System.out.println("결과 : "+result+"입니다");
							System.out.println("정신과 상담이 필요합니다 예약하시겠습니까?");
							System.out.println("1.네 2.아니오");
							System.out.print("선택 > ");
							int selectNo1 = scan.nextInt();
							switch(selectNo1) {
							case 1 :
								System.out.print("거주지역을 입력해 주세요 : ");
								String address = scan.next();
								sql.reservation(address);	

								
							case 2 :
								break;
							}
							
						}
					
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
				break;
			case 5 :
			case 8 :
				System.out.println("상담 병원 예약 페이지 입니다.");
				System.out.println("상담 받으실 병원을 선택해 주세요 :");
				System.out.println("1.연수메디칼의원신경정신과, 2.서울 신경 정신과, 3.용인 정신과 의원");
				int selectNo2 = scan.nextInt();
				switch(selectNo2) {
				case 1 :
					sql.yeonsoo();
					break;
				case 2 :
					sql.seoul();
					break;
				case 3 :
					sql.yongin();
					break;
				}
				break;
			case 99 :
				System.out.println("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.println("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				sql.adminDB(id, password);
				break;
				
			}
		}

	}

}

package test20191230;

import java.util.*;

public class NaverMain {

	public static void main(String[] args) {
		DBsql sql = new DBsql();
		NaverMember nm = null;
		List<NaverMember> memberList = new ArrayList<NaverMember>();
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int selectNo = 0;
		while(run){
			System.out.println("0.관리자 조회 1.DB접속, 2.회원가입, 3.회원정보수정, 4.탈퇴  9.종료");
			selectNo = scan.nextInt();
			switch(selectNo) {
			case 0 :
				System.out.print("ID를 입력하세요 : ");
				String id = scan.next();
				System.out.print("비밀번호를 입력하세요 : ");
				String password = scan.next();
				sql.selectMember(id, password);
				break;
			case 1 :
				sql.dbConnection();
				break;
			case 2 :
				System.out.print("ID를 입력하세요 : ");
				id = scan.next();
				System.out.print("비밀번호를 입력하세요 : ");
				password = scan.next();
				System.out.print("이름을 입력하세요 : ");
				String name = scan.next();
				System.out.print("생년월일을 입력하세요 : ");
				String birth = scan.next();
				System.out.print("성별을 입력하세요 : ");
				String gender = scan.next();
				System.out.print("이메일을 입력하세요 : ");
				String mail = scan.next();
				System.out.print("핸드폰 번호를 입력하세요 : ");
				String phone = scan.next();
				nm = new NaverMember(id,password,name,birth,gender,mail,phone);
				sql.insertDB(nm);
				break;
			case 3 :
				System.out.print("ID를 입력해 주세요 : ");
				id = scan.next();
				System.out.print("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				sql.updateMember(id, password);
				break;
			case 4 :
				System.out.print("ID를 입력해 주세요 : ");
				id = scan.next();
				System.out.print("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				sql.deleteMember(id, password);
				break;
			case 9 :
				run = false;
				break;
			}
			
		}

	}

}

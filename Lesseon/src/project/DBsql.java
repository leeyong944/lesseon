package project;

import java.sql.*;
import java.util.Scanner;

public class DBsql {
	int totalScore;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}

	public void signUp(MentalTest mt) {
		String sql = "INSERT INTO MENTALTEST VALUES(?,?,?,?,?,0,0,0,0)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mt.getId());
			pstmt.setString(2, mt.getPassword());
			pstmt.setString(3, mt.getName());
			pstmt.setString(4, mt.getTel());
			pstmt.setInt(5, mt.getBalance());
			pstmt.executeUpdate();
			System.out.println("회원가입 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}

	public boolean check(String id, String password) {
		boolean check = false;
		String sql = "SELECT * FROM MENTALTEST WHERE ID = ? AND PASSWORD = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = true;
			}else {
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public void updateMember(MentalTest mt){
		String sql = "UPDATE MENTALTEST SET PASSWORD = ?, TEL = ?, BALANCE = ? WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mt.getPassword());
			pstmt.setString(2, mt.getTel());
			pstmt.setInt(3, mt.getBalance());
			pstmt.setString(4, mt.getId());
			pstmt.executeUpdate();
			System.out.println("회원 정보 수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteMember(String id) {
		String sql = "DELETE FROM MENTALTEST WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("회원 탈퇴 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void adminDB(String id, String password) {
		String sql = "SELECT PASSWORD FROM MENTALTEST WHERE ID = 'admin'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				if(password.equals(rs.getString("PASSWORD"))){
				System.out.println("관리자로 로그인 되었습니다");
				String sql2 = "SELECT * FROM MENTALTEST";
				pstmt = con.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println("");
					System.out.print("아이디 : "+rs.getString("ID")+", ");
					System.out.print("비밀번호 : "+rs.getString("PASSWORD")+", ");
					System.out.print("이름 : "+rs.getString("NAME")+", ");
					System.out.print("전화번호 : "+rs.getString("TEL")+", ");
					System.out.print("잔액 : "+rs.getString("BALANCE")+", ");
					System.out.print("DSCORE : "+rs.getString("DSCORE")+", ");
					System.out.print("SSCORE : "+rs.getString("SSCORE")+", ");
					System.out.print("AASCORE : "+rs.getString("AASCORE")+", ");
					System.out.print("IASCORE : "+rs.getString("IASCORE")+", ");
					System.out.println("");	
			}}} else {
				System.out.println("입력하신 정보가 일치하지 않습니다.");
			}
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public int DTest(String id) {
		Scanner scan = new Scanner(System.in);
		System.out.println("우울증 테스트 화면 입니다.");
		System.out.println("문제를 보고 자신이 해당하는 사항을 선택해주세요.");
		System.out.println("--------------------------------------------------");
		System.out.println("문제 1 : 나는 기운이 없고 우울하다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		int selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		System.out.println("문제 2 : 나는 쓸모가 없고 필요없는 사람이라고 느낀다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		System.out.println("문제 3 : 나는 눈물을 쏟거나 울고 싶어진다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		System.out.println("문제 4 : 나는 밤에 잠을 잘 못잔다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		System.out.println("문제 5 : 나는 별다른 이유 없이 피곤해진다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		System.out.println("문제 6 : 나는 안절부절 못해서 진정할 수가 없다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		System.out.println("문제 7 : 심장이 전보다 빨리 뛴다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		System.out.println("문제 8 : 나는 평소보다 신경이 더 날카롭다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		System.out.println("문제 9 : 내가 죽어야 남들이 더 잘 될 것이다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		System.out.println("문제 10 : 나는 미래를 희망적이지 않다고 생각한다.");
		System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore+selectNum;
		int score = this.totalScore;
		this.totalScore = 0;
		String sql = "UPDATE MENTALTEST SET DSCORE = ? WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, score);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
			
	}
	
	public void STest(String id) {
		Scanner scan = new Scanner(System.in);
		System.out.println("스트레스 테스트 화면 입니다.");
		System.out.println("문제를 보고 자신이 해당하는 사항을 선택해주세요.");
		System.out.println("--------------------------------------------------");
		System.out.println("문제 1 : 눈이 피로하다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		int selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		System.out.println("문제 2 : 어지럼증을 느낄 때가 있다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		System.out.println("문제 3 : 귀에서 소리가 들릴 때가 있다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		System.out.println("문제 4 : 때로는 입안에 염증이 생길 때가 있다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		System.out.println("문제 5 : 좀처럼 피로가 없어지지 않는다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		System.out.println("문제 6 : 쉽게 피로를 느낀다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		System.out.println("문제 7 : 사소한 일로 화가 난다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		System.out.println("문제 8 : 일할 의욕이 생기지 않는다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		System.out.println("문제 9 : 잠을 쉽게 들지 못한다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		System.out.println("문제 10 : 꿈을 많이 꾸거나 선잠을 잔다.");
		System.out.println("1. 예   2. 아니오");
		System.out.print("선택 > ");
		selectNum = scan.nextInt();
		this.totalScore = this.totalScore + selectNum;
		int score = this.totalScore;
		this.totalScore = 0;
	}
	
	public void reservation(String address) {
		String sql = "SELECT HOSPITALNAME FROM HOSPITAL WHERE ADDRESS LIKE ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+address+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("거주지에서 가장 가까운 병원은 "+rs.getString("HOSPITALNAME")+"입니다.");
			}else {
				System.out.println("현 거주지역에 정신과치료 병원이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	public void yeonsoo() {
		String sql = "SELECT * FROM RESERVATION WHERE HOSPITALNAME LIKE '%연수%'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("이름 : "+rs.getString("NAME"));
				System.out.print("예약날짜 : "+rs.getString("RDATE")+", ");
				System.out.println("예약시간 : "+rs.getString("RTIME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void seoul() {
		String sql = "SELECT * FROM RESERVATION WHERE HOSPITALNAME LIKE '%서울%'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("이름 : "+rs.getString("NAME"));
				System.out.print("예약날짜 : "+rs.getString("RDATE")+", ");
				System.out.println("예약시간 : "+rs.getString("RTIME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void yongin() {
		String sql = "SELECT * FROM RESERVATION WHERE HOSPITALNAME LIKE '%용인%'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("이름 : "+rs.getString("NAME"));
				System.out.print("예약날짜 : "+rs.getString("RDATE")+", ");
				System.out.println("예약시간 : "+rs.getString("RTIME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
			
	
	

}

package project;

import java.sql.*;
import java.util.Scanner;

public class DBsql {
	
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
	a
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
	
	public void DTest(String id, String password, int score, int selectNum) {
		String sql = "SELECT Dscore FROM MENTALTEST WHERE PASSWORD = ? ";
		Scanner scan = new Scanner(System.in);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(2)==password){
					String sql2 = "UPDATE MENTALTEST SET DSCORE = ? WHERE PASSWORD = ?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(2, password);
					score = rs.getInt(6);
					score = score+selectNum;
					pstmt.setInt(1, score);
				} else {
					System.out.println("아이디 또는 비밀번호가 틀립니다.");
				}
			pstmt.executeUpdate();
			}
			System.out.println("총점 : "+Dscore+"점");
			System.out.println("결과 : "+result+"입니다");
			if(Dscore<=7) {
			System.out.println("[7점이하] 정상음주입니다.");
			} else if(Dscore<=11) {
				System.out.println("[7~11점] “ 위험음주 수준으로 주의를 요합니다.”"); 
				System.out.println("아직까지는 특별히 심각한 음주로 인한 문제가 발생하지는 않았지만,");
				System.out.println("향후 음주로 인한 문제가 발생할 가능성이 있습니다.");
				System.out.println("음주량을 줄이거나 음주횟수를 줄여 적정음주를 실행하도록 하는 것이 좋습니다.");
			} else if(Dscore<=19) {
				System.out.println("");
			} else if(Dscore>=20) {
				System.out.println("");
			}
			
		}catch(SQLException e) {
				e.printStackTrace();
			}
}
	
	
			
			
	
	

}

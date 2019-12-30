package test20191230;

import java.sql.*;
import java.util.*;

public class DBsql {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}
	
	public void insertDB(NaverMember nm) {
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?)";
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nm.getId());
			pstmt.setString(2, nm.getPassword());
			pstmt.setString(3, nm.getName());
			pstmt.setString(4, nm.getBirth());
			pstmt.setString(5, nm.getGender());
			pstmt.setString(6, nm.getMail());
			pstmt.setString(7, nm.getPhone());
			pstmt.setDate(8, sqlDate);
			pstmt.executeUpdate();
			System.out.println("가입완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMember(String id , String password) {
		Scanner scan = new Scanner(System.in);
		String sql = "SELECT PASSWORD FROM MEMBER WHERE ID = ?";
		String sql1 = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String naverPassword = rs.getString("password");
				if(naverPassword.equals(password)) {
					System.out.println("로그인 성공");
					sql1 = "UPDATE MEMBER SET PASSWORD = ?,NAME = ?,BIRTH = ? WHERE ID = ?";
					pstmt = con.prepareStatement(sql1);
					System.out.print("수정할 비밀번호를 입력해 주세요 : ");
					String password1 = scan.next();
					pstmt.setString(1, password1);
					System.out.print("수정할 이름을 입력해 주세요 : ");
					String name = scan.next();
					pstmt.setString(2, name);
					System.out.print("수정할 생년월일을 입력해 주세요 : ");
					String birth = scan.next();
					pstmt.setString(3, birth);
					pstmt.setString(4, id);
					pstmt.executeUpdate();
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
			}else {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public void selectMember(String id, String password) {
		String sql = "SELECT PASSWORD FROM MEMBER WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String naverPassword = rs.getString("password");
				if(naverPassword.equals(password)) {
					System.out.println("관리자 ID 접속 성공");
					String sql1 = "SELECT * FROM MEMBER";
						pstmt = con.prepareStatement(sql1);
						rs = pstmt.executeQuery();
						while(rs.next()) {
							System.out.print(rs.getString("id")+", ");
							System.out.print(rs.getString("password")+", ");
							System.out.print(rs.getString("name")+", ");
							System.out.print(rs.getString("birth")+", ");
							System.out.print(rs.getString("gender")+", ");
							System.out.print(rs.getString("mail")+", ");
							System.out.print(rs.getString("phone")+", ");
							System.out.println(rs.getString("joindate"));
						}
				}else {
					System.out.println("관리자 아이디가 아닙니다.");
				}
				
			}	
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void deleteMember(String id, String password) {
		String sql = "SELECT PASSWORD FROM MEMBER WHERE ID = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String naverPassword = rs.getString("password");
				if(naverPassword.equals(password)) {
					String sql1 = "DELETE FROM MEMBER WHERE ID=?";
					pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					System.out.println("탈퇴 처리 되었습니다.");
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
			}else {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}

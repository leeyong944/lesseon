package test20191231;

import java.sql.*;
import java.util.*;

public class DBsql {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}

	public void createAccount(Bank bank) {
		String sql = "INSERT INTO BANK VALUES(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bank.getCustomerNo());
			pstmt.setString(2, bank.getName());
			pstmt.setString(3, bank.getAccountNo());
			pstmt.setInt(4, bank.getBalance());
			pstmt.executeUpdate();
			System.out.println("고객 등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public boolean confirm(String name, String accountNo) {
		String sql = "SELECT * FROM BANK WHERE NAME = ? AND ACCOUNTNO = ?";
		boolean confirm = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, accountNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				confirm = true;
			}else {
				confirm = false;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirm;
	}
	
	public void deposit(int deposit, String accountNo) {
		String sql = "SELECT BALANCE FROM BANK WHERE ACCOUNTNO = ?";
		int balance = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				balance = rs.getInt("BALANCE");
			}
			String sql2 = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNTNO = ?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, balance+deposit);
			pstmt.setString(2, accountNo);
			pstmt.executeUpdate();
			System.out.println("입금 완료");
			System.out.println("현재 잔액 : "+(balance+deposit));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void withdraw(int withdraw, String accountNo) {
		String sql = "SELECT BALANCE FROM BANK WHERE ACCOUNTNO = ?";
		int balance = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				balance = rs.getInt("BALANCE");
			}
			if(balance>=withdraw) {
				String sql2 = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNTNO = ?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setInt(1, balance-withdraw);
				pstmt.setString(2, accountNo);
				pstmt.executeUpdate();
				System.out.println("출금 완료");
				System.out.println("현재 잔액 : "+(balance-withdraw));
			}else {
				System.out.println("계좌의 잔액이 부족합니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void account(String accountNo) {
		int balance = 0;
		String sql = "SELECT BALANCE FROM BANK WHERE ACCOUNTNO = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				balance = rs.getInt("BALANCE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("현재 계좌의 잔액은 "+balance+"원 입니다.");
	}
	
	public void remittance() {
		
	}

}

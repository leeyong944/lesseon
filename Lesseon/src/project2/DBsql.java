package project2;

import java.sql.*;
import java.util.*;

public class DBsql {
	int balance = 0 ;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static Map<Integer, List<String>> seats;
	private Scanner scan;
	private List<String> seat;
	private int row;
	private int col;
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}
	
	public DBsql() {
		this.seats = new HashMap<Integer, List<String>>();
		this.scan = new Scanner(System.in);
	}
	
	public List<String> getSeat() {
		return seat;
	}

	public void setSeat(List<String> seat) {
		this.seat = seat;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}
	
	public Map<Integer, List<String>>getSeats(){
		return seats;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	public void signUp(PcManagement pm) {
		String sql = "INSERT INTO PCMEMBER VALUES(?,?,?,?,0)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pm.getId());
			pstmt.setString(2, pm.getPassword());
			pstmt.setString(3, pm.getName());
			pstmt.setString(4, pm.getPhone());
			pstmt.executeUpdate();
			System.out.println("회원가입 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}

	public boolean check(String id, String password) {
		boolean check = true;
		String sql = "SELECT * FROM PCMEMBER WHERE ID = ? AND PASSWORD = ?";
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
	
	public void updateMember(PcManagement pm){
		String sql = "UPDATE PCMEMBER SET PASSWORD = ?, PHONE = ? WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pm.getPassword());
			pstmt.setString(2, pm.getPhone());
			pstmt.setString(3, pm.getId());
			pstmt.executeUpdate();
			System.out.println("회원 정보 수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteMember(String id) {
		String sql = "DELETE FROM PCMEMBER WHERE ID = ?";
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
		String sql = "SELECT PASSWORD FROM PCMEMBER WHERE ID = 'admin'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				if(password.equals(rs.getString("PASSWORD"))){
				System.out.println("관리자 아이디 접속 성공");
				String sql2 = "SELECT * FROM PCMEMBER";
				pstmt = con.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println("");
					System.out.print("아이디 : "+rs.getString("ID")+", ");
					System.out.print("비밀번호 : "+rs.getString("PASSWORD")+", ");
					System.out.print("이름 : "+rs.getString("NAME")+", ");
					System.out.print("전화번호 : "+rs.getString("PHONE")+", ");
					System.out.print("잔액 : "+rs.getInt("BALANCE")+", ");
					System.out.println("");	
			}}} else {
				System.out.println("관리자가 아닙니다");
			}
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void chargeDB(String id, int balance) {
		
		String sql = "SELECT BALANCE FROM PCMEMBER WHERE ID = ? ";
		Scanner scan = new Scanner(System.in);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				this.balance = rs.getInt("balance");
				}
		String sql2 = "UPDATE PCMEMBER SET BALANCE = ? WHERE ID = ?";
		pstmt = con.prepareStatement(sql2);
		pstmt.setInt(1, this.balance+balance);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
}

	public Map<Integer,List<String>> createSeats(){
		for(int i = 0; i < 4; i++) {
			this.seat = new ArrayList<String>();
			for(int j = 0; j < 5; j++) {
				seat.add("☆");
			}
			seats.put(i, seat);
		}
		return seats;
	}
	
			
	public String inputScanner() {
		scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	public int inputScannerInt() {
		scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public void printSeats() {
		for(int i = 0; i < 4; i++) {
			this.seat = this.seats.get(i);
			for(String s : seat) {
				System.out.print(s);
			}
			System.out.println("");
		}
		
	}
	
	public boolean checkRow(int num) {
		if(num <= 0 || num >= 6) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkCol(int num) {
		if(num <= 0 || num >= 5) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkSeats() {
		for(int i = 0; i < 4; i++) {
			List<String> checkList = getSeats().get(this.row - 1);
			for(String s: checkList) {
				if(checkList.get(this.col - 1).equals("★")) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void cancleSeats(String seatNum) {
		seatNum = seatNum.trim();
		seatNum = seatNum.replace(" ", "");
		String seatNumbers[] = seatNum.split(",");
		
		this.setRow(Integer.parseInt(seatNumbers[0]));
		this.setCol(Integer.parseInt(seatNumbers[1]));
		
		List<String> selectSeats = getSeats().get(row-1);
		selectSeats.set(col-1, "☆");
		
		printSeats();
	}
	
	public void pcUse() {
		while(true) {
			System.out.println("pc사용할 좌석을 입력해 주세요 ex(x,y : x번째줄 y번째)");
			printSeats();
			
			String seatNum = inputScanner();
			System.out.println("");
			
			seatNum = seatNum.trim();
			seatNum = seatNum.replace(" ", "");
			String seatNumbers[] = seatNum.split(",");
			
			this.setRow(Integer.parseInt(seatNumbers[0]));
			this.setCol(Integer.parseInt(seatNumbers[1]));
			
			if(checkRow(this.row)||checkCol(this.col)) {
				System.out.println("존재하지 않는 좌석 입니다.");
			}else {
				if(checkSeats()) {
					System.out.println("이미 사용중인 좌석입니다.");
					printSeats();
				}else {
					List<String> selectSeats = getSeats().get(this.row-1);
					selectSeats.set(this.col-1, "★");
					System.out.println(row+"번째 줄 "+col+"번째 좌석에 사용을 시작합니다.");
					printSeats();
					break;
				}
			}
			
		}
	}

}

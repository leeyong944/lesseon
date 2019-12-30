package test20191226_2;

import java.sql.*;
import java.util.*;

//쿼리문을 모아놓은 클래스
public class DBsql {
	// DB 접속을 위한 변수 선언
	Connection con=null;
	// 쿼리문 전송을 위한 변수 선언
	PreparedStatement pstmt = null;
	// 조회(SELECT) 결과를 저장하기 위한 변수 선언
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}
	
	// STUDENT 테이블 전체 조회 메소드
	public void selectDB() {
		//실행하고자 하는 쿼리문을 String 변수로 지정
		String sql ="SELECT * FROM STUDENT";
		
		try {
			// 접속한 DB에 쿼리문을 전송할 준비
			pstmt = con.prepareStatement(sql);
			// 쿼리문을 실행하고 실행결과를 rs에 저장
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("studentno")+", ");
				System.out.print(rs.getString("name")+", ");
				System.out.print(rs.getInt("age")+", ");
				System.out.print(rs.getString("address")+", ");
				System.out.print(rs.getString("gender")+", ");
				System.out.println(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// STUDENT 테이블에 데이터 추가
	public void insertDB() {
		String sql = "INSERT INTO STUDENT VALUES(9, '학생5', 11, '강원도', '남성', '010-9999-9999')";
		
		try {
			pstmt = con.prepareStatement(sql);
			int result = pstmt.executeUpdate(); // 성공하면 1 실패하면 0
			System.out.println("insert 결과 "+result);
			System.out.println("DB에 저장 성공!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
	
//	public void insertDB1(int STUDENTNO, String NAME, int AGE, String ADDRESS, String GENDER, String PHONE) {
//		con = DBConnection.makeConnection();
//		String sql = "INSERT INTO STUDENT VALUES("+STUDENTNO+NAME+AGE+ADDRESS+GENDER+PHONE+")";
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.executeUpdate();
//			System.out.println("DB에 저장 성공!!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void insertDB2() {
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 10);
			pstmt.setString(2, "학생6");
			pstmt.setInt(3, 22);
			pstmt.setString(4, "부산광역시");
			pstmt.setString(5, "여성");
			pstmt.setString(6, "010-1212-1212");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertDB1(Student student) {
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
//		Scanner scan = new Scanner(System.in);
		try {
			pstmt = con.prepareStatement(sql);
//			int studentno;
//			String name;
//			int age;
//			String address;
//			String gender;
//			String phone;
//			System.out.print("학생번호 : ");
//			studentno = scan.nextInt();
//			System.out.print("이름 : ");
//			name = scan.next();
//			System.out.print("나이 : ");
//			age = scan.nextInt();
//			System.out.print("주소 : ");
//			address = scan.next();
//			System.out.print("성별 : ");
//			gender = scan.next();
//			System.out.print("전화번호 : ");
//			phone = scan.next();
			pstmt.setInt(1, student.getStudentNo());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getAge());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getGender());
			pstmt.setString(6, student.getPhone());
			System.out.println("DB저장 완료");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> selectDB1() {
		String sql ="SELECT * FROM STUDENT";
		Student stu = null;
		List<Student> list = new ArrayList<Student>();
		try {	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stu = new Student(rs.getInt("studentno"),rs.getString("name"),rs.getInt("age"),
								  rs.getString("address"),rs.getString("gender"),rs.getString("phone"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	/*
	 * 조건검색
	 *  1. 여자인 학생만 출력하기
	 *  2. 주소가 인천인 학생만 출력하기
	 *  3. 주소 입력해서 출력하기
	 */
	
	
	public void condition() {
		String sql = "SELECT * FROM STUDENT WHERE GENDER = '여성'";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("studentNo")+", ");
				System.out.print(rs.getString("name")+", ");
				System.out.print(rs.getInt("age")+", ");
				System.out.print(rs.getString("address")+", ");
				System.out.print(rs.getString("gender")+", ");
				System.out.println(rs.getString("phone"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void condition2() {
		String sql = "SELECT * FROM STUDENT WHERE ADDRESS LIKE '%인천%'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("studentNo")+", ");
				System.out.print(rs.getString("name")+", ");
				System.out.print(rs.getInt("age")+", ");
				System.out.print(rs.getString("address")+", ");
				System.out.print(rs.getString("gender")+", ");
				System.out.println(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void condition3(String city) {
		String sql = "SELECT * FROM STUDENT WHERE ADDRESS LIKE ?";
		List<Student> stuList = new ArrayList<Student>();
		try {
			Student stu = null;
			Scanner scan = new Scanner(System.in);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+city+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stu = new Student();
				stu.setStudentNo(rs.getInt("studentNo"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("studentNo"));
				stu.setAddress(rs.getString("address"));
				stu.setGender(rs.getString("gender"));
				stu.setPhone(rs.getString("phone"));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Student a : stuList) {
			System.out.println(a);
		}
	}
	
	
	//a
	
	
	
	
	public void updateDB(String phone, int studentNo) {
		String sql = "UPDATE STUDENT SET PHONE = ? WHERE STUDENTNO = ?";
		Student stu = null;
		try {
			stu = new Student();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setInt(2, studentNo);
			pstmt.executeUpdate();
			System.out.println("수정 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteDB(int studentNo) {
		String sql = "DELETE STUDENT WHERE STUDENTNO = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studentNo);
			pstmt.executeUpdate();
			System.out.println("삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

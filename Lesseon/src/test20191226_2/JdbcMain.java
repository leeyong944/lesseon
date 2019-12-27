package test20191226_2;
//a
import java.util.*;

public class JdbcMain {

	public static void main(String[] args) {
		Student student = null;
		List<Student> list = new ArrayList<Student>();
		/*
		 * 1. DBConnection 클래스의 makeConnection 메소드 호출하여
		 *    DB 접속 정보를 가져옴
		 * 2. con 객체를 가지고 DBsql 클래스의 메소드 호출하여 원하는
		 *    쿼리문 실행
		 */
//		Connection con = null;
//		con = DBConnection.makeConnection();
		
		DBsql sql = new DBsql();
//		sql.selectDB(con);
//		
		/*
		 * 1번 선택하면 전체조회, 2번선택하면 데이터 저장
		 */
		Scanner scan = new Scanner(System.in);
		int selectNum = 0;
		boolean run = true;
		while(run) {
			System.out.println("0.DB 접속, 1.전체 조회, 2. 데이터 추가, 3.데이터 추가(? 사용), 4.데이터 추가(입력), 5.전체 조회(ArrayList)"
					 		   +", 6.조건 검색, 7.수정,  8.종료");
			selectNum = scan.nextInt();
			switch(selectNum) {
			case 0 :
				sql.dbConnection();
				break;
			case 1 :
				sql.selectDB();
				break;
			case 2 :
				sql.insertDB();
				break;
			case 3 :
				sql.insertDB2();
				break;
			case 4 :
				int studentNo;
				String name;
				int age;
				String address;
				String gender;
				String phone;
				System.out.print("학생번호 : ");
				studentNo = scan.nextInt();
//				student.setStudentNo(studentNo); 이런식으로 해도됨
				System.out.print("이름 : ");
				name = scan.next();
				System.out.print("나이 : ");
				age = scan.nextInt();
				System.out.print("주소 : ");
				address = scan.next();
				System.out.print("성별 : ");
				gender = scan.next();
				System.out.print("전화번호 : ");
				phone = scan.next();
				student = new Student(studentNo,name,age,address,gender,phone);
				sql.insertDB1(student);
				break;
			case 5 :
//				list = new ArrayList<Student>();
				list = sql.selectDB1();
				//전체조회메소드를 호출하여 호출 결과를 가져옴
				break;
			case 6 :
				System.out.println("1.여성만 출력, 2.인천인 학생 출력 3.주소 입력 출력");
				int selectNum1 = scan.nextInt();
				switch(selectNum1) {
				case 1 : 
					sql.condition();
					break;
				case 2 :
					sql.condition2();
					break;
				case 3 :
					System.out.print("검색할 주소를 입력하세요 : ");
					String city = scan.next();
					sql.condition3(city);
					break;
				}
				
				break;
			case 7 :
				System.out.print("수정할 학생 번호를 입력하세요 : ");
				int studentNo1 = scan.nextInt();
				System.out.print("수정할 전화 번호를 입력하세요 : ");
				String phone1 = scan.next();
				sql.updateDB(phone1, studentNo1);
				break;
			case 8 :
				run = false;				
				break;
				
			}
		}
		int index = 0;
		for(Student a:list) {
			System.out.println(index+""+a);
			index++;
		}
			//DB에서 조회한 전체 학생 목록을 여기 위치에서 출력
		
	}

}

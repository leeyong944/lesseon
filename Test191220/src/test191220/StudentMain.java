package test191220;

import java.util.*;

public class StudentMain {

	public static void main(String[] args) {
		/*
		 * ----------------------------------------------------
		 * 1.학생등록|2.과목별 점수입력|3.점수리스트|4.과목별 최고점수|5.종료
		 * ----------------------------------------------------
		 * 선택>1
		 * 학생정보를 입력하세요
		 * 이름 : ㅇㅇ
		 * 생년월일 : 1999
		 * 주소 : ㅇㅇ
		 * 전화번호:111
		 * 선택>2
		 * 과목별 성적을 입력하세요
		 * 학생이름을 입력하세요 : ㅇㅇ
		 * java 점수 :ㅇㅇ
		 * servlet 점수 :ㅇㅇ
		 * spring 점수 : ㅇㅇ
		 * 선택>3
		 * 이름 생년월일 주소 전화번호 점수들~~~~~~
		 * 선택>4
		 * 과목을 선택하세요
		 * 1.java|2.servlet|3.spring
		 * 선택>1
		 * java의 최고점수는 나나의 99입니다.
         */
		boolean run = true;
		int select = 0;
		String name = null;
		int birth = 0;
		String address = null;
		int phoneNumber = 0;
		
		Scanner scan = new Scanner(System.in);
		Student student = null;
		List<Student> studentMember = new ArrayList<Student>();
		
		
		while(run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.학생등록|2.과목별 점수입력|3.점수리스트|4.과목별 최고점수|5.종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택>");
			select = scan.nextInt();
			switch(select) {
			case 1 :
				int studentNumber = studentMember.size() + 1;
				System.out.println("학생 정보를 입력하세요");
				System.out.print("이름 : ");
				name = scan.next();
				System.out.print("생년월일 : ");
				birth = scan.nextInt();
				System.out.print("주소 : ");
				address = scan.next();
				System.out.print("전화번호 : ");
				phoneNumber = scan.nextInt();
				student = new Student(studentNumber, name, birth, address, phoneNumber);
				studentMember.add(student);
				break;
			case 2 :
				System.out.println("과목별 성적을 입력하세요");
				System.out.print("학생 이름을 입력하세요 : ");
				name = scan.next();
				for(int i = 0; i < studentMember.size(); i++) {
					if(studentMember.get(i).getName().equals(name)) {
						System.out.print("java 점수 : ");
						int javaScore = scan.nextInt();
						studentMember.get(i).setJavaScore(javaScore);
						System.out.print("servlet 점수 : ");
						int servletScore = scan.nextInt();
						studentMember.get(i).setServletScore(servletScore);
						System.out.print("spring 점수 : ");
						int springScore = scan.nextInt();
						studentMember.get(i).setSpringScore(springScore);
						break;
					}
				}
				break;
			case 3 :
				for(int i = 0; i < studentMember.size(); i++) {
					System.out.println(studentMember.get(i));
				}
				break;
			case 4 :
				System.out.println("과목을 선택하세요");
				System.out.println("-------------------------");
				System.out.println("1.java|2.servlet|spring");
				System.out.println("-------------------------");
				System.out.print("선택 >");
				select = scan.nextInt();
				switch(select) {
				case 1 :
					int max = 0;
					for(int i = 0; i < studentMember.size(); i++) {
						if(max < studentMember.get(i).getJavaScore()) {
							max = studentMember.get(i).getJavaScore();
						}
						if(max == studentMember.get(i).getJavaScore()) {
							name = studentMember.get(i).getName();
						}
					}

					System.out.println("java 최고점수는 "+name+"의 "+max+"점 입니다.");
					break;
				case 2 :
					int max1 = 0;
					for(int i = 0; i < studentMember.size(); i++) {
						if(max1 < studentMember.get(i).getServletScore()) {
							max1 = studentMember.get(i).getServletScore();
						}
						if(max1 == studentMember.get(i).getServletScore()) {
							name = studentMember.get(i).getName();
						}
					}
					System.out.println("servlet 최고점수는 "+name+"의 "+max1+"점 입니다.");
					break;
				case 3 :
					int max2 = 0;
					for(int i = 0; i < studentMember.size(); i++) {
						if(max2 < studentMember.get(i).getSpringScore()) {
							max2 = studentMember.get(i).getSpringScore();
						}
						if(max2 == studentMember.get(i).getSpringScore()) {
							name = studentMember.get(i).getName();
						}
					}
					System.out.println("spring 최고점수는 "+name+"의 "+max2+"점 입니다.");
					break;
				}
				break;
			case 5 :
				System.out.println("성적관리 프로그램이 종료됩니다.");
				run = false;
			}
			
		}
		scan.close();

	}

}

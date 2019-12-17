package test;

public class NaverMemberMain {

	public static void main(String[] args) {
		NaverMember ly = new NaverMember("idid", "1234abc", "이용",
				     "1991-01-24", "남자", "tot124@naver.com","01080195124");
		//id 필드에 저장된값 getter 메소드 이용하여 출력하기
		System.out.println(ly.getId());
		//id 필드값을 bb로 저장
		ly.setId("bb");
		System.out.println(ly.getId());
		System.out.println(ly.toString());

	}

	
}

package test20191226_1;

import java.util.*;

public class TryCatch {

	public static void main(String[] args) {
		// ArrayList를 선언해서 Exception을 발생시켜보세요.
		
//		List<String> list = new ArrayList<String>();
//		
//		list.add("aa");
//		for(int i = 0; i<=list.size();i++) {
//			System.out.println(list.get(i));
//		}
//		
		
		try {
			List<String> list = new ArrayList<String>();
			list.add("aa");
			for(int i = 0; i<list.size();i++) {
				System.out.println(list.get(i));
			}
		} catch(IndexOutOfBoundsException e) {
			System.out.println("예외가 발생했습니다.");
			e.printStackTrace();
		} finally {//예외가 발생하든 안하든 무조건나옴  써도되고 안써도되고. try + catch 는 같이 써야함
			System.out.println("무조건 나와요");
		}
		
		
		

	}

}

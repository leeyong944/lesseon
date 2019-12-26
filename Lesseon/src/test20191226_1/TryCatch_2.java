package test20191226_1;

public class TryCatch_2 {

	public static void main(String[] args) {
//		String str1 = "100";
//		String str2 = "a100";
//		System.out.println(str1+str1);
//		int num1 = Integer.parseInt(str1);
//		int num2 = Integer.parseInt(str2);
//		System.out.println(num1+num1);
		
		try {
			String str1 = "100";
			String str2 = "a100";
			System.out.println(str1+str1);
			int num1 = Integer.parseInt(str1);
			int num2 = Integer.parseInt(str2);
			System.out.println(num1+num1);
		} catch(NumberFormatException e) {//Exception 만 써도 가능하긴함.
			System.out.println("예외처리");
			e.printStackTrace();
		} finally {
			String str1 = "100";
			int num1 = Integer.parseInt(str1);
			System.out.println(num1+num1);
		}

	}

}

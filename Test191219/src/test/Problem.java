package test;

import java.util.*;

public class Problem {

	public static void main(String[] args) {
		/*
		 * 단어를 입력하세요:student
		 * 단어를 입력하세요:chair
		 * 단어를 입력하세요:tip
		 * 단어를 입력하세요:school
		 * 단어를 입력하세요:phone
		 * student
		 * chair
		 * tip
		 * school
		 * phone
		 * 가장 긴 단어는 :student 
		 */
        int a = 0;
		String max = null;
		String word1 = null;
		List<String> word = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		for(int i = 1; i <= 5; i++) {
			System.out.print("단어를 입력하세요 : ");
			word1=scan.next();
			word.add(word1);
			if(a<=word1.length()) {
				max = word1;
			}
		}
		for(int j = 0; j < word.size(); j++) {
			System.out.println(word.get(j));
		}
		
		System.out.println("가장 긴 단어는 : "+max);
		
		int longword=0;
		for(int i = 1; i<word.size(); i++) {
			if(word.get(longword).length()<word.get(i).length()) {
				longword = i;
			}
		}
	
	}


}

package javapgm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPalindrome_Pgm {
	static char[] revArr;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		
		//Solution #1 :
//		char[] charArray = inputStr.toCharArray();
//		revArr=new char[charArray.length];
//		for(int i = charArray.length-1,j=0;i>-1;i--, j++) {
//			revArr[j]=charArray[i];
//		}
//		String revStr = String.valueOf(revArr);
//		if(revStr.equalsIgnoreCase(inputStr)) {
//			System.out.println("Given String is Palindrome...");
//		} else {
//			System.out.println("GiverString is not Palindrome...");
//		}
		
		//Solution #2:
		StringBuilder sb = new StringBuilder();
		StringBuilder reverse = sb.append(inputStr).reverse();
		if (reverse.toString().equalsIgnoreCase(inputStr)) {
			System.out.println("Given String is Palindrome...");
		} else {
			System.out.println("GiverString is not Palindrome...");
		}
		
		
	}

}

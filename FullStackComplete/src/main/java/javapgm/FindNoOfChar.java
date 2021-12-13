package javapgm;

import java.util.Scanner;

public class FindNoOfChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int lChar = 0;
		int uChar = 0;
		int sChar = 0;
		int digit = 0;
		char[] cArray = new char[input.length()];
		cArray = input.toCharArray();
		for(int i=0;i<input.length();i++) {
			if(cArray[i] >=65 && cArray[i] <=90) {
				uChar++;
			}else if(cArray[i] >=97 && cArray[i] <=122) {
				lChar++;
			}else if(cArray[i] >=48 && cArray[i] <=57) {
				digit++;
			}else {
				sChar++;
			}
		}
		float percent = (float)(uChar*100)/(float)input.length();
		System.out.println("Number of uppercase letters is "+ uChar + ". So percentage is " + String.format("%.2f", percent) +"%");  
		percent = (float)(lChar*100)/(float)input.length();
		System.out.println("Number of lowercase letters is "+ lChar + ". So percentage is " + String.format("%.2f", percent) +"%");
		percent = (float)(digit*100)/(float)input.length();
		System.out.println("Number of digits is "+ digit + ". So percentage is " + String.format("%.2f", percent) +"%");
		percent = (float)(sChar*100)/(float)input.length();
		System.out.println("Number of other characters is "+ sChar + ". So percentage is " + String.format("%.2f", percent) +"%");
	}

}

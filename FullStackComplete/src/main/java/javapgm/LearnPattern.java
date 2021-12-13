package javapgm;

import java.util.Scanner;
import java.util.regex.Pattern;


public class LearnPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(Pattern.matches("\\d\\d\\d\\d\\d", str));
		sc.close();
	}

}

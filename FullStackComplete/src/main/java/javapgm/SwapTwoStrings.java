package javapgm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapTwoStrings {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int s1Length = s1.length();
		s1=s1+s2;
		s2=s1.substring(0,s1Length);
		s1=s1.substring(s1Length);
		System.out.println(s1);
		System.out.println(s2);
		

	}

}

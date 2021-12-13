package javapgm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromepgm {

	static int inputNum,temp,revNum=0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.print("Enter the number to check : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputNum = Integer.parseInt(br.readLine());
		temp=inputNum;
		while(temp>0) {
			revNum=(revNum*10)+(temp%10);
			temp=temp/10;
		}
		if(inputNum==revNum) {
			System.out.println("Palindrome!!!...");
		}
		else {
			System.out.println("Not Palindrome!!!...");
		}
	}

}

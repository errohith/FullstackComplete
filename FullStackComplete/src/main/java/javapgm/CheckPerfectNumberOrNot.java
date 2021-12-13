package javapgm;

import java.util.Scanner;

public class CheckPerfectNumberOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input the Number : ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int temp=0;
		for(int i=1;i<input;i++) {
			if(input%i==0) {
				temp+=i;
			}
		}
		if(input == temp) {
			System.out.println("Given Number is perfect Number");
		} else {
			System.out.println("Given Number is Not a perfect Number");
		}
		sc.close();

	}

}

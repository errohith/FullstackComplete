package javapgm;

import java.util.Scanner;

public class PatternPgm1 {

	static int fromNum, toNum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter from number : ");
		fromNum=sc.nextInt();
		System.out.print("Enter To number : " );
		toNum=sc.nextInt();
		
		for(int i=fromNum;i<=toNum;i++) {
			if(i%3==0 && i%5==0) {
				System.out.print("FizzBuzz ");
			}
			else if(i%3==0) {
				System.out.print("Fizz ");
			}
			else if(i%5==0) {
				System.out.print("Buzz ");
			}
			else {
				System.out.print(i +" ");
			}
		}
	}

}

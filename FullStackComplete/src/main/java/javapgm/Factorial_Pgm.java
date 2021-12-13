package javapgm;

import java.util.Scanner;

public class Factorial_Pgm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		Factorial_Pgm obj = new Factorial_Pgm();
		int factNum = obj.factorial2(in);
		System.out.println(factNum);
		

	}
	
	//IMPLEMENTATION #1 : Modified Logic with recursive
	public int factorial(int num) {
		if(num>1) {
			num=num * factorial(num-1);
			return num;
		}
		return num;
	}
	
	//IMPLEMENTATION #2 : Proper logic with recursive
	public int factorial1(int num) {
		if(num==0) {
			return 1;
		}
		return num * factorial1(num-1);
	}
	
	//IMPLEMENTATION #2 : Proper logic with iterative
	public int factorial2(int num) {
		int fact = 1;
		for(int i=1;i<=num;i++) {
			fact*=i;
		}
		return fact;
		
		
		
	}

}

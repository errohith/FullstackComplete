package javapgm;

import java.util.Scanner;

public class FloydTriangle {
	static int k=1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Input Number : ");
		int input = sc.nextInt();
		for(int i=0;i<input;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print(k+" ");
				k=k+1;
			}
			System.out.println("");
		}
		
	}
}

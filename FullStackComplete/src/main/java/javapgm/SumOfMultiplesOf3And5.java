package javapgm;

import java.util.Scanner;

public class SumOfMultiplesOf3And5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int temp=0;
		for(int i=3;i<input;i++) {
			if(i%3==0 || i%5==0) {
				temp=temp+i;
			}
		}
		System.out.println(temp);
		

	}

}

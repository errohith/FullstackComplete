package javapgm;

import java.util.Scanner;

public class LargestNumberExceedGivenInput {
	
	/* Get two inputs(1 Number and 1 Digit) from  user. Write a java program to find the largest  number that is less than the given number and  also should not contain the given digit.
	*  For ex, If 154 is the given number and 5 is the given digit, then  you should find the largest number less than 154 such that it  should not contain 5 in it. In this case, 149 will be the answer.
	*  Note: Write a pseudocode first and then proceed to coding.
	*/
	static int flag = -1;
	static int arr[] = new int[3];
	static int num;
	static int inc=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Input Number : ");
		int inputNum = sc.nextInt();
		System.out.println("Ënter a Digit : ");
		int inputDigit = sc.nextInt();
		int temp = inputNum;
		while(inputNum>0) {
			num= inputNum%10;
			inputNum=inputNum/10;
			if(num==inputDigit) {
				flag=inc;
			}
			inc++;
		}
		System.out.println("Result is :");
		if (flag == -1) {
			System.out.println("Entered Digit is not within the given number");
		} else {
			for(int i=0;i<=flag;i++) {
				if(i==flag) {
					System.out.println((int)(temp-(temp%(Math.pow(10, i)))-1));
				}
			}
		}
	}

}

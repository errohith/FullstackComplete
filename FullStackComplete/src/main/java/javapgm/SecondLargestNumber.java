package javapgm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SecondLargestNumber {

	static List<Integer> arrList;
	static List<Integer> arrList1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Solution #1 :
		//Integer[] intArray = {20, 340, 21, 879, 92, 21,474,83647,-200};
		Integer[] intArray = {-20, -340, -21, -879, -92, -21,-474,-83647,-200};
		int temp;
		for(int i=0;i<intArray.length;i++ ) {
			for(int j=i+1;j<intArray.length;j++) {
				if(intArray[i]<intArray[j]) {
					temp = intArray[i];
					intArray[i] = intArray[j];
					intArray[j] = temp;
				}
			}
		}
		
		System.out.println(intArray[1]);
		
		//Solution #2 :
		arrList=Arrays.asList(intArray);
		arrList.sort(Comparator.reverseOrder());
		System.out.println(arrList.get(1));
		
		//Solution #3 :
		arrList1 = new ArrayList<Integer>();
		Collections.addAll(arrList1, intArray);
		Collections.sort(arrList1);
		System.out.println(arrList1.get(arrList1.size()-2));

	}

}

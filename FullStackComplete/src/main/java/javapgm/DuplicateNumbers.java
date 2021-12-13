package javapgm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] a = {13,15,67,88,65,13,99,67,65,87,13};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0;i<a.length;i++) {
			if(map.get(a[i])==null) {
				map.put(a[i], 1);
			} else {
				map.put(a[i], map.get(a[i])+1);
			}
		}
		Set<Integer> keySet = map.keySet();
		for (Integer key : keySet) {
			if(map.get(key)>1) {
				
				System.out.print(key + " ");
			}
		}
	}
	

}

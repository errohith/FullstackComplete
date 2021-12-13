package javapgm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class printUniqueCharacters {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] cInput = input.toCharArray();
		Set<Character> set = new LinkedHashSet<>();
		for (Character c : cInput) {
			if(!(c==' ')) {
				set.add(Character.toLowerCase(c));
			}
		}
		String output = "";
		for (Character ch : set) {
			output=output+ch;
		}
		System.out.println(output);
	}

}

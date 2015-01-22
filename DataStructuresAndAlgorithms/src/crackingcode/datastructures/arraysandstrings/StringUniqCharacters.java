package crackingcode.datastructures.arraysandstrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1.1 Implement an algorithm to determine if a string has all unique characters
 * What if you can not use additional data structures? (Page 48)
 * 
 * @author varadmeru
 */
public class StringUniqCharacters {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = null;

		// Take input
		try {
			input = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Print out the result
		System.out.println(uniqCharacters1(input));
		System.out.println(uniqCharacters2(input));
	}

	private static String uniqCharacters1(String input) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String uniqCharacters2(String input) {
		// TODO Auto-generated method stub
		return null;
	}
}
package basics.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reverses a string.
 * 
 * @input: From Command Line.
 * @output: Reverse of the string.
 * @author varadmeru
 */
public class ReverseString {
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
		System.out.println(reverseString(input));
	}

	public static String reverseString(String input) {
		// Create a buffer to hold the reverse string
		StringBuffer reverse = new StringBuffer();

		// Parse the inupt string from the end till the start and put it in the
		// reverse string buffer.
		for (int i = input.length() - 1; i >= 0; i--) {
			reverse.append(input.charAt(i));
		}
		return reverse.toString();
	}
}

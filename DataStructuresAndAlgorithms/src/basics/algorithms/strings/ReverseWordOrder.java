package basics.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author varadmeru
 *
 */
public class ReverseWordOrder {

	/**
	 * @param args
	 */
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
		System.out.println(reverseOrderOfWords1(input));
		System.out.println(reverseOrderOfWords2(input));
	}

	/**
	 * @param input
	 * @return
	 */
	private static String reverseOrderOfWords1(String input) {
		StringBuffer buffer1 = new StringBuffer();
		StringBuffer buffer2 = new StringBuffer();

		input.trim();

		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) != ' ') {
				buffer1.append(input.charAt(i));
			} else {
				for (int j = buffer1.length() - 1; j >= 0; j--) {
					buffer2.append(buffer1.charAt(j));
				}
				buffer2.append(' ');
				buffer1 = new StringBuffer();
			}
		}

		// For the last word, still residing in the buffer1.
		for (int j = buffer1.length() - 1; j >= 0; j--) {
			buffer2.append(buffer1.charAt(j));
		}

		return buffer2.toString();
	}

	private static String reverseOrderOfWords2(String input) {
		StringBuffer buffer1 = new StringBuffer();
		StringBuffer buffer2 = new StringBuffer();

		input.trim();

		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) != ' ') {
				buffer1.append(input.charAt(i));
			} else {
				buffer2.append(buffer1.reverse());
				buffer2.append(' ');
				buffer1 = new StringBuffer();
			}
		}

		// For the last word, still residing in the buffer1.
		buffer2.append(buffer1.reverse());

		return buffer2.toString();
	}
}

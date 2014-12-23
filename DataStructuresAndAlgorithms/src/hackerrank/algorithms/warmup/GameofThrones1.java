package hackerrank.algorithms.warmup;

import java.util.*;

/*
 * King Robert has 7 kingdoms under his rule. He finds out from a 
 * raven that the Dothraki are soon going to wage a war against him. 
 * But, he knows the Dothraki need to cross the Narrow River to enter 
 * his realm. There is only one bridge that connects both banks of the 
 * river which is sealed by a huge door.

 door

 The king wants to lock the door so that the Dothraki can't enter. 
 But, to lock the door he needs a key that is an anagram of a certain palindrome string.
 The king has a string composed of lowercase English letters. 
 Help him figure out if any anagram of the string can be a palindrome or not.

 Input Format 
 A single line which contains the input string

 Constraints 
 1<=length of string <= 10^5 
 Each character of the string is a lowercase English letter.

 Output Format 
 A single line which contains YES or NO in uppercase.

 Sample Input : 01
 aaabbbb
 Sample Output : 01
 YES

 Explanation 
 A palindrome permutation of the given string is bbaaabb. 

 Sample Input : 02
 cdefghmnopqrstuvw
 Sample Output : 02
 NO

 Explanation 
 You can verify that the given string has no palindrome permutation. 

 Sample Input : 03
 cdcdcdcdeeeef
 Sample Output : 03
 YES

 Explanation 
 A palindrome permutation of the given string is ddcceefeeccdd .
 */

public class GameofThrones1 {
	static String palidromeExists(String input) {
		int temp = 0;
		int length = input.length();
		char[] x = new char[length];
		boolean isEven = (length % 2 == 0) ? true : false;
		boolean isOdd = false;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		// Building the Map of the frequency of the characters of the string.
		for (int i = 0; i < length; i++) {
			if (map.containsKey(input.charAt(i))) {
				temp = map.get(input.charAt(i));
				temp++;
				map.put(input.charAt(i), temp);
			} else {
				map.put(input.charAt(i), 1);
			}
		}

		int currentPointer = 0;
		// Per character in the Map
		for (Character key : map.keySet()) {

			// fetch the frequency of the character
			int tempx = map.get(key);
			// If it is even, start placing it from both the ends
			if (tempx % 2 == 0) {
				// While all the characters are used up!
				while (tempx > 0) {
					x[currentPointer] = key;
					x[length - currentPointer - 1] = key;
					tempx -= 2;
					currentPointer++;
				}
				// For characters with odd frequency
			} else {
				// If the string is has a length which is an even number,
				// there's no place for ODD numbered frequency
				if (isEven) {
					return "NO";
				} else {
					// There can only be one odd character. So, created a flag
					// isOdd which sets up for the first time and the next time
					// it throws an exception (returns NO in our case)
					if (!isOdd) {
						x[length / 2] = key;
						tempx--;
						for (int k = 1; tempx > 0; k++) {
							x[length / 2 + k] = key;
							x[length / 2 - k] = key;
							tempx -= 2;
						}
						isOdd = true;
					} else {
						return "NO";
					}
				}
			}
		}
		System.out.println(x);

		return "YES";
	}

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();
		String ans;

		ans = palidromeExists(inputString);

		// Assign ans a value of YES or NO, depending on whether or not
		// inputString satisfies the required condition
		System.out.println(ans);
		myScan.close();
	}
}

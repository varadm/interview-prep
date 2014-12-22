package hackerrank.algorithms.warmup;

import java.util.Scanner;

/*
 * Problem Statement

 Roy wanted to increase his typing speed for programming contests. 
 So, his friend advised him to type the sentence "The quick brown 
 fox jumps over the lazy dog" repeatedly because it is a pangram. 
 ( pangrams are sentences constructed by using every letter of the 
 alphabet at least once. )

 After typing the sentence several times, Roy became bored with it. 
 So he started to look for other pangrams.

 Given a sentences, tell Roy if it is a pangram or not.

 Input Format
 Input consists of a line containing s.

 Constraints 
 Length of s can be atmost 103 (1≤|s|≤103) and it may contain spaces, lowercase and uppercase letters. Lowercase and uppercase instances of a letter are considered same.

 Output Format
 Output a line containing pangram if s is a pangram, otherwise output not pangram.

 Sample Input #1
 We promptly judged antique ivory buckles for the next prize
     
 Sample Output #1
 pangram
 
 Sample Input #2
 We promptly judged antique ivory buckles for the prize
     
 Sample Output #2
 not pangram
 
 Explanation

 In the first testcase, the answer is pangram because the sentence contains 
 all the letters.
 */

public class Pangrams {
	static String isPangram(String input) {
		boolean[] charBM = new boolean[26];
		String inputLower = input.toLowerCase();
		int aCharNum = (int) 'a';

		for (int i = 0; i < inputLower.length(); i++) {
			if (inputLower.charAt(i) != ' ')
				charBM[(((int) inputLower.charAt(i)) % aCharNum)] = true;
		}

		for (int j = 0; j < 26; j++) {
			if (charBM[j] == false) {
				return "not pangram";
			}
		}

		return "pangram ";
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		String inputString;
		Scanner in = new Scanner(System.in);

		// Get the number of input integers
		inputString = in.nextLine();

		// isPangram(string)
		System.out.println(isPangram(inputString));

		in.close();
	}
}

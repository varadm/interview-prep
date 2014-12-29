package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * <pre>
 * Problem Statement
 * Watson gives two integers A & B to Sherlock and asks if he can count 
 * the number of square integers between A and B (both inclusive). A square 
 * integer is an integer which is the square of any integer. 
 * For example, 1, 4, 9, 16 are some of the square integers as they are 
 * squares of 1, 2, 3, 4 respectively.
 * 
 * Input Format 
 * First line contains T, the number of testcases. T test cases follow, each in a newline. 
 * Each testcase contains two space separated integers denoting A and B.
 * 
 * Output Format 
 * For each testcase, print the required answer in a new line.
 * 
 * Constraints 
 * 1 ≤ T ≤ 100 
 * 1 ≤ A ≤ B ≤ 109
 * 
 * Sample Input
 * 2
 * 3 9
 * 17 24
 * 
 * Sample output
 * 2
 * 0
 * 
 * Explanation 
 * Test Case #00: In range [3,9], 4 and 9 are the two square numbers. 
 * Test Case #01: In range [17,24], there are no square numbers.
 * </pre>
 * 
 * @author varadmeru
 */

public class SherlockAndSquares {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println(getSquares(in.nextLong(), in.nextLong()));
		}
		in.close();
	}

	static long getSquares(long num1, long num2) {
		if (num1 == 0)
			num1++;
		Double x = Math.sqrt(num1);
		Double y = Math.sqrt(num2);
		long xLong = x.longValue();
		long yLong = y.longValue();
		long count = 0L;

		for (long i = xLong; i <= yLong; i++) {
			if ((i * i) <= num2 && (i * i) >= num1)
				count++;
		}

		return count;
	}
}

package hackerrank.algorithms.warmup;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <pre>
 * Problem Statement
 * 
 * Manasa is out on a hike with friends. She finds a trail of stones with 
 * numbers on them. She starts following the trail and notices that two 
 * consecutive stones have a difference of either a or b. Legend has it 
 * that there is a treasure trove at the end of the trail and if Manasa 
 * can guess the value of the last stone, the treasure would be hers. 
 * Given that the number on the first stone was 0, find all the possible 
 * values for the number on the last stone.
 * 
 * Note : The numbers on the stones are in increasing order
 * 
 * Input Format 
 * The first line contains an integer T i.e. the number of Test cases. T testcases follow. 
 * Each testcase has 3 lines. The first line contains n ( the number of stones ) 
 * The second line contains a. The third line contains b.
 * 
 * Output Format 
 * Space separated list of numbers which are the possible values of the last stone in increasing order.
 * 
 * Constraints 
 * 1 ≤ T ≤ 10 
 * 1 ≤ n, a, b ≤ 103
 * 
 * Sample Input
 * 2
 * 3 
 * 1
 * 2
 * 4
 * 10
 * 100
 * 
 * Sample Output
 * 2 3 4 
 * 30 120 210 300
 *  
 * Explanation
 * All possible series for first test cases are given below.
 * 0,1,2
 * 0,1,3
 * 0,2,3
 * 0,2,4
 * 
 * Hence the answer 2 3 4.
 * 
 * Series with different number of final step for second test cases are
 * 0, 10, 20, 30
 * 0, 10, 20, 120
 * 0, 10, 110, 120
 * 0, 10, 110, 210
 * 0, 100, 110, 120
 * 0, 100, 110, 210
 * 0, 100, 200, 210
 * 0, 100, 200, 300
 * 
 * hence the answer 30 120 210 300
 * 
 * Extra Input
 * 3
 * 3
 * 1
 * 2
 * 4
 * 10
 * 100 
 * 10 
 * 5 
 * 100
 * 
 * 45 140 235 330 425 520 615 710 805 900
 * </pre>
 * 
 * @author varadmeru
 */
public class ManasaAndStones {
	static String getPossibleValues(int numOfStones, int a, int b) {
		// Maintaining the current entries in the currentSet.
		SortedSet<Integer> currentSet = new TreeSet<Integer>();
		// Next iteration entries in the set.
		SortedSet<Integer> nextSet = new TreeSet<Integer>();
		// Initial value of the stone is 0.
		currentSet.add(0);

		// for each stone we got, (we start with 1 and not zero as 1st stone
		// would have the value 0, which is counted for, in the previous line.
		for (int i = 1; i < numOfStones; i++) {
			// for each possible stone value available in the currentSet, add
			// the value by a and b and put it into the nextSet.
			for (Integer stoneNum : currentSet) {
				nextSet.add(stoneNum + a);
				nextSet.add(stoneNum + b);
			}
			// Clear the currentSet.
			currentSet.clear();
			// Add all the entries from the nextSet.
			currentSet.addAll(nextSet);
			// Clear the nextSet.
			nextSet.clear();
		}
		// Creating the StringBuffer for the expected output.
		StringBuffer buffer = new StringBuffer();
		for (Integer integer : currentSet) {
			buffer.append(integer + " ");
		}

		// no need for keeping the mem.
		currentSet.clear();

		// Removing the trailing spaces.
		return buffer.toString().trim();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numTestCases = in.nextInt();

		for (int i = 0; i < numTestCases; i++) {
			int numStones = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(getPossibleValues(numStones, a, b));
		}

		in.close();
	}
}

/*
 * 
 * 
 * 2 3 1 2 4 10 100
 * 
 * 
 * 
 * 3 3 1 2 4 10 100 10 5 100
 */
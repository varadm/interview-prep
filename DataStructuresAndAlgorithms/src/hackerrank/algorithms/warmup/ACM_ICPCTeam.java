package hackerrank.algorithms.warmup;

import java.util.Scanner;

/*
 * Problem Statement

 You are given a list of N people who are attending ACM-ICPC World Finals. 
 Each of them are either well versed in a topic or they are not. 
 Find out the maximum number of topics a 2-person team can know. 
 And also find out how many teams can know that maximum number of topics.

 Input Format

 The first line contains two integers N and M separated by a single space, 
 where N represents the number of people, and M represents the number of topics. 
 N lines follow.
 Each line contains a binary string of length M. If the ith line's jth character is 1, 
 then the ith person knows the jth topic and doesn't know the topic otherwise.

 Output Format
 On the first line, print the maximum number of topics a 2-person team can know. 
 On the second line, print the number of 2-person teams that can know the maximum number of topics. 

 Constraints 
 2 ≤ N ≤ 500 
 1 ≤ M ≤ 500

 Sample Input
 4 5
 10101
 11100
 11010
 00101

 Sample Output
 5
 2

 Explanation 
 (1, 3) and (3, 4) know all the 5 topics. So the maximal topics a 2-person team knows 
 is 5, and only 2 teams can achieve this.
 */

public class ACM_ICPCTeam {
	public static void main(String[] args) {
		acm();
	}

	static void acm() {
		int numOfStudents = 0;
		int numOfSubjects = 0;
		int currentHighest = Integer.MIN_VALUE;
		int currentFrequency = Integer.MIN_VALUE;
		Scanner in = new Scanner(System.in);

		// Get the number of input Strings
		numOfStudents = in.nextInt();
		numOfSubjects = in.nextInt();

		int[][] input2d = new int[numOfStudents][numOfSubjects];
		int[] counter = new int[numOfStudents];

		in.nextLine();

		// For each string read, push it to the LinkedList.
		for (int i = 0; i < numOfStudents; i++) {
			String temp = in.nextLine();
			for (int j = 0; j < numOfSubjects; j++) {
				input2d[i][j] = Integer.parseInt(temp.charAt(j) + "");
			}
		}

		// For all students
		for (int i = 0; i < numOfStudents; i++) {
			// For all subjects
			for (int j = 0; j < numOfSubjects; j++) {
				// For all students after i'th student.
				for (int k = i + 1; k < numOfStudents; k++) {
					// If anyone of the students has a one
					if (input2d[i][j] == 1 || input2d[k][j] == 1) {
						// incr the counter.
						counter[k]++;
					}
				}
			}
			for (int j = 0; j < counter.length; j++) {
				if (counter[j] > currentHighest) {
					currentHighest = counter[j];
					currentFrequency = 1;
				} else if (counter[j] == currentHighest) {
					currentFrequency++;
				}
			}
			for (int j = 0; j < counter.length; j++) {
				counter[j] = 0;
			}
		}

		System.out.println(currentHighest);
		System.out.println(currentFrequency);

		in.close();
	}
	/**
	 * The following piece of code was n^2. And was horrible in timing.
	 * 
	 * <pre>
	 * <code>
	 *  public static void main(String[] args) {
	 * 			int numOfStudents = 0;
	 * 			int numOfSubjects = 0;
	 * 			int groups = 0;
	 * 			int subjects = 0;
	 * 
	 * 			List<String> input = new LinkedList<String>();
	 * 			Scanner in = new Scanner(System.in);
	 * 
	 * 			// Get the number of input Strings
	 * 			numOfStudents = in.nextInt();
	 * 			numOfSubjects = in.nextInt();
	 * 			in.nextLine();
	 * 
	 * 			// For each string read, push it to the LinkedList.
	 * 			for (int i = 0; i < numOfStudents; i++) {
	 * 				input.add(in.nextLine());
	 * 			}
	 * 			
	 * 			int temp = 0;
	 * 			// For each string read, push it to the LinkedList.
	 * 			for (int i = 0; i < numOfStudents; i++) {
	 * 				for (int j = i + 1; j < numOfStudents; j++) {
	 * 					temp = 0;
	 * 					for (int k = 0; k < numOfSubjects; k++) {
	 * 						if (input.get(i).charAt(k) == '1' || input.get(j).charAt(k) == '1') {
	 * 							temp++;
	 * 						}
	 * 					}
	 * 				}
	 * 				if (temp > subjects) {
	 * 					subjects = temp;
	 * 					groups = 1;
	 * 				} else if (temp == subjects) {
	 * 					groups++;
	 * 				}
	 * 			}
	 * 			System.out.println(subjects);
	 * 			System.out.println(groups);
	 * 			in.close();
	 * 		}
	 * 		</code>
	 * </pre>
	 */
}
package interviewquestions.palantir;

import java.util.Scanner;

/**
 * Need to remove statics and make it more dynamic.
 * 
 * @author varadmeru
 */
public class PalantirMagicBox {
	// Global variable. Reduces the passing overload.
	static int[][] input2dArray;

	static int numRows, numColumns;

	// Integer representations of P and T would be used to store the input
	static final int P = 0;
	static final int T = 1;

	/**
	 * Important function. Logic is in this function.
	 * 
	 * @param numRows
	 * @param numColumns
	 * @return
	 */
	static int getNumberOfWishes() {
		// To maximize this entry.
		int currentWishes = Integer.MIN_VALUE;
		
		for(int i = 0; i < numColumns; i++) {
			for (int j = i; j < numColumns; j++) {
				flipEntriesInt(createArrayWithRange(i,j));
				int currentSums = getMinOrMaxSumsFromRows();
				currentWishes = (currentWishes < currentSums) ? currentSums: currentWishes;
			}
		}
		
		return currentWishes;
	}
	
	/**
	 * @return
	 */
	static int getMinOrMaxSumsFromRows(){
		int[] currentRowSums = getRowsSum();
		int temp = 0;
		for (int i : currentRowSums) {
			if(i == 0 || i == numColumns) temp++;
		}
		return temp;
	}

	/**
	 * The flipper.
	 * 
	 * @param columns
	 */
	static void flipEntriesInt(int[] columns) {
		for (int col : columns) {
			for (int row = 0; row < input2dArray.length; row++) {
				input2dArray[row][col] = (input2dArray[row][col] == P) ? T : P;
			}
		}
	}

	/**
	 * @return array of sums of rows
	 */
	static int[] getRowsSum() {
		// Sum of Rows and Columns
		int[] sumRows = new int[numRows];

		// Find the sum of all the rows and store it in sumRows.
		for (int rowNum = 0; rowNum < numRows; rowNum++) {
			for (int colNum = 0; colNum < numColumns; colNum++) {
				sumRows[rowNum] += input2dArray[rowNum][colNum];
			}
		}
		return sumRows;
	}

	/**
	 * @return array of sums of columns
	 */
	int[] getColsSum() {
		// Sum of Columns
		int[] sumCols = new int[numColumns];

		// Find the sums of all the columns and store it in sumCols.
		for (int rowNum = 0; rowNum < numRows; rowNum++) {
			for (int colNum = 0; colNum < numColumns; colNum++) {
				sumCols[colNum] += input2dArray[rowNum][colNum];
			}
		}
		return sumCols;
	}

	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return returns an array with the range provided by the start and the end parameters
	 */
	static int [] createArrayWithRange (int start, int end) {
		int range = end - start + 1;
		int[] array = new int[range];
		
		for(int i = 0; i < range; i++, start++){
			array[i] = start;
		}
		
		return array;
	}
	
	/**
	 * Main Functions
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		// Get the number of input rows and columns
		numRows = in.nextInt();
		numColumns = in.nextInt();

		// create a new 2d array
		input2dArray = new int[numRows][numColumns];

		// eat the next line
		in.nextLine();

		// For each string read, see what the character is? If its a P or a T?
		for (int i = 0; i < numRows; i++) {
			String temp = in.nextLine();
			for (int j = 0; j < numColumns; j++) {
				input2dArray[i][j] = temp.charAt(j) == 'P' ? P : T;
			}
		}
		
		// close the reader
		in.close();
		
		// Calls the function which will compute the number of wishes we get.
		System.out.println(getNumberOfWishes());

	}
}
 
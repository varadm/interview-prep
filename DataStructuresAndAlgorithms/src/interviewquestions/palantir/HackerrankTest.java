package interviewquestions.palantir;

import java.util.Scanner;

public class HackerrankTest {
    static String testAnagrams(String string1, String string2){
    	int lengthAscii = 255;
        int charAscii1 [] = new int [lengthAscii];
        int charAscii2 [] = new int [lengthAscii];
        
        for(int i = 0; i< string1.length(); i++) charAscii1[(int)string1.charAt(i)]++;
        for(int i = 0; i< string2.length(); i++) charAscii2[(int)string2.charAt(i)]++;
        
        for (int i = 0; i < lengthAscii; i++) {
			if(charAscii1[i] == charAscii2[i]) continue;
			else return "Not anagrams!";
			
		}
        return "Anagrams!";
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner myScan = new Scanner(System.in);
		String inputString1 = myScan.nextLine();
        String inputString2 = myScan.nextLine();
        
        System.out.println(testAnagrams(inputString1, inputString2));
        myScan.close();
    }
}

import java.util.*;
import java.lang.*;

public class prob6
{
	static final int MAXSIMULATION = 10000;
	static final char NOBALL = '0';
	static final char BALL = '1';
	static final int SIZE = 25;
	static Scanner scnr;
    public static void main(String args[])
    {
		scnr = new Scanner(System.in);

		int n = scnr.nextInt(); scnr.nextLine();
		while(n-->0){
			validPattern();
		}

    }

	static void validPattern(){
		String patternString;
        char[] catchArr = new char[MAXSIMULATION];
        Arrays.fill(catchArr, NOBALL);

		patternString = scnr.nextLine();
		String patternArr[] = patternString.split(" ");

		int numBalls = patternArr.length;
        int[] pattern = new int[patternArr.length];
        for(int i = 0; i < numBalls; i++){
            pattern[i] = Integer.valueOf(patternArr[i]);
		}

        boolean crash = false;
        for(int i = 0; i < MAXSIMULATION-300 && !crash; i++){
			// Add a ball if we are at the starting pattern
			if(i < pattern.length && catchArr[i] == NOBALL && pattern[i] != 0){
				catchArr[i] = BALL;
			}
			// // Check we have a ball to throw if needed
			// if(pattern[i % pattern.length] != 0 && catchArr[i] == NOBALL){
			// 	crash = true;
			// }
			// We weren't supposed to catch anything here
			if(pattern[i % pattern.length] == 0 && catchArr[i] == BALL){
				crash = true;
			}
            // Get which toss we are on
            int jump = pattern[i % pattern.length];

            // check if we crash
            if(catchArr[i + jump] == BALL) {
                crash = true;
            }

            // else we can catch the ball at that time
            catchArr[i + jump] = BALL;

        }
		if(!crash)
			System.out.println(patternString + " - can be juggled");
		else
			System.out.println(patternString + " - cannot be juggled");
	}
}

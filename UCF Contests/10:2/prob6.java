
import java.util.*;
import java.lang.*;

public class prob6
{
	static MAXSIMULATION = 10000;
	static char EMPTY = '0';
	static int SIZE = 25;
	static Scanner scnr
    public static void main(String args[])
    {
		scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		while(n-->0){
			validPattern();
		}

    }

	static void validPattern(){
		while(true)
        {
            char[] catchArr = new char[MAXSIMULATION];
            Arrays.fill(catchArr, EMPTY);

			String patternString = scnr.nextLine(); scnr.nextLine();
			String patternArr[] = patternString.split(" ");

            int[] pattern = new int[patternArr.length];
            for(int i = 0; i < numBalls; i++)
                pattern[i] = Integer.valueOf(patternArr[i]);

            char nextBall = 'A';
            boolean crash = false;
            for(int i = 0; i < MAXSIMULATION-300; i++){
                if(catchArr[i] == EMPTY){
                    catchArr[i] = nextBall;
                    nextBall++;
                }
                // Get which ball we are on
                char curBall = catchArr[i];
                int jump = pattern[i % numBalls];

                // don't worry about beyond MAXSIMULATION
                if(i + jump >= MAXSIMULATION) continue;

                // check if we hit a crash
                if(catchArr[i + jump] != EMPTY) {
                    System.out.println("CRASH"); //at position " + i + " TO position " + (i+jump));
                    crash = true;
                    break;
                }
                // else we can catch the ball at that time
                catchArr[i + jump] = curBall;
            }

            if(!crash){
				System.out.println(patternString " - can be juggled");
				return;
			}

        }
		System.out.println(patternString " - cannot be juggled");
	}
}


import java.util.*;
import java.lang.*;

class g
{
    public static void main(String args[])
    {
        char EMPTY = '0';
        int SIZE = 20;

        Scanner scnr = new Scanner(System.in);

        while(true)
        {
            int numBalls = scnr.nextInt();
            if(numBalls == 0) return;

            char[] catchArr = new char[SIZE];
            Arrays.fill(catchArr, EMPTY);

            int[] pattern = new int[numBalls];
            for(int i = 0; i < numBalls; i++)
                pattern[i] = scnr.nextInt();

            char nextBall = 'A';
            boolean crash = false;
            for(int i = 0; i < SIZE; i++){
                if(catchArr[i] == EMPTY){
                    catchArr[i] = nextBall;
                    nextBall++;
                }
                // Get which ball we are on
                char curBall = catchArr[i];
                int jump = pattern[i % numBalls];

                // don't worry about beyond 20
                if(i + jump >= SIZE) continue;

                // check if we hit a crash
                if(catchArr[i + jump] != EMPTY) {
                    System.out.println("CRASH"); //at position " + i + " TO position " + (i+jump));
                    crash = true;
                    break;
                }
                // else we can catch the ball at that time
                catchArr[i + jump] = curBall;
            }

            if(!crash)System.out.println(new String(catchArr));

        }
    }
}

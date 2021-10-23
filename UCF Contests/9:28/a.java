
import java.util.*;
import java.lang.*;

class a
{
    public static void main(String args[])
    {
        char EMPTY = '0';
        int SIZE = 20;

        Scanner scnr = new Scanner(System.in);

        int numBalls = scnr.nextInt();
        while(numBalls != 0)
        {
            String catch = new String();
            for(int i = 0; i < SIZE; i++){
                catch[i] = EMPTY;
            }

            int[] pattern = new int[numBalls];
            for(int i = 0; i < numBalls; i++)
                pattern[i] = scnr.nextInt();

            char nextBall = 'A';

            for(int i = 0; i < SIZE; i++){
                if(catch[i] == EMPTY){
                    catch[i] = nextBall++;
                }
                // Get which ball we are on
                char curBall = catch[i];
                int jump = pattern[curBall - 'A'];

                // don't worry about beyond 20
                if(i + jump >= SIZE) continue;

                // check if we hit a crash
                if(catch[i + jump] != EMPTY) {
                    System.out.println("CRASH");
                    return;
                }
                // else we can catch the ball at that time
                catch[i + jump] = curBall;
            }

            System.out.println(new String(catch));

            int numBalls = scnr.nextInt();
        }
    }

    public static boolean rec(int cap, int[] nums){
      if(cap == 0) return true;

      for(int i = 1; i <= 3; i++){
        //System.out.println("nums[" + i+ "] = " + nums[i]);
        if(nums[i] == 0) continue;
        nums[i]--;
        if(rec(cap-i, nums)) return true;
        nums[i]++;
      }

      return false;
    }
}

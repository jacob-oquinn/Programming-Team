
import java.util.*;
import java.lang.*;

class c
{
	static final int EMPTY = -1;
	static final int MOD = 10007;
    public static void main(String args[])
    {
		Scanner scnr = new Scanner(System.in);

        int T = scnr.nextInt();
        for(int caseNum = 1; caseNum <= T; caseNum++){

			scnr.nextInt(); // get rid of the given case num

			int steps = scnr.nextInt();

			// d[i] = the number of valid moves given a fresh game with i stepsLeft
			int[] dp = new int[steps+3];
			// initalize dp
			for(int i = 0; i < dp.length; i++)
				dp[i] = EMPTY;
			dp[0] = 0;
			dp[1] = 2;
			dp[2] = 3;

			System.out.println(caseNum + " " + countPaths(steps, dp));
        }

    }

	static int countPaths(int steps, int[] dp){

		if(dp[steps] != EMPTY)
			return dp[steps];

		if(dp[steps-1] == EMPTY)
			countPaths(steps-1, dp);

		int numPaths = 0;

		// take a step right
		numPaths = (numPaths + dp[steps-1]) % MOD;

		// take a step down-right
		numPaths = (numPaths + dp[steps-2]) % MOD;

		// Check if we could have looped back perfectly
		// Completely filled
		if(steps % 2 == 1)
			numPaths = (numPaths + 1) % MOD;

		dp[steps] = numPaths;
		return dp[steps];

	}


}

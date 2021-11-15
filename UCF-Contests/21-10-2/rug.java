
import java.util.*;
import java.lang.*;

class rug
{
    static int n;
    static int[][]dp;
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

		n = scnr.nextInt();
		int s = scnr.nextInt();
		char[][] grid = new char[n][n];
		for(int i = 0; i < n; i++){
			String str = scnr.next();
			for(int j = 0; j < str.length(); j++){
				grid[i][j] = str.charAt(j);
			}
		}

        dp = new int[n][n]; // store number of dirty in rect (0,0) to (i,j)
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], 0);

        // initialize first position
        dp[0][0] = dirty(grid, 0, 0);

        // initialize first row and first col
        for(int row = 1; row < n; row++)
            dp[row][0] = dp[row-1][0] + dirty(grid,row,0);

        for(int col = 1; col < n; col++)
            dp[0][col] = dp[0][col-1] + dirty(grid,0,col);
        // initialize rest of array
		for(int col = 1; col < n; col++){
			for(int row = 1; row < n; row++){
				dp[row][col] = dp[row-1][col] + dp[row][col-1] - dp[row-1][col-1] + dirty(grid, row, col);
			}
		}

        // rug covers between 0 and s*s dirty spots
        int[] freq = new int[s*s+1];
        // check every spot we can put the rug and count how many dirty spots it covers
        // using bottom right corner as reference
        int c = 0;
        for(int row = s-1; row < n; row++){
            for(int col = s-1; col < n; col++){
                c++;
                int dirtyCovered = dp[row][col] - getDp(row-s, col) - getDp(row, col-s) + getDp(row-s, col-s);
                freq[dirtyCovered]++;
                //System.out.printf("(%d, %d)\n", row, col);
            }
        }
/*
        for(int [] x : dp){
            for(int y : x)
                System.out.printf("%3d", y);
            System.out.println();
        }
        //System.out.println("Count = " + c);

*/

        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0)
                System.out.println(i + " " + freq[i]);
        }

	}

    static int dirty(char[][] grid, int i , int j){
        return (grid[i][j] == 'D') ? 1 : 0;
    }
    static int getDp(int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= n) return 0;
        return dp[i][j];
    }

}

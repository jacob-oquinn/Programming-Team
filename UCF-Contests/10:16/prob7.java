import java.util.*;
import java.lang.*;


public class prob7{

	static Scanner scnr;
	static int r;
	static int c;
	static final int EMPTY = -1;
	static long grid[][];
	static int dp[][];
	static final int MOD = 1000;

	public static void main(String[] args){
		scnr = new Scanner(System.in);

		int numCases = scnr.nextInt();

		while(numCases-->0){
			r = scnr.nextInt();
			c = scnr.nextInt();

			 grid= new long[r][c];
			 dp = new int[r][c];

			for(int row = 0; row < r; row++){
				for(int col = 0; col < c; col++){
					grid[row][col] = scnr.nextLong();
					dp[row][col] = EMPTY;
				}
			}
			// initialize dp
			dp[0][0] = 1;
			// loop through each diagnol
			System.out.println(getNumPaths(r-1, c-1));
		}
	}
	static int getNumPaths(int row, int col){

		if(dp[row][col] != EMPTY) return dp[row][col];

		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		int sum = 0;
		for(int i = 0; i < dr.length; i++){
			int newRow = row+dr[i];
			int newCol = col+dc[i];
			// OOB check
			if(newRow < 0 || newRow >= r || newCol >= c || newCol < 0) continue;
			if(grid[newRow][newCol] > grid[row][col])
				sum += getNumPaths(newRow, newCol);
		}
		dp[row][col] = sum%MOD;
		return dp[row][col];
	}
}












//

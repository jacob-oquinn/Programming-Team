import java.util.*;
import java.lang.*;

public class e {
	final static int NOT_POSSIBLE = 5000;
	final static int EMPTY = 5001;
	final static boolean DEBUG = false;
	static int[][] grid;
	static int[][] dp;
	static int[][] visitedPath;
	static int w;
	static int h;

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		h = scnr.nextInt();
		w = scnr.nextInt();

		grid = new int[h][w];
		dp   = new int[h][w];
		visitedPath = new int[h][w];

		for(int i = 0; i < h; i++){
			Arrays.fill(dp[i], EMPTY);
			Arrays.fill(visitedPath[i], 0);
		}

		for(int i = 0; i < h; i++){
			String s = scnr.next();
			for(int j =0;j<w;j++){
				grid[i][j] = s.charAt(j) - '0';
				if(grid[i][j] == 0)
					dp[i][j] = NOT_POSSIBLE;
			}
		}

		dp[h-1][w-1] = 0;
		dfs(0,0);
		System.out.print((dp[0][0] == NOT_POSSIBLE) ? "-1" : dp[0][0]);

	}
	static int dfs(int r, int c){
		if(DEBUG){
			System.out.println(r + ", " + c);
			System.out.println();
			for(int i =0; i < h; i++){
				for(int j =0;j<w;j++){
					System.out.print(dp[i][j] + " ");
				}System.out.println();
			}
		}

		if(r >= h || r < 0 || c >= w || c < 0 || visitedPath[r][c] == 1){
			visitedPath[r][c] = 0;
			return NOT_POSSIBLE;
		}

		if(dp[r][c] != EMPTY){
			visitedPath[r][c] = 0;
			return dp[r][c];
		}

		visitedPath[r][c] = 1;

		int step = grid[r][c];
		int[] dr = {step, 0,0, -1*step};
		int[] dc = {0, -1*step, step,0};
		int best = NOT_POSSIBLE;

		for(int i = 0; i < 4;i++){
			if(r + dr[i] >= h || r + dr[i] < 0 || c + dc[i] >= w || c + dc[i] < 0)
				continue;

			int dist = 1 + dfs(r + dr[i], c + dc[i]);
			best = (int)Math.min( best, dist );
		}

		visitedPath[r][c] = 0;
		dp[r][c] = best;
		return dp[r][c];
	}
}

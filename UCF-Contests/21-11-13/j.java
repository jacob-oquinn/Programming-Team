import java.util.*;
import java.lang.*;


public class j{

	static int h;
	static int w;
	static int grid[][];
	static boolean fill[][];
	static Scanner scnr;
	public static void main(String arg[]){
		scnr = new Scanner(System.in);
		h = scnr.nextInt()+2;
		w = scnr.nextInt()+2;
		grid = new int[h][w];
		fill = new boolean[h][w];

		for(int r = 0; r < h; r++){
			Arrays.fill(fill[r], false);
			for(int c = 0; c < w; c++){
				grid[r][c] = scnr.nextInt();
			}
		}

		if(!solve(1, 1)){
			System.out.println("impossible");
			return;
		}
		for(int r = 1; r < h-1; r++){
			for(int c = 1; c < w-1; c++){
				System.out.print((fill[r][c]) ? "x" : ".");
			}
			System.out.println();
		}
	}

	static boolean solve(int r, int c){
		// Move pointer back to front and down a row
		if(c >= w-1) {
			r++;
			c = 1;
		}
		// Full grid solved
		if(r >= h-1)
			return true;

		// Try leaving empty
		fill[r][c] = false;
		if(validPosition(r,c) && solve(r,c+1)) return true;

		// Try filling
		fill[r][c] = true;
		if(validPosition(r,c) && solve(r, c+1)) return true;
		// Backtrack
		return false;
	}

	static boolean validPosition(int r, int c){
		int dr[] = {-1,-1,-1,0,0,0,1,1,1};
		int dc[] = {-1,0,1,-1,0,1,-1,0,1};

		for(int i = 0; i < dr.length; i++){
			int rr = r + dr[i];
			int cc = c + dc[i];
			int target = grid[rr][cc];
			// If we are at top left should be at its target
			if(rr == r - 1 && cc == c - 1){
				if(getCount(rr, cc) != target) return false;
			}
			// If we are at right col, top right should be at target
			if(c == w - 1 && (rr == r - 1 && cc == c + 1)){
				if(getCount(rr, cc) != target) return false;
			}
			// if we are at last row, left elements should be at target
			if(r == h - 1 && (cc == c - 1)){
				if(getCount(rr, cc) != target) return false;
			}
			// if we are at bottom right, all elements should be at target
			if(r == h - 1 && c == w - 1){
				if(getCount(rr, cc) != target) return false;
			}

			// remaining values should be at or below their target
			if(getCount(rr, cc) > target) return false;
		}
		return true;
	}

	static int getCount(int r, int c){
		int dr[] = {-1,-1,-1,0,0,0,1,1,1};
		int dc[] = {-1,0,1,-1,0,1,-1,0,1};
		int count = 0;

		// Count up filled neighbors
		for(int i = 0; i < dr.length; i++){
			int rr = r + dr[i];
			int cc = c + dc[i];
			// OOB check
			if(rr >= h || rr < 0 || cc >= w || cc < 0) continue;
			if(fill[rr][cc]) count++;
		}
		return count;
	}

}

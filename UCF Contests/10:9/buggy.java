
import java.util.*;
import java.lang.*;

class buggy
{
	static char[][] grid;
	static int[][] dis;
	static int r;
	static int c;
	static int rT;
	static int cT;
	static String instructions;

	static int oo = (int)1e5;
	static int NOTFILLED = oo;

	static final char WALL = '#';

    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
		r = scnr.nextInt();
		c = scnr.nextInt();

		grid = new char[r][c];

		int rS = -1;
		int cS = -1;

		for(int row = 0; row < r; row++){
			String s = scnr.next();
			for(int col = 0; col < c; col++){
				grid[row][col] = s.charAt(col);
				// Starting location
				if(s.charAt(col) == 'R'){
					rS = row;
					cS = col;
				}
				// Ending location
				if(s.charAt(col) == 'E'){
					rT = row;
					cT = col;
				}
			}
		}
		instructions = scnr.next();

		// get starting position
		int [] t = {-1,-1};
		System.out.println(bfs(0, rS, cS, t, 0));

    }

	static int bfs(int ind, int row, int col, int[] prevPos, int curDis){

		int[] curPos = {row,col};

		// Reached the target
		if(row == rT && col == cT) return 0;

		int min = oo;
		int[] pos;

		// Check if there are instructions left
		if(ind < instructions.length()){
			// Follow along
			pos = updatePos(instructions.charAt(ind), row, col);
			min = Math.min(rec(ind+1, pos[0],pos[1], curPos, curDis), min);

			// Delete
			min = Math.min(1 + rec(ind+1, row, col, curPos, curDis+1), min);
		}

		// Insert
		// don't go back the way we came.
		char [] moves = {'U','D','R','L'};
		for(char move : moves){
			pos = updatePos(move, row, col

			// Don't repeat
			if(pos[0] == curPos[0] && pos[1] == curPos[1]) continue;

			min = Math.min(1 + rec(ind, pos[0],pos[1], curDis+1), min);
		}
		return min;
	}

	static int[] updatePos(char d, int row, int col){
		switch(d){
			case 'U': if(row>0 && grid[row-1][col] != WALL)row--;
			break;
			case 'D': if(row<r-1 && grid[row+1][col] != WALL)row++;
			break;
			case 'L': if(col>0 && grid[row][col-1] != WALL)col--;
			break;
			case 'R': if(col<c-1 && grid[row][col+1] != WALL)col++;
			break;
		}
		int [] ret = {row,col};
		return ret;
	}
}















//

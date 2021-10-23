
import java.util.*;
import java.lang.*;

class histogram
{
	static char[][] grid;
	static int r;
	static int c;
	static int rT;
	static int cT;
	static String instructions;

	static final char WALL = '#';

    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
		r = scnr.nextInt();
		c = scnr.nextInt();

		grid = new char[r][c];

		int rS;
		int cS

		for(int row = 0; row < r; row++){
			String s = scnr.next();
			for(int col = 0; col < c; col++){
				grid[row][col] = s.charAt(col);
				// Starting location
				if(s.chatAt(col) == 'R'){
					rS = row;
					cS = col;
				}
				// Ending location
				if(s.chatAt(col) == 'E'){
					rT = row;
					cT = col;
				}
			}
		}
		instructions = scnr.next();

		// get starting position
		System.out.println(rec(0), rS, cS);

    }

	static int rec(int ind, int row, int col, int[] prevPos){
		int[] curPos = {row,col};

		// Reached the target
		if(row == rT && col == cT) return 0;

		int min = Integer.MAX_VALUE;
		int[] pos;

		// Check if there are instructions left
		if(pos < instructions.length){
			// Follow along
			pos = updatePos(instructions.charAt(i), row, col);
			min = Math.min(rec(ind+1, pos[0],pos[1]), min);

			// Delete
			min = Math.min(1 + rec(ind+1, row, col), min);
		}

		// Insert
		// don't go back the way we came.
		char [] moves = {'U','D','R','L'};
		for(char move : moves){
			pos = updatePos(move, row, col);

			// Don't double back
			if(pos[0] == prevPos[0] && pos[1] == prevPos[1]) continue;

			min = Math.min(1 + rec(ind, pos[0],pos[1]), min);
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
		return {row, col};
	}
}















//

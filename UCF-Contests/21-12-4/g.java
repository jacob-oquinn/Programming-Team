import java.util.*;
import java.lang.*;

public class g {
	final static char EMPTY = '.';
	final static char WALL = '#';
	final static char EMPTY_TARGET = '+';
	final static char BOX = 'b';
	final static char BOX_ON_TARGET = 'B';
	// I won't be using worker, just tracking curR and curC
	final static char WORKER = 'w';
	final static char WORKER_ON_TARGET = 'W';

	static char grid[][];
	static int h;
	static int w;
	static int curR;
	static int curC;

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		h = scnr.nextInt();
		w = scnr.nextInt();
		int caseNum = 1;

		while(h != 0 && w != 0){
			grid = new char[h][w];
			// read in grid
			for(int r = 0; r < h; r++){
				String s = scnr.next();
				for(int c = 0; c < w; c++){
					grid[r][c] = s.charAt(c);
					// ignore worker
					if(grid[r][c] == WORKER){
						grid[r][c] = EMPTY;
						curR = r;
						curC = c;
					}
				}
			}

			String instructions = scnr.next();
			boolean done = false;
			for(char step : instructions.toCharArray()){
				//System.out.println();
				//printGrid();

				// Stop moving if we win
				if(done) break;

				int dc = 0;
				int dr = 0;
				switch(step){
					case 'U':
						dr = -1; break;
					case 'R':
						dc = 1; break;
					case 'D':
						dr = 1; break;
					case 'L':
						dc = -1; break;
					default:
						System.out.println("error");
				}
				// wall present do nothing
				if(grid[curR + dr][curC + dc] == WALL){

				}
				// no block present, worker just walks
				else if(grid[curR + dr][curC + dc] == EMPTY ||
				   grid[curR + dr][curC + dc] == EMPTY_TARGET){
				    curR += dr;
				    curC += dc;
			    }
				// box present
				else if(grid[curR + dr][curC + dc] == BOX_ON_TARGET ||
				   grid[curR + dr][curC + dc] == BOX){
					// OOB check that shouldn't be needed
					if(curR + dr*2 >= h || curR + dr*2 < 0 ||
					   curC + dc*2 >= w || curC + dc*2 < 0){

					}
				    // Check if wall or box is behind
					else if(grid[curR + dr*2][curC + dc*2] != BOX_ON_TARGET &&
					   grid[curR + dr*2][curC + dc*2] != BOX &&
					   grid[curR + dr*2][curC + dc*2] != WALL ){
						// Delete current box
						grid[curR + dr][curC + dc] =
							(grid[curR + dr][curC + dc] == BOX_ON_TARGET) ? EMPTY_TARGET : EMPTY;

						// Moving box onto a target
					    if(grid[curR + dr*2][curC + dc*2] == EMPTY_TARGET){
							grid[curR + dr*2][curC + dc*2] = BOX_ON_TARGET;
						}
						// Move box onto empty
						else if(grid[curR + dr*2][curC + dc*2] == EMPTY){
							grid[curR + dr*2][curC + dc*2] = BOX;
						}

					    // Move worker
					    curR += dr;
					    curC += dc;
				    }
			    }
				// Check if we win
				done = true;
				for(int r = 0; r < h; r++){
					for(int c = 0; c < w; c++){
						if(grid[r][c] == EMPTY_TARGET) done = false;
					}
				}
			}

			System.out.println("Game " + (caseNum++) + ": " + ((done) ? "complete" : "incomplete"));
			printGrid();

			// next set of inputs
			h = scnr.nextInt();
			w = scnr.nextInt();

		}

	}

	static void printGrid(){
		for(int r = 0; r < h; r++){
			for(int c = 0; c < w; c++){
				char output = grid[r][c];
				// Worker is on this position
				if(r == curR && c == curC){
					// Print out worker, worker on target when we hit our last position
					if(grid[r][c] == EMPTY_TARGET)
						output = WORKER_ON_TARGET;
					else if(grid[r][c] == EMPTY)
						output = WORKER;
					else
						System.out.println("ERROR_EEROR_ERROR: worker on non-available spot");

				}
				System.out.print(output);
			}
			System.out.println();
		}
	}
}

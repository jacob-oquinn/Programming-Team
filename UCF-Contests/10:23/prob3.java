import java.util.*;
import java.lang.*;


public class prob3{

	static final boolean DEBUG = true;

	static char board[][];
	static final char EMPTY = ' ';
	static final char MAYBE = '?';
	static final char NOT   = '-';

	static int c;
	static int r;
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		for(int caseNum = 1; ; caseNum++){
			c = scnr.nextInt();
			r = scnr.nextInt();
			if(c == 0 || r == 0) return;

			board = new char[r][c];
			for(int row = 0; row < r; row++){
				String s = scnr.next();
				for(int col = 0; col < c; col++){
					board[row][col] = s.charAt(col);
				}
			}
			boolean chain = true;
			while(chain){
				chain = false;
				char[][] tempBoard = new char[r][c];
				for(int row = 0; row < r; row++){
					for(int col = 0; col < c; col++){
						tempBoard[row][col] = board[row][col];
					}
				}
				// delete chains
				for(int row = 0; row < r; row++){
					for(int col = 0; col < c; col++){
						System.out.print("c");
						if(!Character.isAlphabetic(tempBoard[row][col])) continue;

						int len = getChainLength(tempBoard, row, col);

						if(len >= 4){
							chain = true;
							removeChain(tempBoard, row, col);
							System.out.println("Chain at " + r + " " + c);
						}
						else {
							removeMaybes(tempBoard, row, col);
						}
					}
				}
				// update board to reflect items falling
				for(int row = r-1; row >= 0; row--){
					for(int col = 0; col < c; col++){
						// remove chains from board
						if(tempBoard[row][col] == EMPTY){
							board[row][col] = EMPTY;
							continue;
						}
						int curRow = row;
						while(false && curRow < r-1 && board[curRow+1][col] == EMPTY){
							board[curRow+1][col] = board[curRow][col];
							board[curRow][col] = EMPTY;
							curRow++;
						}
					}
				}
				if(DEBUG){
					for(int row = 0; row < r; row++){
						for(int col = 0; col < c; col++){
							System.out.print(board[row][col]);
						}System.out.println();
					}
				}
			}
			// Count number of tiles remaining
			int count = 0;
			for(int row = 0; row < r; row++){
				for(int col = 0; col < c; col++){
					if(board[row][col] != EMPTY) count++;
				}
			}
			System.out.println(caseNum + ": " + count);
		}

	}
	// FloodFill algorithm
	static int getChainLength(char tempBoard[][], int row, int col){
		int dr[] = {-1, 0, 1, 0};
		int dc[] = { 0, 1, 0,-1};

		char target = tempBoard[row][col];
		if(!Character.isAlphabetic(target)) return 0;

		tempBoard[row][col] = MAYBE;
		int chainLength = 0;
		for(int i = 0; i < 4; i++){
			int newRow = row += dr[i];
			int newCol = col += dc[i];

			if(!inBounds(newRow, newCol) || tempBoard[newRow][newCol] != target) continue;
			chainLength += getChainLength(tempBoard, newRow, newCol);
		}

		return chainLength + 1;
	}

	// turns maybe to empty
	static void removeChain(char tempBoard[][], int row, int col){
		int dr[] = {-1, 0, 1, 0};
		int dc[] = { 0, 1, 0,-1};

		tempBoard[row][col] = EMPTY;

		for(int i = 0; i < 4; i++){
			int newRow = row += dr[i];
			int newCol = col += dc[i];
			if(!inBounds(newRow, newCol) || tempBoard[newRow][newCol] != MAYBE) continue;
			removeChain(tempBoard, newRow, newCol);
		}
	}
	// takes chain we just looked at and assigns values to NOT a chain
	static void removeMaybes(char tempBoard[][], int row, int col){
		int dr[] = {-1, 0, 1, 0};
		int dc[] = { 0, 1, 0,-1};

		tempBoard[row][col] = NOT;

		for(int i = 0; i < 4; i++){
			int newRow = row += dr[i];
			int newCol = col += dc[i];
			if(!inBounds(newRow, newCol) || tempBoard[newRow][newCol] != MAYBE) continue;
			removeChain(tempBoard, newRow, newCol);
		}
	}

	static boolean inBounds(int row, int col){
		return !(row < 0 || row >= r || col < 0 || col >= c);
	}

}

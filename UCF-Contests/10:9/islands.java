
import java.util.*;
import java.lang.*;

class islands
{
	static int r;
	static int c;
	static final char FILL = '-';
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
		r = scnr.nextInt();
		c = scnr.nextInt();
		char[][] arr = new char[r][c];
		for(int row = 0; row < r; row++){
			String s = scnr.next();
			for(int col = 0; col < c; col++){
				arr[row][col] = s.charAt(col);
			}
		}
		int ret = 0;
		for(int row = 0; row < r; row++){
			for(int col = 0; col < c; col++){
				if(arr[row][col] == 'L'){
					ret++;
					floodFill(arr,row,col);
				}
			}
		}
		System.out.println(ret);
    }

	static int perm(char[][] arr){
		int min = Integer.MAX_VALUE;
		boolean cloudPresent = false;
		for(int row = 0; row < r; row++){
			for(int col = 0; col < c; col++){
				if(arr[row][col] != 'C') continue;
				cloudPresent = true;
				arr[row][col] = 'L';
				min = Math.min(perm(arr), min);
				arr[row][col] = 'W';
				min = Math.min(perm(arr), min);

			}
		}
		if(!cloudPresent){
			return countIslands(arr);
		}
		return min;
	}

	static int countIslands(char[][] arr){
		int ret = 0;

		for(int row = 0; row < r; row++){
			for(int col = 0; col < c; col++){
				if(arr[row][col] != 'L') continue;
				ret++; // island found
				// fill island "flood fill"
				floodFill(arr, row, col);
			}
		}
		for(int row = 0; row < r; row++){
			for(int col = 0; col < c; col++){
				if(arr[row][col] == FILL)
				 	arr[row][col] = 'L';
			}
		}

		return ret;
	}
	static void floodFill(char[][] arr, int row, int col){
		if(row < 0 || row >= r || col < 0 ||  col >= c) return;
		if(arr[row][col] != 'L' && arr[row][col] != 'C') return;

		int [] dx = {-1,0,1,0};
		int [] dy = {0,1,0,-1};

		arr[row][col] = FILL;

		for(int i = 0 ; i < 4; i++){
			floodFill(arr, row+dx[i],col+dy[i]);
		}

	}


}

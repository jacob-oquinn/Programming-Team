
import java.util.*;
import java.lang.*;

class gravity
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
		int r = scnr.nextInt();
		int c = scnr.nextInt();
		char[][] arr = new char[r][c];
		for(int row = 0; row < r; row++){
			String s = scnr.next();
			for(int col = 0; col < c; col++){
				arr[row][col] = s.charAt(col);
			}
		}

		for(int row = r-1; row >= 0; row--){
			for(int col = c-1; col >= 0; col--){
				moveDown(arr,row,col);
			}
		}
		for(int row = 0; row < r; row++){
			for(int col = 0; col < c; col++){
				System.out.print(arr[row][col]);
			}System.out.println();
		}


    }

	void moveDown(char[][] arr, int row, int col){
		if(row > 0 && arr[row+1][col] == '.'){
			arr[row][col] = '.';
			arr[row+1][col] = 'o';
		}
		moveDown(arr, row+1,col);
	}

}

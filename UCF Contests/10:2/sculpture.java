
import java.util.*;
import java.lang.*;

class sculpture
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

        int r = scnr.nextInt();
		int c = scnr.nextInt();
		int [][] grid = new int [r][c];
		for(int i = 0; i < r; i++){
			for(int j = 0 ; j < c; j++){
				grid[i][j] = scnr.nextInt();
			}
		}
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0,  1, 0,-1};
		int drain[][] = new int[r][c];
		for(int i = 0; i < r; i++){
			Arrays.fill(drain[i], 0);
			for(int j = 0 ; j < c; j++){
				if(i == 0 || i == r-1 || j == 0 || j== c-1) continue;
				int needsDrain = 1;
				for(int k = 0; k < 4;k++){
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(grid[i][j] > grid[nx][ny]) needsDrain = 0;
				}
				drain[i][j] = needsDrain;
			}
		}
		for(int i = 0; i < r; i++){
			for(int j = 0 ; j < c; j++){
				System.out.print(drain[i][j] + " ");
			}
			System.out.println();
		}

    }
}

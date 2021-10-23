
import java.util.*;
import java.lang.*;

class c
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
        int T = scnr.nextInt();
        for(int caseNum = 1; caseNum <= T; caseNum++){

			int x = scnr.nextInt();
			int y = scnr.nextInt();

			int[][] visited = new int[64][64];

			for(int i = 0; i < 64; i++){
				for(int j = 0; j < 64; j++){
					visited[i][j] = 0;
				}
			}
			visited[x][y] = 1;

			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};
			int direction = 1;// start facing up
			for(char c : scnr.next().toCharArray()){
				switch(c){
					case 'F':
						x += dx[direction];
						y += dy[direction];
						visited[x][y]++;
					break;
					case 'R':
						direction++;
					break;
					case 'L':
						direction--;
					break;
				}
				if(direction == -1)direction = 3;
				if(direction == 4)direction = 0;
			}
			int n = 0;
			for(int i = 0; i < 64; i++){
				for(int j = 0; j < 64; j++){
					if(visited[i][j] >= 2) n++;
				}
			}

            System.out.printf("Case #%d: %d %d %d\n", caseNum, x, y, n);
        }
    }
}

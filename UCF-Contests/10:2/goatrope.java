
import java.util.*;
import java.lang.*;

class goatrope
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

		int x = scnr.nextInt();
		int y = scnr.nextInt();
		int x1 = scnr.nextInt();
		int y1 = scnr.nextInt();
		int x2 = scnr.nextInt();
		int y2 = scnr.nextInt();

		double dist = 999999;
		if(x > x1 && x < x2){
			if(y < y1){
				dist = y1 - y;
			} else {
				dist = y - y2;
			}
		} else if(y < y2 && y > y1){
			if(x < x1){
				dist = x1 - x;
			} else {
				dist = x - x2;
			}
		}
		// some diag
		else {
			int[][] corners = {{x1,y1}, {x2,y1}, {x2,y2} , {x1,y2}};
			for(int [] corner : corners){
				dist = Math.min(dist, getDist(x,y,corner[0],corner[1]));
			}
		}
		System.out.printf("%.3f\n", dist);
    }
	static double getDist(int x1, int y1, int x2, int y2){
		int dx = Math.max(x1,x2) - Math.min(x1,x2);
		int dy = Math.max(y1,y2) - Math.min(y1,y2);
		return Math.sqrt(dx*dx + dy*dy);

	}
}

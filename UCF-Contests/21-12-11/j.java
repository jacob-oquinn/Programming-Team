import java.util.*;
import java.lang.*;

public class j {
	final static boolean DEBUG = false;
	static int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
	static int bestDist;
	static int bestVal = -1;
	static int target;
	static int w;
	static int h;
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int v = 1; v < 401; v++){
			// convert to Arr
			ArrayList<Integer> vals = new ArrayList<Integer>();
			String t = String.valueOf(v);
			while(t.length() > 0 && !t.equals("0")){
				int tt = Integer.valueOf(t);
				vals.add(tt % 10);
				t = String.valueOf(tt / 10);
			}
			int r = (vals.get(vals.size()-1) == 0) ? 3 : (vals.get(vals.size()-1) - 1) / 3;
			int c = (vals.get(vals.size()-1) == 0) ? 1 : (vals.get(vals.size()-1) - 1) % 3;
			boolean valid = true;

			for(int i = vals.size()-2; i >=0; --i){
				int newR = (vals.get(i) == 0) ? 3 : (vals.get(i) - 1) / 3;
				int newC = (vals.get(i) == 0) ? 1 : (vals.get(i) - 1) % 3;
				if(newR < r || newC < c){
					valid = false;
					break;
				}
				r=newR;
				c=newC;
			}

			if(valid)
				al.add(v);

		}


		int n = scnr.nextInt();
		while(n-->0){
			target = scnr.nextInt();
			bestDist = target;
			bestVal = 0;
			for(int i = 0; i < al.size(); i++){
				int val = al.get(i);
				int dist = Math.abs(target - val);
				if(dist < bestDist){
					bestDist = dist;
					bestVal = val;
				}
			}
			System.out.println(bestVal);
		}
	}

}

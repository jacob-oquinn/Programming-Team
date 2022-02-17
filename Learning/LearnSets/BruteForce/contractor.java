import java.util.*;
import java.lang.*;

public class contractor {
	
	static boolean include[];
	static int day[];
	static int value[];
	static int best;
	static int maxDays;
	
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		int c = scnr.nextInt();
		
		while(c-->0){
			int n = scnr.nextInt();
			maxDays = scnr.nextInt();
			include = new boolean[n];
			day = new int[n];
			value = new int[n];
			for(int i = 0 ; i < n ; i++){
				include[i] = false;
				day[i] = scnr.nextInt();
				value[i] = scnr.nextInt();
			}
			best = 0;
			getMax(0, 0, 0);
			System.out.println(best);
		}
		
	}
	static void getMax(int daysUsed, int val, int index){
		if(daysUsed > maxDays) return;
		best = Math.max(val, best);
		
		if(index >= day.length) return;
		// leave
		getMax(daysUsed, val, index+1);
		
		// take
		getMax(daysUsed + day[index], val + value[index], index+1);
		
	}
}












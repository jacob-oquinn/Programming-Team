import java.util.*;
import java.lang.*;

class failure {

	static int dp[];
	static int T;
	static int c;
	static Scanner scnr;

	public static void main(String args[]){
		scnr = new Scanner(System.in);

		T = scnr.nextInt();
		while(T-->0)
			run();

	}

	static void run(){
		c = scnr.nextInt();
		int[] importance = new int[c];
		int[] partCount = new int[c];
		int maxImportance = 0;
		for(int i = 0; i < c; i++){
			importance[i] = scnr.nextInt();
			maxImportance += importance[i];
			partCount[i] = scnr.nextInt();
		}
		dp = new int[maxImportance + 1];

		for(int part = 0; part < c; part++){
			for(int i = maxImportance; i >= 0; i--){
				int take = 0;
				if(i - importance[part] >= 0)
					take = dp[i - importance[part]] + partCount[part];

				int leave = dp[i] + (partCount[part]-1) / 2;
				dp[i] = Math.max(take, leave);
			}
		}
		System.out.println(dp[(maxImportance - 1) / 2]);
	}
}

/*
2

5
3 10
4 5
1 1
3 8
2 6

3
1 1
1 1
1 1

*/

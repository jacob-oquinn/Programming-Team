import java.util.*;



public class d {

	static final int oo = (int) 1e9;
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		int numCases = sc.nextInt();
		while(numCases --> 0) {

			int bestTime = oo;

			int numDishes = sc.nextInt();
			int target = sc.nextInt();

			int[] minutes = new int[numDishes+1];
			int[] votes = new int[numDishes+1];
			int maxTime = 0;

			for (int j = 1; j < numDishes+1; j++) {
				int t = sc.nextInt();
				minutes[j] = t;
				maxTime += t;
				votes[j] = sc.nextInt();
			}

			int[][] dp = new int[numDishes + 1][maxTime + 1];

			for(int dish = 1; dish < numDishes + 1; dish++){
				for(int time = 1; time < maxTime + 1; time++){

					int take = (time < minutes[dish]) ? -1 : dp[dish-1][time - minutes[dish]] + votes[dish];
					int leave = dp[dish-1][time];
					dp[dish][time] = Math.max(take,leave);

					if(dp[dish][time] >= target)
						bestTime = Math.min(time, bestTime);

				}
			}
			System.out.println(bestTime);
		}
	}
}

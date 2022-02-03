import java.util.*;
import java.lang.*;

public class profits {
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		
		
		int n = scnr.nextInt();
		
		while(n != 0){
			int curSum = Integer.MIN_VALUE + 1000;
			int bestSum = Integer.MIN_VALUE + 1000;
		
			while(n-->0){
				int val = scnr.nextInt();
				curSum = (curSum > 0) ? curSum + val : val;
				bestSum = Math.max(curSum, bestSum);
			}
			System.out.println(bestSum);
			n = scnr.nextInt();
		}
		

		
		
	}
}
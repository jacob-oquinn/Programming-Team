import java.util.*;
import java.lang.*;

public class c {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		int numFloors = scnr.nextInt();
		int[] safe = new int[numFloors];
		Arrays.fill(safe, 0);

		for(int i = 0; i < n; i++){
			int floor = scnr.nextInt() - 1;
			if(scnr.next().equals("SAFE")){
				for(int j = 0; j <= floor; j++)
					safe[j] = 1;
			}
			else {
				for(int j = floor; j < numFloors; j++)
					safe[j] = -1;
			};
		}
		// get lowest potential break drop
		int bestBreak = -1;
		for(int j = numFloors - 1;j >= 0; j--){
			if(safe[j] == 1) break;
			bestBreak = j;
		}
		// get highest potential safe drop
		int bestSafe = -1;
		for(int j = 0; j < numFloors; j++){
			if(safe[j] == -1) break;
			bestSafe = j;
		}
		if(bestSafe == numFloors - 1) bestSafe--;
		if(bestBreak == 0) bestBreak++;
		System.out.println((bestBreak+1) + " " + (bestSafe+1));

		
	}
}

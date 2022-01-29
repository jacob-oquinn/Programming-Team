import java.util.*;
import java.lang.*;

public class d {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		int [] skills = new int[n];
		for(int i = 0; i < n; i++)
			skills[i] = scnr.nextInt();
		Arrays.sort(skills); //FUCK DUHHH
		int lowest = Integer.MAX_VALUE;
		for(int i = 0; i < n/2; i++){
			int val = skills[i] + skills[n - i - 1];
			lowest = Math.min(val, lowest);
		}
		System.out.print(lowest);
	}
}

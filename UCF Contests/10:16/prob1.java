import java.util.*;
import java.lang.*;


public class prob1{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		int [] trees = new int[n];
		for(int i =0; i < n;i++){
			trees[i] = scnr.nextInt();
		}
		n = scnr.nextInt();
		while(n-->0){
			int start = scnr.nextInt() - 1;
			int end = scnr.nextInt() -1;
			long sum = 0;
			for(int i = start; i <= end; i++){
				sum += trees[i];
			}
			System.out.println(sum);
		}

	}
}

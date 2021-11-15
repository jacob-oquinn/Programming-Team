import java.util.*;
import java.lang.*;


public class c{
	// sort weights Array
	// take the largest buckets available and the smallest if possible
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int numBuckets = scnr.nextInt();
		int c = scnr.nextInt();
		int weights[] = new int[numBuckets];
		for(int i = 0; i < numBuckets; i++){
			weights[i] = scnr.nextInt();
		}
		Arrays.sort(weights);
		int l = 0;
		int r = weights.length - 1;
		int ret = 0;
		while(l <= r){
			ret++;
			if(weights[r] + weights[l] <= c){
				l++;
				r--;
			} else {
				r--;
			}
		}
		System.out.println(ret);
	}
}

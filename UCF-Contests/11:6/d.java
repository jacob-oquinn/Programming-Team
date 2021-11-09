import java.util.*;
import java.lang.*;


public class d {
	//

	static int farey[];
	static int isPrime[];
	public static void main(String[] args){
		// precalculate values
		// if divisor is prime, all values can be added to farey sequence
		// if dividend & divisor are mutually prime, add to sequence

		isPrime = new int[10001];
		// Arrays.fill(isPrime, 1);
		// for(int i = 1; i < isPrime.length; i++){
		// 	// skip nonprime numbers
		// 	if(isPrime[i] != 1) continue;
		// 	for(int j = i*2; j < isPrime.length; j+=i)
		// 		isPrime[j] = i;
		// }

		farey = new int[10001];
		Arrays.fill(farey, -1);
		farey[1] = 2;
		for(int i = 2; i < farey.length; i++){
			int newTerms = 0;
			for(int j = 1; j < i; j++){
				if(gcd(i,j) == 1) newTerms++;
			}
			farey[i] = newTerms + farey[i-1];
		}


		Scanner scnr = new Scanner(System.in);
		int numCases = scnr.nextInt();
		while(numCases-->0){
			System.out.println(scnr.nextInt() + " " + farey[scnr.nextInt()]);
		}
	}
	static int gcd(int ta, int tb){
		int a = Math.max(ta,tb);
		int b = Math.min(ta,tb);
		if(b == 0) return a;
		return gcd(a%b,b);
	}

}

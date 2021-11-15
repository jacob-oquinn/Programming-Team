import java.util.*;
import java.lang.*;


public class h{
	// count number of steps up taken
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		// assume all numbers are prime until disproven
		boolean[] primes = new boolean[10000009];
		Arrays.fill(primes, true);
		primes[1] = false;

		for(int i = 2; i < primes.length; i++){
			if(!primes[i]) continue;
			for(int k = 2*i; k < primes.length; k+=i){
				primes[k] = false;
			}
		}

		int numCases = scnr.nextInt();


		// points of error double -> int (rounding)
		// dividing ints
		while(numCases-->0){
			double num1 = scnr.nextDouble();
			double num2 = scnr.nextDouble();
			// get rid of decimal
			num1*=100000;
			num2*=100000;

			// round results
			// System.out.println("num1 = " + num1 + ", num2 = " + num2);
			int n1 = (int)Math.round(num1);
			int n2 = (int)Math.round(num2);
			int gcd = GCD(n1, n2);
			//System.out.println("GCD = " + gcd);
			n1 /= gcd;
			n2 /= gcd;
			//System.out.println(n1 + " " + n2);

			if(primes[n1] && primes[n2])
				System.out.println(n1 + " " + n2);
			else
				System.out.println("impossible");
		}
	}

	static int GCD(int a, int b){
		int aa = Math.max(a,b);
		int bb = Math.min(a,b);
		if(bb == 0) return aa;
		//System.out.println("a = " + aa + " b = " + bb);
		return GCD(bb, aa % bb);
	}
}

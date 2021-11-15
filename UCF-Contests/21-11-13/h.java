import java.util.*;
import java.lang.*;


public class h{
	// count number of steps up taken
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		// assume all numbers are prime until disproven
		boolean[] primes = new boolean[10000001];
		Arrays.fill(primes, true);
		primes[0] = false;
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
			String num1 = scnr.next();
			String num2 = scnr.next();
			// get rid of decimal
			num1 = num1.replace(".","");
			num2 = num2.replace(".","");

			// round results
			// System.out.println("num1 = " + num1 + ", num2 = " + num2);
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			int gcd = GCD(n1, n2);
			// System.out.println("GCD = " + gcd);
			n1 /= gcd;
			n2 /= gcd;
			// System.out.println(n1 + " " + n2);

			if(n1 == 1 && n2 == 1)
				System.out.println(2 + " " + 2);
			else if(primes[n1] && primes[n2])
				System.out.println(n1 + " " + n2);
			else
				System.out.println("impossible");
		}
	}

	static int GCD(int a, int b){
		return (b == 0) ? a : GCD(b, a % b);
	}
}

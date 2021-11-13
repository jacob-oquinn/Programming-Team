import java.util.*;
import java.lang.*;


public class h{
	// count number of steps up taken
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		boolean[] primes = new boolean[1e7];
		Arrays.fill(primes, true);
		for(int i = 1; i*i < primes.length; i++){
			if(!primes[i]) continue;
			for(int k = 2*i; k < primes.length; k+=i){
				primes[k] = false;
			}
		}

		int numCases = scnr.nextInt();

		while(numCases-->0){
			double num1 = scnr.nextDouble();
			double num2 = scnr.nextDouble();

			while((int)num1 != num1 || (int)num2 != num2){
				num1*=10;
				num2*=10;
			}
			int n1 = (int)num1;
			int n2 = (int)num2;
			int gcd = GCD(n1, n2);
			n1 /= gcd;
			n2 /= gcd;
			System.out.println( (primes[n1] && primes[n2]) ? (n1 + " " n2) : ("impossible"));
		}
	}

	static int GCD(int a, int b){
		int aa = Math.max(a,b);
		int bb = Math.min(a,b);
		if(bb == 0) return aa;
		return GCD(bb, aa % bb);
	}
}


import java.util.*;
import java.lang.*;

class goldbach
{
	static HashSet<Integer> primes;
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
		primes = new HashSet<Integer>();

		int num = scnr.nextInt();

		System.out.print(rec(num));

	}

	static int rec(int num){
		if(num < 3) return 0;

		int temp = num;
		while(--temp>0)
			if(checkPrime(temp) && checkPrime(num-temp)) break;

		//System.out.println("rec: " + temp);
		return rec(temp - (num-temp)) + 1;
	}

	static boolean checkPrime(int num){
		if(num == 1) return false;
		if(primes.contains(num)) return true;

		if(num == 2 || num == 3) return true;

		if(num % 2 == 0) return false;

		for(int i = 3; i <= Math.sqrt(num); i+=2){
			if(num % i == 0) return false;
		}

		primes.add(num);
		return true;
	}
}

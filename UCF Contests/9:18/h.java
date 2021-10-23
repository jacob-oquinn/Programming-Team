import java.util.*;
import java.lang.*;

public class h{

	public static main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		while(n-->0){
			System.out.println(scnr.nextInt());
			int numTerms = scnr.nextInt();

			int terms = new int[numTerms];
			terms[0] = scnr.nextInt();
			terms[1] = scnr.nextInt();

			HashMap<Integer, HashSet<Integer>> hm = new HashMap<Integer, HashSet<Integer>>();
			ArrayList<Integer> repeated = new ArrayList<Integer>();

			hm.get(terms[0]).add(terms[1]);

			boolean done = false;
			for(int i = 2; i < numTerms && !done; i++){
				int sum = terms[i-1] + terms[i-2];
				int j = 0;
				while(true){
					if(sum % primes[j] == 0) break;
					j++;
				}
				terms[i] = sum / primes[j];
				if(!hm.get(terms[i-1]).add(terms[i])){
					repeated.add(terms[i-1]);
					repeated.add(terms[i]);
				}

			}

		}
	}


}

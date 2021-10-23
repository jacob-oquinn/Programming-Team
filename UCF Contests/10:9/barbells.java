
import java.util.*;
import java.lang.*;

class barbells
{
	static HashSet<Long> hs;
	static long bars[];
	static long weights[];
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

		int numBars = scnr.nextInt();
		bars = new long[numBars];

		int numWeights = scnr.nextInt();
		weights = new long[numWeights];

		for(int i = 0; i < numBars ; i++){
			bars[i] = scnr.nextLong();
		}
		for(int i = 0; i < numWeights; i++){
			weights[i] = scnr.nextLong();
		}

		// Store all the valid weights seens so far
		hs = new HashSet<Long>();
		int pos = 0;
		perm(0,0,pos);

		ArrayList<Long> al = new ArrayList<>();
		hs.forEach((n) -> {
			al.add(n);
		});
		Collections.sort(al);
		al.forEach((n) -> {
			System.out.println(n);
		});

    }

	static void perm(long left, long right, int pos){
		if(right == left){
			//System.out.println("left: " + left + ", Right:" + right);
			for(long barWeight : bars){
				hs.add(left + right + barWeight);
			}
		}
		if(pos == weights.length) return;
		// exclude from set
		perm(left, right, pos+1);
		// add to left
		perm(left + weights[pos], right, pos+1);
		// add to right
		perm(left, right + weights[pos], pos+1);


	}
}

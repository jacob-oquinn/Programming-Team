import java.util.*;
import java.lang.*;


public class prob9{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int numCases = scnr.nextInt();
		while(numCases-->0){
			long numRows = scnr.nextLong();
			long numTrees = scnr.nextLong();

			double sum = 0;
			double max = -1;
			while(numRows-->0){
				double temp = scnr.nextDouble();
				sum += temp;
				max = Math.max(max, temp);
			}

			double treesToAddToMax = Math.floor(numTrees * (max*1.0 / sum) + 1);
			// If we only have one segment we'll overcount
			if(treesToAddToMax > numTrees) treesToAddToMax = numTrees;

			double ans = Math.round(max / (treesToAddToMax+1) * 1000) / 1000.0;
			System.out.printf("%.3f\n", ans);
		}
	}
}

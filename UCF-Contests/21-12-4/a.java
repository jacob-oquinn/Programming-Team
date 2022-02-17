import java.util.*;
import java.lang.*;

public class a {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		long a = scnr.nextLong();
		long b = scnr.nextLong();
		int caseNum = 1;
		while(a != 0 || b != 0){
			ArrayList<String> output = new ArrayList<String>();
			ArrayList<Integer> padding = new ArrayList<Integer>();
			output.add(String.valueOf(a));
			output.add(String.valueOf(b));
			// get resulting multiplication
			long finalRes = a * b;
			// padding for a and b
			padding.add(String.valueOf(finalRes).length() - String.valueOf(a).length());
			padding.add(String.valueOf(finalRes).length() - String.valueOf(b).length());

			// get the lines for multiplication
			int pos = -1;
			int zeroStreak = 0;
			while(b > 0){
				pos++;
				long m = b % 10; // get ones place
				b /= 10; // drop ones place

				// Skip cases when we have zero in ones place
				if(m == 0) {
					zeroStreak++;
					continue;
				}

				long res = m * a; // multiply
				String ret = String.valueOf(res);
				// calculate how much padding line needs
				padding.add(String.valueOf(finalRes).length() - ret.length() - pos);
				// add training zeros
				while(zeroStreak-->0){
					ret = ret.concat("0");
				} zeroStreak = 0;
				output.add(ret);
				// padding for this line

			}
			// madding for last element
			padding.add(0);
			// remove middle results if there is only one
			if(output.size() == 3){
				output.remove(2);
				padding.remove(2);
			}

			// add final results
			output.add(String.valueOf(finalRes));

			// Spaces used for formating is final length of final result
			int space = 0;
			if(finalRes == 0) space = 1;
			while(finalRes > 0){
				space++;
				finalRes /= 10;
			}


			// print out output
			System.out.println("Problem " + caseNum++);
			for(int i = 0; i < output.size(); i++){
				// ------- check
				if(i == 2 || i == output.size() - 1) {
					for(int j = 0; j < space; j++)
						System.out.print("-");
					System.out.println();
				}

				String s = output.get(i);

				int p = padding.get(i);
				while(p-->0){
					System.out.print(" ");
				}
				System.out.printf("%s\n", s);
			}

			// get next round of inputs
			a = scnr.nextLong();
			b = scnr.nextLong();
		}

	}
}

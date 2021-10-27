import java.util.*;
import java.lang.*;


public class prob9{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int N = scnr.nextInt(); scnr.nextLine();
		for(int caseNum = 1; caseNum <= N; caseNum++){
			String a = scnr.nextLine();
			String b = scnr.nextLine();

			a = a.replace(" ", "");
			a = a.replace("{", "").toLowerCase();
			a = a.replace("}", "");

			b = b.replace(" ", "");
			b = b.replace("{", "").toLowerCase();
			b = b.replace("}", "");

			//System.out.println(a);
			//System.out.println(b);

			String aArr[] = a.split(",");
			String bArr[] = b.split(",");

			HashSet<String> hsA = new HashSet<String>();
			HashSet<String> hsB = new HashSet<String>();

			boolean properSubset = true;
			boolean equalSets = true;
			for(String s : aArr){
				if(s.equals("")) continue;
				hsA.add(s);
			}
			for(String s : bArr){
				if(s.equals("")) continue;
				hsB.add(s);
			}
			// check if A contains every element in B
			for(String s : bArr){
				if(s.equals("")) continue;
				if(!hsA.contains(s))
					properSubset = false;
			}
			// Check if A and B are equal
			if(hsA.size() != hsB.size() || !properSubset) {
				equalSets = false;
			} else {
				// check if B contains every element in A
				for(String s : aArr){
					if(s.equals("")) continue;
					if(!hsB.contains(s))
						equalSets = false;
				}
			}


			System.out.println(caseNum + ": " + ((properSubset && !equalSets) ? "YES" : "NO"));
		}
	}
}

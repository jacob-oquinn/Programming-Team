import java.util.*;
import java.lang.*;

public class i {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		String [] strs = new String[n];
		for(int i = 0; i < n; i++){
			strs[i] = scnr.next();
		}
		n = scnr.nextInt();
		HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> incorrect = new HashMap<String, ArrayList<String>>();

		for(int i = 0; i< n; i++){
			String d = scnr.next();
			String e = scnr.next();
			String valid = scnr.next();

			if(valid.equals("correct")){
				if(correct.get(d) == null)
					correct.put(d, new ArrayList<String>());
				correct.get(d).add(e);
			}else {
				if(incorrect.get(d) == null)
					incorrect.put(d, new ArrayList<String>());
				incorrect.get(d).add(e);
			}

		}

		int numCorrect = 1;
		int total = 1;
		boolean m = false;
		for(String d : strs){
			if(correct.get(d) != null){
				m = true;
				numCorrect *= correct.get(d).size();
			}
			int a = 0; int b = 0;
			if(correct.get(d) != null)
				a = correct.get(d).size();
			if(incorrect.get(d) != null)
				b = incorrect.get(d).size();
			total *= a+b;
		}
		total -= numCorrect;
		if(numCorrect == 1 && m){
			for(String d : strs){
				System.out.print(correct.get(d).get(0) + " ");
			}
		} else {
			System.out.println(numCorrect + " correct");
			System.out.println(total + " incorrect");
		}

	}
}

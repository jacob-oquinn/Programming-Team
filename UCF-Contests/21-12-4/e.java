import java.util.*;
import java.lang.*;

public class e {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		String s = scnr.nextLine();
		while(!s.equals("END")){
			boolean freq[] = new boolean[256];
			Arrays.fill(freq, false);

			boolean valid = true;
			for(char c : s.toCharArray()){
				if(c == ' ') continue;
				if(freq[c])
				 	valid = false;
				freq[c] = true;
			}

			if(valid)
				System.out.println(s);

			s = scnr.nextLine();
		}

	}
}

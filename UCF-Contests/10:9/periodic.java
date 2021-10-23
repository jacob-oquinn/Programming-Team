
import java.util.*;
import java.lang.*;

class periodic
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
		String s = scnr.next();
		int k;
		for(k = 1; k < s.length()/2+1; k++){
			//System.out.println("K = " + k);
			if(s.length() % k != 0) {
				//System.out.println("Skipping: " + k);
				continue;
			}

			String base = s.substring(0,k);

			int rep = 0;
			boolean solution = true;

			for(int start = k; start < s.length(); start += k){

				rep++;

				String comp = s.substring(start, start + k);
				//System.out.println(comp + ": " + start + ", " + (start + k));

				for(int i = 0; i < base.length() ;i++){
					if(comp.charAt((i + rep) % comp.length()) != base.charAt(i)){
						//System.out.println(comp);
						//System.out.println(base);
						solution = false;
					}
				}
			}

			if(solution) {
				System.out.println(k);
				return;
			}

		}

		System.out.println(s.length());
    }
}

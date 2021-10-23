import java.util.*;
import java.lang.*;


public class prob4{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		String firstName[] = new String[256];
		String lastName[] = new String[256];

		for(int i = 0; i < 26; i++){
			char c = scnr.next().charAt(0);
			firstName[c] = scnr.nextLine();
		}
		for(int i = 0; i < 26; i++){
			char c = scnr.next().charAt(0);
			lastName[c] = scnr.nextLine();
		}

		int n = scnr.nextInt();
		while(n-->0){
			String f = scnr.next();
			String l = scnr.next();
			System.out.print(f + " " + l + " =");

			String newFirst = firstName[f.charAt(0)];
			String newLast = lastName[l.charAt(0)];
			System.out.print(newFirst + "" + newLast);

			System.out.println();

		}
	}
}

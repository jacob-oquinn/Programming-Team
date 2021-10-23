import java.util.*;
import java.lang.*;


public class prob3{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int low = scnr.nextInt();
		int high = scnr.nextInt();
		int caseNum = 1;
		while(low <= high){
			System.out.println("Case " + caseNum++ + ":");
			for(int i = low; i <= high; i++){
				if(i % 3 == 0) System.out.print("Mercer");
				if(i % 4 == 0) System.out.print("Bears");
				if(i % 18 == 0) System.out.print("Grrrr");
				if(i % 33 == 0) System.out.print("Bite");
				if(i % 3 != 0 && i % 4 != 0 && i % 18 != 0 && i % 33 != 0)
				 	System.out.print(i);

				System.out.println();
			}
			System.out.println();
			low = scnr.nextInt();
			high = scnr.nextInt();
		}

	}
}

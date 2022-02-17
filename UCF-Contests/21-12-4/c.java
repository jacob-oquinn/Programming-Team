import java.util.*;
import java.lang.*;

public class c {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		int caseNum = 1;
		while(n!=0){
			Double bestPrice = -1.0;
			int bestDiameter = -1;
			for(int i = 0; i < n; i++){
				int r = scnr.nextInt();
				Double p = scnr.nextDouble();
				Double ppi = r*r/p;
				if(ppi > bestPrice){
					bestPrice = ppi;
					bestDiameter = r;
				}

			}
			System.out.printf("Menu %d: %d\n", caseNum++, bestDiameter);
			n = scnr.nextInt();
		}

	}
}

import java.util.*;
import java.lang.*;


public class a{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int caseNum = scnr.nextInt();
		for(int curCase = 1; curCase <= caseNum; curCase++){
			scnr.next();
			int prev = scnr.nextInt();
			int total = 0;
			for(int i = 1; i < 15; i++){
				int cur = scnr.nextInt();
				if(cur > prev) total++;
				prev = cur;
			}
			System.out.println(curCase + " " + total);
		}
	}
}

import java.util.*;
import java.lang.*;


public class g{
	// count number of steps up taken
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();

		int curVal = scnr.nextInt();
		int high = curVal;
		int low = 0;
		for(int i = 1; i < n; i++){
			// System.out.println(low + " - " + high);
			curVal = scnr.nextInt();
			int l = curVal - high;
			int h = curVal - low;
			low = Math.max(0, l);
			high = h;
		}
		// System.out.println(low + " - " + high);
		int l = curVal - high;
		int h = curVal - low;
		low = Math.max(0, l);
		high = h;
		// System.out.println(low + " - " + high);
		int ret = high - low + 1;
		if(high < low) System.out.println(0);
		else System.out.println(ret);
	}
}

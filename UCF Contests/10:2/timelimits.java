
import java.util.*;
import java.lang.*;

class timelimits
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

        int numSols = scnr.nextInt();
		int multiplier = scnr.nextInt();
		int max = -1;
		while(numSols-->0){
			max = Math.max(max, scnr.nextInt());
		}

		System.out.println((int)Math.ceil((double)max * multiplier / 1000.0));
    }
}

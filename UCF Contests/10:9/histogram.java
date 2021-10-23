
import java.util.*;
import java.lang.*;

class histogram
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		while(n-->0){
			int k = scnr.nextInt();
			while(k-->0)
				System.out.print("=");
			System.out.println();
		}
    }
}

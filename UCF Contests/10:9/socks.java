
import java.util.*;
import java.lang.*;

class socks
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
        long sum = 0;
        long max = -1;
        while(n-->0){
            long socks = scnr.nextLong();
            sum += socks;
            max = Math.max(max, socks);
        }
        if(max >= sum - max)
            System.out.println((sum - max));
        else
            System.out.println((sum / 2));


    }
}


import java.util.*;
import java.lang.*;

public class b
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        while(n-->0){
			long t = scnr.nextLong();
			System.out.println(Math.min(dis25(t), dis00(t)));
		}
    }

	public static int dis25(long t){
		int ret = 0;
		// Count the number of elements it takes to get to a 2 and a 5
		while(t > 0 && t % 10 != 5){
			t /= 10;
			ret++;
		}
		while(t > 10 && t % 25 != 0){
			long temp = t % 10;
			t /= 100;
			t = t * 10 + temp;
			ret++;
		}
		return (t % 25 == 0) ? ret : Integer.MAX_VALUE;
	}

	public static int dis00(long t){
		int ret = 0;
		// Count the number of elements it takes to get to a 2 and a 5
		while(t > 0 && t % 10 != 0){
			t /= 10;
			ret++;
		}
		while(t > 10 && t % 50 != 00){
			long temp = t % 10;
			t /= 100;
			t = t * 10 + temp;
			ret++;
		}
		return (t % 50 == 00) ? ret : Integer.MAX_VALUE;
	}
}
